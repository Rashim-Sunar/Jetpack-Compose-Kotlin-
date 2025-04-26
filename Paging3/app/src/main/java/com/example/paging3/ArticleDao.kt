package com.example.paging3

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ArticleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(articles: List<Article>)

    @Query("SELECT * FROM articles ORDER BY id ASC")
    fun getAllArticlesPaged(): PagingSource<Int, Article>
}
