package com.example.basicproject.tests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.basicproject.MainActivity
import com.example.basicproject.R
import org.junit.Rule
import org.junit.Test

class SwitchesTest {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testSwitchOne() {
        onView(withId(R.id.switchButton))
            .perform(ViewActions.click())

        // First Switch Tests
        onView(withId(R.id.switchOneLabel)).check(matches(withText("Off")))

        onView(withId(R.id.switchOne)).check(matches(isNotChecked()))
            .perform(ViewActions.click())

        onView(withId(R.id.switchOne)).check(matches(isChecked()))

    }

    @Test
    fun testSwitchTwo() {
        onView(withId(R.id.switchButton))
            .perform(ViewActions.click())

        // First Switch Tests
        onView(withId(R.id.switchTwoLabel)).check(matches(withText("Off")))

        onView(withId(R.id.switchTwo)).check(matches(isNotChecked()))
            .perform(ViewActions.click())

        onView(withId(R.id.switchTwo)).check(matches(isChecked()))

    }

    @Test
    fun testSwitchThree() {
        onView(withId(R.id.switchButton))
            .perform(ViewActions.click())

        // First Switch Tests
        onView(withId(R.id.switchThreeLabel)).check(matches(withText("Off")))

        onView(withId(R.id.switchThree)).check(matches(isNotChecked()))
            .perform(ViewActions.click())

        onView(withId(R.id.switchThree)).check(matches(isChecked()))

    }

    @Test
    fun testSwitchFour() {
        onView(withId(R.id.switchButton))
            .perform(ViewActions.click())

        // First Switch Tests
        onView(withId(R.id.switchFourLabel)).check(matches(withText("Off")))

        onView(withId(R.id.switchFour)).check(matches(isNotChecked()))
            .perform(ViewActions.click())

        onView(withId(R.id.switchFour)).check(matches(isChecked()))

    }

    @Test
    fun testSwitchFive() {
        onView(withId(R.id.switchButton))
            .perform(ViewActions.click())

        // First Switch Tests
        onView(withId(R.id.switchFiveLabel)).check(matches(withText("Off")))

        onView(withId(R.id.switchFive)).check(matches(isNotChecked()))
            .perform(ViewActions.click())

        onView(withId(R.id.switchFive)).check(matches(isChecked()))

    }
}