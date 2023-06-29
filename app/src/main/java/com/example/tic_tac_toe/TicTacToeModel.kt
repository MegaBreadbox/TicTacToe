package com.example.tic_tac_toe

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Collections.list

class TicTacToeModel: ViewModel() {
    private val _uiState = MutableStateFlow(TicTacToeUiState())
    val uiState: StateFlow<TicTacToeUiState> = _uiState.asStateFlow()
    private val tempBoard: MutableList<String> = _uiState.value.board.toMutableList()




    fun selectSpace(UiIndex: Int) {
        if (_uiState.value.isEmpty && _uiState.value.isCircle) {
            tempBoard[UiIndex] = "Circle"
            _uiState.update { currentState ->
                currentState.copy(
                    isEmpty = false,
                    isCircle = !_uiState.value.isCircle,
                    board = tempBoard
                )
            }
        }
    }




}


