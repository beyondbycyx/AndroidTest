package com.hugo.androidtest;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.TextView;

/**
 * Created by hq on 2015/11/9.
 * Android Support Test:由于使用了android support test,不是自带的android test ,需要手动注入工具类
 *  Espresso 工具的使用：
 *  它是一个可以在Activity 界面上寻找任何的的View 控件，并对其执行任何的action操作，还有check检查操作。
 *
 */
public class EspressoTest extends ActivityInstrumentationTestCase2<ViewPerformActivity> {

    private ViewPerformActivity activity;

    public EspressoTest() {
        super(ViewPerformActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //手动注入工具:Instrumentation
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        activity = getActivity();

    }

    public void testChangeText() {
        //获取某个View
        ViewInteraction viewFocus = Espresso.onView(ViewMatchers.withId(R.id.et));
        //执行某个动作
        viewFocus.perform(ViewActions.clearText());
        viewFocus.perform(ViewActions.typeText("new"));
        TextView tv = (TextView) activity.findViewById(R.id.et);
        //检查结果
        EspressoTest.assertEquals("new", tv.getText()+"");

    }
}
