package Polymorphism.Types_of_poly;

/*
    Circle class is a CHILD of Shapes (Inheritance).
    This class demonstrates METHOD OVERRIDING (Run-time Polymorphism).
*/
public class Circle extends Shapes {
    
    /*
        Overriding the area() method from Shapes.
        This version will be executed when the object type is Circle,
        even if the reference type is Shapes.
        
        @Override annotation:
        - Ensures method is truly overriding a parent method.
        - Compiler gives an error if method signature doesn’t match.
    */
    @Override
    void area() {
        System.out.println("I am in Circle");
    }
}
