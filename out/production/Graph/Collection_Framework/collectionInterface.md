1 -> `Collection` is an interface which is present in java.util package 

2->`Syntax`:public interface Collection<E> extends Iterable 

3->Collection was introduced in Jdk 1.2 version 

4->Collection is an Object which is used to represent a group of Indicvidual Object or single object 

5->Collection is the `root` interface of collection Framework 

6->There is no concreate class which implements the collection interface directly but 
there are interfaces which inherit the collection interface 

`List`
`Set`
`Queue`

What is difference between collections and collection 

=>Collection is an interface 
=>Collection is utility class 

=>Collection is an Object which is used to represent a group of individual object as a single unit 

=>Collections defines several utility methods
that are used to operate on collection objects like
sorting, searching etc

=>Collection interface contains `default abstract` method and `static methods`

=>Collection Contains only `static methods`

What is utility class in Java 
->Utility class is a helper class which cannot be instantiated 
    `utility class contains only static methods`
    `Example:Arrays,Collection`
    `How to create a Utility class`
              ->declare the class as object and final 
              ->we have to create a private coonstructor to prevent object creation 
              ->class should contains only static methods and does not contains abstract methods 
              ->every methods should have deep documentation 

What is utility `Utility Methods`.

->utility methods perform common often reused methods.
->Utlity methods always a static type 
->`Examples`:Searching,Sorting,method perform to string menupulatin methods connecting to database etc 



