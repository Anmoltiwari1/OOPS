# 📦 Java Inheritance Examples – Box Classes

This project demonstrates **different types of inheritance** in Java with clear examples and constructor chaining.

---

## 📜 Main.java
```java
package Inheritance.Inheritance_Types;

public class Main {
    public static void main(String[] args) {

        // --------------------------------------------
        // 🔹 Constructor selection depends on arguments passed
        // --------------------------------------------

        // Cube with side = 4 (Single constructor argument)
        Box box = new Box(4);
        System.out.println(box.l + " " + box.w + " " + box.h);

        // Default constructor from BoxWeight (Single Level Inheritance)
        BoxWeight box3 = new BoxWeight(); // All values default to -1
        System.out.println(box3.h + " " + box3.l);

        // Parameterized constructor from BoxWeight
        BoxWeight box4 = new BoxWeight(2, 3, 4, 8);
        System.out.println(box4.l + " " + box4.h + " " + box4.w + " " + box4.weight);

        // --------------------------------------------
        // 🔹 Reference type decides accessible members
        // --------------------------------------------
        // Even though actual object is BoxWeight,
        // reference type Box can only access members of Box.
        Box box5 = new BoxWeight(2, 3, 4, 5);
        // System.out.println(box5.weight); // ❌ Compile-time error

        // --------------------------------------------
        // ❌ Invalid: Parent reference cannot be directly assigned
        // to an object of child without type matching
        // --------------------------------------------
        // BoxWeight box6 = new Box(1, 2, 3); // ❌ Incompatible types

        // --------------------------------------------
        // 1️⃣ Single Level Inheritance:
        // BoxWeight → Box
        // --------------------------------------------
        Box box1_Single_level = new Box();

        // --------------------------------------------
        // 2️⃣ Multilevel Inheritance:
        // BoxPrice → BoxWeight → Box
        // Constructor chain: BoxPrice() → BoxWeight() → Box()
        // --------------------------------------------
        BoxPrice box9 = new BoxPrice();

        // --------------------------------------------
        // 3️⃣ Multiple Inheritance:
        // (Not supported in Java with classes)
        // Java avoids ambiguity of diamond problem by
        // using interfaces for multiple inheritance.
        // Example: class C implements A, B { }
        // --------------------------------------------

        // --------------------------------------------
        // 4️⃣ Hierarchical Inheritance:
        // BoxWeight → Box
        // BoxColor → BoxWeight
        // Both BoxPrice and BoxColor share the same parent hierarchy
        // --------------------------------------------

        // --------------------------------------------
        // 5️⃣ Hybrid Inheritance:
        // Combination of multiple inheritance types.
        // Not fully supported in Java with classes,
        // but achievable with interfaces + class inheritance.
        // --------------------------------------------
    }
}
package Inheritance.Inheritance_Types;

public class Box {
    double l; // length
    double h; // height
    double w; // width

    // Default constructor: Initializes dimensions to -1 (uninitialized state)
    Box() {
        super(); // Calls Object class constructor (implicit in Java)
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    // Constructor for cube (all sides equal)
    Box(double side) {
        this.l = side;
        this.h = side;
        this.w = side;
    }

    // Constructor for a rectangular box
    Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }
}
package Inheritance.Inheritance_Types;

// 🔹 Single Level Inheritance (BoxWeight → Box)
public class BoxWeight extends Box {
    double weight; // Additional property

    // Default constructor
    public BoxWeight() {
        super(); // Initializes dimensions to -1
        this.weight = -1;
    }

    // Parameterized constructor:
    // Uses super() to initialize dimensions from Box
    public BoxWeight(double l, double h, double w, double weight) {
        super(l, h, w); // Initialize parent class fields
        this.weight = weight;
    }
}
package Inheritance.Inheritance_Types;

// 🔹 Multilevel Inheritance (BoxPrice → BoxWeight → Box)
public class BoxPrice extends BoxWeight {
    double cost;

    // Default constructor: calls parent (BoxWeight) constructor
    BoxPrice() {
        super(); // Calls BoxWeight() → Box()
        this.cost = -1;
    }

    // Parameterized constructor:
    // Passes l, h, w, weight to BoxWeight
    public BoxPrice(double l, double h, double w, double weight, double cost) {
        super(l, h, w, weight);
        this.cost = cost;
    }
}
package Inheritance.Inheritance_Types;

// 🔹 Hierarchical Inheritance (BoxColor → BoxWeight → Box)
public class BoxColor extends BoxWeight {
    // Can add color-related fields and methods here
}
        Box
         ↑
    ┌────┴────┐
    │         │
BoxWeight   BoxColor  ← Hierarchical
    ↑
 BoxPrice   ← Multilevel
