package com.hugo.androidtest;

import android.widget.Button;
import android.widget.TextView;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.internal.SdkEnvironment;

import static org.junit.Assert.*;

/**
 * Created by hugo on 2016/4/20.
 */


@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = 21)
public class RoboActivityTest {

    private RoboActivity mRoboActivity;
    private Button mBt;
    private TextView mTv;

    @Before
    public void setup() {

        mRoboActivity = Robolectric.setupActivity(RoboActivity.class);
        mBt = (Button) mRoboActivity.findViewById(R.id.bt);
        mTv = (TextView) mRoboActivity.findViewById(R.id.tv);

    }


    @Test
    public void testInit() throws Exception {

        assertThat(mTv.getText().toString(), IsEqual.equalTo("textview1"));

    }
}