package and5.abrar.newsjetpackcompose.staff

import and5.abrar.newsjetpackcompose.api.ApiService
import and5.abrar.newsjetpackcompose.data.ResponseStaffItem
import javax.inject.Inject

class StaffRepository @Inject constructor(private val staffapi : ApiService)  {
    suspend fun getStaff() : List<ResponseStaffItem>{
        return staffapi.getAllStaff()
    }
}