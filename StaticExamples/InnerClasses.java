package StaticExamples;

// ✅ Outer (top-level) classes CANNOT be static in Java.
// The "static" keyword here only works for inner/nested classes.
// This "Test" class is a completely separate, top-level class.
class Test {
    String name;

    public Test(String name) {
        this.name = name;
    }
}

public class InnerClasses {

    /*
     * 🚫 NON-STATIC Inner Class Example (commented out):
     *
     * If we define "Test" here WITHOUT static:
     *
     * class Test {
     *     String name;
     *
     *     public Test(String name) {
     *         this.name = name;
     *     }
     * }
     *
     * Then this inner class would be tied to an object of "InnerClasses".
     * This means:
     * - You CANNOT create an object of Test without first creating
     *   an object of InnerClasses.
     * - Syntax would be:
     *      InnerClasses outer = new InnerClasses();
     *      InnerClasses.Test obj = outer.new Test("Hello");
     *
     * This is because non-static inner classes carry a hidden reference
     * to the outer class object.
     */

    /*
     * ✅ STATIC Inner Class:
     * By adding "static" before class Test, we make it an independent
     * nested class that does NOT depend on an object of Outer Class.
     * 
     * Key differences from non-static inner class:
     * - No hidden reference to Outer class object.
     * - Can be created directly using:
     *      InnerClasses.Test obj = new InnerClasses.Test("Hello");
     * - Useful for grouping classes logically, without tying their lifecycle
     *   to an instance of the outer class.
     */
    static class Test {
        String name;

        public Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        /*
         * Creating objects of the STATIC inner class:
         * 
         * Since Test is static, we can create objects directly
         * without creating an object of InnerClasses.
         *
         * If Test was non-static:
         *   ❌ Test a = new Test("Anmol");  // ERROR
         *   ✅ InnerClasses outer = new InnerClasses();
         *      Test a = outer.new Test("Anmol");
         */
        Test a = new Test("Anmol");
        Test b = new Test("Work");

        // Printing the name of the first object:
        System.out.print(a.name);
    }
}
