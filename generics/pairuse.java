package generics;

public class pairuse {
    public static void main(String[] args) {

        pair<String, Integer> pinner = new pair<>("ab", 100);
        pair<Double, String> p2inner = new pair<>(2d,"revi");
        pair<pair<String, Integer>, pair<Double, String>> p = new pair<>();
        p.setFirst(pinner); //setting first as pinner
        p.setsecond(p2inner); // setting second as p2inner
        System.out.println(p.getfirst()); //address dega
        System.out.println(p.getSecond());
        System.out.println(p.getfirst().getfirst()); // first ke andar first
        System.out.println(p.getfirst().getSecond());
        System.out.println(p.getSecond().getfirst());
        System.out.println(p.getSecond().getSecond()); // second ke andar second


//        p.setsecond("abcdlodi");
//        System.out.println(p.getSecondt());

//        int i = 10; // int i = null; not allowed
//        Integer i1 = null; // allowed but dangerous

//        pair p = new pair(10,20);
        //in case if we dont define and directly write this it will consider
//        the type as object (object is the super class) as its parent
//        class of everything
//        p.setFirst("aa");
//        p.setFirst(101);

//        String f = (String)p.getfirst();  we dont know what getfirst will return as
//        object. and it can have any value and can return an exception error
//        it allows both see
//        System.out.println(p.getfirst() + " " + p.getSecondt());
//        even if its not incorrect syntax wise but very dangerous




//        pairString s = new pairString("aa","bb");
//        pairdouble d = new pairdouble(4.1, 7.8);

//        pair<String> a = new pair<String>("aa","bb");
//        a.setFirst("10");
//        System.out.println(a.getfirst() + " " + a.getSecondt());


//        pair<int> b = new pair<int>(10,20);
//        we cant use primitve data types to create new objects .
//        so cant I create a object with int ? we can!
//        we have to write a non prirmitve datattype like Integer , a wrapper class
//        for every primritve datatype we have a wrapper class
//        pair<Integer> b = new pair<Integer>(10,20); // something like this
//        System.out.println(b.getfirst() + " " + b.getSecondt());
//
//        pair<Double> c = new pair<Double>(10d,20d); // something like this
//        System.out.println(c.getfirst() + " " + c.getSecondt());

//        pair<vehicle> pv = new pair<vehicle>(new vehicle(), new vechile());
//        we can do this


//        pair<Integer, String> p = new pair<>(10, "abcdlodi");
//        System.out.println(p.getfirst() + " " + p.getSecondt());








    }
}
