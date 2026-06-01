package uz.haydovchi.ai.domain.model

import java.util.Date

data class Trip(
    val id: String,
    val fromLocation: String,
    val toLocation: String,
    val startTime: Date? = null,
    val endTime: Date? = null,
    val status: TripStatus = TripStatus.PLANNED,
    val distanceKm: Int = 0,
    val income: Long = 0,
    val expenses: Long = 0,
    val notes: String = ""
)

enum class TripStatus {
    PLANNED,
    IN_PROGRESS,
    PAUSED,
    COMPLETED,
    CANCELLED
}