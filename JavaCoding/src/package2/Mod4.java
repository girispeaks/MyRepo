package package2;
import package1.Mod2;

public class Mod4 extends Mod2 {
	public void m4(){
		Mod2.year=2016;
		System.out.println("Current year is "+ Mod2.year);
		System.out.println("Current Month is "+curMonth(12));
		Mod4 md4=new Mod4();
		//Variables exposed from Mod2 to Mod4
		md4.curWeek(10);
		md4.curMonth(12);
		md4.week=12;
		
	}
}
