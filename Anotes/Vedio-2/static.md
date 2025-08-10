# Java `static` Keyword, Static Variables, Methods, and Static Blocks

This document explains the **`static` keyword** in Java, covering static variables, static methods, static blocks, and their execution order.  
It also includes **full code examples** and a diagram of execution flow.

---

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
