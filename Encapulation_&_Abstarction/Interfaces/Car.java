package Interfaces;

/*
 * Car class
 * ---------
 * Demonstrates multiple interface implementation.
 * Implements Engine, Brake, and Media together.
 */
public class Car implements Engine, Brake, Media {

    @Override
    public void applybreak() {
        System.out.println("I apply brake");
    }

    @Override
    public void start() {
        System.out.println("I start engine");
    }

    @Override
    public void stop() {
        System.out.println("I stop engine");
    }

    @Override
    public void acc() {
        System.out.println("I accelerate engine");
    }
}
