package com.jetpackcomposereqres.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jetpackcomposereqres.common.Resource
import com.jetpackcomposereqres.domain.usecase.GetUserListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserListUseCase: GetUserListUseCase,
) : ViewModel() {

    var state by mutableStateOf(HomeUiState())
        private set

    init {
        getUserList()
    }

    private fun getUserList() {
        viewModelScope.launch {
            getUserListUseCase.invoke().collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        state = state.copy(
                            isLoading = true,
                            isError = null,
                            data = emptyList()
                        )
                    }
                    is Resource.Success -> {
                        result.data?.let {
                            state = state.copy(
                                isLoading = false,
                                isError = null,
                                data = it
                            )
                        }
                    }
                    is Resource.Error -> {
                        state = state.copy(
                            isLoading = false,
                            isError = result.message,
                            data = emptyList()
                        )
                    }
                }
            }
        }
    }

}