package com.arkam.muvisku.data.remote.responses


import com.google.gson.annotations.SerializedName
import com.arkam.muvisku.model.Search

data class MultiSearchResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val searches: List<Search>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)