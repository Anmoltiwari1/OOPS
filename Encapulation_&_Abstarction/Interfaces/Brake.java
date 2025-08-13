package Interfaces;

/*
 * Brake interface
 * ----------------
 * Represents the braking functionality in a vehicle.
 * 
 * Key Points:
 * - Interfaces can only have abstract methods (before Java 8).
 * - Any class implementing this must provide its own "applyBrake" behavior.
 */
public interface Brake {
    void applybreak(); // Method to apply brakes
}
