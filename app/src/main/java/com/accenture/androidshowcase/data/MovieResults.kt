package com.accenture.androidshowcase.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieResults(@SerializedName("Search") var movies: List<Movie>?,
                        @SerializedName("Error") var errorMsg: String?,
                        @SerializedName("Response") var response: String) : Serializable {

    constructor() : this(null, null, "")

    fun isSuccessful(): Boolean = response.equals("True", true)

}
