# 🧠 Java Notes – Classes and Objects

---

## 📌 What is a Class?

- A **class** is a **logical construct**, not a physical one.
- It is a **user-defined data type** that groups **properties** (variables) and **functions** (methods) together.
- A **class** acts as a **template or blueprint** from which **objects** are created.

### 🔧 Example Analogy:
- A class is like the concept of a **car** → it has common properties: `engine`, `price`, `seats`.
- From this blueprint, we can create different **objects** like:
  - `Audi`
  - `BMW`
  - `Tata`

---

## 🧍‍♂️ What is an Object?

- An **object** is an **instance** (physical reality) of a class.
- It has actual values assigned to the properties defined by the class.

---

## 🧩 Key Concepts

| Term               | Explanation                                                                 |
|--------------------|-----------------------------------------------------------------------------|
| **Class**          | Logical structure or blueprint (e.g. `Human`)                               |
| **Object**         | Real entity created from class (e.g. `Anmol`, `Kunal`)                      |
| **Instance Variable** | Variables inside the object (e.g. `name`, `rno`, `marks` of a student)       |
| **`.` (dot) operator** | Used to access members of an object (`object.property`)                   |

---

## 💻 Java Code Example

```java
// Java program to demonstrate class and object

public class Classes {
    public static void main(String[] args) {
        // Kunal will have 3 properties: rno, name, and marks
        Student kunal;
    }
}

// Class creation
class Student {
    int[] rno = new int[5];
    String[] name = new String[5];
    float[] marks = new float[5];
}
