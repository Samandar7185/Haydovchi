package uz.haydovchi.ai.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import uz.haydovchi.ai.presentation.navigation.Routes

data class BottomNavItem(
    val route: String,
    val label: String,
    val icon: @Composable () -> Unit
)

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(
        BottomNavItem(
            route = Routes.DASHBOARD,
            label = "Bosh sahifa",
            icon = { Icon(Icons.Default.Home, contentDescription = null) }
        ),
        BottomNavItem(
            route = Routes.TRIPS,
            label = "Reyslar",
            icon = { Icon(Icons.Default.List, contentDescription = null) }
        ),
        BottomNavItem(
            route = Routes.EXPENSES,
            label = "Xarajatlar",
            icon = { Icon(Icons.Default.AttachMoney, contentDescription = null) }
        ),
        BottomNavItem(
            route = Routes.PROFILE,
            label = "Profil",
            icon = { Icon(Icons.Default.Person, contentDescription = null) }
        )
    )

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                    }
                },
                icon = item.icon,
                label = { Text(item.label) }
            )
        }
    }
}