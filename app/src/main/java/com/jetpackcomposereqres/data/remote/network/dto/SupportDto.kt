package com.jetpackcomposereqres.data.remote.network.dto


import com.google.gson.annotations.SerializedName

data class SupportDto(
    @SerializedName("text")
    val text: String?,
    @SerializedName("url")
    val url: String?
)