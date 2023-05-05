package com.arkam.muvisku.model

import com.arkam.muvisku.R
import com.arkam.muvisku.screens.destinations.AccountScreenDestination
import com.arkam.muvisku.screens.destinations.Destination
import com.arkam.muvisku.screens.destinations.FavoritesScreenDestination
import com.arkam.muvisku.screens.destinations.HomeScreenDestination


sealed class BottomNavItem(var title: String, var icon: Int, var destination: Destination){

    object Home: BottomNavItem(
        title = "Home",
        icon = R.drawable.ic_home,
        destination = HomeScreenDestination
    )
    object Favorites: BottomNavItem(
        title = "Favorites",
        icon = R.drawable.ic_star,
        destination = FavoritesScreenDestination
    )
    object Account: BottomNavItem(
        title = "Account",
        icon = R.drawable.ic_profile,
        destination = AccountScreenDestination
    )

}