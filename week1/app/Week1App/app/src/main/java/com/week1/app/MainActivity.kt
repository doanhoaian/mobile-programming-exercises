package com.week1.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.week1.app.ui.theme.Week1AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week1AppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        modifier = Modifier
            .padding(WindowInsets.systemBars.asPaddingValues()),
        topBar = {
            Row(modifier = Modifier.padding(15.dp, 10.dp)) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .border(1.dp, color = Color.Gray, shape = MaterialTheme.shapes.medium)
                        .padding(10.dp)
                )
                Spacer(modifier = Modifier.weight(1f, true))

                Icon(
                    Icons.Outlined.Edit,
                    tint = Color.Green,
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .border(1.dp, color = Color.Gray, shape = MaterialTheme.shapes.medium)
                        .padding(10.dp)
                )
            }
        },
        containerColor = Color.White
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.img_op),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(MaterialTheme.shapes.extraLarge)
            )
            Text(text = "Android", style = MaterialTheme.typography.headlineLarge)
            Text(text = "Ho Chi Minh City, VN", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_9_pro")
@Composable
fun MainScreenPreview() {
    Week1AppTheme {
        MainScreen()
    }
}