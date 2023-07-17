package com.example.tic_tac_toe

import androidx.lifecycle.ViewModel
import com.example.tic_tac_toe.data.EmptyList.initialBoard
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TicTacToeModel: ViewModel() {
    private val _uiState = MutableStateFlow(TicTacToeUiState())
    val uiState: StateFlow<TicTacToeUiState> = _uiState.asStateFlow()
    private var tempBoard: MutableList<String> = _uiState.value.board.toMutableList()


    companion object {
        private const val CENTER_OF_BOARD = 4
    }


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

    private fun victoryUpdate(){
        _uiState.update{
            it.copy(
                victoryText = if(_uiState.value.isCircle){ "Cross Wins!"} else "Circle Wins!",
                isGameOver = true
            )
        }
    }

    fun winCondition(): Boolean {
        //horizontal victory
        for(i in 1 until tempBoard.size step 3){
            if(
                tempBoard[i-1] == tempBoard[i] && tempBoard[i+1] == tempBoard[i]
                && tempBoard[i] != "empty"
            ){
                victoryUpdate()
                return true
            }

        }
        //Diagonal victory
        if(tempBoard[CENTER_OF_BOARD] != "empty") {
            if (
                tempBoard[CENTER_OF_BOARD] == tempBoard[CENTER_OF_BOARD - 2] &&
                tempBoard[CENTER_OF_BOARD] == tempBoard[CENTER_OF_BOARD + 2] ||
                tempBoard[CENTER_OF_BOARD] == tempBoard[CENTER_OF_BOARD - 4] &&
                tempBoard[CENTER_OF_BOARD] == tempBoard[CENTER_OF_BOARD + 4]
            ) {
                victoryUpdate()
                return true
            }
        }
        //Vertical victory
        for(i in 1 until tempBoard.size step 3){

        }
        return false
    }

    fun resetGame(){
        _uiState.update{
            it.copy(
                isGameOver = false,
                isCircle = true,
                board = initialBoard
            )
        }
        for(i in tempBoard.indices){
            tempBoard[i] = "empty"
        }

    }




}


