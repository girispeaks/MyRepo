package package1;

public class findOval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Selenium";
		String strO="AEIOU";
		str=str.toUpperCase();
		int cnt=0;
		for(int i=0;i<str.length();i++){
			//int cnt=0;
			for(int j=0;j<strO.length();j++){
				if(str.charAt(i)==strO.charAt(j))
					cnt++;
					//System.out.println(str.charAt(i)+" is an oval");
			}
		}
		System.out.println(cnt);

	}

}
