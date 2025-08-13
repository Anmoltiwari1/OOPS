// 'Son' class extends 'Parent' and provides concrete implementations for the abstract methods
public class Son extends Parent {

    // Overriding the 'career' method from Parent
    @Override
    void career() {
        System.out.println("I am going to be a doctor");
    }

    // Overriding the 'partner' method from Parent
    @Override
    void partner() {
        System.out.println("I love the girl");
    }
}
