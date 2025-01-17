package com.pscode.app.domain.remote

import com.pscode.app.domain.model.CountryData
import com.pscode.app.utils.Response

interface CountryApi {
    suspend fun getAllCountries(): Response<List<CountryData>>
}