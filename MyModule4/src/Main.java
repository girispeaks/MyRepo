
public class Main {

	public static void main(String[] args) {
		
		/*Car C=new Car();
		System.out.println("Wheels "+C.wheels);
		C.start();
		C.accelerate();
		C.stopping();
		System.out.println("-------------------------------");
		Mercedes M = new Mercedes();
		M.price=2000000;
		M.wheels=4;
		M.start();
		M.accelerate();
		M.stopping();
		M.refueling();*/
		
		//Reference of a parent class pointing to an object of a child class
		//By doing this the overridden functions of child class will be called along with the parent class functions 
		Car d = new Mercedes();
		d.start();
		d.accelerate();
		d.stopping();
		
		System.out.println("*************");
		
		Mercedes m = new Mercedes();
		m.start();
		m.accelerate();
		m.stopping();
		m.refueling();
		m.price = 10;
	}

}
