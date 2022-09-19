package com.jetpackcomposereqres.domain.usecase

import com.jetpackcomposereqres.common.Resource
import com.jetpackcomposereqres.domain.model.Data
import com.jetpackcomposereqres.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUserListUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(): Flow<Resource<List<Data>>> = repository.getUsersList()
}