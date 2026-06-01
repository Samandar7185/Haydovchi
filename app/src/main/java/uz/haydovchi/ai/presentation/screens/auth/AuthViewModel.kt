package uz.haydovchi.ai.presentation.screens.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun onPhoneNumberChanged(phone: String) {
        _uiState.value = _uiState.value.copy(phoneNumber = phone)
    }

    fun sendOtp() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            // TODO: Call API to send OTP
            // For now simulate success
            kotlinx.coroutines.delay(1500)
            
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                isOtpSent = true
            )
        }
    }

    fun verifyOtp(otp: String) {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            
            // TODO: Verify OTP with backend / Telegram
            kotlinx.coroutines.delay(1000)
            
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                isAuthenticated = true
            )
        }
    }
}

data class AuthUiState(
    val phoneNumber: String = "",
    val isLoading: Boolean = false,
    val isOtpSent: Boolean = false,
    val isAuthenticated: Boolean = false,
    val error: String? = null
)