# **Java**

## **Java Fundamentals**
Java is a high-level programming language for coding created by Sun Microsystems in 1995 as a `multi-platform`, `object-oriented`, and `network centric` language.

### **<ins>Java Core Requirements</ins>**
#### **1. Java Runtime Environment** 
A software package that provides libraries and other resources that Java program requires to run correctly

#### **2. Java Virtual Machine**
Machine that runs Java application as a run-time engine:
* `compliers` - convers your writen instruction into binary program before execution. Then, the CPU executes directly later
* `interpreter` - takes the source code, then translates into machine instruction (<i><span style="color: red;">in binary</span></i>) and execute the code to the CPU line-by-line in `real-time`

#### **3. Java Application Programming Interface**
Built-in Java functions that can be used by the users


# **Data Types**
Used for possible storage and operation on the data.

## **1. Primitive Data Types**
These are data that are not object and have no methods
<table>
    <tr>
        <th>Data types</th>
        <th>Description</th>
        <th>Size</th>
        <th>Default value</th>
        <th>Range</th>
    </tr>
    <tr>
        <th>byte</th>
        <th>Byte length integer</th>
        <th>8-bit</th>
        <th>0</th>
        <th>-128 to +127</th>
    </tr>
    <tr>
        <th>short</th>
        <th>Short integer</th>
        <th>16-bit</th>
        <th>0</th>
        <th>-32,768 to +32,767</th>
    </tr>
    <tr>
        <th>int</th>
        <th>Integer number</th>
        <th>32-bit</th>
        <th>0</th>
        <th>-2.15x10<sup>9</sup> to +2.15x10<sup>6</sup></th>
    </tr>
    <tr>
        <th>long</th>
        <th>Long integer</th>
        <th>64-bit</th>
        <th>0L</th>
        <th>-2<sup>63</sup> to +2<sup>63</sup>-1</th>
    </tr>
    <tr>
        <th>float</th>
        <th>Single precision floating point</th>
        <th>32-bit</th>
        <th>0.0f</th>
        <th>-1.4x10<sup>-45</sup> to +3.4x10<sup>38</sup></th>
    </tr>
    <tr>
        <th>double</th>
        <th>Double precision floating point</th>
        <th>64-bit</th>
        <th>0.0d</th>
        <th>-4.9x10<sup>-324</sup> to +1.8x10<sup>308</sup></th>
    </tr>
    <tr>
        <th>char</th>
        <th>Simple character</th>
        <th>8-bit</th>
        <th>\u0000</th>
        <th>0 to 65,535</th>
    </tr>
    <tr>
        <th>boolean</th>
        <th>A boolean with true or false value</th>
        <th>1-bit</th>
        <th>false</th>
        <th>-</th>
    </tr>
</table>

## **Example**

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
A package that is based on the primitive data type that have more functionalities (e.g. `String` class). <br>
 Performing mathematical calculation is not allowed even if the data is stored in has digits


# **Variables and Constants**
A variable is a combinations of a `type`, `identifier`, and `value` that can be change in the program. <br>
On the other hand, a constant is also the same combination as variable, but the value cannot be change in program.

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

# **Operators**
Symbols used to compute and compare values and test to test multiple conditons

## **Arithmetic Operator**
<table>
    <tr>
        <th>Name</th>
        <th>Operator</th>
        <th>Description</th>
        <th>Example</th>
    </tr>
    <tr>
        <th>Addition</th>
        <th>+</th>
        <th>adds an operand</th>
        <th>int x = y + z</th>
    </tr>
    <tr>
        <th>Subtraction</th>
        <th>-</th>
        <th>subtracts the right operand from the left operand</th>
        <th>int x = y - z</th>
    </tr>
    <tr>
        <th>Multiplication</th>
        <th>*</th>
        <th>Multiplies the operands</th>
        <th>int x = y * z</th>
    </tr>
    <tr>
        <th>Division</th>
        <th>/</th>
        <th>Divides the left operand by the right operance</th>
        <th>int x = y / z</th>
    </tr>
    <tr>
        <th>Modulus</th>
        <th>%</th>
        <th>calculates the remainder of an integer division</th>
        <th>int x = y % z</th>
    </tr>
</table>

## **Assignment Operator**
<table>
    <tr>
        <th>Name</th>
        <th>Operator</th>
        <th>Description</th>
        <th>Example</th>
    </tr>
    <tr>
        <th>Assignment</th>
        <th>=</th>
        <th>assigns the value of the right operand to the left operand</th>
        <th>int x = y</th>
    </tr>
    <tr>
        <th>Add and assignment</th>
        <th>+=</th>
        <th>adds the operands and assigns the result to the left operand</th>
        <th>int x += y</th>
    </tr>
    <tr>
        <th>Subtract and assignment</th>
        <th>-=</th>
        <th>subtracts the right operand from the left operand and store the value the result in the left operand</th>
        <th>int x -= y</th>
    </tr>
    <tr>
        <th>Multiple and assignment</th>
        <th>*=</th>
        <th>multiplies the right operand from the left operand and store the value the result in the left operand</th>
        <th>int x *= yz</th>
    </tr>
    <tr>
        <th>Divide and assignment</th>
        <th>/=</th>
        <th>divides the right operand from the left operand and store the value the result in the left operand</th>
        <th>int x /= y</th>
    </tr>
    <tr>
        <th>Modulus and assignment</th>
        <th>%=</th>
        <th>get the remainder of the right operand from the left operand and store the value the result in the left operand</th>
        <th>int x %= y</th>
    </tr>
</table>

## **Unary Operator**
<table>
    <tr>
        <th>Name</th>
        <th>Operator</th>
        <th>Description</th>
        <th>Example</th>
    </tr>
    <tr>
        <th>Unary plus</th>
        <th>+</th>
        <th>represents the positive value</th>
        <th>+a</th>
    </tr>
    <tr>
        <th>Unary minus</th>
        <th>-</th>
        <th>represents the negative value</th>
        <th>-a</th>
    </tr>
    <tr>
        <th>Increament</th>
        <th>++</th>
        <th>increases the value of the operand by 1</th>
        <th>a++</th>
    </tr>
    <tr>
        <th>Decreament</th>
        <th>--</th>
        <th>increases the value of the operand by 1</th>
        <th>a--</th>
    </tr>
    <tr>
        <th>Logical complement</th>
        <th>!</th>
        <th>inverts the value of a boolean variable</th>
        <th>!true</th>
    </tr>
</table>

## **Comparison Operator**
<table>
    <tr>
        <th>Name</th>
        <th>Operator</th>
        <th>Description</th>
        <th>Example</th>
    </tr>
    <tr>
        <th>Equal to</th>
        <th>==</th>
        <th>evaluates whether the operands are equals</th>
        <th>x == y</th>
    </tr>
    <tr>
        <th>Not equal to</th>
        <th>!=</th>
        <th>evaluates whether the operands are not equals</th>
        <th>x != y</th>
    </tr>
    <tr>
        <th>Greater than</th>
        <th>></th>
        <th>evaluates whether the left operands is greater than the right operand</th>
        <th>x > y</th>
    </tr>
    <tr>
        <th>Less than</th>
        <th><</th>
        <th>evaluates whether the left operands is greater than the less operand</th>
        <th>x < y</th>
    </tr>
    <tr>
        <th>Greater than or equal</th>
        <th>>=</th>
        <th>evaluates whether the left operands is greater than or equal to the right operand</th>
        <th>x >= y</th>
    </tr>
    <tr>
        <th>Less than or equal</th>
        <th>>=</th>
        <th>evaluates whether the left operands is less than or equal to the right operand</th>
        <th>x <= y</th>
    </tr>
</table>

## **Shift Operator**
<table>
    <tr>
        <th>Name</th>
        <th>Operator</th>
        <th>Description</th>
        <th>Example</th>
    </tr>
    <tr>
        <th>Signed left shift</th>
        <th><<</th>
        <th>shifts all the bits to the right by specified number. For example, num<<2, will shift the bits of num to left by two position</th>
        <th>x << 2</th>
    </tr>
    <tr>
        <th>Signed right shift</th>
        <th>>></th>
        <th>shifts all the bits to the left by specified number. For example, num>>2, will shift the bits of num to left by two position</th>
        <th>x >> 2</th>
    </tr>
    <tr>
        <th>Unsigned right shift</th>
        <th> >>> </th>
        <th>same as signed right shift except that it fills the vacent leftmost position with I's instead of sign bit</th>
        <th>x >>> 2</th>
    </tr>
</table>

## **Bitwise Operator**
<table>
    <tr>
        <th>Name</th>
        <th>Operator</th>
        <th>Description</th>
        <th>Example</th>
    </tr>
    <tr>
        <th>AND</th>
        <th>&</th>
        <th>AND results in a 1 if both the bits are 1. Any other combination results in 0</th>
        <th>x & y</th>
    </tr>
    <tr>
        <th>OR</th>
        <th>|</th>
        <th>OR result in a 0 when both the bits are 0. Any other combination results 1</th>
        <th>x | y</th>
    </tr>
    <tr>
        <th>XOR</th>
        <th>^</th>
        <th>XOR results in a 0, if both the bits are of the same value and 1 if the bits have different values</th>
        <th>x ^ y</th>
    </tr>
    <tr>
        <th>Inversion</th>
        <th>~</th>
        <th>convers all 1 bits to 0's and all 0 bits to 1's</th>
        <th>~x</th>
    </tr>
</table>

# **Logical Operators**
<table>
    <tr>
        <th>Name</th>
        <th>Operator</th>
        <th>Description</th>
        <th>Example</th>
    </tr>
    <tr>
        <th>Logical AND</th>
        <th>&&</th>
        <th>if both the operands are non-zero,  the expression returns true; otherwise, it returns false</th>
        <th>x > 4 && y < 8</th>
    </tr>
    <tr>
        <th>Logical OR</th>
        <th>||</th>
        <th>If one or both the operand are non-zero, the expression returns true; otherwise, it returns false</th>
        <th>x > 4 || y < 8</th>
    </tr>
</table>

# **Input**
It is the process of entering a data in the software running on computer through typed text, various types of files, or mouse commands. <br>
It come on different sources such as mouse, keyboard, a disk, or even sensor on a robots.

# **Output**
The data processed by the computer software that can be directed at printers, screen monitor, and other devices that displays output. <br>
Can be any form such as output on screen, a disk, a printer, or even in a form of movement found in a robots.

# **Scanner package**
An import statement `import java.util.Scanner;` is added to use predefined method for inputs. <br> On the other hand, `System.out` is the console output, the output sent to the console. <br> While the `println` is the statement (<i><span style="color: red;">function</span></i>) that display the value to be shown on the screen or monitor.

# **Java.lang**
It includes the system and math classes. <br> This package is automatically imported into all java programs so `import` statement is not needed to use the functions of the lang package.

# **Control-Flow Structure**
A program that performs decision making to determine the sequence in which it will execute the instructions. <br> It is also used to control the execution flow of the program.

## **1. Selection Statement**
A control flow construct that directs the program to execute specific blocks of code based on whether a runtime condition evaluates to true or false.
* `if-statement` - data is compared, and decision is made depending on the comparison result
* `if-else statement` - extention of if-statement where the else-block is executed whenever the if-block is false
* `switch statement` - it is used whenever there are multiple values possible for variable

## **2. Repetition Statement**
A looping statement that causes a section of a program to be repeated based on a specific number of times. The loop continues until the condition becomes false.
* `while-statement` - loop that continues until the evaluating condition becomes false
* `do-while statement` - loop that list the contion after the statement to be executed
* `for-statement` - used when the iteration are known in advance (<i><span style="color: red;">iteration refers to the number of times the loop body is executed</span></i>)

## **3. Branching Statement**
These statements transfer control to another part of the program.
* `break-statement` - used to break out of loop and can be labeled or unlabeled (<i><span style="color: red;">also breaks switch statement</span></i>)
* `continue-statement` - used in looping statement to skip current iteration of the loop and resume to the next iteration
* `return-statement` - transfers the control to the caller of the method

# **String**
A sentence of characters that is considered as an object and have a specific methods. It contains <ins>String index</ins>, each characters has a specific position, for example character starts at index 0. <ins>String literal</ins>, a series of characters found enclosed in double quotes and considered as constand.

## **Built-in String Methods**
* **charAt()** - returns the character present in the specific index
* **trim()** - removes the leading and trailing whitespaces from a string
* **replace()** - changes the matching occurrences of a text or character in the string with new text or character
* **equals()** - returns true if two strings are identical and false otherwise
* **toLowerCase()/toUpperCase()** - changes all characters in the string to lowercase or uppercase
* **length()** - returns the number of characters in the string
* **concat()** - method returns a new string based on two concatenated or joined strings
* **indexOf()** - returns the position in number of the text 
* **compareTo()** - compares two strings based on their dictionary order

# **Array**
Represents data in a connected space in the computer. Basically, a colletion of element of the same type. There are types of arrays that needs to be study, these are the <ins>Single-Dimension Array</ins>, a list of same type variable where data moves in single dimension (left and right). And lastly, <ins>Multi-Dimension Array</ins>, it refers as an array of an array where data moves in multiple dimension. For example, Two-Dimesional Array, data moves in left-to-right and top-to-bottom.