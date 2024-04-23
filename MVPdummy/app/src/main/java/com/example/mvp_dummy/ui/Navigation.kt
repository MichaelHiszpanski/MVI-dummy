package com.example.mvp_dummy.ui

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.mvp_dummy.analiticsHelper.AnalyticsHelper
import com.example.mvp_dummy.ui.components.ConfirmationScreen
import com.example.mvp_dummy.ui.components.LoginAutoIDScreen


@Composable
fun Navigation( navController: NavHostController, scrollState: ScrollState,

               paddingValues: PaddingValues
) {
        NavHost(navController = navController, startDestination ="Login"
      , modifier = Modifier.padding(paddingValues =paddingValues )) {

            composable("Login") {
                LoginAutoIDScreen(

                    onLoginClicked = { _ -> println("Success") },
                    scrollState = scrollState,
                    navController = navController
                )
            }

            composable("Confirmation") {
                ConfirmationScreen(

                    scrollState = scrollState,
                    navController = navController
                )
            }

        }
}






/////
//fun NavGraphBuilder.bottomNavigation(navController: NavController, articles:List<TopNewsArticle>,
//                                     newsManager: NewsManager) {
//    composable(BottomMenuScreen.TopNews.route) {
//        TopNews(navController = navController,articles,newsManager.query, newsManager = newsManager)
//    }
//    composable(BottomMenuScreen.Categories.route) {
//        newsManager.getArticlesByCategory("business")
//        newsManager.onSelectedCategoryCHanged("business")
//
//        Categories(newsManager = newsManager, onFetchCategory = {
//            newsManager.onSelectedCategoryCHanged(it)
//            newsManager.getArticlesByCategory(it)
//        }, navController = navController, articles = articles)
//    }
//    composable(BottomMenuScreen.Sources.route) {
//        Sources(newsManager = newsManager)
//    }
//}