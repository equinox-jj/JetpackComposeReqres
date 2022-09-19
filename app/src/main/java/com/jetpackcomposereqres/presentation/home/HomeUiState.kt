package com.jetpackcomposereqres.presentation.home

import com.jetpackcomposereqres.domain.model.Data

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: String? = null,
    val data: List<Data> = emptyList()
)
