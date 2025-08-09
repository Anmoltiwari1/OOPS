public class Wrapper {
    public static void main(String[] args) {
        int a=10;

        //num is not variable , it is object
        Integer num=45;

        //final keyword-->The variable declared with final cannot be modified.
        //final varibale has to be instillized.
        //final property that it will not chnage the value is only upto primitive datatype(int,float etc..) not for non-primitive(like Integer,Double ,final Student one=new Student.. etc) because Non-primitive points to refernce(address of object) means in non-primitive we can change the value but not reference. 
        final int B=23;
        //B++; Will not work

        final A kunal=new A("kunal kush");
        kunal.name="other name";

        //cannot be assigned only values can be changed
        kunal=new A("new object");

    }

}

class A{
String name;

public A(String name){
    this.name=name;
}
}
