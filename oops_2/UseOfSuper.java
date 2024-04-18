package oops_2;
class Person{
	int id;
	String name;
	
	public Person(int id,String name) {
		this.id=id;
		this.name=name;
	}
}

class Emp extends Person{
	float salary;
	int id;
	String name;

	public Emp(int id,String name,float salary) {
		super(id, name);
		this.salary=salary;
	}
	
	void print() {
		System.out.println(id+" "+name+" "+salary);
	}
	
}

public class UseOfSuper {

	public static void main(String[] args) {
		Emp e=new Emp(10, "sss", 12.4f);
		e.print();

	}

}
