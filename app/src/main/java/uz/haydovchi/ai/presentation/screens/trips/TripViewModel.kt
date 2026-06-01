package uz.haydovchi.ai.presentation.screens.trips

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.haydovchi.ai.domain.model.Trip
import uz.haydovchi.ai.domain.model.TripStatus
import java.util.*
import javax.inject.Inject

@HiltViewModel
class TripViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(TripUiState())
    val uiState: StateFlow<TripUiState> = _uiState.asStateFlow()

    private val _activeTrip = MutableStateFlow<Trip?>(null)
    val activeTrip: StateFlow<Trip?> = _activeTrip.asStateFlow()

    fun createTrip(from: String, to: String) {
        viewModelScope.launch {
            val newTrip = Trip(
                id = UUID.randomUUID().toString(),
                fromLocation = from,
                toLocation = to,
                status = TripStatus.PLANNED
            )
            _uiState.value = _uiState.value.copy(
                currentTrip = newTrip,
                isCreating = false
            )
        }
    }

    fun startTrip() {
        _activeTrip.value?.let { trip ->
            val startedTrip = trip.copy(
                status = TripStatus.IN_PROGRESS,
                startTime = Date()
            )
            _activeTrip.value = startedTrip
        }
    }

    fun pauseTrip() {
        _activeTrip.value?.let { trip ->
            val pausedTrip = trip.copy(status = TripStatus.PAUSED)
            _activeTrip.value = pausedTrip
        }
    }

    fun finishTrip(income: Long = 0) {
        _activeTrip.value?.let { trip ->
            val finishedTrip = trip.copy(
                status = TripStatus.COMPLETED,
                endTime = Date(),
                income = income
            )
            _activeTrip.value = finishedTrip
            // TODO: Save to repository
        }
    }

    fun setActiveTrip(trip: Trip) {
        _activeTrip.value = trip
    }
}

data class TripUiState(
    val currentTrip: Trip? = null,
    val isCreating: Boolean = false,
    val trips: List<Trip> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)