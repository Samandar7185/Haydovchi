package uz.haydovchi.ai.presentation.screens.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(
                        "Haydovchi AI", 
                        style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
                    ) 
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Active Trip Card (Prominent)
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        "Aktiv reys",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(
                        "Toshkent → Samarqand",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text("Boshlangan: 14:30 • 287 km qoldi")
                    
                    Spacer(Modifier.height(16.dp))
                    
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Button(onClick = { /* Pause trip */ }) {
                            Text("Pauza")
                        }
                        OutlinedButton(onClick = { /* Finish trip */ }) {
                            Text("Tugatish")
                        }
                    }
                }
            }

            // Financial Summary
            Text("Moliyaviy hisobot", style = MaterialTheme.typography.titleLarge)
            
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                FinancialCard("Daromad", "4 850 000 so'm", MaterialTheme.colorScheme.secondary)
                FinancialCard("Xarajat", "1 240 000 so'm", MaterialTheme.colorScheme.error)
                FinancialCard("Foyda", "3 610 000 so'm", MaterialTheme.colorScheme.primary)
            }

            // Quick Actions
            Text("Tezkor harakatlar", style = MaterialTheme.typography.titleLarge)
            
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                LargeActionButton("Yangi reys boshlash", onClick = { /* TODO */ })
                LargeActionButton("Xarajat qo'shish", onClick = { /* TODO */ })
                LargeActionButton("AI yordamchisi", onClick = { /* TODO */ })
            }
        }
    }
}

@Composable
fun FinancialCard(title: String, amount: String, color: Color) {
    Card(
        modifier = Modifier.weight(1f),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(title, style = MaterialTheme.typography.bodyMedium)
            Text(
                amount,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = color
            )
        }
    }
}

@Composable
fun LargeActionButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp), // Large touch target for drivers
        shape = MaterialTheme.shapes.medium
    ) {
        Text(text, style = MaterialTheme.typography.titleMedium)
    }
}