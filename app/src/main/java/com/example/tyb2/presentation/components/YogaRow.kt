package com.example.tyb2.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tyb2.presentation.ui.theme.blueColor
import com.example.tyb2.presentation.ui.theme.greenColor
import com.example.tyb2.presentation.ui.theme.orangeColor
import com.example.tyb2.presentation.ui.theme.purpleColor
import com.example.tyb2.presentation.ui.theme.redColor
import com.example.tyb2.presentation.ui.theme.yellowColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun YogaRow() {
    val colors = listOf(redColor, greenColor, blueColor, purpleColor, orangeColor, yellowColor)
    val pagerState =
        rememberPagerState(pageCount = { Int.MAX_VALUE }, initialPage = Int.MAX_VALUE / 2)
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .height(144.dp)
            .background(purpleColor),
        pageSize = PageSize.Fixed(292.dp),
        contentPadding = PaddingValues(32.dp)
    ) { page ->
        val colorIndex = page % colors.size
        val color = colors[colorIndex]
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                //    TODO() Navigation
            }) {
                Card(
                    modifier = Modifier
                        .padding(horizontal = 8.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = color
                    )
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Page $colorIndex", color = redColor)
                    }
                }
            }
        }
    }
}