package interfaces;

public class car extends Vehicle implements vehicleinterface, carinterface{
// a class can only extend one class but can
// implement more than one interface


    @Override
    public boolean isMotorized() {
        return true;
    }

    @Override
    public String getcompany() {
        return null;
    }

    @Override
    public int numgears() {
        return 5;
    }

//    void print(){
//        System.out.println(pi);
//    }
}
