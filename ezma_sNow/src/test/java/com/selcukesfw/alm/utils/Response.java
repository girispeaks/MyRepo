package com.selcukesfw.alm.utils;

import java.util.Map;
/**
 * This is a naive implementation of an HTTP response. We use it to simplify matters in the
 * examples. It is a container of the response headers and the response body.
 */
public class Response {
    private Map<String, ? extends Iterable<String>> responseHeaders = null;
    private byte[] responseData = null;
    private Exception failure = null;
    private int statusCode = 0;
    /**
     * @param responseHeaders
     * @param responseData
     * @param failure
     */
    protected Response(
            Map<String, Iterable<String>> responseHeaders,
            byte[] responseData,
            Exception failure,
            int statusCode) {
        super();
        this.responseHeaders = responseHeaders;
        this.responseData = responseData;
        this.failure = failure;
        this.statusCode = statusCode;
    }
    protected Response() {}
    /**
     * @return the response Headers
     */
    protected Map<String, ? extends Iterable<String>> getResponseHeaders() {
        return responseHeaders;
    }
    /**
     * @param responseHeaders
     *            the responseHeaders to set
     */
    protected void setResponseHeaders(Map<String, ? extends Iterable<String>> responseHeaders) {
        this.responseHeaders = responseHeaders;
    }
    /**
     * @return the response Data
     */
    protected byte[] getResponseData() {
        return responseData;
    }
    /**
     * @param responseData
     *            the responseData to set
     */
    protected void setResponseData(byte[] responseData) {
        this.responseData = responseData;
    }
    /**
     * @return the failure if the access to the requested URL failed, such as a 404 or 500
     *         If no failure occurred, this method returns null.
     */
    protected Exception getFailure() {
        return failure;
    }
    /**
     * @param failure
     *            the failure to set
     */
    protected void setFailure(Exception failure) {
        this.failure = failure;
    }
    /**
     * @return the statusCode
     */
    protected int getStatusCode() {
        return statusCode;
    }
    /**
     * @param statusCode
     *            the statusCode to set
     */
    protected void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    /**
     * @see java.lang.Object#toString() return the contents of the byte[] data as a string.
     */
    @Override
    public String toString() {
        return new String(this.responseData);
    }
}

