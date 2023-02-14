package com.example.imageprocessing

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.imageprocessing.ui.theme.ImageProcessingTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ImageProcessingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }

        val bitmap = ImageGetter().getImage("$filesDir/19_49_41_R_312.7_166.9.png")

        if (bitmap != null) {
            val result = ImageProcessor().getLifeDetectionInformation(bitmap)
            Log.d("Test", "Result = $result")
        }
    }
}