package com.arkam.muvisku.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.arkam.muvisku.data.paging.*
import com.arkam.muvisku.data.remote.TMDBApi
import com.arkam.muvisku.model.Series
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvSeriesRepository @Inject constructor(private val api: TMDBApi) {
    fun getTrendingThisWeekTvSeries(): Flow<PagingData<Series>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 27),
            pagingSourceFactory = {
                TrendingSeriesSource(api)
            }
        ).flow
    }

    fun getOnTheAirTvSeries(): Flow<PagingData<Series>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 27),
            pagingSourceFactory = {
                OnTheAirSeriesSource(api)
            }
        ).flow
    }

    fun getTopRatedTvSeries(): Flow<PagingData<Series>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 27),
            pagingSourceFactory = {
                TopRatedSeriesSource(api)
            }
        ).flow
    }

    fun getAiringTodayTvSeries(): Flow<PagingData<Series>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 27),
            pagingSourceFactory = {
                AiringTodayTvSeriesSource(api)
            }
        ).flow
    }

    fun getPopularTvSeries(): Flow<PagingData<Series>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 27),
            pagingSourceFactory = {
                PopularSeriesSource(api)
            }
        ).flow
    }
}