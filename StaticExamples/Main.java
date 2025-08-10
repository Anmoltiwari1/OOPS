//static-->means we can access this with using the refernce of the ibject can direclty acceee with the class.
//     -->We can use the stataic varibale without even making the object
//We can make both variable and function as static
//main is declared as static beacuse we have to  not make object of main to access as we cannot be able to do it.
//Simpley static varibale or function belong to the class not the object
//static method can only access static data not able to access non-static data.
//We can call non-static inside the non-static function beacuse it is obvoious when we call non-static function from main the object will we created before calling it.
package StaticExamples;

public class Main {
    public static void main(String[] args) {
        Human kunal=new Human(23, "Kunal", 200, false);
        Human rahul=new Human(32, "rahul", 400, false);
        Human arpit=new Human(32, "arpit", 400, false);

        System.out.println(rahul.name);
        //population ins static variable hence it is same for everyone
        //This will work but use
        System.out.println(kunal.population);
        System.out.println(rahul.population);
        System.out.println(arpit.population);
        //This
        System.out.println(Human.population);
        System.out.println(Human.population);
        System.out.println(Human.population);
    }

    static void fun(){
        Main obj =new Main();
        greeting();//We cannot use this beacuse it is non-static.
        //basicaaly fun does not depend on instance so how can you use something that depend on instances

        obj.greeting();//This will work as object is created.
    }

    void greeting(){
        fun();//We can use the static insinde the non-static that is fine
        System.out.println("Hello world");
    }

}
