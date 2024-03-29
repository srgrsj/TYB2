package com.example.tyb2.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.commandiron.wheel_picker_compose.core.WheelPickerDefaults
import com.commandiron.wheel_picker_compose.core.WheelTextPicker
import com.example.tyb2.presentation.ui.theme.Typography

@Composable
fun TimePicker(
    value: MutableState<Long>
) {
    val minList = generateListOfNumbers(0, 59)
    val secList = generateListOfNumbers(1, 59)

    var min by remember { mutableStateOf(0) }

    var sec by remember { mutableStateOf(0) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clip(
                RoundedCornerShape(15.dp)
            )
            .background(MaterialTheme.colorScheme.background)
    ) {
        WheelTextPicker(
            texts = minList,
            rowCount = 1,
            size = DpSize(128.dp, 50.dp),
            style = Typography.headlineMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            onScrollFinished = { snappedIndex ->
                min = minList[snappedIndex].toInt()
                value.value = convertToMilliseconds(min, sec)
                null
            },
            selectorProperties = WheelPickerDefaults.selectorProperties(
                color = MaterialTheme.colorScheme.background,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.background)
            )
        )
        Text(
            text = ":",
            style = Typography.headlineMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .padding(horizontal = 5.dp)
        )

        WheelTextPicker(
            texts = secList,
            rowCount = 1,
            size = DpSize(128.dp, 50.dp),
            style = Typography.headlineMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            onScrollFinished = { snappedIndex ->
                sec = secList[snappedIndex].toInt()
                value.value = convertToMilliseconds(min, sec)
                null
            },
            selectorProperties = WheelPickerDefaults.selectorProperties(
                color = MaterialTheme.colorScheme.background,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.background)
            )
        )
    }

}

fun generateListOfNumbers(from: Int, to: Int): List<String> {
    val listOfNumbers = mutableListOf<String>()
    for (i in from..to) {
        listOfNumbers.add(i.toString())
    }
    return listOfNumbers
}

fun convertToMilliseconds(min: Int, sec: Int): Long {
    val totalSeconds = min * 60 + sec
    return totalSeconds * 1000L
}

@SuppressLint("UnrememberedMutableState")
@Composable
@Preview
fun PreviewTimePicker() {
    TimePicker(value = mutableStateOf(0L))
}