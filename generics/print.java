package generics;

public class print {

    //by extends i am allowing only vehicle ka class and sub class
    //for example if car was a sub class we could use that

    public static<T extends printinterface> void printArray (T[] arr){
        for (int i = 0; i< arr.length ; i++){
            arr[i].print();
//            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[5];
        for (int i = 0; i < arr.length; i++){
            arr[i] = i+1;
        }

//        printArray(arr);

        String[] arrs = new String[5];
        for (int i = 0; i < arrs.length; i++){
            arrs[i] = "ab";
        }
//        printArray(arrs);

        vehicle v[] = new vehicle[5];
        for (int i = 0; i < v.length; i++){
            v[i] = new vehicle(10*i,"bmw");
        }
        printArray(v);

        student[] s = new student[6];
        for (int i = 0; i < s.length; i++){
            s[i] = new student(2*i+1);
        }
        printArray(s);

    }
}
