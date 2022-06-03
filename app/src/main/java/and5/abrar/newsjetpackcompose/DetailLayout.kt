package and5.abrar.newsjetpackcompose

import and5.abrar.newsjetpackcompose.data.ResponseNewsItem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import and5.abrar.newsjetpackcompose.ui.theme.NewsJetpackComposeTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

class DetailLayout : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val gambar = intent.getStringExtra("image")
                    val judul = intent.getStringExtra("title")
                    val jadwal = intent.getStringExtra("createdAt")
                    val author = intent.getStringExtra("author")
                    Greeting3(gambar = gambar.toString(), judul = judul.toString(), jadwal = jadwal.toString(), author =author.toString() )
                }
            }
        }
    }
}

@Composable
fun Greeting3(gambar:String,judul:String,jadwal:String,author:String) {
    Column(modifier = Modifier.padding(15.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = rememberImagePainter(data = gambar), contentDescription = "ini gambar", modifier = Modifier.width(200.dp).height(150.dp).padding(end = 10.dp) )
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f)
            .padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Judul : $judul",
                color = Color.DarkGray,
                fontWeight = FontWeight.Normal,
            )
            Text(
                text = "Jadwal : $jadwal",
                color = Color.DarkGray,
                fontWeight = FontWeight.Normal,
            )
            Text(
                text = "Sutradara : $author",
                color = Color.DarkGray,
                fontWeight = FontWeight.Normal,
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    NewsJetpackComposeTheme {
    }
}