package Inheritance;

public class bmw extends car{

    public bmw(int numDoors, int maxspeed) {
        super(numDoors, maxspeed);
    }

    @Override
    public String getcompany() {
        return "bmw";
    }
}
