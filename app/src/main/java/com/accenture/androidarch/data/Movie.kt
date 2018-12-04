package com.accenture.androidarch.data

import com.accenture.androidarch.common.NEW_LINE
import com.accenture.androidarch.common.SPACE
import com.accenture.androidarch.common.toUppercase

data class Movie(var id: Int?,
                 var emoji: String?,
                 var title: String?,
                 var imdbId: String?) {

    val displayId: String
        get() = "#$id"

    val titleWithoutSpaces: String
        get() = title?.replace(SPACE, "")
                ?.replace(NEW_LINE, "")
                ?.toUppercase() ?: ""
}
