package code.java.practice.javaexamples;

/**
 * @author abhsinha
 *
 */
class ParentClass {
    int a = 0;
    int b = 0;

    Object move() throws Exception { // return type of parent class is object
        System.out.println("Parent Class Move");
        return "";
    }

    final void parentWatch() {
        System.out.println("Parent Watch");
    }

    static void LetsPlay() {
        System.out.println("Parent Lets Play");
    }
}

public class ChildClass extends ParentClass {

    /*
     * return type is a child class of the parent class return type. So class will compile and
     * execute
     */
    int a = 1;
    int b = 2;

    /*
     * (non-Javadoc)
     * 
     * @see code.java.practice.javaexamples.ParentClass#move()
     */
    @Override
    Integer move() {
        System.out.println("Child Class Move");
        return 0;
    }

    void childWatche() {
        System.out.println("Child Watche");
    }

    static void LetsPlay() {
        System.out.println("Lets Play");
    }
}

// Output
/*
 * 0 0 Child Class Move 0
 */
