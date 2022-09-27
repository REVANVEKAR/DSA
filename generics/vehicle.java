package generics;

public class vehicle implements printinterface{

    int maxspeed;
    String company;

    public vehicle(int maxspeed, String company){
        super();
        this.maxspeed = maxspeed;
        this.company = company;
    }

    public  void print(){
        System.out.println(maxspeed+ " " + company);
    }

}
