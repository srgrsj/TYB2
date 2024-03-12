package com.example.tyb2.presentation.screens.generators.defaultGenerator

import androidx.lifecycle.viewModelScope
import com.example.tyb2.domain.exercise.usecase.ExerciseUseCase
import com.example.tyb2.domain.exersice.model.Exercise
import com.example.tyb2.domain.workout.usecases.WorkoutUseCase
import com.example.tyb2.presentation.screens.generators.GeneratorsScreenViewModel
import com.example.tyb2.util.Muscle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DefaultGeneratorViewModel @Inject constructor(
    private val exerciseUseCase: ExerciseUseCase,
    workoutUseCase: WorkoutUseCase
) : GeneratorsScreenViewModel(workoutUseCase) {

    private var _muscleList = MutableStateFlow(listOf<Muscle>())
    val muscleList: StateFlow<List<Muscle>> = _muscleList.asStateFlow()


    private var _exerciseList = MutableStateFlow(listOf<Exercise>())
    val exerciseList: StateFlow<List<Exercise>> = _exerciseList.asStateFlow()

    //Exercise
    private val _showAddExerciseDialog = MutableStateFlow(false)
    val showAddExerciseDialog: StateFlow<Boolean> = _showAddExerciseDialog.asStateFlow()

    fun showAddExerciseAlertDialog() {
        _showAddExerciseDialog.value = true
    }

    fun hideAddExerciseAlertDialog() {
        _showAddExerciseDialog.value = false
    }

    fun saveExerciseToExerciseList(exercise: Exercise) {
        val eList = exerciseList.value.toMutableList()
        eList.add(exercise)
        viewModelScope.launch {
            _exerciseList.emit(eList)
        }
    }

    fun deleteExerciseFromExerciseList(exercise: Exercise) {
        val eList = exerciseList.value.toMutableList()
        eList.remove(exercise)
        viewModelScope.launch {
            _exerciseList.emit(eList)
        }
    }


    //Workout
    private val _showSaveWorkoutDialog = MutableStateFlow(false)
    val showSaveWorkoutDialog: StateFlow<Boolean> = _showSaveWorkoutDialog.asStateFlow()

    fun showSaveWorkoutAlertDialog() {
        _showSaveWorkoutDialog.value = true
    }

    fun hideSaveWorkoutAlertDialog() {
        _showSaveWorkoutDialog.value = false
    }

}