package oops_1;

public class FractionUse {

	public static void main(String[] args) {
		Fraction f1=new Fraction(4, 6);
//		f1.increment();
		f1.print();
//		f1.add(2, 3);
		
		Fraction f2=new Fraction(4,8);
//		f1.add(f2);
//		f1.print();
		
//		Fraction f3 = Fraction.addTwoFrac(f1, f2);
//		f3.print();
		
		Fraction f=new Fraction(1,2);
		f.addTwoFrac(f1, f2);
		f.print();
		

	}
	
	

}
