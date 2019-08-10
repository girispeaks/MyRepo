package package1;

public class OccOfChinString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="aabcdacd";
		int cnt=0;
		//System.out.println(str.charAt(0));
		for(int i=0;i<str.length();i++){
			cnt=0;
			for(int j=0;j<str.length();j++){
				if(j<i&&(str.charAt(j)==str.charAt(i)))
					break;
				if(str.charAt(i)==str.charAt(j))
					cnt++;
			}
			if(cnt>=1)
				System.out.println(str.charAt(i)+" occured "+cnt+" times");
		}		
	}
}

//&&(str.charAt(j)==str.charAt(i))