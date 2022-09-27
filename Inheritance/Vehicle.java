package Inheritance;

 public abstract class Vehicle {

    private String colour;
    protected int maxSpeed;

    public Vehicle(){

    }
    public Vehicle(int maxSpeed){
        System.out.println("vehicle constructor");
        this.maxSpeed = maxSpeed;
        this.colour = colour;
    }

    public String getcolour(){
        return this.colour;
    }

    public void setcolour(String colour){
        this.colour = colour;
    }


    public void print(){
        System.out.println("Vehicle" + " colour " + getcolour() + " maxSpeed " + maxSpeed );
    }

    public abstract boolean isMotorized();

     public abstract String getcompany();
}

