package com.bignerdranch.android.photogallery

import api.FlickrApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Query

class PhotoRepository {
    private val flickrApi: FlickrApi

    init {
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(PhotoInterceptor())
            .build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
        flickrApi = retrofit.create(FlickrApi::class.java)
    }

    suspend fun fetchPhotos(): List<GalleryItem> =
        flickrApi.fetchPhotos().photos.galleryItems

    suspend fun searchPhotos(query: String): List<GalleryItem> =
        flickrApi.seachPhotos(query).photos.galleryItems
}