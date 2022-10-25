package com.example.basicproject.tests

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.basicproject.MainActivity
import com.example.basicproject.R
import com.example.basicproject.utilities.Utils
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class FormTest {
    private val firstName = "John"
    private val lastName = "Tester"
    private val emailAddress = "joe.tester@automate.com"
    private val formLabelText =
        StringBuilder().append("Name: ").append(firstName).append(" ").append(lastName)
            .append("\n\nEmail Address: ").append(emailAddress).toString()

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(
        MainActivity::class.java
    )

    @Test
    fun verifyFormFilled() {
        onView(withId(R.id.formButton)).perform(ViewActions.click())

        onView(withId(R.id.firstNameFormField)).perform(ViewActions.typeText(firstName))
        onView(withId(R.id.lastNameFormField)).perform(ViewActions.typeText(lastName))
        onView(withId(R.id.emailAddressFormField))
            .perform(ViewActions.typeText(emailAddress))

        onView(withId(R.id.formSubmitButton)).perform(ViewActions.click())

        val formText = Utils.getText(onView(withId(R.id.formDetailsLabel)))
        Log.d("formText", formText.toString())

        onView(withId(R.id.formDetailsLabel))
            .check(ViewAssertions.matches(ViewMatchers.withText(formLabelText)))
    }
}