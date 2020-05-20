package com.sadewawicak.movietvapps.ui.tv

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sadewawicak.movietvapps.R
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity
import com.sadewawicak.movietvapps.data.source.remote.RetrofitClient
import com.sadewawicak.movietvapps.data.source.remote.response.ResultsItemMovieResponse

class TVAdapter (
    val activity: Context?,
    val listener: (TvEntity?) -> Unit): RecyclerView.Adapter<TVAdapter.TVViewHolder>() {

    var mMovies:ArrayList<TvEntity?> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_tv, parent, false)
        return TVViewHolder(view)
    }

    private fun getListMovies(): List<TvEntity?> {
        return mMovies
    }

    fun setListTv(mMovies: List<TvEntity>?) {
        if (mMovies == null) return
        this.mMovies.clear()
        this.mMovies.addAll(mMovies)
    }

    override fun onBindViewHolder(holder: TVViewHolder, position: Int) {
        holder.bindData(activity, getListMovies()[position],listener)
    }

    override fun getItemCount(): Int {
        return getListMovies().size
    }


    class TVViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.findViewById<TextView>(R.id.tv_item_title)
        val imgPoster = itemView.findViewById<ImageView>(R.id.img_poster)
        val tvGenre = itemView.findViewById<TextView>(R.id.tv_item_genre)
        val tvDate = itemView.findViewById<TextView>(R.id.tv_item_date)

        fun bindData(activity: Context?,data:TvEntity?,listener: (TvEntity?) -> Unit){
            tvTitle.text = data?.titleTvs
            tvGenre.text = data?.rating?.toString()
            tvDate.text = String.format("${activity?.resources?.getString(R.string.title_release_date)} ${data?.date}")
            if (activity != null) {
                Glide.with(activity)
                    .load("${RetrofitClient().urlImages}${data?.posterPath}")
                    .apply(RequestOptions.placeholderOf(R.mipmap.ic_launcher).error(R.drawable.ic_error))
                    .into(imgPoster)
            }
            itemView.setOnClickListener{
                listener(data)
            }
        }

    }
}