package com.sadewawicak.movietvapps.ui.bookmark.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.sadewawicak.movietvapps.data.source.AppRepository
import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity
import com.sadewawicak.movietvapps.ui.bookmark.tv.BookmarkTvViewModel
import com.sadewawicak.movietvapps.vo.Resources
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito

class BookmarkMovieViewModelTest {

    @Rule
    @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: BookmarkMovieViewModel
    private val appRepository = Mockito.mock(AppRepository::class.java)

    @Before
    fun setUp() {
        viewModel = BookmarkMovieViewModel(appRepository)
    }

    @Test
    fun getBookmarkMovie() {
        val dummyCourses = MutableLiveData<Resources<PagedList<MovieEntity>>>()
        val listData = Mockito.mock(PagedList::class.java) as PagedList<MovieEntity>
        dummyCourses.value = Resources.success(listData)
        Mockito.`when`(appRepository.getBookmarkMovie()).thenReturn(dummyCourses)
        val observer = Mockito.mock(Observer::class.java) as Observer<Resources<PagedList<MovieEntity>>>
        viewModel.getBookmarkMovie()?.observeForever(observer)
        Mockito.verify(observer).onChanged(Resources.success(listData))
    }
}