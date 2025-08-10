# 🧩 Singleton Pattern in Java

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
