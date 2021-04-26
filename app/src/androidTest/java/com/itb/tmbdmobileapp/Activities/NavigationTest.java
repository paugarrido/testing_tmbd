package com.itb.tmbdmobileapp.Activities;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.itb.tmbdmobileapp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.longClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NavigationTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    // ACTIVITY 2
    @Test
    public void test_login_process() {

        onView(withId(R.id.login_textInputEditText_username)).perform(typeText("activity3")).perform(ViewActions.closeSoftKeyboard());

        onView(withId(R.id.login_textInputEditText_password)).perform(typeText("activity3")).perform(ViewActions.closeSoftKeyboard());

        ViewInteraction checkableImageButton = onView(
                allOf(withId(R.id.text_input_end_icon), withContentDescription("Show password"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.LinearLayout")),
                                        1),
                                0),
                        isDisplayed()));
        checkableImageButton.perform(click());

        ViewInteraction materialCheckBox = onView(
                allOf(withId(R.id.login_checkbox_rememberMe), withText("Remember me"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_login),
                                        0),
                                4),
                        isDisplayed()));
        materialCheckBox.perform(click());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.register_button_login), withText("LOGIN"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_login),
                                        0),
                                5),
                        isDisplayed()));
        materialButton.perform(click());
        onView(withId(R.id.fragment_tmbd_content)).check(matches(isDisplayed()));
    }

    // ACTIVITY 3

    @Test
    public void see_specific_film_and_then_see_one_actor_from_that_film() {

        test_login_process();

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recyclerView_1),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                1)));
        recyclerView.perform(actionOnItemAtPosition(0, click()));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recyclerViewActors),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                4)));
        recyclerView2.perform(actionOnItemAtPosition(1, click()));
        onView(withId(R.id.fragment_tmbd_content)).check(matches(isDisplayed()));

    }

    @Test
    public void go_series_screen_see_specific_serie_and_go_film_screen() {

        test_login_process();

        ViewInteraction materialToolbar = onView(
                allOf(withId(R.id.topAppBar),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.appBarLayout),
                                        0),
                                0),
                        isDisplayed()));
        materialToolbar.perform(click());

        ViewInteraction navigationMenuItemView = onView(
                allOf(withId(R.id.item_series),
                        childAtPosition(
                                allOf(withId(R.id.design_navigation_view),
                                        childAtPosition(
                                                withId(R.id.navigationView),
                                                0)),
                                2),
                        isDisplayed()));
        navigationMenuItemView.perform(click());

        ViewInteraction materialToolbar2 = onView(
                allOf(withId(R.id.topAppBar),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.appBarLayout),
                                        0),
                                0),
                        isDisplayed()));
        materialToolbar2.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recyclerView_1),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                1)));
        recyclerView.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction materialToolbar3 = onView(
                allOf(withId(R.id.topAppBar),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.appBarLayout),
                                        0),
                                0),
                        isDisplayed()));
        materialToolbar3.perform(click());

        ViewInteraction navigationMenuItemView2 = onView(
                allOf(withId(R.id.item_series),
                        childAtPosition(
                                allOf(withId(R.id.design_navigation_view),
                                        childAtPosition(
                                                withId(R.id.navigationView),
                                                0)),
                                2),
                        isDisplayed()));
        navigationMenuItemView2.perform(click());

        ViewInteraction materialToolbar4 = onView(
                allOf(withId(R.id.topAppBar),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.appBarLayout),
                                        0),
                                0),
                        isDisplayed()));
        materialToolbar4.perform(click());
        onView(withId(R.id.fragment_tmbd_content)).check(matches(isDisplayed()));
    }

    @Test
    public void go_actor_screen_see_specific_actor_and_see_specific_film_from_actor(){
        test_login_process();

        ViewInteraction materialToolbar = onView(
                allOf(withId(R.id.topAppBar),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.appBarLayout),
                                        0),
                                0),
                        isDisplayed()));
        materialToolbar.perform(click());

        ViewInteraction navigationMenuItemView = onView(
                allOf(withId(R.id.item_actores),
                        childAtPosition(
                                allOf(withId(R.id.design_navigation_view),
                                        childAtPosition(
                                                withId(R.id.navigationView),
                                                0)),
                                3),
                        isDisplayed()));
        navigationMenuItemView.perform(click());

        ViewInteraction materialToolbar2 = onView(
                allOf(withId(R.id.topAppBar),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.appBarLayout),
                                        0),
                                0),
                        isDisplayed()));
        materialToolbar2.perform(click());

        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.recyclerView_1),
                        childAtPosition(
                                withClassName(is("android.widget.RelativeLayout")),
                                1)));
        recyclerView.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.recyclerViewActors),
                        childAtPosition(
                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                4)));
        recyclerView2.perform(actionOnItemAtPosition(1, click()));
    }



    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

}
