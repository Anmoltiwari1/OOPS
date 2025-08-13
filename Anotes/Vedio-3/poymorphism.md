# Java Polymorphism Example

## 📌 Overview
This project demonstrates **Polymorphism** in Java using **Inheritance** and **Method Overriding**.  
The concept shown here is **runtime polymorphism**, where the method to be executed is determined by the type of the object at runtime.

---

## 📂 Project Structure

---

## 🧠 Key OOP Concepts Used

1. **Inheritance**
   - Child classes (`Circle`, `Square`, `Triangle`) extend the parent class `Shapes`.

2. **Method Overriding**
   - Each child class provides its own implementation of the `area()` method defined in `Shapes`.

3. **Polymorphism**
   - The same method name `area()` behaves differently based on the object type.

---

## 📜 Code Breakdown

### **Shapes.java**
```java
package Polymorphism.Intro;

// Parent class representing general shapes
public class Shapes {

    // Method intended to be overridden by child classes
    void area() {
        System.out.println("I am in shapes");
    }
}
package Polymorphism.Intro;

// Circle class extends Shapes (Inheritance)
public class Circle extends Shapes {

    // Overriding the area() method from Shapes
    @Override
    void area() {
        System.out.println("I am in Circle");
    }
}
package Polymorphism.Intro;

// Square class extends Shapes (Inheritance)
public class Square extends Shapes {

    // Overriding the area() method from Shapes
    @Override
    void area() {
        System.out.println("I am in squares");
    }
}
package Polymorphism.Intro;

// Triangle class extends Shapes (Inheritance)
public class Triangle extends Shapes {

    // Overriding the area() method from Shapes
    @Override
    void area() {
        System.out.println("I am in Triangles");
    }
}
package Polymorphism.Intro;

public class Main {
    public static void main(String[] args) {

        // Creating objects of base and derived classes
        Shapes shape = new Shapes();    // Parent class object
        Circle circle = new Circle();   // Child class Circle object
        Square square = new Square();   // Child class Square object

        // Calling methods
        shape.area();    // Calls Shapes' version
        circle.area();   // Calls Circle's overridden version

        // Note: square object is created but not used
    }
}
