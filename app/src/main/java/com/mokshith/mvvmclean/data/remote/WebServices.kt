package com.mokshith.mvvmclean.data.remote

import com.mokshith.mvvmclean.data.remote.dto.CoinDetailsDto
import com.mokshith.mvvmclean.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface WebServices {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetailsById(@Path("coinsId") coinId: String): CoinDetailsDto

}