package com.sadewawicak.movietvapps.ui.detail.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.sadewawicak.movietvapps.data.source.AppRepository
import com.sadewawicak.movietvapps.data.source.local.entity.TvEntity
import com.sadewawicak.movietvapps.utils.FakeDataDummys
import com.sadewawicak.movietvapps.vo.Resources
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

class DetailTVViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viewModel: DetailTVViewModel? = null
    private val academyRepository = mock(AppRepository::class.java)
    private var dummyCourse: TvEntity? = FakeDataDummys().generateDummyTvs()[0]
    private val courseId = dummyCourse?.id


    @Before
    fun setUp() {
        viewModel = DetailTVViewModel(academyRepository)
        dummyCourse = TvEntity(
            id = 82856,
            titleTvs = "The Mandalorian",
            overview = "Set after the fall of the Empire and before the emergence of the First Order, we follow the travails of a lone gunfighter in the outer reaches of the galaxy far from the authority of the New Republic.",
            date = "2019-11-12",
            rating = "7.9",
            posterPath = "/BbNvKCuEF4SRzFXR16aK6ISFtR.jpg"
        )
    }

    @Test
    fun getTv() {
        val datas = Resources.success(dummyCourse)
        val courseEntities = MutableLiveData<Resources<TvEntity>>()
        courseEntities.value = datas

        `when`(academyRepository.getTvById(courseId.toString())).thenReturn(courseEntities)
        viewModel?.setIDTv(dummyCourse?.id.toString())

        val observer: Observer<Resources<TvEntity>> = mock(Observer::class.java) as Observer<Resources<TvEntity>>
        viewModel?.tvEntity?.observeForever(observer)

        verify(observer).onChanged(datas)
    }

}