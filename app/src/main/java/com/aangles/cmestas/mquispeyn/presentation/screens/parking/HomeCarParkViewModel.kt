package com.aangles.cmestas.mquispeyn.presentation.screens.parking

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aangles.cmestas.mquispeyn.feature_db.domain.uses_cases.DeleteCarPark
import com.aangles.cmestas.mquispeyn.feature_db.domain.uses_cases.GetCarParks
import com.aangles.cmestas.mquispeyn.presentation.screens.users.UserEvent
import com.aangles.cmestas.mquispeyn.presentation.screens.users.UserListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeCarParkViewModel @Inject constructor(
    private val deleteCarPark: DeleteCarPark,
    getCarParks: GetCarParks
): ViewModel() {

    private val _state = mutableStateOf(CarParkListState())
    val state: State<CarParkListState> = _state

    init {
        getCarParks().onEach { carParks ->
            _state.value = state.value.copy(
                carParks = carParks
            )
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: CarParkEvent) {
        when (event) {
            is CarParkEvent.DeleteCarPark -> {
                viewModelScope.launch {
                    deleteCarPark(event.carPark)
                }
            }
        }
    }
}