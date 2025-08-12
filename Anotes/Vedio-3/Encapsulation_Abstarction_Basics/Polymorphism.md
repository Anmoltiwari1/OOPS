# 🧠 Java Polymorphism – Basic Version (No “Types_of_poly” package)

---

## 📂 Shapes.java
```java
package Polymorphism.Intro;

/*
    Base class for polymorphism example.
    - Contains a general area() method.
    - Child classes will override this method.
*/
public class Shapes {
    void area() {
        System.out.println("I am in shapes");
    }
}
package Polymorphism.Intro;

/*
    Circle class extends Shapes.
    Demonstrates METHOD OVERRIDING (Runtime Polymorphism).
*/
public class Circle extends Shapes {
    @Override
    void area() {
        System.out.println("I am in Circle");
    }
}
package Polymorphism.Intro;

/*
    Square class extends Shapes.
    Overrides the area() method to provide its own behavior.
*/
public class Square extends Shapes {
    @Override
    void area() {
        System.out.println("I am in squares");
    }
}
package Polymorphism.Intro;

/*
    Triangle class extends Shapes.
    Overrides the area() method for triangle-specific output.
*/
public class Triangle extends Shapes {
    @Override
    void area() {
        System.out.println("I am in Triangles");
    }
}
package Polymorphism.Intro;

public class Main {
    public static void main(String[] args) {
        
        // Parent reference & Parent object
        Shapes shape = new Shapes();
        
        // Child reference & Child object
        Circle circle = new Circle();
        
        // Another child class (Square) — not used in method call here
        Square square = new Square();

        // Calls Shapes' version
        shape.area();
        
        // Calls Circle's overridden version
        circle.area();
    }
}

