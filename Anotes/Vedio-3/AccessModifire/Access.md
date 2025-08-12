# Java Access Modifiers – Example & Reference

This document demonstrates **private**, **public**, **default (package-private)**, and **protected** access modifiers in Java, with complete code and a quick reference table.

---

## **Access Modifiers Table**

| Modifier       | Same Class | Same Package | Subclass (Different Package) | Other Packages |
|----------------|------------|--------------|------------------------------|----------------|
| **private**    | ✅ Yes      | ❌ No         | ❌ No                         | ❌ No           |
| **default**    | ✅ Yes      | ✅ Yes        | ❌ No                         | ❌ No           |
| **protected**  | ✅ Yes      | ✅ Yes        | ✅ Yes                        | ❌ No           |
| **public**     | ✅ Yes      | ✅ Yes        | ✅ Yes                        | ✅ Yes          |

---

## **Code Example**

### **A.java**
```java
// Class demonstrating different Access Modifiers in Java
public class A {

    // PRIVATE: Accessible only within this class.
    // Often used for sensitive data, requires getter/setter for access.
    private int num;

    // PUBLIC: Accessible from anywhere in the project.
    public String name;

    // DEFAULT (Package-Private): Accessible only within the same package.
    // Not accessible from outside the package.
    int[] arr;

    // PROTECTED: Accessible within the same package and in subclasses (even in different packages).
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
// Subclass inheriting from A
public class Subclass extends A {

    // Constructor calling parent constructor
    public Subclass(int num, String name, int n) {
        super(num, name, n);
    }

    // Method to demonstrate protected access
    public void accessProtected() {
        // 'n' is protected, so it is accessible in subclass
        System.out.println("Accessing protected member n in subclass: " + n);

        // Cannot access private variable 'num' directly:
        // System.out.println(num); ❌
        // Must use getter:
        System.out.println("Accessing private num via getter in subclass: " + getNum());
    }
}
public class Main {
    public static void main(String[] args) {
        // Creating object of class A
        A objA = new A(10, "Kunal", 5);
        objA.displayDetails();

        // Accessing public member directly
        System.out.println("Public name: " + objA.name);

        // Accessing private member using getter
        System.out.println("Private num via getter: " + objA.getNum());

        // Setting a new value to private member via setter
        objA.setNum(50);
        System.out.println("Updated private num: " + objA.getNum());
        System.out.println("-----------------------------------");

        // Creating object of Subclass
        Subclass objSub = new Subclass(34, "Anmol", 99);
        objSub.displayDetails();
        objSub.accessProtected();

        // Accessing public member from subclass object
        System.out.println("Public name in subclass: " + objSub.name);

        // Accessing protected member from subclass object in main (same package)
        System.out.println("Protected n from subclass in main: " + objSub.n);
    }
}

//Hashcode-->It basically takes the object and do some internal working on that and change object into random unique number
