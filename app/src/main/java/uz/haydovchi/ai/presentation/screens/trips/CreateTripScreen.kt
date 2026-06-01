package uz.haydovchi.ai.presentation.screens.trips

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun CreateTripScreen(
    navController: NavController,
    viewModel: TripViewModel = hiltViewModel()
) {
    var fromLocation by remember { mutableStateOf("") }
    var toLocation by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Yangi reys yaratish",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = fromLocation,
            onValueChange = { fromLocation = it },
            label = { Text("Qayerdan") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = toLocation,
            onValueChange = { toLocation = it },
            label = { Text("Qayerga") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                if (fromLocation.isNotBlank() && toLocation.isNotBlank()) {
                    viewModel.createTrip(fromLocation, toLocation)
                    navController.popBackStack()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = fromLocation.isNotBlank() && toLocation.isNotBlank()
        ) {
            Text("Reysni yaratish")
        }
    }
}