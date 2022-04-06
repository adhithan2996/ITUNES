package com.itunes.songs.WebServices

import com.itunes.songs.models.model.*
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface AppleItunes {


    @GET("search")
    fun getSong(@Query("term") song: String ): Observable<Response>
}



