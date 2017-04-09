package com.golect.basicandroidtest.util;


import android.support.annotation.ColorRes;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.internal.util.Checks;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class TestUtils {

    public static Matcher<View> withTextColor(@ColorRes final int colorRes) {
        Checks.checkNotNull(colorRes);
        return new BoundedMatcher<View, TextView>(TextView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("with text color: ");
            }

            @Override
            public boolean matchesSafely(TextView view) {
                final int color = ContextCompat.getColor(view.getContext(), colorRes);
                return color == view.getCurrentTextColor();
            }
        };
    }

}
