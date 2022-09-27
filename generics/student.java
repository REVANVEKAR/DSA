package generics;

public class student implements printinterface{

    int rollnumber;

    public student(int rollnumber){
        this.rollnumber = rollnumber;
    }

    public void print() {
        System.out.println(rollnumber);
    }
}
