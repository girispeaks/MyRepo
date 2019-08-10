package com.selcukesfw.alm.utils;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.internal.Base64Encoder;


/**
* This example shows how to login, logout, and authenticate to the server using REST. Note that this is a
 * rather "thin" layer over {@link ALMRestConnector} because these operations are *almost* HTML
 * standards.
 */
public class ALMLoginLogout {
//    public static void main(String[] args) throws Exception {
//        ALMRestConnector con =
//                ALMRestConnector.getInstance().init(
//                        new HashMap<String, String>(),
//                        Constants.HOST,
//                        Constants.PORT,
//                        Constants.DOMAIN,
//                        Constants.PROJECT);
//        ALMLoginLogout example = new ALMLoginLogout();
//        //Returns null if authenticated. If not authenticated, returns
//        //a URL indicating where to login.
//        //We are not logged in, so call returns a URL
//        String authenticationPoint = example.isAuthenticated();
//        System.out.println("We should authenticate at: " + authenticationPoint);
//        //Now we login to previously returned URL.
//        example.login(authenticationPoint, Constants.USERNAME, Constants.PASSWORD);
//        System.out.println("cookies after authentication (should contain LWSSO_COOKIE_KEY):"
//                           + con.getCookieString());
//        //Proof that we are indeed logged in
//        if (example.isAuthenticated() == null) {
//            System.out.println("we're logged in - no url was returned from isAuthenticated");
//        }
//        //And now we logout
//        example.logout();
//        //And now we can see that we are indeed logged out - because isAuthenticated once again returns a URL, and not null.
//        if (example.isAuthenticated() != null) {
//            System.out.println("user and password successfully logged out, cookies: "
//                               + con.getCookieString());
//        }
//        else {
//            System.out.println("logout failed.");
//        }
//    }
    private ALMRestConnector con;
    protected ALMLoginLogout() {
        con = ALMRestConnector.getInstance();
    }
    /**
     * @param username
     * @param passowrd
     * @return true if authenticated at the end of this method.
     * @throws Exception
     *
     * convenience method used by other examples to do their login
     */
    protected boolean login(String username, String passowrd) throws Exception {
        String authenticationPoint = this.isAuthenticated();
        if (authenticationPoint != null) {
            return this.login(authenticationPoint, Constants.USERNAME, Constants.PASSWORD);
        }
        return true;
    }
    /**
     * @param loginUrl
     *            to authenticate at
     * @param username
     * @param password
     * @return true on operation success, false otherwise
     * @throws Exception
     *
     * logging in to our system is standard http login (basic authentication), where one must store
     * the returned cookies for further use.
     */
    protected boolean login(String loginUrl, String username, String password) throws Exception {
        //Create a string that looks like "Basic ((username:password)<as bytes>)<64encoded>"
        byte[] credBytes = (username + ":" + password).getBytes();
        String credEncodedString = "Basic " + new Base64Encoder().encode(credBytes);
        Map<String, String> map = new HashMap<String, String>();
        map.put("Authorization", credEncodedString);
        Response response = con.httpGet(loginUrl, null, map);
        boolean ret = response.getStatusCode() == HttpURLConnection.HTTP_OK;
        return ret;
    }
    /**
     * @return true if logout successful
     * @throws Exception
     *             close session on server and clean session cookies on client
     */
    protected boolean logout() throws Exception {
        //New that the get operation logs us out by setting authentication cookies to: LWSSO_COOKIE_KEY="" using server response header Set-Cookie
        Response response =
                con.httpGet(con.buildUrl("qcbin/authentication-point/logout"), null, null);
        return (response.getStatusCode() == HttpURLConnection.HTTP_OK);
    }
    /**
     * @return null if authenticated.<br>
     *         a url to authenticate against if not authenticated.
     * @throws Exception
     */
    protected String isAuthenticated() throws Exception {
        String isAuthenticateUrl = con.buildUrl("qcbin/rest/is-authenticated");
        String ret;
        Response response = con.httpGet(isAuthenticateUrl, null, null);
        int responseCode = response.getStatusCode();
        //If already authenticated
        if (responseCode == HttpURLConnection.HTTP_OK) {
            ret = null;
        }
        //If not authenticated - get the address where to authenticate via WWW-Authenticate
        else if (responseCode == HttpURLConnection.HTTP_UNAUTHORIZED) {
            Iterable<String> authenticationHeader =
                    response.getResponseHeaders().get("WWW-Authenticate");
            String newUrl = authenticationHeader.iterator().next().split("=")[1];
            newUrl = newUrl.replace("\"", "");
            newUrl += "/authenticate";
            ret = newUrl;
        }
        //Not OK and not unauthorized - means some kind of error, like 404, or 500
        else {
            throw response.getFailure();
        }
        return ret;
    }
}

