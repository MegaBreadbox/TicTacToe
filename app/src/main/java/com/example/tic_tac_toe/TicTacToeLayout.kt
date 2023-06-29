package com.example.tic_tac_toe

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tic_tac_toe.ui.theme.TicTac_ToeTheme



@Composable
fun boardLayout(
    toeModel: TicTacToeModel = viewModel(),
){
    val TicTacToeState by toeModel.uiState.collectAsState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ){
        items(9,){boardCard(it, toeModel)
        }
        // put the 3 in a row check into lazy grid
    }
}


@Composable
private fun boardCard(cardIndex: Int, viewModel: TicTacToeModel = viewModel() ,modifier: Modifier = Modifier) {
    //hoist isCircle because otherwise its managed individually across 9 cards.

    Card(
        modifier = modifier
            .clickable {
                viewModel.selectSpace(cardIndex)
            }
    ) {
        Row(){
            Text(text = "select..")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun TicTac_ToePreview() {
    TicTac_ToeTheme {
        boardLayout()
    }
}
