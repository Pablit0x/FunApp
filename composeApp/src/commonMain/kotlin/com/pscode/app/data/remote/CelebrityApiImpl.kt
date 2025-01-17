package com.pscode.app.data.remote

import com.pscode.app.data.model.celebrity.CelebritiesDto
import com.pscode.app.domain.remote.CelebrityApi
import com.pscode.app.utils.Response
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.CancellationException

class CelebrityApiImpl(private val httpClient: HttpClient) : CelebrityApi {

    private val baseUrl = "https://pablit0x.github.io/nation_explorer_celebrities_api/"


    override suspend fun getCelebritiesByCountryName(countryName: String): Response<CelebritiesDto> {
        return try {
            Response.Success(data = httpClient.get {
                url("${baseUrl}/$countryName.json")
            }.body<CelebritiesDto>())
        } catch (e: IOException) {
            Response.Error("Network issue.")
        } catch (e: ClientRequestException) {
            Response.Error("Invalid request.")
        } catch (e: ServerResponseException) {
            Response.Error("Server unavailable.")
        } catch (e: HttpRequestTimeoutException) {
            Response.Error("Request timed out.")
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            Response.Error("Unexpected issue occurred.")
        }
    }
}