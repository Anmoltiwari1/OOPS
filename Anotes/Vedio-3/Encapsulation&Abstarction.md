/*
    📌 Encapsulation vs Abstraction (Quick Revision Notes)

    Encapsulation:
    - Wrapping data (fields) and methods into a single unit (class).
    - Achieved using access modifiers (private, public, protected).
    - Controls HOW data is accessed/modified (via getters/setters).
    - Implementation-level concept (code organization & data protection).
    - Example: Private variables + public getters/setters.

    Abstraction:
    - Hiding implementation details, showing only essential features.
    - Achieved using abstract classes & interfaces.
    - Focuses on WHAT operations an object can perform, not HOW.
    - Design-level concept (focus on interaction, not internals).
    - Example: Using ArrayList methods without knowing internal code.

    🆚 Quick Comparison Table:
    ---------------------------------------------------------------
    Feature           | Encapsulation               | Abstraction
    ---------------------------------------------------------------
    Purpose           | Hide the data               | Hide the process
    Level             | Implementation-level        | Design-level
    Achieved by       | Access modifiers, classes   | Abstract classes, interfaces
    Focus             | Data hiding                 | Hiding complexity
    Example           | Getters/Setters             | ArrayList usage
    ---------------------------------------------------------------
*/

class Student {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}
