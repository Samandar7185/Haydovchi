package uz.haydovchi.ai.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.haydovchi.ai.presentation.screens.dashboard.DashboardScreen

object Routes {
    const val DASHBOARD = "dashboard"
    const val TRIPS = "trips"
    const val EXPENSES = "expenses"
    const val AI_CHAT = "ai_chat"
    const val PROFILE = "profile"
}

@Composable
fun HaydovchiAINavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.DASHBOARD
    ) {
        composable(Routes.DASHBOARD) {
            DashboardScreen(navController = navController)
        }
        
        // TODO: Add other screens
        composable(Routes.TRIPS) { /* TripsScreen() */ }
        composable(Routes.EXPENSES) { /* ExpensesScreen() */ }
        composable(Routes.AI_CHAT) { /* AIChatScreen() */ }
        composable(Routes.PROFILE) { /* ProfileScreen() */ }
    }
}