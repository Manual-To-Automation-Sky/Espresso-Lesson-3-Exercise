package com.example.basicproject.tests

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.RootMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.MediumTest
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.example.basicproject.MainActivity
import com.example.basicproject.R
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@MediumTest
@RunWith(AndroidJUnit4ClassRunner::class)
class AlertTest {

    @Rule @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun verifyAlertDisplayed() {
        Espresso.onView(withId(R.id.alertButton)).perform(ViewActions.click())
        Espresso.onView(withId(android.R.id.button2))
            .check(ViewAssertions.matches(isDisplayed()))
    }

    @Test
    fun verifyAlertDialogClosed() {
        Espresso.onView(withId(R.id.alertButton)).perform(ViewActions.click())
        Espresso.onView(
            Matchers.allOf(
                withId(android.R.id.button2),
                withText("No")
            )
        ).perform(ViewActions.click())
        Espresso.onView(isRoot()).inRoot(RootMatchers.isDialog()).noActivity()
    }

    @Test
    fun verifyAlertPageDisplayed() {
        Espresso.onView(withId(R.id.alertButton)).perform(ViewActions.click())
        Espresso.onView(
            Matchers.allOf(
                withId(android.R.id.button1),
                withText("Yes")
            )
        ).perform(ViewActions.click())
        Espresso.onView(withId(R.id.alertPageText))
            .check(ViewAssertions.matches(withText("You are on the Alert page!")))
    }

    @Test
    fun verifyHomePageDisplayed() {
        Espresso.onView(withId(R.id.alertButton)).perform(ViewActions.click())
        Espresso.onView(
            Matchers.allOf(
                withId(android.R.id.button1),
                withText("Yes")
            )
        ).perform(ViewActions.click())
        Espresso.onView(withId(R.id.alertPageGoBackButton)).perform(ViewActions.click())
        Espresso.onView(withId(R.id.alertButton))
            .check(ViewAssertions.matches(isDisplayed()))
    }
}