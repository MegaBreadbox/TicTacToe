package com.example.tic_tac_toe

data class TicTacToeUiState(
    val isEmpty: Boolean = false,
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
