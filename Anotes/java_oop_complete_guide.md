# Complete Java Object-Oriented Programming Guide

## Table of Contents
1. [Classes and Objects](#classes-and-objects)
2. [Object Creation and Memory](#object-creation-and-memory)
3. [Constructors](#constructors)
4. [Wrapper Classes and Final Keyword](#wrapper-classes-and-final-keyword)
5. [Static Keyword](#static-keyword)
6. [Static Inner Classes](#static-inner-classes)
7. [Packages](#packages)
8. [Singleton Pattern](#singleton-pattern)
9. [Inheritance Introduction](#inheritance-introduction)
10. [Types of Inheritance](#types-of-inheritance)
11. [Polymorphism Introduction](#polymorphism-introduction)
12. [Types of Polymorphism](#types-of-polymorphism)
13. [Encapsulation and Abstraction](#encapsulation-and-abstraction)

---

## Classes and Objects

### 📌 What is a Class?

- A **class** is a **logical construct**, not a physical one.
- It is a **user-defined data type** that groups **properties** (variables) and **functions** (methods) together.
- A **class** acts as a **template or blueprint** from which **objects** are created.

#### 🔧 Example Analogy:
- A class is like the concept of a **car** → it has common properties: `engine`, `price`, `seats`.
- From this blueprint, we can create different **objects** like:
  - `Audi`
  - `BMW`
  - `Tata`

### 🧍‍♂️ What is an Object?

- An **object** is an **instance** (physical reality) of a class.
- It has actual values assigned to the properties defined by the class.

### 🧩 Key Concepts

| Term               | Explanation                                                                 |
|--------------------|-----------------------------------------------------------------------------|
| **Class**          | Logical structure or blueprint (e.g. `Human`)                               |
| **Object**         | Real entity created from class (e.g. `Anmol`, `Kunal`)                      |
| **Instance Variable** | Variables inside the object (e.g. `name`, `rno`, `marks` of a student)       |
| **`.` (dot) operator** | Used to access members of an object (`object.property`)                   |

### 💻 Java Code Example

```java
// Java program to demonstrate class and object

public class Classes {
    public static void main(String[] args) {
        // Kunal will have 3 properties: rno, name, and marks
        Student kunal;
    }
}

// Class creation
class Student {
    int[] rno = new int[5];
    String[] name = new String[5];
    float[] marks = new float[5];
}
```

---

## Object Creation and Memory

```java
//new operator-->Student student1;(declare)
//            -->dynimacally aloocates memory and returs refrence to it
//              student1=new Student();
//            -->what dies new does-->dynamic memory alocation

public class objects {
    public static void main(String[] args){

        Student[] students=new Student[5];

        // Student kunal;
        // kunal=new Student();
        
        Student kunal=new Student();

        kunal.rno=15;
        kunal.name="Kunal kushwaha";
        kunal.marks=98.0f;

        System.out.println(kunal.rno);
        System.out.println(kunal.name);
        System.out.println(kunal.marks);

    }
}

class Student{
    int rno;
    String name;
    float marks;
}
```

---

## Constructors

```java
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

        // Calling to same reference
        Student one=new Student();
        Student two=one;

        one.name="Hello";
        System.out.println(two.name);
    }
}

class Student {
    int rno;
    String name;
    float marks;

    void greeting() {
        System.out.println("Name is " + this.name);
    }

    void changeName(String newName) {
        name = newName;
    }

    // Constructor with parameters
    Student(int rno, String name, float marks) {
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }

    // Copy constructor
    Student(Student other) {
        this.name = other.name;
        this.rno = other.rno;
        this.marks = other.marks;
    }

    // Default constructor calling another constructor
    Student() {
        this(13, "Anmol", 23.0f);
    }
}
```

---

## Wrapper Classes and Final Keyword

### 1. Introduction
This example demonstrates:
- The concept of **Wrapper Classes** in Java.
- How the **`final` keyword** behaves differently for **primitive** and **non-primitive** data types.
- The difference between **changing a value** and **changing a reference**.

### 2. Full Code Example

```java
public class Wrapper {
    public static void main(String[] args) {
        // Primitive type
        int a = 10;

        // Wrapper class object (non-primitive type)
        Integer num = 45;

        // -------------------------------
        // Using 'final' with primitive type
        // -------------------------------
        final int B = 23; 
        // B++; // ❌ Error: Cannot change value of a final primitive

        // -------------------------------
        // Using 'final' with non-primitive type
        // -------------------------------
        final A kunal = new A("kunal kush");

        // ✅ Allowed: Changing the object's internal property
        kunal.name = "other name";

        // ❌ Not allowed: Reassigning the reference to a new object
        // kunal = new A("new object");
    }
}

class A {
    String name;

    public A(String name) {
        this.name = name;
    }
}
```

---

## Static Keyword

### What is `static` in Java?

In Java, the `static` keyword is used for:
- **Variables** → Shared by all objects of a class.
- **Methods** → Can be called without creating an object.
- **Blocks** → Code that runs once when the class is loaded.

**Key Properties:**
- Belongs to the **class**, not an object.
- **Static methods** cannot access non-static variables directly.
- Static blocks are used for **initialization**.

### Example 1 — Static Variable

#### `Human.java`
```java
package StaticExamples;

public class Human {
    int age;
    String name;
    int salary;
    boolean ismarried;
    
    // Common to all objects
    static long population;

    public Human(int age, String name, int salary, boolean ismarried) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.ismarried = ismarried;

        // Increment population for every object created
        Human.population += 1;
    }
}
```

#### `Main.java`
```java
package StaticExamples;

public class Main {
    public static void main(String[] args) {
        Human kunal = new Human(23, "Kunal", 200, false);
        Human rahul = new Human(32, "Rahul", 400, false);
        Human arpit = new Human(32, "Arpit", 400, false);

        System.out.println(rahul.name);

        // Accessing static variable via object (possible but not recommended)
        System.out.println(kunal.population);
        System.out.println(rahul.population);
        System.out.println(arpit.population);

        // Recommended: Access via class name
        System.out.println(Human.population);
        System.out.println(Human.population);
        System.out.println(Human.population);
    }

    static void fun() {
        Main obj = new Main();
        // greeting(); // ❌ Cannot call non-static method directly
        obj.greeting(); // ✅ Works because an object is created
    }

    void greeting() {
        fun(); // ✅ Static can be called from non-static
        System.out.println("Hello world");
    }
}
```

#### `Staticblob.java`
```java
package StaticExamples;

// Shows initialization of static variables
public class Staticblob {
    static int a = 4;
    static int b;
    
    // Will only run once when the class is first loaded
    static {
        System.out.println("I am in static block");
        b = a * 5;
    }

    public static void main(String[] args) {
        // We create the object here, which triggers class loading
        Staticblob obj = new Staticblob();
        System.out.println(Staticblob.a + " " + Staticblob.b);
    }
}
```

### Execution Flow Diagram
```
          ┌───────────────────────────────┐
          │ Class Loading by JVM           │
          └──────────────┬────────────────┘
                         │
             Initialize static variables
                         │
            Execute static block(s) once
                         │
             Call main(String[] args)
                         │
            ┌─────────────────────────────┐
            │   Inside main method         │
            │  (create objects, call       │
            │   methods, etc.)             │
            └─────────────────────────────┘
                         │
            Objects call constructors
                         │
                   Program ends
```

---

## Static Inner Classes

### 📌 Overview
In Java, classes can be **nested** (a class inside another class). These nested classes can be:
1. **Non-static inner classes** → tied to an instance of the outer class.
2. **Static nested classes** → independent of the outer class object.

### 💡 Key Concepts

#### 1. **Top-Level Classes Cannot Be Static**
In Java:
- The keyword `static` means "belongs to the class, not an object".
- Top-level classes are **already outside** any other class, so making them static makes no sense.
- **Only nested classes** (classes defined inside another class) can be marked `static`.

#### 2. **Non-Static Inner Classes**
- They **require** an instance of the outer class.
- They have an **implicit reference** to the outer class object.
- You must create them like this:
  ```java
  Outer outer = new Outer();
  Outer.Inner innerObj = outer.new Inner();
  ```

### Example Code

```java
package StaticExamples;

// ✅ Outer (top-level) classes CANNOT be static in Java.
// The "static" keyword here only works for inner/nested classes.
class Test {
    String name;

    public Test(String name) {
        this.name = name;
    }
}

public class InnerClasses {

    /*
     * 🚫 NON-STATIC Inner Class Example (commented out):
     *
     * If we define "Test" here WITHOUT static:
     *
     * class Test {
     *     String name;
     *
     *     public Test(String name) {
     *         this.name = name;
     *     }
     * }
     *
     * Then this inner class would be tied to an object of "InnerClasses".
     * This means:
     * - You CANNOT create an object of Test without first creating
     *   an object of InnerClasses.
     * - Syntax would be:
     *      InnerClasses outer = new InnerClasses();
     *      InnerClasses.Test obj = outer.new Test("Hello");
     *
     * This is because non-static inner classes carry a hidden reference
     * to the outer class object.
     */

    /*
     * ✅ STATIC Inner Class:
     * By adding "static" before class Test, we make it an independent
     * nested class that does NOT depend on an object of Outer Class.
     * 
     * Key differences from non-static inner class:
     * - No hidden reference to Outer class object.
     * - Can be created directly using:
     *      InnerClasses.Test obj = new InnerClasses.Test("Hello");
     * - Useful for grouping classes logically, without tying their lifecycle
     *   to an instance of the outer class.
     */
    static class Test {
        String name;

        public Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        /*
         * Creating objects of the STATIC inner class:
         * 
         * Since Test is static, we can create objects directly
         * without creating an object of InnerClasses.
         *
         * If Test was non-static:
         *   ❌ Test a = new Test("Anmol");  // ERROR
         *   ✅ InnerClasses outer = new InnerClasses();
         *      Test a = outer.new Test("Anmol");
         */
        Test a = new Test("Anmol");
        Test b = new Test("Work");

        // Printing the name of the first object:
        System.out.print(a.name);
    }
}
```

---

## Packages

**Packages** in Java are containers for classes.  
They are essentially just folders that organize Java files.

### Key Points
- **Packages are containers for classes**.
- **A package is simply a folder** in the file system.
- We cannot create two `.java` files with the same name inside the **same** package (folder).  
  To have files with the same class name, we place them in different packages.
- **We can call methods of another package from another folder** using `import` and then invoking that function.

### Example 1 — Simple Class in a Package

```java
public class packages {
    
}
//only function that are public that only can be accessed
```

### File Structure
```
OOPS/
 ├─ a/
 │   └─ Hello.java
 └─ b/
     └─ Hello.java
```

#### `a/Hello.java`
```java
package a;

public class Hello {
    public static void main(String[] args) {
        // Empty main method
    }

    public static void print() {
        System.out.println("Hello a");
    }
}
```

#### `b/Hello.java`
```java
// We can call a method of another package from another folder using import
// and then using that function
package b;
import static a.Hello.print;

public class Hello {
    public static void main(String[] args) {
        System.out.println("This is b");
        print();
    }
}
```

---

## Singleton Pattern

### **What is a Singleton?**
A **Singleton** is a design pattern that ensures:
1. Only **one** instance of a class exists during the lifetime of the program.
2. There is a **global access point** to that instance.

### **Why use Singleton?**
- **Memory Efficiency** → Only one object is created, reused everywhere.
- **Control** → Restricts instantiation to a single instance.
- **Consistency** → Same object means same state across the program.

### **Example Code**

#### **Singleton.java**
```java
package SigletonClass;

public class Sigleton {

    // 🔹 Private constructor → Prevents object creation from outside this class.
    private Sigleton() {
    }

    // 🔹 Holds the single allowed instance of Sigleton.
    private static Sigleton instance;

    // 🔹 Global access point for the single instance.
    public static Sigleton getInstance() {
        if (instance == null) {
            // Object is created only ONCE.
            instance = new Sigleton();
        }
        return instance;
    }
}
```

#### **Main.java**
```java
package SigletonClass;

public class Main {

    public static void main(String[] args) {

        // Getting the singleton instance
        Sigleton obj1 = Sigleton.getInstance();
        Sigleton obj2 = Sigleton.getInstance();
        Sigleton obj3 = Sigleton.getInstance();

        // All references point to the SAME object
        System.out.println(obj1 == obj2); // true
        System.out.println(obj2 == obj3); // true
    }
}
```

### Flow Diagram
```
           ┌────────────────────┐
          │   Main Class        │
          └────────────────────┘
                  │
                  ▼
         getInstance() called
                  │
   ┌──────────────┴──────────────┐
   │ instance == null?           │
   └──────────────┬──────────────┘
                  │YES
                  ▼
     Create new Sigleton object
                  │
                  ▼
    Return same object reference
                  │
                  ▼
   All variables share SAME object
```

---

## Inheritance Introduction

### Box.java
```java
// Parent class
// Represents a 3D box with length, height, and width.
// Used as a base class for more specific types of boxes.
public class Box {
    double l; // length
    double h; // height
    double w; // width

    // Default constructor: initializes dimensions to -1 (uninitialized state)
    Box() {
        super(); // Calls Object class constructor (implicit in Java)
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    // Constructor for a cube (all sides equal)
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
```

### BoxWeight.java
```java
// Child class extending Box
// Adds weight property to the box dimensions from the parent class.
public class BoxWeight extends Box {
    double weight; // Additional property for the weight of the box

    // Default constructor: initializes weight and parent dimensions to -1
    public BoxWeight() {
        super(); // Optional here, would be called automatically
        this.weight = -1;
    }

    // Parameterized constructor:
    // Uses super() to initialize Box's dimensions,
    // then initializes weight.
    public BoxWeight(double l, double h, double w, double weight) {
        super(l, h, w); // Call parent constructor to initialize dimensions
        this.weight = weight;
    }
}
```

### Main.java
```java
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
    }
}
```

---

## Types of Inheritance

### Main.java
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
```

### Box.java
```java
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
```

### BoxWeight.java
```java
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
```

### BoxPrice.java
```java
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
```

### BoxColor.java
```java
package Inheritance.Inheritance_Types;

// 🔹 Hierarchical Inheritance (BoxColor → BoxWeight → Box)
public class BoxColor extends BoxWeight {
    // Can add color-related fields and methods here
}
```

### Inheritance Hierarchy Diagram
```
        Box
         ↑
    ┌────┴────┐
    │         │
BoxWeight   BoxColor  ← Hierarchical
    ↑
 BoxPrice   ← Multilevel
```

---

## Polymorphism Introduction

### Shapes.java
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
```

### Circle.java
```java
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
```

### Square.java
```java
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
```

### Triangle.java
```java
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
```

### Main.java
```java
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
```

---

## Types of Polymorphism

### Intro.java
```java
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
s.area(); // Runs Circle's area() because object is Circle.

*/
public class Intro {
    
}
```

### Circle.java
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
        - Compiler gives an error if method signature doesn't match.
    */
    @Override
    void area() {
        System.out.println("I am in Circle");
    }
}
```

### Main.java
```java
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
```

### Number.java
```java
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
```

### Shapes.java
```java
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
```

---

## Encapsulation and Abstraction

### 📌 Encapsulation vs Abstraction (Quick Revision Notes)

**Encapsulation:**
- Wrapping data (fields) and methods into a single unit (class).
- Achieved using access modifiers (private, public, protected).
- Controls HOW data is accessed/modified (via getters/setters).
- Implementation-level concept (code organization & data protection).
- Example: Private variables + public getters/setters.

**Abstraction:**
- Hiding implementation details, showing only essential features.
- Achieved using abstract classes & interfaces.
- Focuses on WHAT operations an object can perform, not HOW.
- Design-level concept (focus on interaction, not internals).
- Example: Using ArrayList methods without knowing internal code.

### 🆚 Quick Comparison Table:
| Feature           | Encapsulation               | Abstraction                 |
|-------------------|-----------------------------|-----------------------------|
| Purpose           | Hide the data               | Hide the process            |
| Level             | Implementation-level        | Design-level                |
| Achieved by       | Access modifiers, classes   | Abstract classes, interfaces|
| Focus             | Data hiding                 | Hiding complexity           |
| Example           | Getters/Setters             | ArrayList usage             |

### Encapsulation Example
```java
class Student {
    private String name;

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}
```

### Abstraction Example
```java
abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}
```

---

## Summary

This comprehensive guide covers all the fundamental concepts of Object-Oriented Programming in Java:

1. **Classes and Objects**: The foundation of OOP - blueprints and instances
2. **Object Creation**: Understanding memory allocation and the `new` operator
3. **Constructors**: Different types including default, parameterized, and copy constructors
4. **Wrapper Classes**: Understanding primitive vs non-primitive types and the `final` keyword
5. **Static Keyword**: Class-level members, methods, and initialization blocks
6. **Static Inner Classes**: Nested classes and their relationship with outer classes
7. **Packages**: Code organization and namespace management
8. **Singleton Pattern**: Ensuring single instance creation and global access
9. **Inheritance**: Code reusability through parent-child relationships
10. **Types of Inheritance**: Single, multilevel, hierarchical, and their implementations
11. **Polymorphism**: Runtime and compile-time polymorphism with method overriding and overloading
12. **Encapsulation and Abstraction**: Data hiding and complexity management

Each section includes practical code examples, detailed explanations, and best practices to help you master Java OOP concepts. The examples progress from basic to advanced topics, building upon previously learned concepts to create a solid foundation in object-oriented programming.