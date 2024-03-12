package com.example.tyb2.presentation.screens.generators.defaultGenerator

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tyb2.R
import com.example.tyb2.presentation.ui.theme.Typography
import com.example.tyb2.util.Muscle
import com.example.tyb2.util.MuscleStuff

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DefaultGenerator(
//    navController: NavController,
//    viewModel: DefaultGeneratorViewModel = hiltViewModel()
) {
    var searchBarValue by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 52.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .height(50.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                SearchBar(
                    colors = SearchBarDefaults.colors(MaterialTheme.colorScheme.onPrimary),
                    shape = RoundedCornerShape(10.dp),
                    query = searchBarValue,
                    onQueryChange = { searchBarValue = it },
                    onSearch = {},
                    active = false,
                    placeholder = {
                        Text(
                            text = "Search by exercises",
                            style = Typography.labelMedium.copy(fontSize = 16.sp),
                            color = MaterialTheme.colorScheme.primary
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.icon_search),
                            contentDescription = "",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    onActiveChange = {},
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .height(50.dp)

                ) {}
            }

            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 20.dp, top = 5.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_left_arrow),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .scale(1.78f)
                )
            }
        }

        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 15.dp)
            ) {
                Text(
                    text = "Группы мышц",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = Typography.headlineMedium
                )
            }

            LazyRow(
                content = {
                    MuscleStuff.allMuscleList.forEach() {
                        item {
                            MuscleBox(muscle = it)
                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }
                },
                modifier = Modifier
                    .padding(start = 15.dp, top = 10.dp)
            )

        }

    }
}

@Composable
fun MuscleBox(muscle: Muscle) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    val border by animateDpAsState(
        targetValue = if (isSelected) 5.dp else 0.dp,
        label = "",
        animationSpec = tween(
            durationMillis = 500
        )

    )
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.onPrimary)
            .size(150.dp)
            .border(
                border,
                MuscleStuff.defineColor(MuscleStuff.defineGroup(muscle)),
                RoundedCornerShape(10.dp)
            )
            .clickable {
                isSelected = !isSelected
            }
    ) {
        Image(
            painter = painterResource(id = MuscleStuff.definePicture(muscle)),
            contentDescription = null,
            modifier = Modifier.scale(2.5f)

        )
    }
}
//ПАМЯТКА ЧТО СДЕЛАТЬ А ТО ЗАБУДУ.
//крч во вьюмодели создан лист с мышцами и
//нужно короче когда выбрано их добавлять туда
//ну короче разберешься мысль ты понял