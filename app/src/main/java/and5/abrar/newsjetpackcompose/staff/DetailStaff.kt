package and5.abrar.newsjetpackcompose.staff

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
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

class DetailStaff : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val detailstaf =intent.getSerializableExtra("detailstaf") as ResponseStaffItem
        setContent {
            NewsJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting5(detailstaf)
                }
            }
        }
    }
}

@Composable
fun Greeting5(staf : ResponseStaffItem) {
    Column(modifier = Modifier.padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = rememberImagePainter(data = staf.image), contentDescription = "ini gambar", modifier = Modifier.width(200.dp).height(150.dp).padding(end = 10.dp) )
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "nama : ${staf.name}",
                color = Color.DarkGray,
                fontWeight = FontWeight.Normal,
            )
            Text(
                text = "email : ${staf.email}",
                color = Color.DarkGray,
                fontWeight = FontWeight.Normal,
            )
            Text(
                text = "dibuat : ${staf.createdAt}",
                color = Color.DarkGray,
                fontWeight = FontWeight.Normal,
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    NewsJetpackComposeTheme {

    }
}