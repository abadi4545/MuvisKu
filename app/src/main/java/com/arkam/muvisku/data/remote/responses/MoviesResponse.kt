package com.arkam.muvisku.data.remote.responses

import com.google.gson.annotations.SerializedName
import com.arkam.muvisku.model.Movie

data class MoviesResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val searches: List<Movie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)