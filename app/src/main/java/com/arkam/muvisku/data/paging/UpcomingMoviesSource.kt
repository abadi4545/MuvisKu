package com.arkam.muvisku.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.arkam.muvisku.data.remote.TMDBApi
import com.arkam.muvisku.model.Movie
import retrofit2.HttpException
import java.io.IOException

class UpcomingMoviesSource(private val api: TMDBApi) :
    PagingSource<Int, Movie>() {
    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
        return try {
            val nextPage = params.key ?: 1
            val upcomingComingMoviesList = api.getUpcomingMovies(nextPage)
            LoadResult.Page(
                data = upcomingComingMoviesList.searches,
                prevKey = if (nextPage == 1) null else nextPage - 1,
                nextKey = if (upcomingComingMoviesList.searches.isEmpty()) null else upcomingComingMoviesList.page + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}