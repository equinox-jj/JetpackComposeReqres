package com.jetpackcomposereqres.data.mapper

import com.jetpackcomposereqres.data.remote.network.dto.DataDto
import com.jetpackcomposereqres.data.remote.network.dto.UserResposesDto
import com.jetpackcomposereqres.domain.model.Data
import com.jetpackcomposereqres.domain.model.UserResponse

fun DataDto.dataDtoToData() : Data {
    return Data(
        avatar = avatar,
        email = email,
        first_name = firstName,
        last_name = lastName
    )
}

fun UserResposesDto.userResponseDtoToUserResponse() : UserResponse {
    return UserResponse(
        data = data.map { it.dataDtoToData() }
    )
}