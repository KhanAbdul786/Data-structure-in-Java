package oops_1;

public class Fraction {
	int numerator;
	int denominator;

	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	public void setNumerator(int num) {
		numerator=num;
		simplify();
	}
	public int geNumerator() {
		return numerator;
	}
	
	public void setDenominator(int num) {
		if(num==0) {
			denominator=1;
		}
		denominator=num;
		simplify();
	}
	public int getDenominator() {
		return denominator;
	}

	public void print() {
		simplify();
		System.out.println(numerator + "/" + denominator);
	}

	private void simplify() {
		int gcd = 1;
		int min = Math.min(numerator, denominator);
		for (int i = 2; i < min; i++) {
			if (numerator % i == 0 && denominator % i == 0) {
				gcd = i;
			}
		}
		numerator = numerator / gcd;
		denominator = denominator / gcd;

	}
	public void increment() {
		numerator=numerator+denominator;
	}
	
//	public void add(int numerator, int denominator) {
//		this.numerator=this.numerator*denominator+this.denominator*numerator;
//		this.denominator=this.denominator*denominator;
//		simplify();
//	}
	
	//OR
	public void add(Fraction f) {
		this.numerator=this.numerator*f.denominator+this.denominator*f.numerator;
		this.denominator=this.denominator*f.denominator;
		simplify();
	}
	
	public void substract(Fraction f) {
		this.numerator=this.numerator*f.denominator-this.denominator*f.numerator;
		this.denominator=this.denominator*f.denominator;
		simplify();
	}
	
	public Fraction addTwoFrac(Fraction f1,Fraction f2) {
		int num=f1.numerator*f2.denominator+f1.denominator*f2.numerator;
		int denom=f1.denominator*f2.denominator;
		Fraction f3=new Fraction(num,denom);
		return f3;
	
	}

}
