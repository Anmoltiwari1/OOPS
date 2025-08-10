# Understanding Static Inner Classes in Java

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
