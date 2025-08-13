package Interfaces;

/*
 * PowerEngine class
 * -----------------
 * Implements Engine for traditional fuel-powered engines.
 */
public class PowerEngine implements Engine {

    @Override
    public void start() {
        System.out.println("Power start engine");
    }

    @Override
    public void stop() {
        System.out.println("Power stop engine");
    }

    @Override
    public void acc() {
        System.out.println("Power accelerate engine");
    }
}
