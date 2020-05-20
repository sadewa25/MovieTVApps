package com.sadewawicak.movietvapps.ui.detail.movie

import android.content.Context
import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.jakewharton.espresso.OkHttp3IdlingResource
import com.sadewawicak.movietvapps.R
import com.sadewawicak.movietvapps.data.source.remote.RetrofitClient
import org.junit.After
import org.junit.Rule
import org.junit.Test

class DetailMovieActivityTest {

    @Rule
    @JvmField
    var activityRule: ActivityTestRule<DetailMovieActivity> =
        object : ActivityTestRule<DetailMovieActivity>(DetailMovieActivity::class.java) {
            override fun getActivityIntent(): Intent {
                IdlingRegistry.getInstance().register(idlingResource)
                val targetContext: Context =
                    InstrumentationRegistry.getInstrumentation().targetContext
                val result = Intent(targetContext, DetailMovieActivity::class.java)
                result.putExtra("id", "330457")
                return result
            }
        }

    val idlingResource: IdlingResource = OkHttp3IdlingResource.create("okhttp", RetrofitClient.ok)

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(idlingResource)
    }


    @Test
    fun loadCourse() {

        Espresso.onView(ViewMatchers.withId(R.id.text_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.text_title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Frozen II")))
        Espresso.onView(ViewMatchers.withId(R.id.text_date))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}