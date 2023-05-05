package com.arkam.muvisku.data.remote.responses

import com.google.gson.annotations.SerializedName
import com.arkam.muvisku.model.Genre

data class GenresResponse(
    @SerializedName("genres")
    val genres: List<Genre>
)