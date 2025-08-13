# NiceCar Interfaces & Implementations — UML and Explanation

## Overview
This Java example demonstrates:
- **Interfaces**: Defining contracts for `Engine`, `Brake`, and `Media`.
- **Multiple Interface Implementation**: `Car` implements multiple interfaces.
- **Composition**: `NiceCar` contains (`has-a`) `Engine` and `Media` objects, allowing runtime swapping.

---

## Interfaces
### `Brake`
```java
public interface Brake {
    void applybreak();
}
public interface Engine {
    static final int Price = 78000;
    void start();
    void stop();
    void acc();
}


public interface Media {
    void start();
    void stop();
}


public class NiceCar {
    private Engine engine;
    private Media player = new CdPlayer();

    public NiceCar() {
        engine = new PowerEngine();
    }

    public NiceCar(Engine engine) {
        this.engine = engine;
    }

    public void start() { engine.start(); }
    public void stop() { engine.stop(); }
    public void musicstart() { player.start(); }
    public void upgradeEngine() { this.engine = new ElecTricEngine(); }
}


public class Main {
    public static void main(String[] args) {
        NiceCar car = new NiceCar();
        car.start();        // PowerEngine starts
        car.musicstart();   // Music starts

        car.upgradeEngine(); // Switch to ElecTricEngine
        car.start();         // Electric engine starts
    }
}
