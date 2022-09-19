package com.jetpackcomposereqres.domain.repository

import com.jetpackcomposereqres.common.Resource
import com.jetpackcomposereqres.domain.model.Data
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getUsersList(): Flow<Resource<List<Data>>>
    fun getSingleUser(id: Int): Flow<Resource<Data>>

}