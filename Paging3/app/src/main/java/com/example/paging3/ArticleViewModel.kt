package com.example.paging3

import androidx.lifecycle.ViewModel
import androidx.paging.cachedIn
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ArticleViewModel(private val repository: ArticleRepository) : ViewModel() {
    val articles = repository.getPagedArticles().cachedIn(viewModelScope)

    fun insertDummyData() {
        viewModelScope.launch {
            repository.insertDummyArticles()
        }
    }
}
