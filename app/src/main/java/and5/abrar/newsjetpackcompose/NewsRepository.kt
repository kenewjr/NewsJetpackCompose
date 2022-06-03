package and5.abrar.newsjetpackcompose

import and5.abrar.newsjetpackcompose.api.ApiService
import and5.abrar.newsjetpackcompose.data.ResponseNewsItem
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsapi :ApiService) {
    suspend fun getNews() : List<ResponseNewsItem>{
    return  newsapi.getAllNews()
    }
}