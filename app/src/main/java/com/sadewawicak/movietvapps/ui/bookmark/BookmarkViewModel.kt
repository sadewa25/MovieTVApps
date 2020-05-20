package com.sadewawicak.movietvapps.ui.bookmark

import android.content.Context
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import androidx.viewpager.widget.ViewPager
import com.sadewawicak.movietvapps.R
import com.sadewawicak.movietvapps.ui.bookmark.movie.BookmarkMovieFragment
import com.sadewawicak.movietvapps.ui.bookmark.tv.BookmarkTvFragment

class BookmarkViewModel : ViewModel() {

    fun setupViewPager(context: Context, viewPager: ViewPager, manager: FragmentManager?) {
        val adapter =
            BookmarkViewPager(manager!!)
        adapter.addFragment(
            BookmarkMovieFragment(), context.getString(
                R.string.title_movie
            )
        )
        adapter.addFragment(
            BookmarkTvFragment(), context.getString(
                R.string.title_tvshow
            )
        )
        viewPager.adapter = adapter
    }

}