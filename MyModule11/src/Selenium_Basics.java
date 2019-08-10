import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Selenium_Basics {

	public static void main(String[] args) {
		
		ProfilesIni prof = new ProfilesIni();
		FirefoxProfile p = prof.getProfile("Selenium_User");
		
		FirefoxDriver d = new FirefoxDriver(p);
		d.
		
		

	}

}
