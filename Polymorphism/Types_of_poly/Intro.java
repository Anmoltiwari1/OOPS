package Polymorphism.Types_of_poly;

/*
========================================
📌 POLYMORPHISM IN JAVA
========================================

Polymorphism = "One name, many forms"

TYPES:
----------------------------------------
1️⃣ Compile-Time (Static) Polymorphism
   - Achieved by METHOD OVERLOADING.
   - Same method name, but parameter list differs 
     (number, type, or order of parameters).
   - Decided by the compiler at compile time.
   - Example: Multiple constructors.

2️⃣ Run-Time (Dynamic) Polymorphism
   - Achieved by METHOD OVERRIDING.
   - Child class has a method with the SAME signature as the parent,
     but different implementation.
   - Which method runs is decided at runtime based on OBJECT TYPE.
   - Rules:
       🔹 Final methods cannot be overridden.
       🔹 Static methods cannot be overridden (only hidden).
       🔹 Access level in child must not be more restrictive.

----------------------------------------
⚙ IMPORTANT:
- Reference Type (left side of =) → Decides which members can be accessed.
- Object Type (right side of =)   → Decides which overridden method runs.

Example:
Shapes s = new Circle();
s.area(); // Runs Circle’s area() because object is Circle.

*/
public class Intro {
    
}
