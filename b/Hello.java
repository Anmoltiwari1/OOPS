//We can call methode of another package from another folder using import and usign that function
package b;
import static a.Hello.print;

public class Hello {
    public static void main(String[] args) {
        System.out.println("This is b");
        print();
    }
}
