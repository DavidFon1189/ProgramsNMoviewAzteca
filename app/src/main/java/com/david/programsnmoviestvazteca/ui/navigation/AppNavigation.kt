package com.david.programsnmoviestvazteca.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.david.programsnmoviestvazteca.domain.model.CategoryContent
import com.david.programsnmoviestvazteca.domain.model.MediaContent
import com.david.programsnmoviestvazteca.ui.detail.MediaDetailRoute
import com.david.programsnmoviestvazteca.ui.detail.MediaDetailScreen
import com.david.programsnmoviestvazteca.ui.home.HomeRoute
import com.david.programsnmoviestvazteca.ui.home.HomeScreen

@Composable
fun AppNavigation(featuredItems: List<CategoryContent>) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.MEDIA
    ) {

        composable(Routes.MEDIA) {

            HomeRoute(
                featuredItems = featuredItems,
                onMediaClick = { media ->

                    navController.navigate(
                        Routes.mediaDetails(media.id)
                    )
                }
            )
        }

        composable(
            route = Routes.MEDIA_DETAILS_ROUTE,
            arguments = listOf(
                navArgument(Routes.MEDIA_ID) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val mediaId = backStackEntry.arguments
                ?.getInt(Routes.MEDIA_ID)

            if (mediaId != null && mediaId > 0) {

                MediaDetailRoute(
                    mediaId = mediaId,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )

            } else {
                Text("Contenido no encontrado")
            }
        }
    }
}