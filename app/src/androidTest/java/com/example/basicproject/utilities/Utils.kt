package com.example.basicproject.utilities

import android.view.View
import android.widget.TextView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object Utils {
    fun getText(viewInteraction: ViewInteraction): String? {
        val stringHolder = arrayOf<String?>(null)
        viewInteraction.perform(object : ViewAction {
            override fun getConstraints() = ViewMatchers.isAssignableFrom(TextView::class.java)

            override fun getDescription() = "Get text from View: ${stringHolder[0]}"

            override fun perform(uiController: UiController, view: View) {
                val tv = view as TextView
                stringHolder[0] = tv.text.toString()
            }
        })
        return stringHolder[0]
    }

    fun getCurrentDate(): String? {
        val formatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy")
        val current = LocalDateTime.now().format(formatter)

        return current
    }
}