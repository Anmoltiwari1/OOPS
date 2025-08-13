// Main class to test method overriding with abstract classes
public class Main {
    public static void main(String[] args) {
        
        // Creating Son object and calling overridden methods
        Son son = new Son();
        son.career(); // Output: I am going to be a doctor
        
        // Creating Daughter object and calling overridden methods
        Daughter daughter = new Daughter();
        daughter.career(); // Output: I am going to be a coder
    }
}