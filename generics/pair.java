package generics;

public class pair<T, S>{

    //two generic variables


    //i have used T as a variable with no defined data type yet and
    //i can assign its value once i create a object . i can use anything
    // like revi but
    // i have to write<rev> infront of class to use it as a generic


    private /*int*/T first;
    private /*int*/S second;

    public pair(/*int*/T first , /*int*/S second){
        this.first = first;
        this.second = second;
    }

    public pair() {

    }

    public /*int*/T getfirst(){
        return first;
    }

    public void setFirst(/*int*/T first){
        this.first = first;
    }

    public /*int*/S getSecond(){
        return second;
    }

    public void setsecond(/*int*/S second){
        this.second  = second;
    }

}
