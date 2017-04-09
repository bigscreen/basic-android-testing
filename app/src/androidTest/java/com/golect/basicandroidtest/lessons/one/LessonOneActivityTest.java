package com.golect.basicandroidtest.lessons.one;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.golect.basicandroidtest.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.golect.basicandroidtest.util.TestUtils.withTextColor;

@RunWith(AndroidJUnit4.class)
public class LessonOneActivityTest {

    @Rule
    public ActivityTestRule<LessonOneActivity> activityTestRule = new ActivityTestRule<>(LessonOneActivity.class);

    @Test
    public void testShouldShowEvenNumberMessage() throws Exception {
        onView(withId(R.id.input_number)).perform(typeText("80"), closeSoftKeyboard());
        onView(withId(R.id.button_check)).perform(click());
        onView(withId(R.id.text_message)).check(matches(isDisplayed()))
                .check(matches(withText("You enter an even number.")))
                .check(matches(withTextColor(R.color.textEvenColor)));
    }

    @Test
    public void testShouldShowOddNumberMessage() throws Exception {
        onView(withId(R.id.input_number)).perform(typeText("99"), closeSoftKeyboard());
        onView(withId(R.id.button_check)).perform(click());
        onView(withId(R.id.text_message)).check(matches(isDisplayed()))
                .check(matches(withText("You enter an odd number.")))
                .check(matches(withTextColor(R.color.textOddColor)));
    }

    @Test
    public void testShouldShowErrorMessage() throws Exception {
        onView(withId(R.id.input_number)).perform(typeText("qwerty"), closeSoftKeyboard());
        onView(withId(R.id.button_check)).perform(click());
        onView(withId(R.id.text_message)).check(matches(isDisplayed()))
                .check(matches(withText("Please input decimal number.")))
                .check(matches(withTextColor(R.color.textRed)));
    }
}