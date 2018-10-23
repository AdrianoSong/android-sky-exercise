package test.song.sky.com.br.skymobileexerciseandroid.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(

        @SerializedName("title")
        val title: String,

        @SerializedName("overview")
        val overview: String,

        @SerializedName("duration")
        val duration: String,

        @SerializedName("release_year")
        val release_year: String,

        @SerializedName("cover_url")
        val cover_url: String,

        @SerializedName("id")
        val id: String

): Serializable