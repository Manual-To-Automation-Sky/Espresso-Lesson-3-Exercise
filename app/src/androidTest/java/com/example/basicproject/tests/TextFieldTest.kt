package com.example.basicproject.tests

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.SmallTest
import androidx.test.rule.ActivityTestRule
import com.example.basicproject.MainActivity
import com.example.basicproject.R
import org.junit.Rule
import org.junit.Test

@SmallTest
class TextFieldTest {

    @Rule @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun verifyEnteredTextSuccessfully() {
        val textFieldText = "Sky Espresso Lesson 1"
        val enteredText = "Entered Text: $textFieldText"

        // Find the Texxt Field button on the main page
        onView(withId(R.id.textFieldButton))
                .perform(ViewActions.click())

        // Find the text field and type text into it
        onView(withId(R.id.textField))
                .perform(ViewActions.typeText(textFieldText))

        // Close the Keyboard to prevent view issues
        ViewActions.closeSoftKeyboard()

        // Click the Submit button to enter the text
        onView(withId(R.id.submitButton))
                .perform(ViewActions.click())

        val toolbar: ViewInteraction = onView(withId(R.id.enteredTextLabel))

        val text = getText(toolbar)


        // Verify that the text label is updated with the text entry.
        onView(withId(R.id.enteredTextLabel))
                .check(ViewAssertions.matches(ViewMatchers.withText(enteredText)))
    }

    @Test
    fun verifyErrorWhenSubmitBlank() {
        val errorMessage = "No text was entered!"
        onView(withId(R.id.textFieldButton))
                .perform(ViewActions.click())

        // Click the Submit button to enter the text
        onView(withId(R.id.submitButton))
                .perform(ViewActions.click())
        onView(withId(R.id.textFieldErrorLabel))
                .check(ViewAssertions.matches(ViewMatchers.withText(errorMessage)))
    }

    fun getText(viewInteraction: ViewInteraction): String? {
        val stringHolder = arrayOf<String?>(null)
        viewInteraction.perform(object : ViewAction {
            override fun getConstraints() = isAssignableFrom(TextView::class.java)

            override fun getDescription() = "Get text from View: ${stringHolder[0]}"

            override fun perform(uiController: UiController, view: View) {
                val tv = view as TextView
                stringHolder[0] = tv.text.toString()
            }
        })
        return stringHolder[0]
    }
}