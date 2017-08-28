package com.stackoverflow.fundamentals;

/**
 * Created by jonasd on 2017-08-05.
 */
public class Parent {
    int x =  2;

    public Parent() {
        System.out.println(this);
    }

    public int getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Parent(x = " + x + ")";
    }
}
