package com.sadewawicak.movietvapps.ui.bookmark


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.sadewawicak.movietvapps.R
import com.sadewawicak.movietvapps.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_bookmark.*

/**
 * A simple [Fragment] subclass.
 */
class BookmarkFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bookmark, container, false)
    }

    private var viewModel: BookmarkViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = obtainViewModel(activity)
        viewModel?.setupViewPager(context!!, viewpager_main, fragmentManager)
        tabs_main.setupWithViewPager(viewpager_main)
    }

    private fun obtainViewModel(activity: FragmentActivity?): BookmarkViewModel? {
        val factory: ViewModelFactory? = ViewModelFactory().getInstance(activity?.application)
        if (activity != null) {
            return ViewModelProviders.of(activity, factory).get(BookmarkViewModel::class.java)
        }
        return null
    }


}
