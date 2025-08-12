public class Main {
    public static void main(String[] args) {
        // Creating object of class A
        A objA = new A(10, "Kunal", 5);
        objA.displayDetails();

        // Accessing public member directly
        System.out.println("Public name: " + objA.name);

        // Accessing private member using getter
        System.out.println("Private num via getter: " + objA.getNum());

        // Setting a new value to private member via setter
        objA.setNum(50);
        System.out.println("Updated private num: " + objA.getNum());
        System.out.println("-----------------------------------");

        // Creating object of Subclass
        Subclass objSub = new Subclass(34, "Anmol", 99);
        objSub.displayDetails();
        objSub.accessProtected();

        // Accessing public member from subclass object
        System.out.println("Public name in subclass: " + objSub.name);

        // Accessing protected member from subclass object in main (same package)
        System.out.println("Protected n from subclass in main: " + objSub.n);
    }
}
