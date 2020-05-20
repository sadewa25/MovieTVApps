package com.sadewawicak.movietvapps.ui.detail.tv

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sadewawicak.movietvapps.R
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity
import com.sadewawicak.movietvapps.data.source.remote.RetrofitClient
import com.sadewawicak.movietvapps.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_detail_tv.*
import kotlinx.android.synthetic.main.content_detail_tv.*

class DetailTVActivity : AppCompatActivity(), View.OnClickListener {

    private var viewModel: DetailTVViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_tv)

        viewModel = obtainViewModel(this)
        viewModel?.setIDTv(intent.getStringExtra("id"))

        viewModel?.tvEntity?.observe(this, Observer {
            bindTVs(it?.data)
            setBookmarkState(it?.data?.isBookmarked)
            loading.visibility = View.GONE
        })

        fab.setOnClickListener(this)

    }

    private fun bindTVs(model: TvEntity?) {
        text_title.text = model?.titleTvs
        text_date.text = "${model?.rating} - ${model?.date}"
        text_description.text = model?.overview

        Glide.with(applicationContext)
            .load("${RetrofitClient().urlImages}${model?.posterPath}")
            .apply(RequestOptions.placeholderOf(R.mipmap.ic_launcher).error(R.drawable.ic_error))
            .into(image_poster)

    }

    private fun obtainViewModel(activity: AppCompatActivity?): DetailTVViewModel? {
        val factory: ViewModelFactory? = ViewModelFactory().getInstance(activity?.application)
        if (activity != null) {
            return ViewModelProviders.of(activity, factory).get(DetailTVViewModel::class.java)
        }
        return null
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.fab -> {
                viewModel?.setTvBookmark()
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
                fab.setImageDrawable(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_bookmarked_white
                    )
                )
            }
        }
    }
}
