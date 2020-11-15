package com.indriyantongrh.submission2aplikasigithubuser.Baseurl

import androidx.constraintlayout.solver.state.State
import com.indriyantongrh.submission2aplikasigithubuser.Model.ResponseSearch
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.connection.ConnectInterceptor.intercept
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.io.IOException


/**
 *  Create by Indriyantongrh on 12/11/20
 */

class NetworkConfig{

    var httpClient = OkHttpClient.Builder()

    fun getInterceptor() : OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
                .addInterceptor{chain ->
                    val newRequest = chain.request().newBuilder()
                            .addHeader("Authorization", "token c035ef468dbb6a39ebfe9a0675fa39236322c2c8")
                            .build()
                    chain.proceed(newRequest)
                }
            .build()

        return  okHttpClient
    }



    fun getRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(getInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val getUserss: getUsers = getRetrofit().create(getUsers::class.java)
    val getDetail: getDetailUsers = getRetrofit().create(getDetailUsers::class.java)


}

interface getUsers {
    @Headers("Content-Type:application/json; charset=UTF-8")
    @GET("search/users")
    fun getUserSearch2(@Query("q") q: String?) : Call<ResponseSearch>
}

interface getDetailUsers {
    @GET("users")
    fun getUserSearch2(@Query("q") q: String?) : Call<ResponseSearch>
}






