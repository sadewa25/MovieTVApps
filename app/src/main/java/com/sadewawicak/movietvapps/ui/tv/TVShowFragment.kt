package com.sadewawicak.movietvapps.ui.tv


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
import com.sadewawicak.movietvapps.ui.detail.tv.DetailTVActivity
import com.sadewawicak.movietvapps.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_tvshow.*

/**
 * A simple [Fragment] subclass.
 */
class TVShowFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tvshow, container, false)
    }

    private var viewModel: TVViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = obtainViewModel(activity)

        val adapter = TVAdapter(context) {
            val i = Intent(context, DetailTVActivity::class.java)
            i.putExtra("id", it?.id.toString())
            activity?.startActivity(i)
        }

        viewModel?.getTVShows()?.observe(this, Observer {
            if (it.data != null){
                adapter.setListTv(it.data)
                adapter.notifyDataSetChanged()
                loading.visibility = View.GONE
            }
        })

        rv_tvs.layoutManager = LinearLayoutManager(context)
        rv_tvs.setHasFixedSize(true)
        rv_tvs.adapter = adapter

    }

    private fun obtainViewModel(activity: FragmentActivity?): TVViewModel? {
        val factory: ViewModelFactory? = ViewModelFactory().getInstance(activity?.application)
        if (activity != null) {
            return ViewModelProviders.of(activity, factory).get(TVViewModel::class.java)
        }
        return null
    }


}
