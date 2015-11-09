package com.hugo.androidtest;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;

/**
 *
 *  Activity 的单元测试:
 *  某个Activity启动另一个Activity之间的交流。
 *  测试button的performClick 事件，触发启动另一个的Activity
 * Created by hq on 2015/11/8.
 */
public class LaunchActivityUnitTest extends ActivityUnitTestCase<LaunchActivity> {

    private Intent intent;

    public LaunchActivityUnitTest() {
        super(LaunchActivity.class);
    }


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //因为这里是单元测试，系统不会帮我们启动一个activity，需要自己手动的启动一个activity
        intent = new Intent(getInstrumentation().getTargetContext(), LaunchActivity.class);
        startActivity(intent, null, null);

        //获取启动后的activity的button组件
        Button bt = (Button) getActivity().findViewById(R.id.bt);
        //无法使用TouchUtils ，因为这里不是UI线程启动，是另一个
        bt.performClick();//启动点击事件

        Intent startedActivityIntent = getStartedActivityIntent();
        int reqeustCode = getStartedActivityRequest();
        int finishEdCode = getFinishedActivityRequest();

        assertNotNull("startedActivityIntent is null", startedActivityIntent);
        assertEquals(101, reqeustCode);
        assertEquals(10,finishEdCode);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();

    }
}
