package com.jetpackcomposereqres.data.repository

import com.jetpackcomposereqres.common.Resource
import com.jetpackcomposereqres.data.mapper.dataDtoToData
import com.jetpackcomposereqres.data.remote.network.ApiServices
import com.jetpackcomposereqres.domain.model.Data
import com.jetpackcomposereqres.domain.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiServices: ApiServices,
) : Repository {

    override fun getUsersList(): Flow<Resource<List<Data>>> = flow {
        emit(Resource.Loading())
        try {
            val response = apiServices.getUsersList().map { it.dataDtoToData() }
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage))
        }
    }

    override fun getSingleUser(id: Int): Flow<Resource<Data>> = flow {
        emit(Resource.Loading())
        try {
            val response = apiServices.getSingleUser(id).dataDtoToData()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Error(message = e.localizedMessage))
        }
    }

}