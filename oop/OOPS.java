
// public class OOPS {
//     public static void main(String[] args) {
//         // Pen p1 = new Pen();
//         // p1.setColor("blue");
//         // System.out.println(p1.getColor());
//         // p1.setTip(2);
//         // p1.setColor("Green");
//         // System.out.println(p1.getTip());
//         // System.out.println(p1.getColor());

//         // Student s1 = new Student();
//         // s1.name = "Saifullah"; 
//         // s1.roll = 32;
//         // s1.marks[0] = 89;
//         // s1.marks[1] = 97;
//         // s1.marks[2] = 99;

//         // Student s2 = new Student(s1);

//         // s1.marks[0] = 100;
//         // System.out.println(s2.name);
        
//         // for(int i = 0 ; i < s1.marks.length ; i++) {
//         //     System.out.println(s2.marks[i]);
//         // }

//         // Fish shark = new Fish();
//         // shark.eat();

//         // Calculator cal = new Calculator();
//         // System.out.println(cal.sum(1, 1,4));


//         Deer dr = new Deer();
//         dr.eat();
        
//     }
    
// }


// //Polymorphism

// //Method Overloading
// class Calculator {
//     int sum(int a, int b) {
//         return a + b;
//     }
//     float sum(float a, float b ) {
//         return a + b;
//     }
//     int sum(int a, int b, int c) {
//         return a + b + c;
//     }
// }

// //Method overriding 
// class Animals {
//     void eat() {
//         System.out.println("Eat AnyThing");
//     }
// }

// class Deer extends Animals {
//     void eat() {
//         System.out.println("Eat Grass");
//     }
// }

// // //base class
// // class Animals {
// //     String color;

// //     void eat() {
// //         System.out.println("Eats");
// //     }

// //     void breath() {
// //         System.out.println("Breaths");
// //     }
// // }
// // //derives class
// // class Fish extends Animals {
// //     int fins;

// //     void swim() {
// //         System.out.println("Swims");
// //     }
    
// // }




// // class Student  {
// //     String name;
// //     int roll;
// //     String password;
// //     int marks[];

// //     // //shallow copy construtor 
// //     // Student(Student s1) {
// //     //     marks = new int[3];
// //     //     this.name = s1.name;
// //     //     this.roll = s1.roll;
// //     //     this.marks = s1.marks;
// //     // }

// //     //Deep Copy Constructor
// //     Student (Student s1) {
// //         marks = new int[3];
// //         this.name = s1.name;
// //         this.roll = s1.roll;
// //         for (int i = 0 ; i < marks.length ; i++) {
// //             this.marks[i] = s1.marks[i];
// //         }
// //     }

// //     Student () {
// //         marks = new int[3];
// //     }
// //     Student(String name) {
// //         marks = new int[3];
// //         this.name = name;
// //     }

// //     Student (int roll) {
// //         marks = new int[3];
// //         this.roll = roll;
// //     }

// //     Student (int marks[]) {
// //         marks = new int[3];
// //         this.marks = marks;
// //     }
// // }

// // class Pen {
// //     private String color;
// //     private int tip;

// //     String getColor() {
// //         return this.color;
// //     }

// //     void setColor(String newColor) {
// //         color = newColor;
// //     }

// //     int getTip() {
// //         return this.tip;
// //     }

// //     void setTip(int newTip) {
// //         tip = newTip;
// //     }
// // }


//Abstraction



// public class OOPS {
//     public static void main(String[] args) {
//         // Chicken h = new Chicken();
//         // h.changeColor();
//         // System.out.println(h.color);

//         Mustang mg = new Mustang();
//         System.out.println(mg.color);
//         mg.changeColor();
//         System.out.println(mg.color);


//     }
// }


// abstract class Animals {
//     String color;
//     void eat() {
//         System.out.println("Eats");
//     } 
//     // Animals () {
//     //     color = "brown";
//     // }
//     Animals () {
//         System.out.println("Animal Class called");
//     }
    
//     abstract void  walk();
// }

// class Horse extends Animals{
//     void changeColor() {
//         color = "Black";
//     }
//     void walk() {
//         System.out.println("Walks");
//     }
//     Horse() {
//         System.out.println("Horse Class Called");
//     }
// }

// class Mustang extends Horse {
//     void changeColor() {
//         color = "peal";
//     }

//     Mustang () {
//         System.out.println("Mustang Class called");
//     }

// }

// class Chicken extends Animals {
//     void changeColor() {
//         color = "White";
//     }
//     void walk() {
//         System.out.println("runs");  
//     }
// }




// public class OOPS {

//     public static void main(String[] args) {
//        Bear b = new Bear();
//        b.eat();
//     }
// }

// interface Herbivore {
//     void eat();
// }

// interface Carnivore {
//     void eat();
// }

// class Bear implements Herbivore, Carnivore {
//     public void eat() {
//         System.out.println("Eat grass and meat");  
//     }
// }


// interface ChessPlayer  {
//     void moves();
// }

// class Queen implements ChessPlayer{
//     public void moves() {
//         System.out.println("Up, Down, Left, Right, Diagonal (in all 4 direction)");
//     }
// }

// class Rook implements ChessPlayer{
//     public void moves() {
//         System.out.println("Up, Down, Left, Right");
//     }
// }

// class King implements ChessPlayer{
//     public void moves() {
//         System.out.println("Up, Down, Left, Right and Diagonal(by 1 step)");
//     }
// }

// //static keyword;
// class OOPS {
//     public static void main(String[] args) {
//         Student s1 = new Student("Saifullah");
//         Student s2 = new Student("Shagufta");
//         s1.school = "anglo";
//         System.out.println(s1.name);
//         System.out.println(s2.school);
//         s1.percentage = Student.percentage(23, 45, 78);
//         s2.percentage = Student.percentage(67, 89, 90);
//         System.out.println(s1.percentage);
//         System.out.println(s2.percentage);

                         
        
//     }
// }

// class Student {
//     String name;
//     int roll;
//     int percentage ;
//     static int percentage(int phy, int chem, int math) {
//         return (phy + chem + math) / 3;
//     }

//     static String school = "Rpvv";
    
//     Student () {

//     }

//     Student (String name) {
//         this.name  = name;
//     }

//     Student (int roll) {
//         this.roll = roll;
//     }
// }



//Super keyword 


