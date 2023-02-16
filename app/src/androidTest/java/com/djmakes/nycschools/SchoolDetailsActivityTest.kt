package com.djmakes.nycschools

import androidx.core.content.MimeTypeFilter.matches
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.djmakes.nycschools.ui.SchoolDetailsActivity
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SchoolDetailsActivityTest {

    @Test
    fun test_isActivityInView(){
        val activityScenario = ActivityScenario.launch(SchoolDetailsActivity::class.java)
        onView(ViewMatchers.withId(R.id.detail_school_name))
            .check(ViewAssertions.matches(isDisplayed()))

        onView(ViewMatchers.withId(R.id.detail_school_address))
                .check(ViewAssertions.matches(isDisplayed()))

        onView(ViewMatchers.withId(R.id.detail_school_city))
            .check(ViewAssertions.matches(isDisplayed()))

        onView(ViewMatchers.withId(R.id.detail_school_phone))
            .check(ViewAssertions.matches(isDisplayed()))

        onView(ViewMatchers.withId(R.id.detail_school_overview))
            .check(ViewAssertions.matches(isDisplayed()))

        }


}