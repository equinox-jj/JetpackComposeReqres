package com.jetpackcomposereqres.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jetpackcomposereqres.presentation.home.component.CardUserList

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state = viewModel.state
    Box(modifier = Modifier.fillMaxSize()) {
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.data.size) { i ->
                val result = state.data[i]
                CardUserList(
                    result = result,
                    modifier = Modifier
                        .height(150.dp)
                        .padding(15.dp)
                        .fillMaxWidth(),
                )
            }
        }

        state.isError?.let { error ->
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = error,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 20.sp,
            )
        }
    }

}