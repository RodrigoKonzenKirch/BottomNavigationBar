package com.example.bottomnavigationbar

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import com.example.bottomnavigationbar.ui.theme.BottomNavigationBarTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            BottomNavigationBarTheme{
                MainScreen(navController = navController)
            }
        }
    }

    @Test
    fun navigateFromHomeToMailScreen() {
        composeTestRule.onNodeWithText("Email").performClick()

        composeTestRule.onNodeWithText("Mail Screen").assertExists()
    }

    @Test
    fun navigateFromHomeToCallScreen() {
        composeTestRule.onNodeWithText("Call").performClick()

        composeTestRule.onNodeWithText("Call Screen").assertExists()
    }
}