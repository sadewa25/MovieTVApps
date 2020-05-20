package com.sadewawicak.movietvapps.ui.bookmark.movie

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sadewawicak.movietvapps.R
import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity
import com.sadewawicak.movietvapps.data.source.remote.RetrofitClient

class BookmarkMovieAdapter(
    val activity: Context?,
    val listener: (MovieEntity?) -> Unit
) : PagedListAdapter<MovieEntity,BookmarkMovieAdapter.AcademyViewHolder>(DIFF_CALLBACK) {

    companion object{
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcademyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_movie, parent, false)
        return AcademyViewHolder(view)
    }

    override fun onBindViewHolder(holder: AcademyViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bindData(activity, movie, listener)
    }


    class AcademyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tv_item_title)
        val imgPoster = itemView.findViewById<ImageView>(R.id.img_poster)
        val tvGenre = itemView.findViewById<TextView>(R.id.tv_item_genre)
        val tvDate = itemView.findViewById<TextView>(R.id.tv_item_date)

        fun bindData(
            activity: Context?,
            data: MovieEntity?,
            listener: (MovieEntity?) -> Unit
        ) {
            tvTitle.text = data?.titleMovie
            tvGenre.text = data?.rating.toString()
            tvDate.text =
                String.format("${activity?.resources?.getString(R.string.in_cinema)} ${data?.date}")
            if (activity != null) {
                Glide.with(activity)
                    .load("${RetrofitClient().urlImages}${data?.posterPath}")
                    .apply(RequestOptions.placeholderOf(R.mipmap.ic_launcher).error(R.drawable.ic_error))
                    .into(imgPoster)
            }
            itemView.setOnClickListener {
                listener(data)
            }
        }

    }

}