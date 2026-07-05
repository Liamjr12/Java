# Java

## Java Fundamentals
Java is a high-level programming language for coding created by Sun Microsystems in 1995 as a `multi-platform`, `object-oriented`, and `network centric` language.

### Java Core Requirements
### **1. Java Runtime Environment** 
* A software package that provides libraries and other resources that Java program requires to run correctly

### **2. Java Virtual Machine**
* <ins>Machine that runs Java application as a run-time engine</ins>:
    * `compliers` - convers your writen instruction [code] into binary program before execution. Then, the CPU executes directly later
    * `interpreter` - takes the source code [instructions], then translates into machine instruction (in binary) and execute the code to the CPU line-by-line in `real-time`

### **3. Java Application Programming Interface**
* Built-in Java functions that can be used by the users

<hr>

# Data Types
Used for possible storage and operation on the data.

## **1. Primitive Data Types**
```java
    //Primitive Data Types
    byte byteExample = 127;
    System.out.println(byteExample);            //RANGE: -128 to +127

    short shortExample = 32767;
    System.out.println(shortExample);           //RANGE: -32,678 to +32,767

    int intExample = 12996745;
    System.out.println(intExample);             //RANGE: Large enough to store a massive number

    long longExample = 1567983277L;
    System.out.println(longExample);            //RANGE: Larger than int and uses the capital 'L' placed after the value

    float floatExample = 1.5f;
    System.out.println(floatExample);           //Single precision and takes half the space of double, use the initial 'f' after the value

    double doubleExample = 1.699;
    System.out.println(doubleExample);          //Double precisions and faster than float, this floating point can handle massive real numbers

    char charExample = 'A';
    System.out.println(charExample);            //For single character only

    boolean booleanExample = true;
    System.out.println(booleanExample);         //Has a value of true and false only
```

## **2. Abstract Data Type**
* A package that is based on the primitive data type that have more functionalities (e.g. `String` class)
* Performing mathematical calculation is not allowed even if the data is stored in has digits

<hr>

# Variables and Constants
A variable is a combinations of a `type`, `identifier`, and `value` that can be change in the program. On the other hand, a constant is also the same combination as variable, but the value cannot be change in program.

```java
//Variable
String name = "Liamjr";
name = "NewLiamJr";
System.out.println(name);

//Constant
final String name = "Liamjr";
name = "NewLiamJr";
System.out.println(name);   //This will result an error

```
<hr>

# Operators
* Symbols used to compute and compare values and test to test multiple conditons

## **1. Arithmetic Operators** 
1. `Add`
```java
//Example 1
int var1 = 5;
int var2 = 7;
System.out.println(var1 + var2);

//Example 2
float var1 = 6.7f;
float var2 = 12.9;
System.out.println(var1 + var2);
```
2. `Subtract`
```java
//Example 1
int var1 = 9;
int var2 = 12;
System.out.println(var2 - var1);

//Example 2
float var1 = 6.7f;
float var2 = 12.9;
System.out.println(var2 - var1);
```
3. `Multiply`
```java
//Example 1
int var1 = 3;
int var2 = 2;
System.out.println(var1 * var2);

//Example 2
float var1 = 5.5f;
float var2 = 10.1;
System.out.println(var1 * var2);
```
4. `Divide`
```java
//Example 1
int var1 = 5;
int var2 = 30;
System.out.println(var2 / var1);

//Example 2
float var1 = 3.5f;
float var2 = 7.0;
System.out.println(var2 / var1);
```
5. `Modulus`
```java
//Example 1
int var1 = 5;
int var2 = 30;
System.out.println(var2 % var1);

//Example 2
float var1 = 3.5f;
float var2 = 7.0;
System.out.println(var2 % var1);
```

## **2. Assignment Operator**
1. `Assignment`
```java
```java
//Example 1
int var1 = 50;
int var2 = 300;
System.out.println(var1 = var1);

//Example 2
float var1 = 2.25f;
float var2 = 14.9;
System.out.println(var1 = var2);
```
2. `Add and assign`
```java
//Example 1
int var1 = 5;
int var2 = 7;
System.out.println(var1 += var2);

//Example 2
float var1 = 6.7f;
float var2 = 12.9;
System.out.println(var1 += var2);
```
3. `Subtract and assign`
```java
//Example 1
int var1 = 9;
int var2 = 12;
System.out.println(var2 -= var1);

//Example 2
float var1 = 6.7f;
float var2 = 12.9;
System.out.println(var2 -= var1);
```
4. `Multiply and assign`
```java
//Example 1
int var1 = 3;
int var2 = 2;
System.out.println(var1 *= var2);

//Example 2
float var1 = 5.5f;
float var2 = 10.1;
System.out.println(var1 *= var2);
```
5. `Divide and assign`
```java
//Example 1
int var1 = 5;
int var2 = 30;
System.out.println(var2 /= var1);

//Example 2
float var1 = 3.5f;
float var2 = 7.0;
System.out.println(var2 /= var1);
```
6. `Remainder and assign`
```java
//Example 1
int var1 = 5;
int var2 = 30;
System.out.println(var2 %= var1);

//Example 2
float var1 = 3.5f;
float var2 = 7.0;
System.out.println(var2 %= var1);
```

## **3. Unary Operators**
1. `Unary plus/minus`
```java
int a = 10;
System.out.println(+a); // 10
System.out.println(-a); // -10
```
2. `Increment`
```java
int a = 5;
a++; // a is 6
```
3. `Decrement`
```java
int a = 5;
a--; // a is 4
```
4. `Logical Complement`
``` java
boolean isCorrect = true;
System.out.println(!isCorrect); // false
```

## **4. Comparison Operators**
1. `Equal to`
```java
int a = 5; int b = 5;
System.out.println(a == b); // true
```
2. `Not equal to`
```java
int a = 5; int b = 3;
System.out.println(a != b); // true
```
3. `Greater then`
```java
int a = 10; int b = 5;
System.out.println(a > b); // true
```
4. `Less than`
```java
int a = 2; int b = 5;
System.out.println(a < b); // true
```
5. `Greater than equal to`
```java
int a = 5; int b = 5;
System.out.println(a >= b); // true
```
6. `Less than equal to`
```java
int a = 4; int b = 5;
System.out.println(a <= b); // true
```

## **5. Shift Operators**
1. `Left shift`
```java
int a = 5; // 0101
System.out.println(a << 1); // 10
```
2. `Right shift`
```java
int a = 10;
System.out.println(a >> 1); // 5
```
3. `Unsigned right shift`
```java
int a = 15;
System.out.println(a >>> 1); // 0
```

<hr>
