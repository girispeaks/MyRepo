package package1;

import package2.Mod3;
import package2.Mod4;

public class Mod1 {

	public static void main(String[] args) {
		// Current package
		Mod2 md1=new Mod2();
		md1.day=24;
		md1.week=4;
		int t=md1.today(24);
		int w=md1.curWeek(4);
		int m= md1.curMonth(10);
		md1.setMonth(5);
		int ranMon=md1.getMonth();
		System.out.println("Accessing private variable from other class-Randam month "+ranMon);
		Mod2.year=1984;
		System.out.println("Year is "+Mod2.year);
		System.out.println("day is "+t);
		System.out.println("week is "+w);
		System.out.println("Month is "+m);
		//Mod2.month=04; not visible coz its private
		//Different package
		Mod3 md2=new Mod3();
		md2.week=3;
		int c=md2.curWeek(3);
		//Cannot access any other variable or methods as they are not public
		System.out.println("..............................");
		System.out.println("Week is "+c);
		//accessing different package protected method using inheritance concept
		Mod4 md3=new Mod4();
		System.out.println("..............................");
		md3.m4();
		
	}

}
