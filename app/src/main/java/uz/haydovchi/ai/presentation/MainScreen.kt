package uz.haydovchi.ai.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.haydovchi.ai.presentation.components.BottomNavBar
import uz.haydovchi.ai.presentation.navigation.Routes
import uz.haydovchi.ai.presentation.screens.dashboard.DashboardScreen
import uz.haydovchi.ai.presentation.screens.expenses.ExpensesScreen
import uz.haydovchi.ai.presentation.screens.profile.ProfileScreen
import uz.haydovchi.ai.presentation.screens.trips.TripsScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.DASHBOARD,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.DASHBOARD) {
                DashboardScreen(navController = navController)
            }
            composable(Routes.TRIPS) {
                TripsScreen(navController = navController)
            }
            composable(Routes.EXPENSES) {
                ExpensesScreen(navController = navController)
            }
            composable(Routes.PROFILE) {
                ProfileScreen(navController = navController)
            }
        }
    }
}