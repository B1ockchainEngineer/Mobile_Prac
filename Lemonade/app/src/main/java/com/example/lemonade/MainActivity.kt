package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme
import java.lang.Math.random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
            }
        }
    }
}

@Composable
fun LemonWithWordsAndImage(modifier: Modifier = Modifier) {
    var click by remember {
        mutableStateOf(1)
    }
    var picture by remember {
        mutableStateOf(R.drawable.lemon_tree)
    }

    var textMsg by remember {
        mutableStateOf(R.string.UI1)
    }


    when (click) {
        1 -> {
            picture = R.drawable.lemon_tree
            textMsg = R.string.UI1
        }

        2 -> {
            picture = R.drawable.lemon_squeeze
            textMsg = R.string.UI2
        }

        3 -> {
            picture = R.drawable.lemon_drink
            textMsg = R.string.UI3
        }

        4 -> {
            picture = R.drawable.lemon_restart
            textMsg = R.string.UI4
        }


    }


    Box(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { if(click ==4) click = 1 else click++  })
            {
                Column {

                    Image(painter = painterResource(id = picture), contentDescription = "1")


                }

            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = stringResource(id = textMsg))
        }
    }


}




@Preview(showBackground = true)
@Composable
fun LemonApp() {
    LemonWithWordsAndImage(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}