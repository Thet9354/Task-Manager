package com.example.taskmanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.*
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    if (intent?.action == Intent.ACTION_VIEW) {
                        // The code below handles the deep link here
                        val deepLinkUri = intent.data
                        if (deepLinkUri != null) {
                            val deepLink = deepLinkUri.toString()
                            if (deepLink == "https://www.betrbeta.com/#start") {
                                navController.navigate("main") // Navigate to the desired screen
                            }
                        }
                    }

                    NavHost(navController, startDestination = "main") {
                        composable("main") { TaskManager() }

                    }
                }
            }
        }
    }
}

@Composable
fun TaskManager(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TaskManagerImage()
        TaskManagerText()
    }
}

@Composable
fun TaskManagerImage() {

    Log.d("MyTag", "Before running updated lottie animation code")

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_lk9ocvu0))
    val progress by animateLottieCompositionAsState(composition)

    LottieAnimation(composition = composition, progress = { progress })

    Log.d("MyTag", "Before running updated lottie animation code")

//    val image = painterResource(id = R.drawable.ic_task_completed)
//    Image(
//        painter = image,
//        contentDescription = "Tick Image",
//        modifier = Modifier.testTag("Tick")
//    )
}

@Composable
fun TaskManagerText(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(R.string.text_1),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )

        Text(
            text = stringResource(R.string.text_2),
            fontSize = 16.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TaskManagerTheme {
        TaskManager()
    }
}