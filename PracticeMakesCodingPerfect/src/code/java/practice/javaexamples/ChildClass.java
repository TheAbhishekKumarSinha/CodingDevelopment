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
}

public class ChildClass extends ParentClass {

    /*
     * return type is a child class of the parent class return type. So class will compile and
     * execute
     */
    int a = 1;
    int b = 2;

    @Override
    Integer move() {
        System.out.println("Child Class Move");
        return 0;
    }

    public static void main(String[] args) {
        ParentClass p = new ChildClass();
        System.out.println(p.a);
        System.out.println(p.b);
        try {
            System.out.println(p.move());
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

// Output
/*
 * 0 0 Child Class Move 0
 */
