package com.jetpackcomposereqres.presentation.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.jetpackcomposereqres.R
import com.jetpackcomposereqres.domain.model.Data

@Composable
fun CardUserList(
    result: Data,
    modifier: Modifier = Modifier,
) {
    Card {
        Column {
            AsyncImage(
                model = result.avatar,
                placeholder = painterResource(id = R.drawable.ic_image),
                contentDescription = null
            )
            Spacer(modifier = modifier.height(10.dp))
            result.email?.let {
                Text(
                    text = it,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                )
            }
        }
    }
}