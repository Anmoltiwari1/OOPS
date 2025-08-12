// Main.java
package Polymorphism.Intro;

public class Main {
    public static void main(String[] args) {
        
        // Creating objects of base class and derived classes
        Shapes shape = new Shapes();    // Object of parent class
        Circle circle = new Circle();   // Object of child class Circle
        Square square = new Square();   // Object of child class Square

        // Calling area() method from base class
        shape.area();   // Will call Shapes' version of area()

        // Calling overridden area() method from child class Circle
        circle.area();  // Will call Circle's version of area()

        // Note: 'square' object is created but not used here
    }
}
