package test.song.sky.com.br.skymobileexerciseandroid.presenter

import android.content.Context
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import test.song.sky.com.br.skymobileexerciseandroid.model.Movie
import android.net.ConnectivityManager

class MainActivityPresenter {

    val movieList = mutableListOf<Movie>()

    fun checkActiveNetwork(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting

        return isConnected
    }

    fun getMoviesV2(){
        val client = OkHttpClient()
        val request = Request.Builder().url("https://sky-exercise.herokuapp.com/api/Movies").build()

        val response = client.newCall(request).execute()

        parseMovies(response.body()?.string())
    }

    fun parseMovies(jsonString: String?){

        if (jsonString.isNullOrEmpty()){

            val emptyItem = Movie("Ops... Houve algum erro tentar novamente", "", "", "", "", "")
            movieList.add(emptyItem)

        } else {
            val myJsonArray = JSONArray(jsonString)

            for (i in 0..(myJsonArray.length() - 1)) {
                val item = Gson().fromJson(myJsonArray.get(i).toString(), Movie::class.java)
                movieList.add(item)
            }
        }
    }
}