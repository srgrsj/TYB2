package com.example.tyb2.domain.user.model

import com.example.tyb2.R
import java.util.UUID

data class User(
    val email: String,
    val id: String = UUID.randomUUID().toString(),
//    val profilePictureUrl: String? = null,
//    val username: String,
//    val categories:
//    val achievements
)



data class Achievement(
    val picture: Int,
    val title: String,
    val description: String,
    val isAchieved: Boolean
)

val userAchievementsList = listOf(
//    TODO
    Achievement(
        picture = R.drawable.achievement_blue_red,
        title = "Первый шаг",
        description = "Завершите свою первую тренировку",
        isAchieved = false
    ),
    Achievement(
        picture = R.drawable.achievement_blue,
        title = "",
        description = "Выполните тренировки на все группы мышцы",
        isAchieved = false
    ),
    Achievement(
        picture = R.drawable.achievement_red,
        title = "Стабильность - залог успеха",
        description = "Тренируйтесь каждый день на протяжении недели",
        isAchieved = false
    ),
    Achievement(
        picture = R.drawable.achievement_purple,
        title = "Вселенский баланс",
        description = "Начните заниматься йогой",
        isAchieved = false
    ),
    Achievement(
        picture = R.drawable.achievement_green,
        title = "",
        description = "Попробуйте все виды йоги",
        isAchieved = false
    ),
    Achievement(
        picture = R.drawable.achievement_black,
        title = "Вижу цель не вижу препятствий",
        description = "Занимайтесь беспрерывно на протяжении месяца",
        isAchieved = false
    )
)