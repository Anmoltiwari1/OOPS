# Packages in Java

**Packages** in Java are containers for classes.  
They are essentially just folders that organize Java files.

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
