package com.pscode.app.data.cache

import com.pscode.app.domain.model.CountryData
import io.github.xxfast.kstore.KStore
import io.github.xxfast.kstore.file.storeOf

class CountryCache {
    val cache: KStore<List<CountryData>> = storeOf(file = getCountryCachePath().path)
}