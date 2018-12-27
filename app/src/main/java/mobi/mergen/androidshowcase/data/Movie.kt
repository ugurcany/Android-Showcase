package mobi.mergen.androidshowcase.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(@SerializedName("imdbID") var imdbId: String,
                 @SerializedName("Title") var title: String,
                 @SerializedName("Year") var year: String,
                 @SerializedName("Poster") var posterUrl: String) : Serializable {

    constructor() : this("", "", "", "")

}
