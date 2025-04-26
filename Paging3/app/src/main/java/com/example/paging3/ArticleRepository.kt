package com.example.paging3

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

class ArticleRepository(private val dao: ArticleDao) {
    fun getPagedArticles(): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = { dao.getAllArticlesPaged() }
        ).flow
    }

    suspend fun insertDummyArticles() {
        val dummyArticles = List(100) {
            Article(title = "Article $it", content = "This is article number $it.")
        }
        dao.insertAll(dummyArticles)
    }
}
