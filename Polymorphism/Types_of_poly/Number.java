package Polymorphism.Types_of_poly;

/*
    Example of Compile-Time (Static) Polymorphism:
    - Achieved via METHOD OVERLOADING.
    - Which method to call is decided at compile time
      based on method signature.
*/
public class Number {
    
    // sum() with 2 parameters
    int sum(int a, int b) {
        return a + b;
    }

    // sum() with 3 parameters
    int sum(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Number obj = new Number();
        
        // Calls 2-parameter sum() → Decided at compile time
        System.out.println(obj.sum(2, 3));

        // Calls 3-parameter sum() → Decided at compile time
        System.out.println(obj.sum(2, 3, 7));
    }
}
