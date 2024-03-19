package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Preview
@Composable
fun ArtSpaceApp() {
    var resp by remember {
        mutableStateOf(1)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtSpaceImage(
            modifier = Modifier
                .wrapContentSize(Alignment.Center),
            resp
        )
        ArtWorkText(
            modifier = Modifier.padding(top = 1000.dp),
            resp// Add padding to separate image and text
        )
        Row(
            modifier = Modifier.padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center
        ){
            Button(
                text = "Previous",
                onClick = {
                    if (resp > 1) {
                        resp --
                    }
                }
            )
            Button(
                text = "Next",
                onClick = {
                    resp ++
                    if(resp > 4)
                        resp = 4
                }
            )
        }
    }
}

@Composable
fun ArtSpaceImage(modifier: Modifier = Modifier, resp: Int) {

    val imageResources = when(resp){
        1 -> R.drawable.btc
        2 -> R.drawable.eth
        3 -> R.drawable.sol
        else -> R.drawable.bnb
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = imageResources),
            contentDescription = "1"
        )
    }
}

@Composable
fun ArtWorkText(modifier: Modifier, resp: Int) {
    val titleResources = when(resp){
        1 -> R.string.btc
        2 -> R.string.eth
        3 -> R.string.sol
        else -> R.string.bnb
    }

    val artistResources = when(resp){
        1 -> R.string.sat
        2 -> R.string.vit
        3 -> R.string.ana
        else -> R.string.cz
    }

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            stringResource(id = titleResources),
            fontSize = 40.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            stringResource(id = artistResources),
            fontSize = 25.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun Button(text: String, onClick: () -> Unit) {
    androidx.compose.material3.Button(
        onClick = {
            onClick()
        },
        modifier = Modifier.padding(horizontal = 30.dp)
    ) {
        Text(text=text)
    }
}