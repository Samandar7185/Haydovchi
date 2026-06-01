package uz.haydovchi.ai.presentation.screens.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    init {
        loadDashboardData()
    }

    private fun loadDashboardData() {
        viewModelScope.launch {
            // TODO: Load from repository (Room + API)
            _uiState.value = DashboardUiState(
                activeTrip = ActiveTrip(
                    id = "trip_001",
                    from = "Toshkent",
                    to = "Samarqand",
                    startTime = "14:30",
                    remainingKm = 287
                ),
                financialSummary = FinancialSummary(
                    income = 4850000,
                    expense = 1240000,
                    profit = 3610000
                )
            )
        }
    }

    fun onPauseTrip() {
        // TODO: Implement pause logic
    }

    fun onFinishTrip() {
        // TODO: Implement finish logic
    }
}

data class DashboardUiState(
    val activeTrip: ActiveTrip? = null,
    val financialSummary: FinancialSummary = FinancialSummary(),
    val isLoading: Boolean = false,
    val error: String? = null
)

data class ActiveTrip(
    val id: String,
    val from: String,
    val to: String,
    val startTime: String,
    val remainingKm: Int
)

data class FinancialSummary(
    val income: Long = 0,
    val expense: Long = 0,
    val profit: Long = 0
)