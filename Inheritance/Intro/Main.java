package Inheritance.Intro;

public class Main {
    public static void main(String[] args) {
        // Constructor selection depends on the arguments passed

        Box box = new Box(4); // Cube with side = 4
        System.out.println(box.l + " " + box.w + " " + box.h);

        BoxWeight box3 = new BoxWeight(); // All values default to -1
        System.out.println(box3.h + " " + box3.l);

        BoxWeight box4 = new BoxWeight(2, 3, 4, 8);
        System.out.println(box4.l + " " + box4.h + " " + box4.w + " " + box4.weight);

        // Reference type decides what members are accessible.
        // Here, reference type is Box, so only Box's fields/methods can be accessed,
        // even though the actual object is BoxWeight.
        Box box5 = new BoxWeight(2, 3, 4, 5);
        // System.out.println(box5.weight); // ❌ Compile-time error: weight not in Box

        // Parent reference cannot point to a child constructor directly:
        // BoxWeight box6 = new Box(1, 2, 3); // ❌ Incompatible types

        //Multilevel Inheritance.
        //Calls Boxprice() consturctor --> calls super() means just above it which is BoxWieght()-->which calls box();
        BoxPrice box9=new BoxPrice();
    }
}
