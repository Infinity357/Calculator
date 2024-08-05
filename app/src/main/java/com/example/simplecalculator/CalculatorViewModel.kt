package com.example.simplecalculator

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    private var _state = mutableStateOf(CalcultorState())
//        private set //private set allows a variable to be read from outside but not be changed from outside
    val state: State<CalcultorState> = _state

    fun onAction(action: CalculatorAction){
        when(action){
            CalculatorAction.Answer -> Calculate()
            CalculatorAction.Clear -> _state = mutableStateOf(CalcultorState())
            CalculatorAction.Delete -> delete()
            CalculatorAction.inputDecimal -> inputDecimal()
            is CalculatorAction.inputNumber -> inputNumber(action.num)
            is CalculatorAction.inputOperation -> inputOpertor(action.operator)
        }
    }

    private fun inputOpertor(operator: Operator) {
        if(_state.value.num1.isNotBlank())
            _state.value = _state.value.copy(operator = operator)
    }

    private fun inputDecimal() {
        when{
            _state.value.operator==null && _state.value.num1.isNotBlank() && !_state.value.num1.contains(".")->
                _state.value = _state.value.copy(num1 = _state.value.num1+".")
            _state.value.operator!=null && _state.value.num2.isNotBlank() && !_state.value.num2.contains(".")->
                _state.value = _state.value.copy(num2 = _state.value.num2+".")
        }
    }

    private fun delete() {
        when{
            _state.value.num2.isNotBlank()->
                _state.value= _state.value.copy(num2 = _state.value.num2.dropLast(1))
            _state.value.operator!=null->
                _state.value=_state.value.copy(operator = null)
            _state.value.num1.isNotBlank()->
                _state.value = _state.value.copy(num1 = _state.value.num1.dropLast(1))
        }
    }

    private fun Calculate() {
        val num1 = _state.value.num1.toDoubleOrNull()
        val num2 = _state.value.num2.toDoubleOrNull()
        if(num1 != null && num2 != null){
        val ans = when(_state.value.operator){
                Operator.Add -> num1 + num2
                Operator.Divide -> num1 / num2
                Operator.Modulus -> num1 % num2
                Operator.Multiply -> num1*num2
                Operator.Subtract -> num1 - num2
                null -> TODO()
            }
            _state.value = _state.value.copy(
                num1 = ans.toString(),
                num2 = "",
                operator = null
            )
        }
    }

    private fun inputNumber(num: Int){
        if(_state.value.num1.isBlank())
            _state.value.copy(num1 = num.toString())
        else
            _state.value.copy(num2 = num.toString())
    }
}

