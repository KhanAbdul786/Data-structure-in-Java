package oops_3;

public class Vehicle implements PrintInterFace{
	int maxSpeed;
	String company;
	public Vehicle(int maxSpeed, String company) {
		super();
		this.maxSpeed = maxSpeed;
		this.company = company;
	}
	@Override
	public void print() {
		System.out.println(maxSpeed+" "+company);
	}
	
	

}
