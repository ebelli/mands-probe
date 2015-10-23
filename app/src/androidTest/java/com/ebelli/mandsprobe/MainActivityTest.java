package com.ebelli.mandsprobe;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.ebelli.mandsprobe.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.ebelli.mandsprobe.matchers.TextInputLayoutMatcher.withError;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testViews(){
        onView(withId(R.id.tilEmail)).check(matches(isDisplayed()));
        onView(withId(R.id.btnSearchSend)).check(matches(isDisplayed()));
        onView(withId(R.id.etEmail)).check(matches(isDisplayed()));
    }

    @Test
    public void testInvalidEmail(){
        onView(withId(R.id.etEmail)).perform(typeText("test"));
        onView(withId(R.id.btnSearchSend)).perform(click());
        onView(withId(R.id.tilEmail)).check(matches(withError(R.string.mailerror)));
    }
}