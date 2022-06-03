package and5.abrar.newsjetpackcompose.staff

import and5.abrar.newsjetpackcompose.DetailLayout
import and5.abrar.newsjetpackcompose.data.ResponseStaffItem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import and5.abrar.newsjetpackcompose.staff.ui.theme.NewsJetpackComposeTheme
import and5.abrar.newsjetpackcompose.viewmodel.StaffViewModel
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StaffLayout : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val staffViewModel = viewModel(modelClass = StaffViewModel::class.java)
                    val datastaff by staffViewModel.dataState.collectAsState()
                    LazyColumn{
                        if (datastaff.isEmpty()){
                            item{

                            }
                        }
                        items(datastaff){
                            Greeting4(staff = it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting4(staff: ResponseStaffItem) {
    val mContext = LocalContext.current
    Column(modifier = Modifier.padding(15.dp)){
        Card(modifier = Modifier
            .padding(5.dp)
            .clickable {
                val pindahdata = Intent(mContext, DetailStaff::class.java)
                pindahdata.putExtra("detailstaf", staff)
                mContext.startActivity(pindahdata)
            }
            .fillMaxWidth()) {
            Row() {
                Image(painter = rememberImagePainter(data = staff.image), contentDescription ="ini gambar", modifier = Modifier.width(200.dp).height(150.dp).padding(end = 10.dp))
                Column(modifier = Modifier.padding(start = 20.dp)){
                    Text(text = staff.name)
                    Text(text = staff.email)
                    Text(text = staff.createdAt)
                }
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    NewsJetpackComposeTheme {
    }
}