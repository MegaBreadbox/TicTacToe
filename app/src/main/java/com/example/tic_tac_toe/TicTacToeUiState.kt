package com.example.tic_tac_toe

data class TicTacToeUiState(
    val isEmpty: Boolean = false,
    val isCircle: Boolean = true,
    val board: List<String> = listOf<String>(
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
