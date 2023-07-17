package com.example.tic_tac_toe

data class TicTacToeUiState(
    val victoryText: String = "Game Over",
    val isGameOver: Boolean = false,
    val isCircle: Boolean = true,
    val board: MutableList<String> = mutableListOf(
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
