class Main {
  public static void main(String[] args) {

    


    //Use the // to create single line comments to either add info or to take out code for debugging

    System.out.println("Hello world!");

    //We will be using System.out.println and System.out.print throughout the year. Try using both below to see what the difference is!






    //ANSWER: 



    //Throughout the year this year we will need to store information. For that we will be using VARIABLES!

    //Java is an Object-Oriented programming language. All variables we use this year will either be OBJECTS or PRIMITIVES

    //There are 8 primitives in Java: int, byte, short, long, float, double, boolean, char

    //For AP we need to know: int, double, boolean

    //List examples of the types below and give definition
    //int (integer): 1,2,3,4
    //integer: any whole number, positive or negative, including zero
    //double:1,2. 5.6, 4.3
    //double: any number that has a decimal point
    //boolean: true, false
    //boolean: any data type that involves a condition

    //For now we are just going to work with primitive

    //Create 3 variables of each of the above types (USE GOOD CODING PRACTICE WHEN CREATING THE VARIABLES

 int age=16;
 int year=2025;
 int grade=11;
 double height=5.3;
 double weight=130.5;
 double gpa=3.8;
 boolean isStudent=true;
 boolean isGraduated=false;
 boolean isWorking=true;

 System.out.println("Age: " + age);
 System.out.println("Year: " + year);
 System.out.println("10 times 10=" +100);



    //MATH TIME!

    //What are the math operators that we can use?
    //+ - * / %

    //Try doing some math operations with numbers. How can we check to see if the math worked?
  
  int a = 6, b = 8;
  System.out.println("Addition: " + (a + b));
  int difference = a - b;
    System.out.println("Difference: " + difference);
    //Create codes that will print the following:

    //Odd integers from 1 to 100, inclusive of both
    System.out.println("Odd integers from 1 to 100:");
    for (int i = 1; i <= 100; i += 2) {
            System.out.print(i + " ");
        }
    System.out.println();


    //All multiples of 3 from 1 to 100
System.out.println("Multiples of 3 from 1 to 100:");
        for (int i = 3; i <= 100; i += 3) {
            System.out.print(i + " ");
        }
        System.out.println();



    //Starting at 1000, print on the same line (with a - [hypthen] between each) all of the numbers that end in 0 going down to 0
    System.out.println("Numbers ending in 0 from 1000 down to 0:");
        for (int i = 1000; i >= 0; i -= 10) {
            if (i > 0) {
                System.out.print(i + "-");
            } else {
                System.out.print(i); // last one without hyphen
            }
        }
  }
}
