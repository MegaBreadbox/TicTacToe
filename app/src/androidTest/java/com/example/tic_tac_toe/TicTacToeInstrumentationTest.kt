package com.example.tic_tac_toe

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.tic_tac_toe.ui.theme.TicTac_ToeTheme
import org.junit.Rule
import org.junit.Test

class TicTacToeInstrumentationTest {
    @get: Rule
    val ticTacToeRule = createComposeRule()

    @Test
    fun myTest() {
        ticTacToeRule.setContent {
            TicTac_ToeTheme {
                boardLayout()
            }
        }
        ticTacToeRule.onAllNodesWithText("select..").onFirst()
            .assertHasClickAction()
            .performClick()
            .assert(hasText("select.."))
    }
}