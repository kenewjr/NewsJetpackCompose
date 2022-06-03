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
import and5.abrar.newsjetpackcompose.viewmodel.NewsViewModel
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val newsViewModel = viewModel(modelClass = NewsViewModel::class.java)
                    val datanews by newsViewModel.dataState.collectAsState()
                    LazyColumn{
                        if (datanews.isEmpty()){
                        item{

                        }
                }
                        items(datanews){
                            Greeting(news = it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(news : ResponseNewsItem) {
    val mContext = LocalContext.current
    Column(modifier = Modifier.padding(15.dp)){
        Card(modifier = Modifier
            .padding(5.dp)
            .clickable {
                val pindahdata = Intent(mContext, DetailLayout::class.java)
                pindahdata.putExtra("author", news.author)
                pindahdata.putExtra("createdAt", news.createdAt)
                pindahdata.putExtra("title", news.title)
                pindahdata.putExtra("image", news.image)
                mContext.startActivity(pindahdata)
            }
            .fillMaxWidth()) {
            Row() {
                Image(painter = rememberImagePainter(data = news.image), contentDescription ="ini gambar", modifier = Modifier.width(200.dp).height(150.dp).padding(end = 10.dp))
                Column(modifier = Modifier.padding(start = 20.dp)){
                    Text(text = news.title)
                    Text(text = news.author)
                    Text(text = news.createdAt)
                }
            }
            
        }
    }
    
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    NewsJetpackComposeTheme {
//        Greeting("Android","","","","","")
    }
}