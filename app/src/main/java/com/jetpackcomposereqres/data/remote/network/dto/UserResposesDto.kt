package com.jetpackcomposereqres.data.remote.network.dto


import com.google.gson.annotations.SerializedName

data class UserResposesDto(
    @SerializedName("data")
    val data: List<DataDto>,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    @SerializedName("support")
    val support: SupportDto?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?
)