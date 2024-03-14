package com.example.tyb2.presentation.screens.initial.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    onboardingViewModel: OnboardingViewModel
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            val pagerState = rememberPagerState(initialPage = 0, pageCount = {3})
            val scope = rememberCoroutineScope()
            val currentPage = pagerState.currentPage
            HorizontalPager(state = pagerState) {
                when(it) {
                    0 ->{ OnBoardingPageOne()}
                    1 ->{ OnBoardingPageTwo()}
                    2 ->{ OnBoardingPageThree() }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PageIndicator(pageSize = 3, selectedPage = currentPage)
                OnBoardingButton(
                    currentPage = currentPage,
                    onNextClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(currentPage + 1)
                        }
                    },
                    onBackClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(currentPage - 1)
                        }
                    },
                    onGetStarted = {
//                        onboardingViewModel.saveAppEntry()
                    }
                )
            }
        }
    }
}

