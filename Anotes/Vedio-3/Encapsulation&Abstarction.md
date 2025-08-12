# 📝 Java OOP Concepts – Quick Revision Sheet

## 1️⃣ Encapsulation

**Definition:**  
Wrapping **data (fields)** and **methods** into a single unit (class) and controlling access to that data.

**Key Points:**
- Achieved with **access modifiers** (`private`, `public`, `protected`).
- Provides **data hiding** via **getters** and **setters**.
- It is an **implementation-level** concept.

**Example:**
```java
class Student {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}
