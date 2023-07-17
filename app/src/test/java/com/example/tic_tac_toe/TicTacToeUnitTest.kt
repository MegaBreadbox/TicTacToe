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

    //edge case
    @Test
    fun gameViewModel_WinCondition_GameOver(){
        viewModel.selectSpace(0)
        viewModel.selectSpace(1)
        viewModel.selectSpace(3)
        viewModel.selectSpace(4)
        viewModel.selectSpace(7)
        viewModel.selectSpace(6)
        viewModel.selectSpace(2)
        viewModel.selectSpace(5)
        viewModel.selectSpace(8)
        val victoryText = viewModel.uiState.value.victoryText
        assertEquals(victoryText, "Game Over")
    }
}