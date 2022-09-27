package Inheritancetemp;

import Inheritance.Vehicle;

public class Truck extends Vehicle {

    int maxLoadCapacity;

    public void print(){
        System.out.println("Vehicle" + " colour " + getcolour() + " maxSpeed " + maxSpeed + "maxLoadCapacity"+ maxLoadCapacity);
    }

    @Override
    public boolean isMotorized() {
        return true;
    }

    @Override
    public String getcompany() {
        return null;
    }


}
