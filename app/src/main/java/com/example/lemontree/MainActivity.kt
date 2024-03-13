package com.example.lemontree

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemontree.ui.theme.LemonTreeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonTreeTheme {
                // A surface container using the 'background' color from the theme
                LemonTree()
            }
        }
    }
}

@Preview
@Composable
fun LemonTree(){
    LemonTreeUi(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center),onImageClick ={}
    )
}

@Composable
fun LemonTreeUi(modifier: Modifier = Modifier, onImageClick:()-> Unit){
    var result by remember {
        mutableStateOf(1)
    }

    var random by remember {
        mutableStateOf((2..4).random())
    }

    val imageResources = when(result){
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Image(
            painter = painterResource(imageResources),
            contentDescription = "1",
            Modifier.clickable {
                onImageClick();
//                result++

                when(result){
                    2 -> {
                        random--
                        if(random == 0){
                            result++
                        }
                    }
                    5 -> result = 0
                    else -> result++
                }

//                if (result==2){
//                    random--
//                    if (random == 0)
//                        result++
//                    else
//                        result = 2
//                }
//                else
//                    result++
//
//
//                if (result == 5)
//                    result = 0
            }
        )

    }


}