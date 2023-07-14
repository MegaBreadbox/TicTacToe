package com.example.tic_tac_toe

data class TicTacToeUiState(
    val isCircle: Boolean = true,
    val board: MutableList<String> = mutableListOf<String>(
        "empty",
        "empty",
        "empty",
        "empty",
        "empty",
        "empty",
        "empty",
        "empty",
        "empty")
)
