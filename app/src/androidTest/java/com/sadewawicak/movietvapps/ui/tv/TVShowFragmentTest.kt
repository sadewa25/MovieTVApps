package com.sadewawicak.movietvapps.ui.tv

import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.jakewharton.espresso.OkHttp3IdlingResource
import com.sadewawicak.movietvapps.R
import com.sadewawicak.movietvapps.SingleFragmentActivity
import com.sadewawicak.movietvapps.data.source.remote.RetrofitClient
import com.sadewawicak.movietvapps.utils.RecyclerViewItemCountAssertion
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TVShowFragmentTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(SingleFragmentActivity::class.java)
    private val movieFragment = TVShowFragment()
    val idlingResource: IdlingResource = OkHttp3IdlingResource.create("okhttp", RetrofitClient.ok)

    @Before
    fun setUp() {
        activityRule.activity.setFragment(movieFragment)
        IdlingRegistry.getInstance().register(idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(idlingResource)
    }


    @Test
    fun loadCourses() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_tvs))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rv_tvs)).check(RecyclerViewItemCountAssertion(20))
    }

}