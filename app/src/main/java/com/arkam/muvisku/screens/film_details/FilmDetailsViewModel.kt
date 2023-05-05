package com.arkam.muvisku.screens.film_details

import androidx.lifecycle.ViewModel
import com.arkam.muvisku.data.remote.responses.CreditsResponse
import com.arkam.muvisku.data.remote.responses.MovieDetails
import com.arkam.muvisku.data.remote.responses.TvSeriesDetails
import com.arkam.muvisku.data.repository.FilmsDetailsRepository
import com.arkam.muvisku.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FilmDetailsViewModel @Inject constructor(
    private val repository: FilmsDetailsRepository
) : ViewModel() {

    suspend fun getMovieDetails(movieId: Int): Resource<MovieDetails> {
        return repository.getMoviesDetails(movieId)
    }

    suspend fun getTvSeriesDetails(tvId: Int): Resource<TvSeriesDetails> {
        return repository.getTvSeriesDetails(tvId)
    }

    suspend fun getMovieCasts(movieId: Int): Resource<CreditsResponse> {
        val cast = repository.getMovieCasts(movieId)
        Timber.d(cast.data.toString())
        return cast
    }

    suspend fun getTvSeriesCasts(tvId: Int): Resource<CreditsResponse> {
        return repository.getTvSeriesCasts(tvId)
    }
}