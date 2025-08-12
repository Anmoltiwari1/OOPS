package Polymorphism.Types_of_poly;

public class Main {
    public static void main(String[] args) {
        
        // Parent reference & Parent object → Runs parent method
        Shapes shape = new Shapes();    
        
        // Child reference & Child object → Runs child method
        Circle circle = new Circle();   
        
        // Parent reference but Child object → Runtime Polymorphism
        Shapes c = new Circle();

        // Calls Shapes' version (parent method)
        shape.area();   

        // Calls Circle's overridden version
        circle.area();  

        /*
           Runtime Polymorphism:
           - Reference type: Shapes → Can access only members of Shapes.
           - Object type: Circle → Overridden method from Circle runs.
        */
        c.area();
    }
}
