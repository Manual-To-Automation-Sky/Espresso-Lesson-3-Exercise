package com.example.basicproject.tests

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.PickerActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.example.basicproject.MainActivity
import com.example.basicproject.R
import com.example.basicproject.utilities.Utils
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.endsWith
import org.junit.Rule
import org.junit.Test

class DatePickerTest {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun setAndCheckDate() {
        val currentDate = Utils.getCurrentDate()

        onView(withId(R.id.dateButton))
            .perform(ViewActions.click())

        // There are 2 identical element ids in this view, so we find the view with the same parent name.
        onView(allOf(withId(R.id.datePickerCalendar), withParent(withId(R.id.datePickerCalendar)))).perform(ViewActions.click())

        onView(withId(R.id.enteredDateLabel))
            .check(matches(withText(currentDate)))
    }
}