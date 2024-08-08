package com.example.simplecalculator

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.*

class CalculatorViewModel: ViewModel() {
    val rep = CalculatorModel()
    private var _state = mutableStateOf(rep.getState().value)
    val state: State<String> = _state

    fun onAction(action: CalculatorAction) {
        when (action) {
            CalculatorAction.Answer -> {
                rep.Calculate()
                _state.value = rep.getState().value
            }
            CalculatorAction.Clear -> {
                rep.clear()
                _state.value = rep.getState().value
            }
            CalculatorAction.Delete -> {
                rep.delete()
                _state.value = rep.getState().value
            }
            CalculatorAction.inputDecimal -> {
                rep.inputDecimal()
                _state.value = rep.getState().value
            }
            is CalculatorAction.inputNumber -> {
                rep.inputNumber(action.num)
                _state.value = rep.getState().value
            }
            is CalculatorAction.inputOperation -> {
                rep.inputOpertor(action.operator)
                _state.value = rep.getState().value
            }
        }
    }
}

