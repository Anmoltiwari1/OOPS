package Inheritance.Intro;
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
