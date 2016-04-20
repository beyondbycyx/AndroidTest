package com.hugo.androidtest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hugo on 2016/4/20.
 */
public class CalculatorUtilsTest {

    CalculatorUtils calculatorUtils ;
    @Before
    public void setUp() throws Exception {
        calculatorUtils = new CalculatorUtils();
    }

    @Test
    public void testAdd() throws Exception {

        double add = calculatorUtils.add(3, 4);
        assertEquals(7, add, 0);

    }

    @Test
    public void testDivide() throws Exception {

        double divide = calculatorUtils.divide(5, 2);
        assertEquals(2.5, divide,0);
    }
}