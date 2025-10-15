package com.guvnoh.boma.functions

import com.guvnoh.boma.models.Receipt
import com.guvnoh.boma.navigation.Screen

data class RecordUiState(
    val isLoading: Boolean = true,
    val records: List<Receipt> = emptyList()
)

