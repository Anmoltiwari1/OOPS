package Interfaces;

/*
 * Main class
 * ----------
 * Entry point to test the interfaces and implementations.
 */
public class Main {
    public static void main(String[] args) {

        // Creating a NiceCar object
        NiceCar car = new NiceCar();

        // Using the default PowerEngine
        car.start();        // Engine starts
        car.musicstart();   // Music starts

        // Upgrading to Electric Engine
        car.upgradeEngine();

        // Using upgraded engine
        car.start();        // Electric engine starts
    }
}
