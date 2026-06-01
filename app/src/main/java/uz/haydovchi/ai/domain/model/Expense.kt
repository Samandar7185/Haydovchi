package uz.haydovchi.ai.domain.model

import java.util.Date

data class Expense(
    val id: String,
    val tripId: String? = null,
    val category: String,           // e.g. "Yoqilg'i", "Ovqat", "Yo'l haqi"
    val subcategory: String? = null,
    val amount: Long,
    val currency: String = "UZS",
    val date: Date = Date(),
    val note: String = "",
    val receiptUrl: String? = null   // for future OCR
)