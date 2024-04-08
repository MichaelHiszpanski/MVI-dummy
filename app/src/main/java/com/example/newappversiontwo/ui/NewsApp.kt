
import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newappversiontwo.MockData
import com.example.newappversiontwo.ui.screens.BottomMenuScreen
import com.example.newappversiontwo.ui.screens.CategoriesScreen
import com.example.newappversiontwo.ui.screens.SourcesScreen


@Composable
fun NewsApp() {
    val navController = rememberNavController()
    val scrollState: ScrollState = rememberScrollState()
    MainScreen(navController =navController , scrollState )


}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(navController: NavController, scrollState: ScrollState){
    Scaffold(bottomBar = {}) {
        Navigation()

    }
}

@Composable
fun Navigation(){
    val navController = rememberNavController()
    val scrollState = rememberScrollState()
    NavHost(navController = navController, startDestination = "top") {
        composable("top") { TopNews(navController) }
        composable("detail/{newsId}",
            arguments = listOf(navArgument("newsId"){type= NavType.IntType})
        ) { navBackStackEntry ->
            val id =navBackStackEntry.arguments?.getInt("newsId")
            val newsData=MockData.getNews(id)
            DetailScreen(newsData, scrollState,navController) }
       // composable("item-news") { TopNewsItem(newsData = MockData.topNewsList[0]) }
    }
}
fun NavGraphBuilder.bottomNavigation(navController: NavController) {
    composable(BottomMenuScreen.TopNews.route) {
        TopNews(navController = navController)
    }
    composable(BottomMenuScreen.Categories.route) {
        CategoriesScreen()
    }
    composable(BottomMenuScreen.Sources.route) {
        SourcesScreen()
    }
}
