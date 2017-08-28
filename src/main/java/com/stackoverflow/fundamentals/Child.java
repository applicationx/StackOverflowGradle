package com.stackoverflow.fundamentals;

/**
 * Created by jonasd on 2017-08-05.
 */
public class Child extends Parent {

    int x = 10;

    public Child() {
        super();
        System.out.println(this);
    }

    public int getX() {
        return x;
    }

    public String toString() {
        return "child (x = "  + getX() + ")";
    }

    public static void main(String[] args) {
        Child c = new Child();
    }
}
