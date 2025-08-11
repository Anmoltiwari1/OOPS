package Inheritance.Inheritance_Types;

// 🔹 Single Level Inheritance (BoxWeight → Box)
public class BoxWeight extends Box {
    double weight; // Additional property

    // Default constructor
    public BoxWeight() {
        super(); // Initializes dimensions to -1
        this.weight = -1;
    }

    // Parameterized constructor:
    // Uses super() to initialize dimensions from Box
    public BoxWeight(double l, double h, double w, double weight) {
        super(l, h, w); // Initialize parent class fields
        this.weight = weight;
    }
}
