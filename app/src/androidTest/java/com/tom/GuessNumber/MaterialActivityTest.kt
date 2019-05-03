package com.tom.GuessNumber

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MaterialActivityTest {
    @Rule
    @JvmField
    val activityTestRule=ActivityTestRule<MaterialActivity>(MaterialActivity::class.java)

    @Test
    fun guessWrong() {
        val resource = activityTestRule.activity.resources
        val secret = activityTestRule.activity.secretNumber.secret
        for (n in 1..10) {
            if(n!=secret) {
                onView(withId(R.id.number_editText)).perform(clearText())
                onView(withId(R.id.number_editText)).perform(typeText(n.toString()))
                onView(withId(R.id.ok_button)).perform(click())
                val message =
                    if (n < secret) resource.getString(R.string.bigger)
                    else resource.getString(R.string.smaller)
                onView(withText(message)).check(matches(isDisplayed()))
                onView(withText(resource.getString(R.string.ok))).perform(click())

            }
        }
    }
}