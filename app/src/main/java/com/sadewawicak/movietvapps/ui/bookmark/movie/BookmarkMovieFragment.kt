package com.sadewawicak.movietvapps.ui.bookmark.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sadewawicak.movietvapps.R
import com.sadewawicak.movietvapps.ui.detail.movie.DetailMovieActivity
import com.sadewawicak.movietvapps.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_bookmark_movie.*
import kotlinx.android.synthetic.main.fragment_movie.loading

class BookmarkMovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bookmark_movie, container, false)
    }

    private var model: BookmarkMovieViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = obtainViewModel(activity)

        val adapter = BookmarkMovieAdapter(context) {
            val i = Intent(context, DetailMovieActivity::class.java)
            i.putExtra("id", it?.id?.toString())
            activity?.startActivity(i)
        }

        model?.getBookmarkMovie()?.observe(this, Observer {
            if (it?.data != null) {
                adapter.submitList(it.data)
                adapter.notifyDataSetChanged()
                loading.visibility = View.GONE
            }
        })

        rv__bookmark_movies.layoutManager = LinearLayoutManager(context)
        rv__bookmark_movies.setHasFixedSize(true)
        rv__bookmark_movies.adapter = adapter

    }

    private fun obtainViewModel(activity: FragmentActivity?): BookmarkMovieViewModel? {
        val factory: ViewModelFactory? = ViewModelFactory().getInstance(activity?.application)
        if (activity != null) {
            return ViewModelProviders.of(activity, factory).get(BookmarkMovieViewModel::class.java)
        }
        return null
    }
}