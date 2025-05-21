package com.week1.app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.week1.app.ui.theme.Week1AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week1AppTheme {
                ThucHanh2()
            }
        }
    }
}

@Composable
fun ThucHanhTuan1() {
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

@Composable
fun ThucHanh1() {
    Scaffold(
        modifier = Modifier
            .padding(WindowInsets.systemBars.asPaddingValues()),
        topBar = {
            Row(modifier = Modifier.padding(15.dp, 10.dp)) {
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
                painter = painterResource(R.drawable._70680900_1330465544796459_2843008803935107182_n),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(MaterialTheme.shapes.extraLarge)
            )
            Text(text = "Doan Hoai An - KM2301A", style = MaterialTheme.typography.titleLarge)
            Text(text = "", style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Composable
fun ThucHanh2() {
    var text by remember { mutableStateOf("") }
    var isFailure by remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text("Thực hành 02")
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Email") },
            isError = isFailure,
            supportingText = { if (isFailure) Text("Email không đúng định dạng") }
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                isFailure = text.isEmpty() || !text.contains("@")
            }
        ) { Text("Kiểm tra") }
    }
}

@Composable
fun ThucHanhTuan2() {

    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("THỰC HÀNH 01", style = MaterialTheme.typography.headlineLarge)

        Spacer(Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray.copy(alpha = .5f), MaterialTheme.shapes.medium)
                .padding(20.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Họ và Tên",
                    modifier = Modifier.width(120.dp),
                    style = MaterialTheme.typography.titleLarge
                )
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier
                        .background(Color.White, MaterialTheme.shapes.large)
                        .clip(MaterialTheme.shapes.large)
                )
            }

            Spacer(Modifier.height(10.dp))

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    "Tuổi",
                    modifier = Modifier.width(120.dp),
                    style = MaterialTheme.typography.titleLarge
                )
                TextField(
                    value = age,
                    onValueChange = { newAge ->
                        if (newAge.all { it.isDigit() }) {
                            age = newAge
                        }
                    },
                    modifier = Modifier
                        .background(Color.White, MaterialTheme.shapes.large)
                        .clip(MaterialTheme.shapes.large),
                )
            }


        }

        Spacer(Modifier.height(20.dp))

        Button(onClick = {
            val ageInt = age.toIntOrNull()
            if (ageInt != null) {
                val message = when {
                    ageInt > 65 -> "Người già"
                    ageInt in 6..65 -> "Người lớn"
                    ageInt in 2..6 -> "Trẻ em"
                    else -> "Em bé"
                }
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Vui lòng nhập tuổi hợp lệ", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text("Kiểm tra")
        }

    }
}

@Preview(showBackground = true, showSystemUi = true, device = "id:pixel_9_pro")
@Composable
fun MainScreenPreview() {
    Week1AppTheme {
        ThucHanhTuan2()
    }
}