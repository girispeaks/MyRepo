package package1;

public class Mod2 {
	int day;
	public int week;
	private static int month=4;
	protected static int year;
	
	int today(int day){
		this.day=day;
		return day;
	}
	
	public int curWeek(int week){
		this.week=week;
		return week;
	}
	
	protected int curMonth(int month){
		Mod2.month=month;
		return month;
	}
	
	private int curYear(int year){
		Mod2.year=year;
		return year;
	}
	int yr=curYear(10);

	public void setMonth(int month){
		Mod2.month=month;
	
	}
	public int getMonth(){
		return Mod2.month;
	}
}