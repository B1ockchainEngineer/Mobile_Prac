import static androidx.compose.ui.test.junit4.AndroidComposeTestRule_androidKt.createComposeRule;
import static com.example.tiptime.MainActivityKt.TipTimeLayout;

import com.example.tiptime.ui.theme.TipTimeTheme
import androidx.compose.runtime.Composable
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat
import androidx.compose.ui.test.junit4.createComposeRule


class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Composable
    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeLayout()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount")
                .performTextInput("10")
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
                "No node with this text was found.")
    }
}
