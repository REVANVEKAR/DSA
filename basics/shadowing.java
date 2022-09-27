package basics;

public class shadowing {
    static int x = 90; //this will be shadowed at line 8 (shadowing)
                       // lower level
                       //will be upper riding the higher level.
                       // higher level is shadowed
    public static void main(String[] args) {
        System.out.println(x); //90
        int x = 40; // the class variable at line 4 is shadowed by this
                    // and also we have to initialize it before using it
        System.out.println(x); //40
        fun();


    }

    static void fun() {
        System.out.println(x);
    }


}
