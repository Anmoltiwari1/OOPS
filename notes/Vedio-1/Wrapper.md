# Java Wrapper Classes and `final` Keyword

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
