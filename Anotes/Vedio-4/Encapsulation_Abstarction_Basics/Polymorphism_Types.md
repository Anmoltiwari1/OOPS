# 🧠 Java Polymorphism – Code & Comments

---

## 📂 Circle.java
```java
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
   - Same method name, but parameter list differs 
     (number, type, or order of parameters).
   - Decided by the compiler at compile time.
   - Example: Multiple constructors.

2️⃣ Run-Time (Dynamic) Polymorphism
   - Achieved by METHOD OVERRIDING.
   - Child class has a method with the SAME signature as the parent,
     but different implementation.
   - Which method runs is decided at runtime based on OBJECT TYPE.
   - Rules:
       🔹 Final methods cannot be overridden.
       🔹 Static methods cannot be overridden (only hidden).
       🔹 Access level in child must not be more restrictive.

----------------------------------------
⚙ IMPORTANT:
- Reference Type (left side of =) → Decides which members can be accessed.
- Object Type (right side of =)   → Decides which overridden method runs.

Example:
Shapes s = new Circle();
s.area(); // Runs Circle’s area() because object is Circle.

*/
public class Intro {
    
}
package Polymorphism.Types_of_poly;

public class Main {
    public static void main(String[] args) {
        
        // Parent reference & Parent object → Runs parent method
        Shapes shape = new Shapes();    
        
        // Child reference & Child object → Runs child method
        Circle circle = new Circle();   
        
        // Parent reference but Child object → Runtime Polymorphism
        Shapes c = new Circle();

        // Calls Shapes' version (parent method)
        shape.area();   

        // Calls Circle's overridden version
        circle.area();  

        /*
           Runtime Polymorphism:
           - Reference type: Shapes → Can access only members of Shapes.
           - Object type: Circle → Overridden method from Circle runs.
        */
        c.area();
    }
}
package Polymorphism.Types_of_poly;

/*
    Example of Compile-Time (Static) Polymorphism:
    - Achieved via METHOD OVERLOADING.
    - Which method to call is decided at compile time
      based on method signature.
*/
public class Number {
    
    // sum() with 2 parameters
    int sum(int a, int b) {
        return a + b;
    }

    // sum() with 3 parameters
    int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Number obj = new Number();
        
        // Calls 2-parameter sum() → Decided at compile time
        System.out.println(obj.sum(2, 3));

        // Calls 3-parameter sum() → Decided at compile time
        System.out.println(obj.sum(2, 3, 7));
    }
}
package Polymorphism.Types_of_poly;

/*
    Parent (Base) class for polymorphism examples.
    - area() method is designed to be overridden by child classes.
*/
public class Shapes {
    
    // Default implementation of area()
    void area() {
        System.out.println("I am in shapes");
    }
}
