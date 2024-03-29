package com.example.tyb2.domain.user.model

import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.example.tyb2.R
import java.util.UUID

data class User(
    val email: String,
    val id: String = UUID.randomUUID().toString(),
//    val profilePictureUrl: String? = null,
//    val username: String,
//    val categories:
    val achievements: List<Achievement> = userAchievementsList,
    val userGender: String = "n" // TODO m / w / n
)


data class Achievement(
    val picture: Int,
    val title: String,
    val description: String,
    val isAchieved: Boolean,
    val achievementType: AchievementType
)

val userAchievementsList = listOf(
//    TODO
    Achievement(
        picture = R.drawable.achievement_blue_red,
        title = "Первый шаг",
        description = "Завершите свою первую тренировку",
        isAchieved = false,
        achievementType = AchievementType.FIRST_TRAIN
    ),
    Achievement(
        picture = R.drawable.achievement_blue,
        title = "Гармония тела",
        description = "Выполните тренировки на все группы мышцы",
        isAchieved = false,
        achievementType = AchievementType.FULL_MUSCLES
    ),
    Achievement(
        picture = R.drawable.achievement_red,
        title = "Стабильность - залог успеха",
        description = "Тренируйтесь каждый день на протяжении недели",
        isAchieved = false,
        achievementType = AchievementType.WEEK_TRAINING
    ),
    Achievement(
        picture = R.drawable.achievement_purple,
        title = "Вселенский баланс",
        description = "Начните заниматься йогой",
        isAchieved = false,
        achievementType = AchievementType.FIRST_YOGA
    ),
    Achievement(
        picture = R.drawable.achievement_green,
        title = "Полной грудью",
        description = "Попробуйте все виды йоги",
        isAchieved = false,
        achievementType = AchievementType.FULL_YOGA
    ),
    Achievement(
        picture = R.drawable.achievement_black,
        title = "Не вижу препятствий",
        description = "Занимайтесь беспрерывно на протяжении месяца",
        isAchieved = false,
        achievementType = AchievementType.MONTH_TRAINING
    )
)

enum class AchievementType {
    FIRST_TRAIN, FULL_MUSCLES, WEEK_TRAINING,
    FIRST_YOGA, FULL_YOGA, MONTH_TRAINING
}