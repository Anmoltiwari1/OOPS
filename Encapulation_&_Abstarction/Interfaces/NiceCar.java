package Interfaces;

/*
 * NiceCar class
 * -------------
 * Demonstrates composition: 
 * - Uses an Engine object (PowerEngine by default, can be upgraded).
 * - Uses a Media object (CD Player by default).
 * 
 * Benefits:
 * - Flexible: Engine and Media implementations can be swapped at runtime.
 */
public class NiceCar {
    private Engine engine;
    private Media player = new CdPlayer(); // Default media player

    // Default constructor: starts with a PowerEngine
    public NiceCar() {
        engine = new PowerEngine();
    }

    // Constructor with custom Engine
    public NiceCar(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
    }

    public void stop() {
        engine.stop();
    }

    public void musicstart() {
        player.start();
    }

    // Upgrade to a new engine type
    public void upgradeEngine() {
        this.engine = new ElecTricEngine();
    }
}
