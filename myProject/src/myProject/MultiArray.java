package myProject;

public class MultiArray {
	 
    public static void main(String[] args) {
          
           String a[][]=new String[4][5];    //declare an array of integers and allocate memory for 10 integers
          
           //Assigning values to first row
           a[0][0]="A1";
           a[0][1]="B1";
           a[0][2]="C1";
           a[0][3]="D1";
           a[0][4]="E1";
          
           //Assigning values to second row
           a[1][0]="A2";
           a[1][1]="B2";
           a[1][2]="C2";
           a[1][3]="D2";
           a[1][4]="E2";
          
           //Assigning values to third row
           a[2][0]="A3";
           a[2][1]="B3";
           a[2][2]="C3";
           a[2][3]="D3";
           a[2][4]="E3";
          
           //Assigning values to fourth row
           a[3][0]="A4";
           a[3][1]="B4";
           a[3][2]="C4";
           a[3][3]="D4";
           a[3][4]="E4";
          
           //Printing values in each index of first row
           System.out.println("First field in first row has value " + a[0][0]);
           System.out.println("Second field in first row has value " + a[0][1]);
           System.out.println("Third field in first row has value " + a[0][2]);
           System.out.println("Fourth field in first row has value " + a[0][3]);
           System.out.println("Fifth field in first row has value " + a[0][4]);
          
           System.out.println("Number of rows are " + a.length);
           System.out.println("Number of columns are " + a[0].length);
          
           //To print the array in order
                                     
           for (int x=0; x<a.length; x++) {
                  for (int y=0; y<a[0].length; y++) 
                        System.out.print(a[x][y]+" ");
                  System.out.print("\n");
                  
           }
          
           System.out.print("......................\n");
           //To print the array in reverse order
          
           for (int p=a.length-1; p>=0; p--) {
                  for (int q=a[0].length-1; q>=0; q--) 
                        System.out.print(a[p][q]+" ");
                  System.out.print("\n");
                  
           }

    }

}
