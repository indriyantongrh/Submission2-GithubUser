package com.indriyantongrh.submission2aplikasigithubuser.baseurl

import com.indriyantongrh.submission2aplikasigithubuser.model.ResponseDetails
import com.indriyantongrh.submission2aplikasigithubuser.model.ResponseFollowers
import com.indriyantongrh.submission2aplikasigithubuser.model.ResponseSearch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


/**
 *  Create by Indriyantongrh on 12/11/20
 */

class NetworkConfig{
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
    val getFollowers: getFollowersMember = getRetrofit().create(getFollowersMember::class.java)
    val getFollowing: getFollowingMember = getRetrofit().create(getFollowingMember::class.java)
}

interface getUsers {
    @Headers("Content-Type:application/json; charset=UTF-8")
    @GET("search/users")
    fun getUserSearch2(@Query("q") q: String?) : Call<ResponseSearch>
}
interface getDetailUsers {
    @GET("users/{username}")
    fun getDetails(@Path("username") username: String?) : Call<ResponseDetails>
}
interface getFollowersMember {
    @GET("users/{username}/followers")
    fun getFollowerss(@Path("username") username: String?) : Call<List<ResponseFollowers>>
}
interface getFollowingMember {
    @GET("users/{username}/following")
    fun getFollowing(@Path("username") username: String?) : Call<List<ResponseFollowers>>
}


