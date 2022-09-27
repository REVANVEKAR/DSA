package exceptions;

public class ExceptionDemo {

    public static int fact(int n) throws NegativeNumberException {
        if(n<0){
            throw new NegativeNumberException();
        }
        int ans = 1;
        for (int i = 0; i<= n;i++){
            ans = ans * i;
        }
        return ans;
    }

    public static int divide(int a , int b) throws DivideByZero{
        if(b == 0 ){
            throw new DivideByZero();
        }
        return a/b;
        }




        public static void main (String[]args) {


        //

        try {
            divide(10, 0);
            System.out.println(fact(1));
            System.out.println("within try");
        }
        catch (DivideByZero e){
            System.out.println("Divide by zero exception raised");
//            e.printStackTrace();
        }
        catch(NegativeNumberException e) {
//            e.printStackTrace();
            System.out.println("negative number exception" );
        }
        catch(Exception e){
            System.out.println("generic exception");
        }finally{

        }
            System.out.println("Main");
    }
}
