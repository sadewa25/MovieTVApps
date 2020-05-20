package com.sadewawicak.movietvapps.ui.movie


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
import kotlinx.android.synthetic.main.fragment_movie.*

/**
 * A simple [Fragment] subclass.
 */
class MovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    private var model: MovieViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = obtainViewModel(activity)

        val adapter = MovieAdapter(context) {
            val i = Intent(context, DetailMovieActivity::class.java)
            i.putExtra("id", it?.id?.toString())
            activity?.startActivity(i)
        }

        //Observer
        model?.getMovies()?.observe(this, Observer {
            if (it?.data != null){
                adapter.setListMovies(it.data)
                adapter.notifyDataSetChanged()
                loading.visibility = View.GONE
            }
        })
        //End


        rv_movies.layoutManager = LinearLayoutManager(context)
        rv_movies.setHasFixedSize(true)
        rv_movies.adapter = adapter

    }

    private fun obtainViewModel(activity: FragmentActivity?): MovieViewModel? {
        val factory: ViewModelFactory? = ViewModelFactory().getInstance(activity?.application)
        if (activity != null) {
            return ViewModelProviders.of(activity, factory).get(MovieViewModel::class.java)
        }
        return null
    }

}
