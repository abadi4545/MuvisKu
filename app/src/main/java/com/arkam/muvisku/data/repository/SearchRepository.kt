package com.arkam.muvisku.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.arkam.muvisku.data.paging.SearchPagingSource
import com.arkam.muvisku.data.remote.TMDBApi
import com.arkam.muvisku.model.Search
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepository @Inject constructor(private val api: TMDBApi) {
    fun multiSearch(queryParam: String): Flow<PagingData<Search>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 27),
            pagingSourceFactory = {
                SearchPagingSource(api, queryParam)
            }
        ).flow
    }
}