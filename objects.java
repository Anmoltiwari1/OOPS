
//new operator-->Student student1;(declare)
//            -->dynimacally aloocates memory and returs refrence to it
//              student1=new Student();
//            -->what dies new does-->dynamic memory alocation
public class objects {
    public static void main(String[] args){

        Student[] students=new Student[5];

        // Student kunal;
        // kunal=new Student();
        
        Student kunal=new Student();

        kunal.rno=15;
        kunal.name="Kunal kushwaha";
        kunal.marks=98.0f;

        System.out.println(kunal.rno);
        System.out.println(kunal.name);
        System.out.println(kunal.marks);


    }
}

class Student{
    int rno;
    String name;
    float marks;
}
