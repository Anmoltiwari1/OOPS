// 'Daughter' class extends 'Parent' and provides its own implementations for the abstract methods
public class Daughter extends Parent {

    // Overriding the 'career' method from Parent
    @Override
    void career() {
        System.out.println("I am going to be a coder");
    }

    // Overriding the 'partner' method from Parent
    @Override
    void partner() {
        System.out.println("I love Ironman");
    }
}