// Abstract class 'Parent' contains abstract methods that must be implemented by its subclasses
// Abstract methods: methods without a body (only a declaration) that subclasses are forced to define
// Rules:
// 1. If a class contains at least one abstract method, it must be declared abstract.
// 2. You cannot create an object of an abstract class.
// 3. Constructors in abstract classes are allowed, but cannot be abstract themselves.
public abstract class Parent {
    
    // Abstract method for defining a career (to be implemented by subclasses)
    abstract void career();
    
    // Abstract method for defining a partner preference (to be implemented by subclasses)
    abstract void partner();
}