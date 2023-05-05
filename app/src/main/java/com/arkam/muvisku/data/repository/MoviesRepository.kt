package com.arkam.muvisku.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.arkam.muvisku.data.paging.*
import com.arkam.muvisku.data.remote.TMDBApi
import com.arkam.muvisku.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesRepository @Inject constructor(private val api: TMDBApi) {

    fun getTrendingMoviesThisWeek(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 27),
            pagingSourceFactory = {
                TrendingMoviesSource(api)
            }
        ).flow
    }

    fun getUpcomingMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 27),
            pagingSourceFactory = {
                UpcomingMoviesSource(api)
            }
        ).flow
    }

    fun getTopRatedMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 27),
            pagingSourceFactory = {
                TopRatedMoviesSource(api)
            }
        ).flow
    }

    fun getNowPlayingMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 27),
            pagingSourceFactory = {
                NowPlayingMoviesSource(api)
            }
        ).flow
    }

    fun getPopularMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = 27),
            pagingSourceFactory = {
                PopularMoviesSource(api)
            }
        ).flow
    }
}