package dummy;

import java.util.Scanner;

public class Dummy8 {

	private static Scanner sc;

	public static void main(String[] args) {
		int num;
		sc = new Scanner(System.in);
		System.out.println("Enter the value of num: ");
		num=sc.nextInt();
		
		for(int i=2;i<=num;i++){
			if(i==num){
				System.out.println("Number is Prime");
				break;
			}
			if(num%i==0){
				System.out.println("Number is not Prime");
				break;
			}
		}
	}
}
