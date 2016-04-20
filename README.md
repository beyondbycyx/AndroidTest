# Android 测试Demo代码
- Junit
- AndroidRunner
- android.support.test
## JUnit support 
- JUnit 4 test  :可以针对某个activity的某个功能进行测试
```java

@RunWith(AndroidJUnit4.class)
public class CalculatorInstrumentationTest
        extends ActivityInstrumentationTestCase2<CalculatorActivity> {

    @Before
    public void setUp() throws Exception {
        super.setUp();

        // Injecting the Instrumentation instance is required
        // for your test to run with AndroidJUnitRunner.
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
    }

    @Test
    public void typeOperandsAndPerformAddOperation() {
        // Call the CalculatorActivity add() method and pass in some operand values, then
        // check that the expected value is returned.
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
```
## android support test 包下的Espresso 
- 可以获取当前activity中的某个view，并对它进行某个动作(click),再进行测试判断

```java
        onView(withId(R.id.my_view))            // withId(R.id.my_view) is a ViewMatcher
        .perform(click())               // click() is a ViewAction
        .check(matches(isDisplayed())); // matches(isDisplayed()) is a ViewAssertion
```
## android test 包下的测试工具
- 可以判断当前activity中的view与view之间的位置关系，并可以进行点击事件。

```java
public class ClickFunActivityTest
        extends ActivityInstrumentationTestCase2 {
    ...
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        setActivityInitialTouchMode(true);

        mClickFunActivity = getActivity();
        mClickMeButton = (Button) 
                mClickFunActivity
                .findViewById(R.id.launch_next_activity_button);
        mInfoTextView = (TextView) 
                mClickFunActivity.findViewById(R.id.info_text_view);
    }
}
@MediumTest
public void testInfoTextView_layout() {
    final View decorView = mClickFunActivity.getWindow().getDecorView();
    ViewAsserts.assertOnScreen(decorView, mInfoTextView);
    assertTrue(View.GONE == mInfoTextView.getVisibility());
}
```
## Unit Tests
- 两个activity之间跳转，与交流的测试

```java
@UiThreadTest  //startActivity 方法需要在主线程中进行
@MediumTest
public void testNextActivityWasLaunchedWithIntent() {
    startActivity(mLaunchIntent, null, null);
    final Button launchNextButton =
            (Button) getActivity()
            .findViewById(R.id.launch_next_activity_button);
    launchNextButton.performClick();

    final Intent launchIntent = getStartedActivityIntent();
    assertNotNull("Intent was null", launchIntent);
    assertTrue(isFinishCalled());

    final String payload =
            launchIntent.getStringExtra(NextActivity.EXTRAS_PAYLOAD_KEY);
    assertEquals("Payload is empty", LaunchActivity.STRING_PAYLOAD, payload);
}
```
##单元测试的地址：http://www.jianshu.com/p/03118c11c199

























