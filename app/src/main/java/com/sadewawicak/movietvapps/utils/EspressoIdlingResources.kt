package com.sadewawicak.movietvapps.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource


class EspressoIdlingResources {

    private val RESOURCE = "GLOBAL"
    private var espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    fun increment() {
        espressoTestIdlingResource.increment()
    }

    fun decrement() {
        espressoTestIdlingResource.decrement()
    }

    fun getEspressoIdlingResource(): IdlingResource? {
        return espressoTestIdlingResource
    }
}