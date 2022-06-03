package and5.abrar.newsjetpackcompose.viewmodel

import and5.abrar.newsjetpackcompose.NewsRepository
import and5.abrar.newsjetpackcompose.data.ResponseNewsItem
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val api : NewsRepository) : ViewModel() {
    private val newsState = MutableStateFlow(emptyList<ResponseNewsItem>())
     val dataState : StateFlow<List<ResponseNewsItem>>
    get() = newsState
    init {
        viewModelScope.launch {
            val news = api.getNews()
            newsState.value = news
        }
    }

}