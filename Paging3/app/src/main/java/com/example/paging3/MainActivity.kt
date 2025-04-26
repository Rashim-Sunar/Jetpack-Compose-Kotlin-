package com.example.paging3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.paging3.ui.theme.Paging3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val database = AppDatabase.getInstance(this)
        val repository = ArticleRepository(database.articleDao())
        val viewModel = ViewModelProvider(this, ArticleViewModelFactory(repository))[ArticleViewModel::class.java]

        setContent {
            Paging3Theme {
                MainScreen(viewModel)
            }
        }
    }
}


@Composable
fun MainScreen(viewModel: ArticleViewModel) {
    val articles = viewModel.articles.collectAsLazyPagingItems()

    // Insert dummy data once on launch
    LaunchedEffect(Unit) {
        viewModel.insertDummyData()
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        // Display paginated items
        items(articles.itemCount) { index ->
            val article = articles[index]

            article?.let {
                ArticleItem(it.title, it.content)
            }
        }

        // Handle loading and error states
        articles.apply {
            when {
                loadState.refresh is LoadState.Loading -> {
                    item { LoadingItem("Loading articles...") }
                }
                loadState.append is LoadState.Loading -> {
                    item { LoadingItem("Loading more...") }
                }
                loadState.refresh is LoadState.Error -> {
                    val e = loadState.refresh as LoadState.Error
                    item { ErrorItem("Error loading articles: ${e.error.localizedMessage}") }
                }
                loadState.append is LoadState.Error -> {
                    val e = loadState.append as LoadState.Error
                    item { ErrorItem("Error loading more: ${e.error.localizedMessage}") }
                }
            }
        }
    }
}

@Composable
fun ArticleItem(title: String, content: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Text(text = content, fontSize = 14.sp)
    }
}

@Composable
fun LoadingItem(message: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator()
        Text(text = message, modifier = Modifier.padding(top = 8.dp))
    }
}

@Composable
fun ErrorItem(message: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = message, color = Color.Red, fontWeight = FontWeight.SemiBold)
    }
}





