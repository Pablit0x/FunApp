package com.pscode.app.domain.repository

import com.pscode.app.domain.model.CountryOverview
import com.pscode.app.utils.Response

interface CountryRepository {
    suspend fun getAllCountries(): Response<List<CountryOverview>>
}