package com.ebelli.mandsprobe.matchers;

import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.lang.reflect.Field;

/**
 * Credits to this Matcher goes to Matthias Bruns
 * https://gist.github.com/matthiasbruns/008f13cab891aa89a583
 */
public class TextInputLayoutMatcher {

    private static final String TAG = "TextInputLayoutMatcher";

    public static Matcher<View> withError(final String expectedError) {
        return new TypeSafeMatcher<View>() {


            @Override
            public void describeTo(Description description) {
            }


            @Override
            public boolean matchesSafely(View view) {
                return checkError(view, expectedError);
            }
        };
    }


    public static Matcher<View> withError(final int expectedError) {
        return new TypeSafeMatcher<View>() {


            @Override
            public void describeTo(Description description) {
            }


            @Override
            public boolean matchesSafely(View view) {
                return checkError(view, view.getContext().getString(expectedError));
            }
        };


    }


    private static boolean checkError(final View view, final String error) {
        if (view instanceof EditText) {
            final EditText editText = (EditText) view;
            return TextUtils.isEmpty(editText.getError()) && TextUtils.isEmpty(error) || error
                    .equals(editText.getError());
        }
        if (view instanceof TextInputLayout) {
            final TextInputLayout textInputLayout = (TextInputLayout) view;
            // Ugly private reflection shit here
            Field field = null;
            try {
                field = TextInputLayout.class.getDeclaredField("mErrorView");
                field.setAccessible(true);
                Object value = field.get(textInputLayout);
                if (value != null && value instanceof TextView) {
                    final TextView reflectedTextView = (TextView) value;
                    final CharSequence text = reflectedTextView.getText();
                    return TextUtils.isEmpty(text) || error
                            .equals(text);
                }
            } catch (IllegalAccessException e) {
                Log.w(TAG, "Could not test for error", e);
                return false;
            } catch (NoSuchFieldException e) {
                Log.w(TAG, "Could not test for error", e);
                return false;
            }
        }
        return false;
    }
}
