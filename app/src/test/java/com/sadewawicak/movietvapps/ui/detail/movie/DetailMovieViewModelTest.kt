package com.sadewawicak.movietvapps.ui.detail.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.sadewawicak.movietvapps.data.source.AppRepository
import com.sadewawicak.movietvapps.data.source.local.LocalRepository
import com.sadewawicak.movietvapps.data.source.local.entity.MovieEntity
import com.sadewawicak.movietvapps.data.source.remote.RemoteRepository
import com.sadewawicak.movietvapps.utils.ContextProvider
import com.sadewawicak.movietvapps.utils.FakeDataDummys
import com.sadewawicak.movietvapps.vo.Resources
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class DetailMovieViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viewModel: DetailMovieViewModel? = null
    private val academyRepository = mock(AppRepository::class.java)

    private var dummyCourse: MovieEntity =
        FakeDataDummys().generateDummyMovies()[0]
    private val courseId = dummyCourse.id


    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(academyRepository)
        dummyCourse = MovieEntity(id = 384018,titleMovie = "Fast & Furious Presents: Hobbs & Shaw",overview = "A spinoff of The Fate of the Furious, focusing on Johnson's US Diplomatic Security Agent Luke Hobbs forming an unlikely alliance with Statham's Deckard Shaw.",date = "2019-08-01",rating = "6.6",posterPath = "/keym7MPn1icW1wWfzMnW3HeuzWU.jpg")
    }

    @Test
    fun getCourse() {
        val datas = Resources.success(dummyCourse)
        val courseEntities = MutableLiveData<Resources<MovieEntity>>()
        courseEntities.value = datas

        `when`(academyRepository.getMovieById(courseId.toString())).thenReturn(courseEntities)
        viewModel?.setIDMovies(courseId.toString())

        val observer: Observer<Resources<MovieEntity>> =
            mock(Observer::class.java) as Observer<Resources<MovieEntity>>
        viewModel?.movieEntity?.observeForever(observer)

        verify(observer).onChanged(datas)
    }

}