# Complete Java Object-Oriented Programming Guide
*From Fundamentals to Advanced Interface Implementation*

## Table of Contents
1. [Classes and Objects](#classes-and-objects)
2. [Object Creation and Memory](#object-creation-and-memory)
3. [Constructors](#constructors)
4. [Wrapper Classes and Final Keyword](#wrapper-classes-and-final-keyword)
5. [Static Keyword](#static-keyword)
6. [Static Inner Classes](#static-inner-classes)
7. [Packages](#packages)
8. [Singleton Pattern](#singleton-pattern)
9. [Access Modifiers](#access-modifiers)
10. [Inheritance Introduction](#inheritance-introduction)
11. [Types of Inheritance](#types-of-inheritance)
12. [Polymorphism Introduction](#polymorphism-introduction)
13. [Types of Polymorphism](#types-of-polymorphism)
14. [Encapsulation and Abstraction](#encapsulation-and-abstraction)
15. [**Advanced Interfaces**](#advanced-interfaces) ⭐
16. [**Interface vs Abstract Classes**](#interface-vs-abstract-classes) ⭐
17. [**Real-World Interface Implementation**](#real-world-interface-implementation) ⭐

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

---

## Access Modifiers

### 📌 **Access Modifiers Overview**

Access modifiers in Java control the visibility and accessibility of classes, methods, and variables. Understanding them is crucial for proper encapsulation and security in your applications.

### **Access Modifiers Table**

| Modifier       | Same Class | Same Package | Subclass (Different Package) | Other Packages |
|----------------|------------|--------------|------------------------------|----------------|
| **private**    | ✅ Yes      | ❌ No         | ❌ No                         | ❌ No           |
| **default**    | ✅ Yes      | ✅ Yes        | ❌ No                         | ❌ No           |
| **protected**  | ✅ Yes      | ✅ Yes        | ✅ Yes                        | ❌ No           |
| **public**     | ✅ Yes      | ✅ Yes        | ✅ Yes                        | ✅ Yes          |

### **Complete Code Example**

#### **A.java**
```java
// Class demonstrating different Access Modifiers in Java
public class A {

    // PRIVATE: Accessible only within this class.
    private int num;

    // PUBLIC: Accessible from anywhere in the project.
    public String name;

    // DEFAULT (Package-Private): Accessible only within the same package.
    int[] arr;

    // PROTECTED: Accessible within the same package and in subclasses.
    protected int n;

    // Getter for private variable 'num'
    public int getNum() {
        return num;
    }

    // Setter for private variable 'num'
    public void setNum(int num) {
        this.num = num;
    }

    // Constructor to initialize all members
    public A(int num, String name, int n) {
        this.num = num;               // private variable
        this.name = name;             // public variable
        this.arr = new int[num];      // default variable
        this.n = n;                   // protected variable
    }

    // Method to display object details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Private num (via getter): " + getNum());
        System.out.println("Protected n: " + n);
        System.out.print("Default array length: " + arr.length);
        System.out.println("\n-----------------------------------");
    }
}
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

#### **1. Single Level Inheritance**
```java
// BoxWeight → Box
public class BoxWeight extends Box {
    double weight;
    
    public BoxWeight(double l, double h, double w, double weight) {
        super(l, h, w);
        this.weight = weight;
    }
}
```

#### **2. Multilevel Inheritance**
```java
// BoxPrice → BoxWeight → Box
public class BoxPrice extends BoxWeight {
    double cost;

    public BoxPrice(double l, double h, double w, double weight, double cost) {
        super(l, h, w, weight);
        this.cost = cost;
    }
}
```

#### **3. Hierarchical Inheritance**
```java
// Multiple classes inherit from the same parent
public class BoxColor extends BoxWeight {
    String color;
}

public class BoxMaterial extends BoxWeight {
    String material;
}
```

---

## Polymorphism Introduction

### 📌 **What is Polymorphism?**

**Polymorphism** = "One name, many forms"

- It allows objects of different classes to be treated as objects of a common base class.
- The **same method name** can behave differently based on the **object type**.
- It's one of the core principles of Object-Oriented Programming.

### **Code Implementation**

#### **Shapes.java**
```java
package Polymorphism.Intro;

// Polymorphism: Many ways to represent the same concept (area here)
public class Shapes {
    
    // Method to be overridden by child classes
    void area() {
        System.out.println("I am in shapes");
    }
}
```

#### **Circle.java**
```java
package Polymorphism.Intro;

// Circle class extends Shapes (Inheritance)
public class Circle extends Shapes {
    
    // Overriding the area() method from Shapes
    @Override
    void area() {
        System.out.println("I am in Circle");
    }
}
```

#### **Main.java**
```java
package Polymorphism.Intro;

public class Main {
    public static void main(String[] args) {
        
        // Creating objects of base class and derived classes
        Shapes shape = new Shapes();    // Object of parent class
        Circle circle = new Circle();   // Object of child class Circle
        
        // Calling area() method from base class
        shape.area();   // Will call Shapes' version of area()
        
        // Calling overridden area() method from child class Circle
        circle.area();  // Will call Circle's version of area()
    }
}
```

---

## Types of Polymorphism

### 📌 **Overview**
Java supports **two types of polymorphism**:

1. **Compile-Time (Static) Polymorphism** → Achieved using **method overloading**
2. **Run-Time (Dynamic) Polymorphism** → Achieved using **method overriding**

### **1️⃣ Compile-Time Polymorphism (Method Overloading)**

```java
package Polymorphism.Types_of_poly;

public class Number {

    // Method overloading: Different parameter lists
    int sum(int a, int b) { 
        return a + b; 
    }
    
    int sum(int a, int b, int c) { 
        return a + b + c; 
    }

    public static void main(String[] args) {
        Number obj = new Number();

        System.out.println(obj.sum(2, 3));    // Calls 2-parameter version
        System.out.println(obj.sum(2, 3, 7)); // Calls 3-parameter version
    }
}
```

### **2️⃣ Run-Time Polymorphism (Method Overriding)**

```java
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
```

---

## Encapsulation and Abstraction

### 📌 **Encapsulation**

**Encapsulation** is the bundling of data (variables) and methods that operate on that data into a single unit (class), while **restricting direct access** to some components.

```java
public class BankAccount {
    // Private variables (encapsulated data)
    private String accountNumber;
    private double balance;
    private String holderName;
    
    // Constructor
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance >= 0 ? initialBalance : 0;
    }
    
    // Public getter methods (controlled access)
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    
    // Public methods with validation (controlled modification)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }
    
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds!");
        }
    }
}
```

### 📌 **Abstraction**

**Abstraction** is the concept of hiding **complex implementation details** and showing only the **essential features** of an object.

#### **Abstract Class Example**

```java
// Abstract class - cannot be instantiated
abstract class Vehicle {
    protected String brand;
    protected int maxSpeed;
    
    // Constructor
    public Vehicle(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }
    
    // Concrete method (implemented)
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Max Speed: " + maxSpeed + " km/h");
    }
    
    // Abstract method (must be implemented by child classes)
    public abstract void start();
    public abstract void stop();
    public abstract void accelerate();
}

// Concrete implementation
class Car extends Vehicle {
    
    public Car(String brand, int maxSpeed) {
        super(brand, maxSpeed);
    }
    
    @Override
    public void start() {
        System.out.println(brand + " car engine started!");
    }
    
    @Override
    public void stop() {
        System.out.println(brand + " car stopped!");
    }
    
    @Override
    public void accelerate() {
        System.out.println(brand + " car is accelerating!");
    }
}
```

---

## Advanced Interfaces

### 📌 **What are Interfaces?**

An **interface** in Java is a **contract** that defines what a class can do, without specifying how it does it. It's a reference type, similar to a class, that can contain:

- **Abstract methods** (methods without implementation)
- **Default methods** (methods with implementation - Java 8+)
- **Static methods** (Java 8+)
- **Constants** (public static final variables)

### **Key Interface Features**

| Feature | Description | Example |
|---------|-------------|---------|
| **Multiple Inheritance** | A class can implement multiple interfaces | `class Car implements Engine, Brake` |
| **Contract Definition** | Interface defines what methods must be implemented | `void start();` |
| **No Object Creation** | Cannot instantiate an interface directly | `Engine e = new Engine(); // ❌` |
| **Default Methods** | Provide default implementation | `default void display() { ... }` |

---

### **Basic Interface Example**

```java
// Define an interface
public interface Engine {
    // Constant (public static final by default)
    int PRICE = 78000;
    
    // Abstract methods (public abstract by default)
    void start();
    void stop();
    void accelerate();
}

// Implement the interface
public class PowerEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Power engine started");
    }
    
    @Override
    public void stop() {
        System.out.println("Power engine stopped");
    }
    
    @Override
    public void accelerate() {
        System.out.println("Power engine accelerating");
    }
}
```

---

### **Multiple Interface Implementation**

```java
// Multiple interfaces
public interface Brake {
    void applyBrake();
}

public interface Media {
    void start();
    void stop();
}

// A class can implement multiple interfaces
public class Car implements Engine, Brake, Media {
    @Override
    public void start() {
        System.out.println("Car engine started");
    }
    
    @Override
    public void stop() {
        System.out.println("Car engine stopped");
    }
    
    @Override
    public void accelerate() {
        System.out.println("Car accelerating");
    }
    
    @Override
    public void applyBrake() {
        System.out.println("Car brakes applied");
    }
    
    // Note: Media also has start() and stop() methods
    // The same implementation satisfies both Engine and Media interfaces
}
```

---

### **Real-World Interface Implementation - NiceCar Example**

Let's create a comprehensive example that demonstrates composition, multiple interfaces, and runtime behavior switching:

#### **Interface Definitions**

```java
// Engine interface - defines engine behavior
public interface Engine {
    static final int PRICE = 78000;  // Constant
    
    void start();
    void stop(); 
    void accelerate();
}

// Brake interface - defines braking behavior
public interface Brake {
    void applyBrake();
}

// Media interface - defines media player behavior
public interface Media {
    void start();
    void stop();
}
```

#### **Concrete Engine Implementations**

```java
// Power Engine Implementation
public class PowerEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Power engine started");
    }
    
    @Override
    public void stop() {
        System.out.println("Power engine stopped");
    }
    
    @Override
    public void accelerate() {
        System.out.println("Power engine accelerating");
    }
}

// Electric Engine Implementation
public class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric engine started silently");
    }
    
    @Override
    public void stop() {
        System.out.println("Electric engine stopped");
    }
    
    @Override
    public void accelerate() {
        System.out.println("Electric engine accelerating smoothly");
    }
}
```

#### **Media Player Implementations**

```java
// CD Player Implementation
public class CDPlayer implements Media {
    @Override
    public void start() {
        System.out.println("CD music started");
    }
    
    @Override
    public void stop() {
        System.out.println("CD music stopped");
    }
}

// Digital Media Player Implementation
public class DigitalMediaPlayer implements Media {
    @Override
    public void start() {
        System.out.println("Digital music streaming started");
    }
    
    @Override
    public void stop() {
        System.out.println("Digital music streaming stopped");
    }
}
```

#### **NiceCar Class - Composition Pattern**

```java
public class NiceCar {
    // Composition: NiceCar HAS-A Engine and Media (not IS-A)
    private Engine engine;
    private Media player;
    
    // Default constructor
    public NiceCar() {
        this.engine = new PowerEngine();    // Default engine
        this.player = new CDPlayer();       // Default media player
    }
    
    // Constructor with custom engine
    public NiceCar(Engine engine) {
        this.engine = engine;
        this.player = new CDPlayer();
    }
    
    // Constructor with custom engine and media
    public NiceCar(Engine engine, Media player) {
        this.engine = engine;
        this.player = player;
    }
    
    // Delegate engine operations
    public void start() {
        engine.start();
    }
    
    public void stop() {
        engine.stop();
    }
    
    public void accelerate() {
        engine.accelerate();
    }
    
    // Delegate media operations
    public void startMusic() {
        player.start();
    }
    
    public void stopMusic() {
        player.stop();
    }
    
    // Runtime behavior switching
    public void upgradeEngine() {
        System.out.println("Upgrading engine...");
        this.engine = new ElectricEngine();
        System.out.println("Engine upgraded to Electric!");
    }
    
    public void upgradeMediaSystem() {
        System.out.println("Upgrading media system...");
        this.player = new DigitalMediaPlayer();
        System.out.println("Media system upgraded to Digital!");
    }
    
    // Get current engine type
    public String getEngineType() {
        return engine.getClass().getSimpleName();
    }
    
    // Get current media type
    public String getMediaType() {
        return player.getClass().getSimpleName();
    }
}
```

#### **Main Demo Class**

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("=== NiceCar Interface Demo ===\n");
        
        // 1. Create car with default components
        NiceCar car1 = new NiceCar();
        System.out.println("Car 1 - Default Configuration:");
        System.out.println("Engine: " + car1.getEngineType());
        System.out.println("Media: " + car1.getMediaType());
        
        car1.start();
        car1.startMusic();
        car1.accelerate();
        car1.stopMusic();
        car1.stop();
        
        System.out.println("\n" + "=".repeat(40) + "\n");
        
        // 2. Upgrade components at runtime
        System.out.println("Car 1 - After Upgrades:");
        car1.upgradeEngine();
        car1.upgradeMediaSystem();
        
        System.out.println("Engine: " + car1.getEngineType());
        System.out.println("Media: " + car1.getMediaType());
        
        car1.start();
        car1.startMusic();
        car1.accelerate();
        car1.stopMusic();
        car1.stop();
        
        System.out.println("\n" + "=".repeat(40) + "\n");
        
        // 3. Create car with custom components
        NiceCar car2 = new NiceCar(new ElectricEngine(), new DigitalMediaPlayer());
        System.out.println("Car 2 - Custom Configuration:");
        System.out.println("Engine: " + car2.getEngineType());
        System.out.println("Media: " + car2.getMediaType());
        
        car2.start();
        car2.startMusic();
        car2.accelerate();
        car2.stopMusic();
        car2.stop();
        
        System.out.println("\n" + "=".repeat(40) + "\n");
        
        // 4. Demonstrate polymorphism with interfaces
        System.out.println("Polymorphism Demo:");
        Engine[] engines = {
            new PowerEngine(),
            new ElectricEngine()
        };
        
        Media[] mediaPlayers = {
            new CDPlayer(),
            new DigitalMediaPlayer()
        };
        
        for (int i = 0; i < engines.length; i++) {
            System.out.println("\nConfiguration " + (i + 1) + ":");
            engines[i].start();
            mediaPlayers[i].start();
            engines[i].accelerate();
            mediaPlayers[i].stop();
            engines[i].stop();
        }
    }
}
```

#### **Expected Output**

```
=== NiceCar Interface Demo ===

Car 1 - Default Configuration:
Engine: PowerEngine
Media: CDPlayer
Power engine started
CD music started
Power engine accelerating
CD music stopped
Power engine stopped

========================================

Car 1 - After Upgrades:
Upgrading engine...
Engine upgraded to Electric!
Upgrading media system...
Media system upgraded to Digital!
Engine: ElectricEngine
Media: DigitalMediaPlayer
Electric engine started silently
Digital music streaming started
Electric engine accelerating smoothly
Digital music streaming stopped
Electric engine stopped

========================================

Car 2 - Custom Configuration:
Engine: ElectricEngine
Media: DigitalMediaPlayer
Electric engine started silently
Digital music streaming started
Electric engine accelerating smoothly
Digital music streaming stopped
Electric engine stopped

========================================

Polymorphism Demo:

Configuration 1:
Power engine started
CD music started
Power engine accelerating
CD music stopped
Power engine stopped

Configuration 2:
Electric engine started silently
Digital music streaming started
Electric engine accelerating smoothly
Digital music streaming stopped
Electric engine stopped
```

---

## Interface vs Abstract Classes

### 📌 **Key Differences**

| **Aspect** | **Interface** | **Abstract Class** |
|------------|---------------|-------------------|
| **Multiple Inheritance** | ✅ Supported | ❌ Not Supported |
| **Method Implementation** | Abstract + Default methods | Abstract + Concrete methods |
| **Variables** | Only constants (public static final) | Any type of variables |
| **Constructors** | ❌ Not allowed | ✅ Allowed |
| **Access Modifiers** | Methods are public by default | Can have any access modifier |
| **When to Use** | Define contracts/capabilities | Share common code among subclasses |

### **Interface Example**

```java
public interface Drawable {
    // Constants (implicitly public static final)
    String DEFAULT_COLOR = "BLACK";
    
    // Abstract methods (implicitly public abstract)
    void draw();
    void resize(double factor);
    
    // Default method (Java 8+)
    default void display() {
        System.out.println("Displaying drawable object");
    }
    
    // Static method (Java 8+)
    static void printInfo() {
        System.out.println("This is a drawable interface");
    }
}

// Implementation
public class Rectangle implements Drawable {
    private double width, height;
    
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void draw() {
        System.out.println("Drawing rectangle: " + width + " x " + height);
    }
    
    @Override
    public void resize(double factor) {
        width *= factor;
        height *= factor;
        System.out.println("Rectangle resized to: " + width + " x " + height);
    }
}
```

### **Abstract Class Example**

```java
public abstract class Shape {
    // Instance variables (not allowed in interfaces)
    protected double x, y;
    protected String color;
    
    // Constructor (not allowed in interfaces)
    public Shape(double x, double y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    // Concrete method with implementation
    public void move(double dx, double dy) {
        x += dx;
        y += dy;
        System.out.println("Shape moved to (" + x + ", " + y + ")");
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract double calculateArea();
    
    // Another concrete method
    public void displayInfo() {
        System.out.println("Shape at (" + x + ", " + y + ") with color " + color);
        System.out.println("Area: " + calculateArea());
    }
}

// Concrete implementation
public class Circle extends Shape {
    private double radius;
    
    public Circle(double x, double y, String color, double radius) {
        super(x, y, color);
        this.radius = radius;
    }
    
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
```

### **When to Use Which?**

#### **Use Interfaces When:**
- You want to define a **contract** that multiple unrelated classes should follow
- You need **multiple inheritance** of type
- You want to achieve **loose coupling**
- You're defining **capabilities** (e.g., Flyable, Swimmable, Comparable)

#### **Use Abstract Classes When:**
- You want to **share code** among several closely related classes
- You need **constructors** or **instance variables**
- You want to provide **default implementations** for most methods
- You're creating a **family of related classes** with common behavior

---

## Real-World Interface Implementation

### 📌 **Advanced Payment System Example**

Let's create a real-world payment processing system that demonstrates advanced interface usage:

#### **Payment Interface Hierarchy**

```java
// Base payment interface
public interface PaymentProcessor {
    boolean processPayment(double amount);
    String getPaymentMethod();
    
    // Default method for logging
    default void logTransaction(double amount, boolean success) {
        System.out.println("Transaction: $" + amount + 
                          " via " + getPaymentMethod() + 
                          " - " + (success ? "SUCCESS" : "FAILED"));
    }
}

// Extended interface for refundable payments
public interface RefundablePayment extends PaymentProcessor {
    boolean processRefund(double amount);
    double getRefundFee();
}

// Interface for payments requiring authentication
public interface SecurePayment {
    boolean authenticate(String credentials);
    void enableTwoFactorAuth();
}

// Interface for international payments
public interface InternationalPayment {
    boolean processInternationalPayment(double amount, String currency);
    double getExchangeRate(String currency);
}
```

#### **Concrete Payment Implementations**

```java
// Credit Card Payment
public class CreditCardPayment implements RefundablePayment, SecurePayment {
    private String cardNumber;
    private boolean isAuthenticated = false;
    private boolean twoFactorEnabled = false;
    
    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
    @Override
    public boolean processPayment(double amount) {
        if (!isAuthenticated) {
            System.out.println("Authentication required for credit card payment");
            return false;
        }
        
        System.out.println("Processing credit card payment of $" + amount);
        // Simulate payment processing
        boolean success = amount > 0 && amount <= 10000; // Max limit
        logTransaction(amount, success);
        return success;
    }
    
    @Override
    public String getPaymentMethod() {
        return "Credit Card ****" + cardNumber.substring(cardNumber.length() - 4);
    }
    
    @Override
    public boolean processRefund(double amount) {
        System.out.println("Processing credit card refund of $" + amount);
        return amount > 0;
    }
    
    @Override
    public double getRefundFee() {
        return 2.50; // Fixed fee
    }
    
    @Override
    public boolean authenticate(String credentials) {
        // Simple authentication simulation
        isAuthenticated = credentials.length() >= 8;
        System.out.println("Credit card authentication: " + 
                          (isAuthenticated ? "SUCCESS" : "FAILED"));
        return isAuthenticated;
    }
    
    @Override
    public void enableTwoFactorAuth() {
        twoFactorEnabled = true;
        System.out.println("Two-factor authentication enabled for credit card");
    }
}

// PayPal Payment
public class PayPalPayment implements RefundablePayment, InternationalPayment {
    private String email;
    
    public PayPalPayment(String email) {
        this.email = email;
    }
    
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + amount);
        boolean success = amount > 0 && amount <= 50000; // Higher limit
        logTransaction(amount, success);
        return success;
    }
    
    @Override
    public String getPaymentMethod() {
        return "PayPal (" + email + ")";
    }
    
    @Override
    public boolean processRefund(double amount) {
        System.out.println("Processing PayPal refund of $" + amount);
        return amount > 0;
    }
    
    @Override
    public double getRefundFee() {
        return 0.0; // No refund fee
    }
    
    @Override
    public boolean processInternationalPayment(double amount, String currency) {
        double convertedAmount = amount * getExchangeRate(currency);
        System.out.println("Processing international PayPal payment: " + 
                          amount + " " + currency + " ($" + convertedAmount + ")");
        return processPayment(convertedAmount);
    }
    
    @Override
    public double getExchangeRate(String currency) {
        // Simplified exchange rates
        switch (currency.toLowerCase()) {
            case "eur": return 0.85;
            case "gbp": return 0.73;
            case "jpy": return 110.0;
            default: return 1.0;
        }
    }
}

// Cash Payment (simple implementation)
public class CashPayment implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing cash payment of $" + amount);
        boolean success = amount > 0;
        logTransaction(amount, success);
        return success;
    }
    
    @Override
    public String getPaymentMethod() {
        return "Cash";
    }
}

// Cryptocurrency Payment
public class CryptocurrencyPayment implements PaymentProcessor, SecurePayment, InternationalPayment {
    private String walletAddress;
    private String cryptoType;
    private boolean isAuthenticated = false;
    
    public CryptocurrencyPayment(String walletAddress, String cryptoType) {
        this.walletAddress = walletAddress;
        this.cryptoType = cryptoType;
    }
    
    @Override
    public boolean processPayment(double amount) {
        if (!isAuthenticated) {
            System.out.println("Wallet authentication required for crypto payment");
            return false;
        }
        
        System.out.println("Processing " + cryptoType + " payment of $" + amount);
        boolean success = amount > 0;
        logTransaction(amount, success);
        return success;
    }
    
    @Override
    public String getPaymentMethod() {
        return cryptoType + " (" + walletAddress.substring(0, 8) + "...)";
    }
    
    @Override
    public boolean authenticate(String credentials) {
        isAuthenticated = credentials.startsWith("pk_");
        System.out.println("Crypto wallet authentication: " + 
                          (isAuthenticated ? "SUCCESS" : "FAILED"));
        return isAuthenticated;
    }
    
    @Override
    public void enableTwoFactorAuth() {
        System.out.println("Hardware wallet authentication enabled");
    }
    
    @Override
    public boolean processInternationalPayment(double amount, String currency) {
        System.out.println("Crypto payments are inherently international");
        return processPayment(amount);
    }
    
    @Override
    public double getExchangeRate(String currency) {
        return 1.0; // Crypto is global
    }
}
```

#### **Payment Processing Service**

```java
public class PaymentService {
    private List<PaymentProcessor> supportedProcessors;
    
    public PaymentService() {
        supportedProcessors = new ArrayList<>();
    }
    
    public void addPaymentMethod(PaymentProcessor processor) {
        supportedProcessors.add(processor);
    }
    
    public boolean processPayment(double amount, PaymentProcessor processor) {
        System.out.println("\n=== Processing Payment ===");
        
        // Check if processor supports secure payment
        if (processor instanceof SecurePayment) {
            SecurePayment securePayment = (SecurePayment) processor;
            if (!securePayment.authenticate("secure123password")) {
                System.out.println("Payment failed due to authentication failure");
                return false;
            }
        }
        
        return processor.processPayment(amount);
    }
    
    public boolean processRefund(double amount, PaymentProcessor processor) {
        System.out.println("\n=== Processing Refund ===");
        
        if (processor instanceof RefundablePayment) {
            RefundablePayment refundable = (RefundablePayment) processor;
            double fee = refundable.getRefundFee();
            System.out.println("Refund fee: $" + fee);
            return refundable.processRefund(amount - fee);
        } else {
            System.out.println("Refunds not supported for " + processor.getPaymentMethod());
            return false;
        }
    }
    
    public void demonstratePolymorphism() {
        System.out.println("\n=== Polymorphism Demonstration ===");
        
        PaymentProcessor[] processors = {
            new CreditCardPayment("1234567812345678"),
            new PayPalPayment("user@example.com"),
            new CashPayment(),
            new CryptocurrencyPayment("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", "Bitcoin")
        };
        
        double amount = 100.0;
        
        for (PaymentProcessor processor : processors) {
            System.out.println("\nTesting: " + processor.getPaymentMethod());
            
            // Authenticate if needed
            if (processor instanceof SecurePayment) {
                ((SecurePayment) processor).authenticate("secure123password");
            }
            
            // Process payment
            boolean success = processor.processPayment(amount);
            
            // Try refund if supported
            if (success && processor instanceof RefundablePayment) {
                System.out.println("Attempting refund...");
                ((RefundablePayment) processor).processRefund(50.0);
            }
        }
    }
}
```

#### **Main Demo Application**

```java
public class PaymentSystemDemo {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        
        System.out.println("=== Advanced Payment System Demo ===");
        
        // 1. Create different payment processors
        CreditCardPayment creditCard = new CreditCardPayment("4532123456789012");
        PayPalPayment paypal = new PayPalPayment("john.doe@email.com");
        CashPayment cash = new CashPayment();
        CryptocurrencyPayment bitcoin = new CryptocurrencyPayment(
            "1BvBMSEYstWetqTFn5Au4m4GFg7xJaNVN2", "Bitcoin");
        
        // 2. Demonstrate individual payment processing
        System.out.println("\n1. Individual Payment Processing:");
        
        // Credit card payment with authentication
        creditCard.enableTwoFactorAuth();
        paymentService.processPayment(500.0, creditCard);
        paymentService.processRefund(200.0, creditCard);
        
        // PayPal international payment
        System.out.println("\n--- PayPal International Payment ---");
        paypal.processInternationalPayment(100.0, "EUR");
        
        // 3. Demonstrate polymorphism
        paymentService.demonstratePolymorphism();
        
        // 4. Feature detection using instanceof
        System.out.println("\n=== Feature Detection ===");
        PaymentProcessor[] allProcessors = {creditCard, paypal, cash, bitcoin};
        
        for (PaymentProcessor processor : allProcessors) {
            System.out.println("\nAnalyzing: " + processor.getPaymentMethod());
            
            if (processor instanceof RefundablePayment) {
                RefundablePayment refundable = (RefundablePayment) processor;
                System.out.println("  ✅ Supports refunds (Fee: $" + refundable.getRefundFee() + ")");
            } else {
                System.out.println("  ❌ No refund support");
            }
            
            if (processor instanceof SecurePayment) {
                System.out.println("  🔒 Requires authentication");
            }
            
            if (processor instanceof InternationalPayment) {
                System.out.println("  🌍 Supports international payments");
            }
        }
        
        System.out.println("\n=== Demo Complete ===");
    }
}
```

### **Key Learning Points from This Example**

1. **Interface Inheritance** - `RefundablePayment extends PaymentProcessor`
2. **Multiple Interface Implementation** - Classes implementing multiple interfaces
3. **Polymorphism** - Same interface, different behaviors
4. **Type Checking** - Using `instanceof` to check capabilities
5. **Default Methods** - Shared implementation in interfaces
6. **Composition** - PaymentService uses various payment processors
7. **Real-world Design** - Modular, extensible, and maintainable code

### **Benefits of This Interface-Based Design**

- **Extensibility**: Easy to add new payment methods
- **Flexibility**: Mix and match capabilities (refundable, secure, international)
- **Testability**: Easy to mock interfaces for testing
- **Loose Coupling**: Components depend on abstractions, not concrete classes
- **Maintainability**: Changes to one implementation don't affect others

---

## Summary

This comprehensive guide covers Java OOP from basic classes to advanced interface implementation. The progression from fundamental concepts like classes and objects to sophisticated design patterns like the payment system demonstrates how these concepts build upon each other to create robust, maintainable applications.

### **Key Takeaways**

1. **Encapsulation** → Bundle data and methods, control access
2. **Inheritance** → Code reusability and "is-a" relationships  
3. **Polymorphism** → One interface, multiple implementations
4. **Abstraction** → Hide complexity, show essential features
5. **Interfaces** → Define contracts, enable multiple inheritance
6. **Composition** → "Has-a" relationships for flexible design

Understanding these concepts and their practical applications is essential for writing professional Java applications and designing scalable software systems.