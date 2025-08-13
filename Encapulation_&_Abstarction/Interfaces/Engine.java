package Interfaces;

/*
 * Engine interface
 * ----------------
 * Represents an engine's core operations.
 * 
 * Key Points:
 * - Multiple engine types can implement this (PowerEngine, ElectricEngine, etc.).
 * - Interfaces allow multiple implementations without inheritance restrictions.
 */
public interface Engine {

    static final int Price = 78000; // Example constant: engine price

    void start(); // Start the engine
    void stop();  // Stop the engine
    void acc();   // Accelerate the engine
}
