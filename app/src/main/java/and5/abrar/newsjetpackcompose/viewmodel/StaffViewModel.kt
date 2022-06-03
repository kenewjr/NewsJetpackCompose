package and5.abrar.newsjetpackcompose.viewmodel

import and5.abrar.newsjetpackcompose.NewsRepository
import and5.abrar.newsjetpackcompose.data.ResponseNewsItem
import and5.abrar.newsjetpackcompose.data.ResponseStaffItem
import and5.abrar.newsjetpackcompose.staff.StaffRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StaffViewModel @Inject constructor(private val api : StaffRepository) : ViewModel() {
    private val staffState = MutableStateFlow(emptyList<ResponseStaffItem>())
    val dataState : StateFlow<List<ResponseStaffItem>>
        get() = staffState
    init {
        viewModelScope.launch {
            val staff = api.getStaff()
            staffState.value = staff
        }
    }
}