package com.arkam.muvisku.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.arkam.muvisku.screens.commons.StandardScaffold
import com.arkam.muvisku.screens.NavGraphs
import com.arkam.muvisku.screens.destinations.AccountScreenDestination
import com.arkam.muvisku.screens.destinations.FavoritesScreenDestination
import com.arkam.muvisku.screens.destinations.HomeScreenDestination
import com.arkam.muvisku.ui.theme.MuvizTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.rememberNavHostEngine
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MuvizTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberAnimatedNavController()

                    val navHostEngine = rememberNavHostEngine()
                        /*rememberAnimatedNavHostEngine()(
                        rootDefaultAnimations = RootNavGraphDefaultAnimations.ACCOMPANIST_FADING,
                        defaultAnimationsForNestedNavGraph = mapOf(
                            NavGraphs.root to NestedNavGraphDefaultAnimations(
                                enterTransition = { fadeIn(animationSpec = tween(1000)) },
                                exitTransition = { fadeOut(animationSpec = tween(1000)) }
                            )
                        )
                    )*/

                    val newBackStackEntry by navController.currentBackStackEntryAsState()
                    val route = newBackStackEntry?.destination?.route

                    StandardScaffold(
                        navController = navController,
                        showBottomBar = route in listOf(
                            HomeScreenDestination.route,
                            FavoritesScreenDestination.route,
                            AccountScreenDestination.route
                        )
                    ) { innerPadding ->
                        Box(modifier = Modifier.padding(innerPadding)) {
                            DestinationsNavHost(
                                navGraph = NavGraphs.root,
                                navController = navController,
                                engine = navHostEngine
                            )
                        }
                    }
                }
            }
        }
    }
}