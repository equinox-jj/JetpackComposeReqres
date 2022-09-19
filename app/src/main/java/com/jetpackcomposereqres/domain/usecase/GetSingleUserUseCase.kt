package com.jetpackcomposereqres.domain.usecase

import com.jetpackcomposereqres.common.Resource
import com.jetpackcomposereqres.domain.model.Data
import com.jetpackcomposereqres.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSingleUserUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(id: Int): Flow<Resource<Data>> = repository.getSingleUser(id)
}