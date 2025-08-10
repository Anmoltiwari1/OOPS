package StaticExamples;

//Shows Insilization of static variable
public class Staticblob {
    static int a=4;
    static int b;
    
    //Will only run once when first time class is loaded or object is created
    static{
        System.out.println("I am in static block");
        b=a*5;
    }

    public static void main(String[] args) {
        //We not create the object ,but we are teeling complier to load class
        Staticblob obj=new Staticblob();
        System.out.println(Staticblob.a +" "+ Staticblob.b);
    }
}
