package and5.abrar.newsjetpackcompose.api

import and5.abrar.newsjetpackcompose.data.ResponseNewsItem
import and5.abrar.newsjetpackcompose.data.ResponseStaffItem
import retrofit2.http.GET

interface ApiService {
    @GET("news")
    suspend fun getAllNews():List<ResponseNewsItem>

    @GET("staf")
    suspend fun getAllStaff():List<ResponseStaffItem>
}