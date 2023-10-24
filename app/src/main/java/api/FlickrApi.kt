package api

import com.bignerdranch.android.photogallery.FlickrResponse
import retrofit2.http.GET
private const val API_KEY = "baa2d54ff110f3b270d16dfb4c77d2c4"
interface FlickrApi {
    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
        "&api_key=$API_KEY" +
        "&format=json" +
        "&nojsoncallback=1" +
        "&extras=url_s"
    )
    suspend fun fetchPhotos(): FlickrResponse
}