package Inheritance;

public abstract class car extends Vehicle{


    int numDoors;
    int maxSpeed;

    public car(int numDoors, int maxspeed){
        super(maxspeed);
        System.out.println("car conmstructor");
        this.numDoors = numDoors;
    }

    public void print(){
        super.print();

        System.out.println("car" + " numDoors " + numDoors);
    }

    @Override
    public boolean isMotorized() {
        return true;
    }

    public void printmaxSpeed(){
        super.maxSpeed = 150;
        System.out.println(maxSpeed + " " + super.maxSpeed);
    }







}
