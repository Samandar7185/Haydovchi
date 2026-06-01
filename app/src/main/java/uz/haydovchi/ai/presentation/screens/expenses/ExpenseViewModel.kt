package uz.haydovchi.ai.presentation.screens.expenses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import uz.haydovchi.ai.domain.model.Expense
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ExpenseViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(ExpenseUiState())
    val uiState: StateFlow<ExpenseUiState> = _uiState.asStateFlow()

    fun addExpense(
        category: String,
        amount: Long,
        note: String = "",
        tripId: String? = null
    ) {
        viewModelScope.launch {
            val newExpense = Expense(
                id = UUID.randomUUID().toString(),
                tripId = tripId,
                category = category,
                amount = amount,
                note = note
            )

            val updatedList = _uiState.value.expenses + newExpense
            _uiState.value = _uiState.value.copy(expenses = updatedList)
        }
    }
}

data class ExpenseUiState(
    val expenses: List<Expense> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)