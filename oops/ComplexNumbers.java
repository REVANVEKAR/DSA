package oops;

public class ComplexNumbers {

    int real;
    int imaginary;

    public ComplexNumbers(int real , int imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public void plus(ComplexNumbers c2){
        this.real = c2.real + this.real;
        this.imaginary = c2.imaginary + this.imaginary;
    }

    public void print(){
        System.out.println(real + " + i" + imaginary);
    }

    public void multiply(ComplexNumbers c2){
        int temp;
        temp = ( this.real * c2.real ) - (this.imaginary * c2.imaginary);
        this.imaginary = (this.real * c2.imaginary) + (this.imaginary * c2.real);
        this.real = temp;
    }
}
