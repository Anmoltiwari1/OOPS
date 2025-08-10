// Singleton class → A design pattern in which ONLY ONE object of the class is allowed to be created.
// The class itself controls the creation of its object.

package SigletonClass;

public class Sigleton {

    // 🔹 Private constructor → Prevents object creation from outside this class.
    // This means: `new Sigleton()` cannot be called from another class.
    private Sigleton() {
    }

    // 🔹 Static variable → holds the single instance of this class.
    // Initially set to null; will be created only when needed (lazy initialization).
    private static Sigleton instance;

    // 🔹 Public static method → Provides a global access point to the object.
    // This method will create the object if it doesn't already exist, otherwise
    // it will return the already created object.
    public static Sigleton getInstance() {
        if (instance == null) {
            // Object is created only ONCE here.
            instance = new Sigleton();
        }
        return instance;
    }
}
