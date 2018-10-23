package test.song.sky.com.br.skymobileexerciseandroid

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import test.song.sky.com.br.skymobileexerciseandroid.adapter.MovieAdapter
import test.song.sky.com.br.skymobileexerciseandroid.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity() {

    private val mainPresenter = MainActivityPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (mainPresenter.checkActiveNetwork(this)){

            Thread( Runnable {

                mainPresenter.getMoviesV2()

                runOnUiThread {
                    hideLoading()
                    setupRecyclerView()
                }

            }).start()

        } else {
            networkUnavailable()
            hideLoading()
        }
    }

    private fun setupRecyclerView(){

        recyclerviewMovies.setHasFixedSize(true)
        recyclerviewMovies.layoutManager = GridLayoutManager(this,  2)
        recyclerviewMovies.adapter = MovieAdapter(mainPresenter.movieList, this)
    }

    private fun hideLoading(){
        progressBarLoading.visibility = View.INVISIBLE
        recyclerviewMovies.visibility = View.VISIBLE
    }

    @SuppressLint("SetTextI18n")
    private fun networkUnavailable(){
        textViewMovieSection.text = "Não foi possivel ter acesso a internet"
    }
}
