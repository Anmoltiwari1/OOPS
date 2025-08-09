public class Constructor {
    public static void main(String[] args) {
        Student kunal=new Student(12, "kunal", 12.0f);
        System.out.println(kunal.name);
        kunal.greeting();
        kunal.changeName("Show lover");
        kunal.greeting();



        Student rahul=new Student(23, "Rahul", 14.0f);
        rahul.greeting();

        Student random=new Student(kunal);
        random.marks=23;
        random.rno=12;

        System.out.println(random.marks);
        
    }
}

class Student{
    int rno;
    String name;
    float marks;

    void greeting(){
        System.out.println("Name is " +this.name);
    }

    void changeName(String newName){
        name=newName;
    }

    //When I run the stundent with 3 parametrs it whill run this constructor
    Student(int rno,String name,float marks){
        this.rno=rno;
        this.name=name;
        this.marks=marks;
    }

    //When I run the student with no parametrs this will run.-->Calles consturctor overloading
    //Correct way is this
    Student(){
        this.rno=13;
        this.name="Anmol";
        this.marks=23.0f;
    }

    //caloing parametes of other stundent
    Student(Student other){
        this.name=other.name;
        this.rno=other.rno;
        this.marks=other.marks;
    }
}
