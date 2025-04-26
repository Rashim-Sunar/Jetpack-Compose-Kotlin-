package com.example.learningdepencyinjection.uis

import androidx.lifecycle.ViewModel
import com.example.learningdepencyinjection.data.QuoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val repository: QuoteRepository
) : ViewModel() {

    private val _quotes =  MutableStateFlow<List<String>>(emptyList())
    val quotes: Flow<List<String>> get() = _quotes

    init {
        loadQuotes()
    }

    private fun loadQuotes() {
        _quotes.value = repository.getQuotes()
    }
}
