package com.hugo.androidtest;

/**
 * Created by hugo on 2016/4/20.
 */
public class CalculatorUtils {

    public double add(double x, double y) {

        return x + y;
    }

    public double divide(double x, double y) {

       if (y == 0) throw new IllegalArgumentException("Dividor cannot be 0");
        return x/y;
    }

    public double sub(double x, double y) {

        return x - y;
    }
}
