package package2;

public class Mod3 {
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
		Mod3.month=month;
		return month;
	}
	
	private int curYear(int year){
		Mod3.year=year;
		return year;
	}

}
