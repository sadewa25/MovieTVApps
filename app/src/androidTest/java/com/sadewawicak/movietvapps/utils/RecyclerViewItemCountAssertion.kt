package com.sadewawicak.movietvapps.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.ViewMatchers
import junit.framework.Assert
import org.hamcrest.core.Is

class RecyclerViewItemCountAssertion(val expectedCount: Int) : ViewAssertion {

    override fun check(view: View, noViewFoundException: NoMatchingViewException?) {
        if (noViewFoundException != null) {
            throw noViewFoundException
        }
        val recyclerView = view as RecyclerView
        val adapter = recyclerView.adapter
        Assert.assertNotNull(adapter)
        ViewMatchers.assertThat(adapter!!.itemCount, Is.`is`(expectedCount))
    }

}