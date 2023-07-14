package com.example.tic_tac_toe

import junit.framework.TestCase.assertEquals
import org.junit.Test

class TicTacToeUnitTest {
    private val viewModel = TicTacToeModel()
    @Test
    fun gameViewModel_Initialization_UiState(){
        val boardUiState = viewModel.uiState.value
        assertEquals(boardUiState.isCircle, true)
    }
    @Test
    fun gameViewModel_Board_Circle() {
        viewModel.selectSpace(0)
        val boardUiStateAfter = viewModel.uiState.value
        assertEquals(boardUiStateAfter.board[0], CIRCLE )
    }
    companion object{
        private const val CIRCLE = "Circle"
    }
}