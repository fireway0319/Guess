package com.tom.GuessNumber

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class MaterialSelfTest {
    @JvmField
    @Rule
    val materialActivity = ActivityTestRule<MaterialActivity>(MaterialActivity::class.java)

    @Test
    fun guessDebug() {
        val resource = materialActivity.activity.resources
        val secret = materialActivity.activity.secretNumber.secret
        for (n in 1..10) {
            if (n != secret) {
                val numberEdit=ViewMatchers.withId(R.id.number_editText)
                Espresso.onView(numberEdit).perform(ViewActions.typeText(n.toString()))
                Espresso.onView(ViewMatchers.withId(R.id.ok_button)).perform(ViewActions.click())

                val message=
                    if(n<secret)resource.getString(R.string.bigger)
                    else    resource.getString(R.string.smaller)
                Espresso.onView(ViewMatchers.withText(message)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
                Espresso.onView(ViewMatchers.withText(R.string.ok)).perform(ViewActions.click())
                Espresso.onView(numberEdit).perform(ViewActions.clearText())
            }
        }
    }
}
