package com.example.taskmanager

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class TaskManagerTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun doesImageExist() {
        composeTestRule.setContent { MainActivity() }

        composeTestRule.onNodeWithContentDescription("Tick Image").assertIsDisplayed()
    }

    @Test
    fun doesTextExist() {
        composeTestRule.setContent { MainActivity() }

        composeTestRule.onNodeWithText(R.string.text_1.toString())
        composeTestRule.onNodeWithText(R.string.text_2.toString())

    }
}