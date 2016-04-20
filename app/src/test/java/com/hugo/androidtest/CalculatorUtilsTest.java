package com.hugo.androidtest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hugo on 2016/4/20.
 * java test ：使用了junit 4 (在.gradle 中添加了依赖 testCompile 'junit:junit:4.12')，直接使用java 虚拟机运行，无需要手机模拟器
 */
public class CalculatorUtilsTest {

    CalculatorUtils calculatorUtils;

    @Before
    public void setUp() throws Exception {
        calculatorUtils = new CalculatorUtils();
    }

    @Test
    public void testAdd() throws Exception {

        double add = calculatorUtils.add(3, 4);
        assertEquals(7, add, 0);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivide() throws Exception {

        double divide = calculatorUtils.divide(5, 0);
        assertEquals(0, divide, 0);

    }

    @Test
    @Ignore("not implement ")
    public void testSub() throws Exception {

    }
}