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
