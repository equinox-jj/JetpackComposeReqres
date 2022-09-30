package com.jetpackcomposereqres.data.remote.network

import com.jetpackcomposereqres.common.Constants.SINGLE_USERS
import com.jetpackcomposereqres.common.Constants.USERS_LIST
import com.jetpackcomposereqres.data.remote.network.dto.DataDto
import com.jetpackcomposereqres.data.remote.network.dto.UserResposesDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {

    @GET(USERS_LIST)
    suspend fun getUsersList(): UserResposesDto

    @GET(SINGLE_USERS)
    suspend fun getSingleUser(
        @Path("id") id: Int,
    ): DataDto

}