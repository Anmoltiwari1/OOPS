package Inheritance.Inheritance_Types;

public class Box {
        double l; // length
    double h; // height
    double w; // width

    // Default constructor: initializes dimensions to -1 (uninitialized state)
    Box() {
        super(); // Calls Object class constructor (implicit in Java)
        this.l = -1;
        this.h = -1;
        this.w = -1;
    }

    // Constructor for a cube (all sides equal)
    Box(double side) {
        this.l = side;
        this.h = side;
        this.w = side;
    }

    // Constructor for a rectangular box
    Box(double l, double h, double w) {
        this.l = l;
        this.h = h;
        this.w = w;
    }
}
