package test.song.sky.com.br.skymobileexerciseandroid

import org.junit.Test
import org.junit.Assert.*
import test.song.sky.com.br.skymobileexerciseandroid.presenter.MainActivityPresenter

/**
 * Exemplo de teste nullable e empty apenas com o metodo parser do objeto MainActivityPresenet
 */
class MainPresenterTest{

    private val mainPresenter = MainActivityPresenter()

    @Test
    fun parseRequestWithNullObect(){

        assertNotNull(mainPresenter.parseMovies(null))
    }

    @Test
    fun parseRequestWithEmptyStringOject(){

        assertEquals(mainPresenter.parseMovies(""), Unit)
    }
}