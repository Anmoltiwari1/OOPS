package Encapsulation;
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
