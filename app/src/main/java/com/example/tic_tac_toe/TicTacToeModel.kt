package com.example.tic_tac_toe

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TicTacToeModel: ViewModel() {
    private val _uiState = MutableStateFlow(TicTacToeUiState())
    val uiState: StateFlow<TicTacToeUiState> = _uiState.asStateFlow()
    private val tempBoard: MutableList<String> = _uiState.value.board.toMutableList()




    fun selectSpace(UiIndex: Int) {
        if(_uiState.value.board[UiIndex] == "empty" && _uiState.value.isCircle) {
            tempBoard[UiIndex] = "Circle"
            _uiState.update { currentState ->
                currentState.copy(
                    isCircle = !_uiState.value.isCircle,
                    board = tempBoard
                )
            }
        }
        else if(_uiState.value.board[UiIndex] == "empty" && !_uiState.value.isCircle){
            tempBoard[UiIndex] = "Cross"
            _uiState.update {
                it.copy(
                    isCircle = !_uiState.value.isCircle,
                    board = tempBoard
                )
            }
        }
    }

    fun winCondition (){
        for(i in 1..tempBoard.size){
            if(
                tempBoard[i-1] == tempBoard[i] && tempBoard[i+1] == tempBoard[i]
                && tempBoard[i] != "empty"
            ){

            }
        }
    }




}


