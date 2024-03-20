package com.example.tiptime

import androidx.compose.runtime.Composable
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {
    @Test
    fun caculateTip_20PercentNoRoundup(){
        val amount = 10.00
        val tipPercent = 20.00
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent)
        assertEquals(expectedTip,actualTip)
    }
}




