package com.sadewawicak.movietvapps.ui.bookmark.tv


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
import kotlinx.android.synthetic.main.fragment_bookmark_tv.*

/**
 * A simple [Fragment] subclass.
 */
class BookmarkTvFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bookmark_tv, container, false)
    }

    private var model: BookmarkTvViewModel? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model = obtainViewModel(activity)
        val adapter = BookmarkTvAdapter(context) {
            val i = Intent(context, DetailTVActivity::class.java)
            i.putExtra("id", it?.id?.toString())
            activity?.startActivity(i)
        }

        model?.getBookmarkTv()?.observe(this, Observer {
            if (it?.data != null) {
                adapter.submitList(it.data)
                adapter.notifyDataSetChanged()
                loading.visibility = View.GONE
            }
        })

        rv__bookmark_tvs.layoutManager = LinearLayoutManager(context)
        rv__bookmark_tvs.setHasFixedSize(true)
        rv__bookmark_tvs.adapter = adapter
    }

    private fun obtainViewModel(activity: FragmentActivity?): BookmarkTvViewModel? {
        val factory: ViewModelFactory? = ViewModelFactory().getInstance(activity?.application)
        if (activity != null) {
            return ViewModelProviders.of(activity, factory).get(BookmarkTvViewModel::class.java)
        }
        return null
    }


}
