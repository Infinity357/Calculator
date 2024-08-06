package com.example.simplecalculator

sealed class CalculatorAction {
    data class inputNumber(val num : Int) : CalculatorAction()
    data class inputOperation(val operator : Operator) : CalculatorAction()
    object inputDecimal : CalculatorAction()
    object Clear : CalculatorAction()
    object Delete : CalculatorAction()
    object Answer : CalculatorAction()
}

sealed class Operator(val operator : String){
    object Add : Operator("+")
    object Subtract : Operator("-")
    object Multiply : Operator("*")
    object Divide : Operator("/")
    object Modulus : Operator("%")
    object Power : Operator("^")
}