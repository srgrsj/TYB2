package com.example.tyb2.util

import androidx.compose.ui.graphics.Color
import com.example.tyb2.R
import com.example.tyb2.presentation.ui.theme.blueColor
import com.example.tyb2.presentation.ui.theme.greenColor
import com.example.tyb2.presentation.ui.theme.orangeColor
import com.example.tyb2.presentation.ui.theme.purpleColor
import com.example.tyb2.presentation.ui.theme.redColor
import com.example.tyb2.presentation.ui.theme.yellowColor

object MuscleStuff {
    val allMuscleList = listOf(
        Muscle.BREAST,
        Muscle.BACK_TRAPEZOID, Muscle.BACK_WIDE,
        Muscle.ARM_FOREARM, Muscle.ARM_BICEPS, Muscle.ARM_TRICEPS,
        Muscle.CORE_STRAIGHT, Muscle.CORE_LATERAL_ABDOMINAL, Muscle.CORE_LUMBAR,
        Muscle.BRACHIAL_BACK, Muscle.BRACHIAL_FRONT,
        Muscle.LEG_QUADRICEPS, Muscle.LEG_THIGHS, Muscle.LEG_CALF
    )

    fun defineColor(muscleGroup: MuscleGroup): Color {
        val color = when (muscleGroup) {
            MuscleGroup.LEG -> greenColor
            MuscleGroup.CORE -> purpleColor
            MuscleGroup.BRACHIAL -> yellowColor
            MuscleGroup.BACK -> blueColor
            MuscleGroup.BREAST -> redColor
            MuscleGroup.ARM -> orangeColor
        }
        return color
    }

    fun defineGroup(muscle: Muscle): MuscleGroup {
        val group = when (muscle) {
            Muscle.BREAST -> MuscleGroup.BREAST
            Muscle.ARM_BICEPS -> MuscleGroup.ARM
            Muscle.ARM_FOREARM -> MuscleGroup.ARM
            Muscle.ARM_TRICEPS -> MuscleGroup.ARM
            Muscle.BACK_TRAPEZOID -> MuscleGroup.BACK
            Muscle.BACK_WIDE -> MuscleGroup.BACK
            Muscle.BRACHIAL_BACK -> MuscleGroup.BRACHIAL
            Muscle.BRACHIAL_FRONT -> MuscleGroup.BRACHIAL
            Muscle.CORE_LATERAL_ABDOMINAL -> MuscleGroup.CORE
            Muscle.CORE_LUMBAR -> MuscleGroup.CORE
            Muscle.CORE_STRAIGHT -> MuscleGroup.CORE
            Muscle.LEG_CALF -> MuscleGroup.LEG
            Muscle.LEG_THIGHS -> MuscleGroup.LEG
            Muscle.LEG_QUADRICEPS -> MuscleGroup.LEG
        }
        return group
    }

    fun defineTitle(muscleGroup: MuscleGroup): String {
        val title = when (muscleGroup) {
//            MuscleGroup.ARM -> "Arms"
//            MuscleGroup.BACK -> "Back"
//            MuscleGroup.BRACHIAL -> "Brachial"
//            MuscleGroup.CORE -> "Core"
//            MuscleGroup.LEG -> "Leg"
//            MuscleGroup.BREAST -> "Breast"

            MuscleGroup.ARM -> "Руки"
            MuscleGroup.BACK -> "Спина"
            MuscleGroup.BRACHIAL -> "Плечи"
            MuscleGroup.CORE -> "Пресс"
            MuscleGroup.LEG -> "Ноги"
            MuscleGroup.BREAST -> "Грудь"
        }
        return title
    }

    fun definePicture(muscle: Muscle): Int {
        val picture = when (muscle) {
            Muscle.BREAST -> R.drawable.muscles_thoracic
            Muscle.ARM_BICEPS -> R.drawable.muscles_arm_biceps
            Muscle.ARM_FOREARM -> R.drawable.muscles_arm_forearm
            Muscle.ARM_TRICEPS -> R.drawable.muscles_arm_triceps
            Muscle.BACK_TRAPEZOID -> R.drawable.muscles_back_trapezoid
            Muscle.BACK_WIDE -> R.drawable.muscles_back_wide
            Muscle.BRACHIAL_BACK -> R.drawable.muscles_brachial_back
            Muscle.BRACHIAL_FRONT -> R.drawable.muscles_brachial_front
            Muscle.CORE_LATERAL_ABDOMINAL -> R.drawable.muscles_core_lateral_abdominal
            Muscle.CORE_LUMBAR -> R.drawable.muscles_core_lumbar
            Muscle.CORE_STRAIGHT -> R.drawable.muscles_core_straight
            Muscle.LEG_CALF -> R.drawable.muscles_leg_calf
            Muscle.LEG_THIGHS -> R.drawable.muscles_leg_thighs
            Muscle.LEG_QUADRICEPS -> R.drawable.muscles_leg_quadriceps
        }
        return picture
    }
}

enum class Muscle {
    BREAST,
    BACK_TRAPEZOID, BACK_WIDE,
    ARM_FOREARM, ARM_BICEPS, ARM_TRICEPS,
    CORE_STRAIGHT, CORE_LATERAL_ABDOMINAL, CORE_LUMBAR,
    BRACHIAL_BACK, BRACHIAL_FRONT,
    LEG_QUADRICEPS, LEG_THIGHS, LEG_CALF
}

enum class MuscleGroup {
    BREAST,
    BACK,
    ARM,
    CORE,
    BRACHIAL,
    LEG
}
