package SigletonClass;

public class Main {

    public static void main(String[] args) {

        // ✅ Correct way: Call getInstance() without "new" because
        // getInstance() itself creates the object internally.

        Sigleton obj1 = Sigleton.getInstance();
        Sigleton obj2 = Sigleton.getInstance();
        Sigleton obj3 = Sigleton.getInstance();

        // All three references point to the SAME object in memory.
        System.out.println(obj1 == obj2); // true
        System.out.println(obj2 == obj3); // true
    }
}
