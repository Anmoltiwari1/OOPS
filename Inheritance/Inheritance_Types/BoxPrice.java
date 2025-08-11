package Inheritance.Inheritance_Types;

// 🔹 Multilevel Inheritance (BoxPrice → BoxWeight → Box)
public class BoxPrice extends BoxWeight {
    double cost;

    // Default constructor: calls parent (BoxWeight) constructor
    BoxPrice() {
        super(); // Calls BoxWeight() → Box()
        this.cost = -1;
    }

    // Parameterized constructor:
    // Passes l, h, w, weight to BoxWeight
    public BoxPrice(double l, double h, double w, double weight, double cost) {
        super(l, h, w, weight);
        this.cost = cost;
    }
}
