package com.hugo.androidtest;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * Created by hq on 2015/11/8.
 * Testing Support Library: 测试支持工具库
 * AndroidJUnitRunner 工具： 支持兼容Junit4，它是Activity test ,可以使用Junit测试
 * 某个activity的方法测试
 */
 @RunWith(AndroidJUnit4.class)
public class JUnitTest extends ActivityInstrumentationTestCase2<CalculatorActivity> {

    private CalculatorActivity activity;

    public JUnitTest() {
        super(CalculatorActivity.class);
    }

    @Before   //相当于嵌入了每个Test 标记方法的最前面
    @Override
    public void setUp() throws Exception {
        super.setUp();
        //手动注入工具:Instrumentation
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        //获取测试的Activity
        activity = getActivity();

    }


    @Test //测试,所有Test 标记的方法 ，都是没有顺序的执行的
    public void addMethodTest() {
        double sum = activity.add(3, 5);
        assertEquals("sum != 8", 8.0, sum);
    }

    @After //每个Test 方法结束后，都会调用它，相当于嵌入了每个Test 标记的方法的结束处。
    @Override
    public void tearDown() throws Exception {
        super.tearDown();

    }

    @BeforeClass //只会执行一次，相当于静态代码块 ，常用于数据库的初始化操作
    public static void staticInit() {

    }

    @AfterClass // 在所有的Test 方法执行后调用，用于处理@BeforeClass 里的资源释放
    public static void release() {

    }
}
