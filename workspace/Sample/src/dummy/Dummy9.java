package dummy;

public class Dummy9 {

	public static void main(String[] args) {
		// Print digits in a string
		String str="star3sun1moon1car3";
		str=str.replaceAll("[^0-9]","").trim();
		System.out.println(str);
		
		String str1[]=str.split("");
		System.out.println(str1[0]);
	}
}
