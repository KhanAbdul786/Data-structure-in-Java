package oops_1;

public class ComplexNumber {
	int real;
	int imagin;

	public ComplexNumber(int real, int imagin) {
		this.real = real;
		this.imagin = imagin;

	}
	
	public void setReal(int real) {
		this.real=real;
	}
	
	public void setImaginary(int imagin) {
		this.imagin=imagin;
	}
	
	public void add(ComplexNumber c) {
		this.real=this.real+c.real;
		this.imagin=this.imagin+c.imagin;
	}
	
	public void show() {
		System.out.println(this.real);
		System.out.println(this.imagin);
	}
	
	public void multiply(ComplexNumber c) {
		int real=(this.real*c.real)-(this.imagin*c.imagin);
		int imag=(this.real*c.imagin)+(c.real*this.imagin);
		this.real=real;
		this.imagin=imag;
	}
	
	public static ComplexNumber addCompl(ComplexNumber c1,ComplexNumber c2) {
		
		int real=(c1.real*c2.real)-(c1.imagin*c2.imagin);
		int imag=(c1.imagin*c2.real)+(c2.imagin*c1.real);
		
		ComplexNumber n=new ComplexNumber(real,imag);
		return n;
	}
	
	public void print() {
		System.out.println(real+"+i"+imagin);
	}
}
