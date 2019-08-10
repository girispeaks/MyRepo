package a.b.c;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator calc=new Calculator();
		CalculatorPortType calcprt=calc.getCalculatorHttpSoap11Endpoint();
		System.out.println(calcprt.add(3, 9));
	}

}
