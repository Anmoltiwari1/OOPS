# Java Polymorphism – Compile-Time & Run-Time

## 📌 Overview
This project demonstrates **both types of polymorphism** in Java:  
1. **Compile-Time (Static) Polymorphism** → Achieved using **method overloading**.  
2. **Run-Time (Dynamic) Polymorphism** → Achieved using **method overriding**.  

It also explains **how reference type and object type affect method calls**.

---

## 📂 Project Structure
## 📂 Project Structure
Polymorphism/
└── Types_of_poly/
├── Shapes.java # Parent class for runtime polymorphism
├── Circle.java # Child class overriding area() method
├── Intro.java # Documentation & theory notes
├── Main.java # Demonstrates runtime polymorphism
└── Number.java # Demonstrates compile-time polymorphism

---

## 🧠 Key OOP Concepts Used

### **1. Compile-Time Polymorphism (Method Overloading)**
- Same method name but **different parameter lists**.
- Resolved **by the compiler** during compilation.
- Example:
```java
int sum(int a, int b) { return a + b; }
int sum(int a, int b, int c) { return a + b + c; }
package Polymorphism.Types_of_poly;

// Parent (Base) class for polymorphism examples
public class Shapes {
    // Default implementation of area()
    void area() {
        System.out.println("I am in shapes");
    }
}
package Polymorphism.Types_of_poly;

/*
    Child class of Shapes demonstrating method overriding
*/
public class Circle extends Shapes {
    
    // Overriding area() method from Shapes
    @Override
    void area() {
        System.out.println("I am in Circle");
    }
}
package Polymorphism.Types_of_poly;

/*
========================================
📌 POLYMORPHISM IN JAVA
========================================

Polymorphism = "One name, many forms"

TYPES:
----------------------------------------
1️⃣ Compile-Time (Static) Polymorphism
   - Achieved by METHOD OVERLOADING.
   - Example: Multiple constructors or same method with different params.

2️⃣ Run-Time (Dynamic) Polymorphism
   - Achieved by METHOD OVERRIDING.
   - Which method runs is decided at runtime based on OBJECT TYPE.
   - Example: Shapes s = new Circle(); s.area();

IMPORTANT:
- Reference Type → Decides accessible members.
- Object Type → Decides which overridden method runs.
*/
public class Intro { }

package Polymorphism.Types_of_poly;

public class Main {
    public static void main(String[] args) {

        // Parent reference & Parent object
        Shapes shape = new Shapes();
        shape.area(); // "I am in shapes"

        // Child reference & Child object
        Circle circle = new Circle();
        circle.area(); // "I am in Circle"

        // Parent reference but Child object (Runtime Polymorphism)
        Shapes c = new Circle();
        c.area(); // "I am in Circle"
    }
}
package Polymorphism.Types_of_poly;

/*
    Example of Compile-Time (Static) Polymorphism
*/
public class Number {

    // Method overloading: Different parameter lists
    int sum(int a, int b) { return a + b; }
    int sum(int a, int b, int c) { return a + b + c; }

    public static void main(String[] args) {
        Number obj = new Number();

        System.out.println(obj.sum(2, 3));    // Calls 2-parameter version
        System.out.println(obj.sum(2, 3, 7)); // Calls 3-parameter version
    }
}
