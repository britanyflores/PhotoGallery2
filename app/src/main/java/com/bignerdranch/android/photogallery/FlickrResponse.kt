package com.bignerdranch.android.photogallery

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class FlickrResponse (
    val photos: PhotoResponse
)