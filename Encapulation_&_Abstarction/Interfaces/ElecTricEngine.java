package Interfaces;

/*
 * ElecTricEngine class
 * --------------------
 * Implements Engine for electric vehicles.
 */
public class ElecTricEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Electric start engine");
    }

    @Override
    public void stop() {
        System.out.println("Electric stop engine");
    }

    @Override
    public void acc() {
        System.out.println("Electric accelerate engine");
    }
}
