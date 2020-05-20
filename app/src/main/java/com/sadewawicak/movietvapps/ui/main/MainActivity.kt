package com.sadewawicak.movietvapps.ui.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sadewawicak.movietvapps.R
import com.sadewawicak.movietvapps.ui.bookmark.BookmarkFragment
import com.sadewawicak.movietvapps.ui.movie.MovieFragment
import com.sadewawicak.movietvapps.ui.tv.TVShowFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, MovieFragment())
            .commit()
        nav_view.setOnNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.navigation_movie -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, MovieFragment()).commit()
                return true
            }
            R.id.navigation_tv -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, TVShowFragment()).commit()
                return true
            }
            R.id.navigation_bookmark -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment, BookmarkFragment()).commit()
                return true
            }
        }
        return false
    }


}
