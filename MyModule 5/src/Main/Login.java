package Main;

import AdminLogin.AdminLogin;// packagename.classname
import Login.UserLogin;

public class Login {

	public static void main(String[] args) {
		UserLogin u=new UserLogin();
		u.Userlog();
		System.out.println(u.i);
		AdminLogin a = new AdminLogin();
		a.adminlog();

	}

}
