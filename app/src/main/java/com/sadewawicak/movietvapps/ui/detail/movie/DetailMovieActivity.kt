package com.sadewawicak.movietvapps.ui.detail.movie

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sadewawicak.movietvapps.R
import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity
import com.sadewawicak.movietvapps.data.source.remote.RetrofitClient
import com.sadewawicak.movietvapps.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.content_detail_movie.*

class DetailMovieActivity : AppCompatActivity(), View.OnClickListener {

    private var detailMovieViewModel: DetailMovieViewModel? = null
    private var entities: MovieEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        detailMovieViewModel = obtainViewModel(this)
        detailMovieViewModel?.setIDMovies(intent?.getStringExtra("id"))

        detailMovieViewModel?.movieEntity?.observe(this, Observer {
            bindMovies(it.data)
            setBookmarkState(it.data?.isBookmarked)
            entities = it.data
            loading.visibility = View.GONE
        })

        fab.setOnClickListener(this)

    }

    private fun bindMovies(movieEntity: MovieEntity?) {
        text_title.text = movieEntity?.titleMovie
        text_date.text = "${movieEntity?.rating} - ${movieEntity?.date}"
        text_description.text = movieEntity?.overview

        Glide.with(applicationContext)
            .load("${RetrofitClient().urlImages}${movieEntity?.posterPath}")
            .apply(RequestOptions.placeholderOf(R.mipmap.ic_launcher).error(R.drawable.ic_error))
            .into(image_poster)

    }

    private fun obtainViewModel(activity: AppCompatActivity?): DetailMovieViewModel? {
        val factory: ViewModelFactory? = ViewModelFactory().getInstance(activity?.application)
        if (activity != null) {
            return ViewModelProviders.of(activity, factory).get(DetailMovieViewModel::class.java)
        }
        return null
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.fab -> {
                detailMovieViewModel?.setMovieBookmark()
            }
        }
    }

    private fun setBookmarkState(state: Boolean?) {
        if (state != null) {
            if (state) {
                fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_bookmark_white
                    )
                )
            } else {
                fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_bookmarked_white))
            }
        }
    }

}
