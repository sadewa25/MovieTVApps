package com.sadewawicak.movietvapps.ui.bookmark.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.sadewawicak.movietvapps.data.source.AppRepository
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity
import com.sadewawicak.movietvapps.vo.Resources
import org.junit.Test

import org.junit.Before
import org.junit.Rule
import org.mockito.Mockito
import org.mockito.Mockito.mock

class BookmarkTvViewModelTest {

    @Rule @JvmField
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: BookmarkTvViewModel
    private val appRepository = mock(AppRepository::class.java)

    @Before
    fun setUp() {
        viewModel = BookmarkTvViewModel(appRepository)
    }

    @Test
    fun getBookmarkTv() {
        val dummyCourses = MutableLiveData<Resources<PagedList<TvEntity>>>()
        val listData = mock(PagedList::class.java) as PagedList<TvEntity>
        dummyCourses.value = Resources.success(listData)
        Mockito.`when`(appRepository.getBookmarkTv()).thenReturn(dummyCourses)
        val observer = mock(Observer::class.java) as Observer<Resources<PagedList<TvEntity>>>
        viewModel.getBookmarkTv()?.observeForever(observer)
        Mockito.verify(observer).onChanged(Resources.success(listData))
    }

}