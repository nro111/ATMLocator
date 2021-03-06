package com.ing.custom.custom;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.core.IsCollectionContaining;

public class CustomMatchers {

    public static <T> Matcher<Iterable<? super T>> exactlyNItems(final int n, Matcher<T> elementMatcher) {

        IsCollectionContaining<T> isCollectionContaining = new IsCollectionContaining<T>(elementMatcher) {

            @Override
            protected boolean matchesSafely(Iterable<? super T> collection, Description mismatchDescription) {
                int count = 0;
                boolean isPastFirst = false;

                for (Object item : collection) {

                    if (elementMatcher.matches(item)) {
                        count++;
                    }

                    if (isPastFirst) {
                        mismatchDescription.appendText(", ");
                    }

                    elementMatcher.describeMismatch(item, mismatchDescription);
                    isPastFirst = true;
                }

                if (count != n) {
                    mismatchDescription.appendText(". Expected exactly " + n + " but got " + count);
                }

                return count == n;
            }
        };

        return isCollectionContaining;
    }

    public static <T> Matcher<Iterable<? super T>> exactlyOnce(Matcher<T> elementMatcher) {
        return exactlyNItems(1, elementMatcher);
    }

}
