package com.hugo.androidtest;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Activity 工具的测试
 *  单个Activity上的某个View/多个View位置关系的测试
 *  测试button 的点击事件(TouchUtils)
 *  两个View之间的位置关系(ViewAsserts)
 * Created by hq on 2015/11/8.
 */
public class ActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity firstActivity;
    private TextView tv;
    private Button bt;
    private TextView testTv;

    /**
     * 由于该类需要被系统调用，而且需要知道它测试的类，所以需要在父类的构造方法中传入。
     */
    public ActivityTest() {
        super(MainActivity.class);//传入测试的类
    }

    /**
     * 第一个方法
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(true); //该方法需要在getActivity()方法之前调用，用来初始化点击事件
        firstActivity = getActivity();
        tv = (TextView) firstActivity.findViewById(R.id.tv);
        bt = (Button) firstActivity.findViewById(R.id.bt);
        testTv = (TextView)firstActivity.findViewById(R.id.test_tv);
        //非空判断
        assertNotNull("firstActivity is null", firstActivity);
        assertNotNull("tv is null", tv);

    }

    /**
     * 测试初始化时的状态
     * 指定为中等测试
     */
    @MediumTest
    public void testPrecondition() {
        String str = tv.getText().toString();
        assertEquals("text", str);

    }

    /**
     * 测试button的点击事件
     * TouchUtils 各种触摸点击事件
     */
    @MediumTest
    public void testClick() {

        //动态的点击按钮
        TouchUtils.clickView(this, bt);

        assertTrue(testTv.getVisibility() == View.GONE);
        assertEquals(tv.getText(),"onclick");
    }

    /**
     * 测试该view是否在某个View group 中
     * ViewAsserts 可以测试两个View之间的位置关系
     */
    @MediumTest
    public void testViewContains() {
        View decorView = firstActivity.getWindow().getDecorView();
        ViewAsserts.assertOnScreen(decorView, testTv);

        ViewAsserts.assertOffScreenAbove(bt, testTv);

    }

    public void testLaunch() {

    }
    /**
     *
     * 最后一个方法
     * @throws Exception
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

    }
}
