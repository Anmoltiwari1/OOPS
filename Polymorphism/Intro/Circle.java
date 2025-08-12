// Circle.java
package Polymorphism.Intro;

// Circle class extends Shapes (Inheritance)
public class Circle extends Shapes {
    
    // Overriding the area() method from Shapes
    //This wull reun when obj to Circle is created.
    //Heance it is oversiding the paranet method.
    void area() {
        System.out.println("I am in Circle");
    }
}
