package com.arkam.muvisku.screens.favorites

import androidx.compose.runtime.State
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arkam.muvisku.data.local.Favorite
import com.arkam.muvisku.data.repository.FavoritesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val repository: FavoritesRepository) :
    ViewModel() {

    val favorites = repository.getFavorites()

    fun insertFavorite(favorite: Favorite) {
        viewModelScope.launch {
            repository.insertFavorite(favorite)
        }
    }

    fun isAFavorite(mediaId: Int): LiveData<Boolean>{
        return repository.isFavorite(mediaId)
    }

    fun deleteOneFavorite(favorite: Favorite) {
        viewModelScope.launch {
            repository.deleteOneFavorite(favorite)
        }
    }

    fun deleteAllFavorites() {
        viewModelScope.launch {
            repository.deleteAllFavorites()
        }
    }
}