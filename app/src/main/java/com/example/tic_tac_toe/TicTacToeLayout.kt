package com.example.tic_tac_toe

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tic_tac_toe.ui.theme.TicTac_ToeTheme



@Composable
fun BoardLayout(
    toeModel: TicTacToeModel = viewModel(),
){
    val ticTacToeState by toeModel.uiState.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ){
        items(9,){BoardCard(it, ticTacToeState, viewModel = toeModel)
        }
        // put the 3 in a row check into lazy grid
    }
    if(!ticTacToeState.board.contains("empty")){
        GameOver()
    }
}


@Composable
private fun BoardCard(
    cardIndex: Int,
    uiState: TicTacToeUiState,
    modifier: Modifier = Modifier,
    viewModel: TicTacToeModel = viewModel(),
) {
    //hoist isCircle because otherwise its managed individually across 9 cards.

    Card(
        modifier = modifier
            .height(100.dp)
            .padding(4.dp)
            .clickable {
                viewModel.selectSpace(cardIndex)
            }
    ) {
        Row(){
            if(uiState.board[cardIndex] == "Circle"){
                Text(text = "Circle")
            }
            else if(uiState.board[cardIndex] == "Cross"){
                Text(text = "Cross")
            }
            else {
                Text(text = "select..")
            }
        }
    }
}

@Composable
private fun GameOver(
    viewModel: TicTacToeModel = viewModel()
){
    val activity = (LocalContext.current as Activity)

    AlertDialog(onDismissRequest = { },
        title = { Text(text = "Game Over")},
        text = {Text(text = "Reset the game?")},
        dismissButton = {
            TextButton(onClick = { activity.finish()}) {
                Text(text = "Exit")
            }
        },
        confirmButton = {
            TextButton(onClick = {viewModel.resetGame()}) {
                Text(text = "Reset")
            }
        }



        )
}

@Preview(showBackground = true)
@Composable
fun TicTac_ToePreview() {
    TicTac_ToeTheme {
        BoardLayout()
    }
}
