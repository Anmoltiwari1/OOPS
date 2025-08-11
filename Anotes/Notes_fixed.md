# 🧠 Java Notes – Classes and Objects

---
## 📌 What is a Class?


- A **class** is a **logical construct**, not a physical one.
- It is a **user-defined data type** that groups **properties** (variables) and **functions** (methods) together.
- A **class** acts as a **template or blueprint** from which **objects** are created.

### 🔧 Example Analogy:
- A class is like the concept of a **car** → it has common properties: `engine`, `price`, `seats`.
- From this blueprint, we can create different **objects** like:
  - `Audi`
  - `BMW`
  - `Tata`

---
## 🧍‍♂️ What is an Object?

- An **object** is an **instance** (physical reality) of a class.
- It has actual values assigned to the properties defined by the class.

---
## 🧩 Key Concepts

| Term               | Explanation                                                                 |
|--------------------|-----------------------------------------------------------------------------|
| **Class**          | Logical structure or blueprint (e.g. `Human`)                               |
| **Object**         | Real entity created from class (e.g. `Anmol`, `Kunal`)                      |
| **Instance Variable** | Variables inside the object (e.g. `name`, `rno`, `marks` of a student)       |
| **`.` (dot) operator** | Used to access members of an object (`object.property`)                   |

---
## 💻 Java Code Example

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
# Java Notes – Objects

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
# Java Constructor Example
## File: `Constructor.java`

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
# Java Wrapper Classes and `final` Keyword
```
## 1. Introduction
This example demonstrates:
- The concept of **Wrapper Classes** in Java.
- How the **`final` keyword** behaves differently for **primitive** and **non-primitive** data types.
- The difference between **changing a value** and **changing a reference**.

---
## 2. Full Code Example

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
# Packages in Java

**Packages** in Java are containers for classes.  
They are essentially just folders that organize Java files.
```
## Key Points
- **Packages are containers for classes**.
- **A package is simply a folder** in the file system.
- We cannot create two `.java` files with the same name inside the **same** package (folder).  
  To have files with the same class name, we place them in different packages.
- **We can call methods of another package from another folder** using `import` and then invoking that function.

---
## Example 1 — Simple Class in a Package

```java
public class packages {
    
}
//only function that are public that only can be accessed
OOPS/
 ├─ a/
 │   └─ Hello.java
 └─ b/
     └─ Hello.java
package a;

public class Hello {
    public static void main(String[] args) {
        // Empty main method
    }

    public static void print() {
        System.out.println("Hello a");
    }
}
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
# Java `static` Keyword, Static Variables, Methods, and Static Blocks

This document explains the **`static` keyword** in Java, covering static variables, static methods, static blocks, and their execution order.  
It also includes **full code examples** and a diagram of execution flow.

---
```
## 1. What is `static` in Java?

In Java, the `static` keyword is used for:
- **Variables** → Shared by all objects of a class.
- **Methods** → Can be called without creating an object.
- **Blocks** → Code that runs once when the class is loaded.

**Key Properties:**
- Belongs to the **class**, not an object.
- **Static methods** cannot access non-static variables directly.
- Static blocks are used for **initialization**.

---
## 2. Example 1 — Static Variable

### `Human.java`
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
# Understanding Static Inner Classes in Java
```
## 📌 Overview
In Java, classes can be **nested** (a class inside another class). These nested classes can be:
1. **Non-static inner classes** → tied to an instance of the outer class.
2. **Static nested classes** → independent of the outer class object.

This document explains the difference and shows how to use **static inner classes** with a practical example.

---
## 💡 Key Concepts

### 1. **Top-Level Classes Cannot Be Static**
In Java:
- The keyword `static` means "belongs to the class, not an object".
- Top-level classes are **already outside** any other class, so making them static makes no sense.
- **Only nested classes** (classes defined inside another class) can be marked `static`.

---

### 2. **Non-Static Inner Classes**
- They **require** an instance of the outer class.
- They have an **implicit reference** to the outer class object.
- You must create them like this:
  ```java
  Outer outer = new Outer();
  Outer.Inner innerObj = outer.new Inner();


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
# 🧩 Singleton Pattern in Java
```
## **What is a Singleton?**
A **Singleton** is a design pattern that ensures:
1. Only **one** instance of a class exists during the lifetime of the program.
2. There is a **global access point** to that instance.

---
## **Why use Singleton?**
- **Memory Efficiency** → Only one object is created, reused everywhere.
- **Control** → Restricts instantiation to a single instance.
- **Consistency** → Same object means same state across the program.

---
## **Example Code**

### **Singleton.java**
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
#Main.java:

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
# Java Inheritance Example

## Box.java
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
