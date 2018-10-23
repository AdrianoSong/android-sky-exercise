package test.song.sky.com.br.skymobileexerciseandroid.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*
import test.song.sky.com.br.skymobileexerciseandroid.R
import test.song.sky.com.br.skymobileexerciseandroid.model.Movie

class MovieAdapter(val myDataSet: MutableList<Movie>, val context: Context) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myDataSet.size
    }

    @Suppress("DEPRECATION")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val imageUrl = myDataSet.get(position).cover_url

        holder.txtMovieName.text = myDataSet.get(position).title
        Glide.with(context).load(imageUrl).into(holder.imgMovieCover)
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val txtMovieName = itemView.textViewMovieName
        val imgMovieCover = itemView.imageViewMovieCover
    }
}