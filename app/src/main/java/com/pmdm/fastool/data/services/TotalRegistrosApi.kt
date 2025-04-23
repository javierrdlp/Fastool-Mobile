package com.pmdm.fastool.data.services

import com.google.gson.annotations.SerializedName

data class TotalRegistrosApi(
    @SerializedName("tabla")
    val tabla: String,
    @SerializedName("total_registros")
    val totalRegistros: Int
)

