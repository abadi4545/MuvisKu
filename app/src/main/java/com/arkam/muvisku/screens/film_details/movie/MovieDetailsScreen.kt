package com.arkam.muvisku.screens.film_details.movie

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import com.ramcosta.composedestinations.annotation.Destination
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.arkam.muvisku.data.remote.responses.CreditsResponse
import com.arkam.muvisku.data.remote.responses.MovieDetails
import com.arkam.muvisku.screens.favorites.FavoritesViewModel
import com.arkam.muvisku.screens.film_details.FilmDetailsViewModel
import com.arkam.muvisku.screens.film_details.common.FilmImageBanner
import com.arkam.muvisku.screens.film_details.common.FilmInfo
import com.arkam.muvisku.util.Constants
import com.arkam.muvisku.util.Resource
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalAnimationApi::class, androidx.compose.ui.ExperimentalComposeUiApi::class)
@Destination
@Composable
fun MovieDetailsScreen(
    filmId: Int,
    navigator: DestinationsNavigator,
    viewModel: FilmDetailsViewModel = hiltViewModel(),
    favoritesViewModel: FavoritesViewModel = hiltViewModel(),
) {
    val scrollState = rememberLazyListState()

    val details = produceState<Resource<MovieDetails>>(initialValue = Resource.Loading()) {
        value = viewModel.getMovieDetails(filmId)
    }.value

    val casts = produceState<Resource<CreditsResponse>>(initialValue = Resource.Loading()) {
        value = viewModel.getMovieCasts(filmId)
    }.value

    // Include Film Genres

    Box {
        if (details is Resource.Success) {
            FilmInfo(
                scrollState = scrollState,
                overview = details.data?.overview.toString(),
                releaseDate = details.data?.releaseDate.toString(),
                navigator = navigator,
                casts = casts
            )
            FilmImageBanner(
                scrollState = scrollState,
                posterUrl = "${Constants.IMAGE_BASE_UR}/${details.data?.posterPath}",
                filmName = details.data?.title.toString(),
                filmId = details.data?.id!!,
                filmType = "movie",
                releaseDate = details.data.releaseDate.toString(),
                rating = details.data.voteAverage?.toFloat()!!,
                navigator = navigator,
                viewModel = favoritesViewModel
            )
        } else {
            CircularProgressIndicator()
        }
    }
}