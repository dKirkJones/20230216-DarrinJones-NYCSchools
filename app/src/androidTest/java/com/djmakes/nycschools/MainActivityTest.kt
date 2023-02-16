package com.djmakes.nycschools

import androidx.core.content.MimeTypeFilter.matches
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.djmakes.nycschools.ui.MainActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Test
    fun test_isActivityInView(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.main))
    }
    @Test
    fun testVisibility_title_startButton() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.txt_title))
            .check(ViewAssertions.matches(isDisplayed())) // method 1

        onView(withId(R.id.txt_title))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))) // method 2

        onView(withId(R.id.btn_start))
            .check(ViewAssertions.matches(isDisplayed()))
    }

}