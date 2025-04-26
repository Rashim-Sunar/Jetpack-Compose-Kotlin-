package com.example.learningdepencyinjection.data

import javax.inject.Inject

class QuoteRepository @Inject constructor() {
    fun getQuotes(): List<String> {
        return listOf(
            "Stay hungry, stay foolish.",
            "Be yourself; everyone else is already taken.",
            "Simplicity is the ultimate sophistication."
        )
    }
}
