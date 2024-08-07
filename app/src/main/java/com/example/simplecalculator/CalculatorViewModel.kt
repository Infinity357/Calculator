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

//    private fun inputOpertor(operator: Operator) {
//        if (_state.value.isNotBlank() && _state.value.get(_state.value.length-1).isDigit())
//            _state.value = _state.value+operator.operator
//    }
//
//    private fun inputDecimal() {
//        if(_state.value.isEmpty() || !_state.value.get(_state.value.length-1).isDigit()){
//            _state.value = _state.value + "0."
//            return
//        }
//        var num = ""
//        for (i in _state.value.length - 1 downTo 0) {
//            if (_state.value.get(i).isDigit())
//                num = num + _state.value.get(i)
//            else
//                break;
//        }
//        if (!_state.value.contains("."))
//            _state.value = _state.value + "."
//    }
//
//    private fun delete() {
//        if(_state.value.isNotBlank()){
//            _state.value = _state.value.dropLast(1)
//        }
//    }
//
//    private fun Calculate() {
//        if(_state.value.isEmpty())
//            return
//        val postfix: String = infixToPostfix(_state.value)
//        val ans: Double = evaluatePostfix(postfix)
//        _state.value = ans.toString()
//    }
//
//    private fun inputNumber(num: Int) {
//        _state.value = _state.value + num.toString()
//    }
//
//    private fun precedence(op: Char): Int {
//        return when (op) {
//            '+', '-' -> 1
//            '*', '/', '%' -> 2
//            '^' -> 3
//            else -> -1
//        }
//    }
//
//    private fun isOperator(c: Char): Boolean {
//        return c in listOf('+', '-', '*', '/', '%', '^')
//    }
//
//    private fun isOperator(token: String): Boolean {
//        return token in listOf("+", "-", "*", "/", "%","^")
//    }
//
//    private fun applyOperator(op: Char, left: Double, right: Double): Double {
//        return when (op) {
//            '+' -> left + right
//            '-' -> left - right
//            '*' -> left * right
//            '/' -> left / right
//            '%' -> left % right
//            '^' -> Math.pow(left , right)
//            else -> throw IllegalArgumentException("Invalid operator: $op")
//        }
//    }
//
//    fun infixToPostfix(infix: String?): String {
//        val stack = Stack<Char>()
//        val postfix = StringBuilder()
//
//        val tokens = StringTokenizer(infix, "()+-*/^% ", true)
//
//        while (tokens.hasMoreTokens()) {
//            val token = tokens.nextToken().trim { it <= ' ' }
//
//            if (token.isEmpty()) continue
//
//            val ch = token[0]
//
//            if (Character.isLetterOrDigit(ch)) {
//                postfix.append(token).append(' ')
//            } else if (ch == '(') {
//                stack.push(ch)
//            } else if (ch == ')') {
//                while (stack.isNotEmpty() && stack.peek() != '(') {
//                    postfix.append(stack.pop()).append(' ')
//                }
//                if (stack.isNotEmpty() && stack.peek() == '(') {
//                    stack.pop()
//                }
//            } else if (isOperator(ch)) {
//                while (stack.isNotEmpty() && precedence(stack.peek()) >= precedence(ch)) {
//                    postfix.append(stack.pop()).append(' ')
//                }
//                stack.push(ch)
//            }
//        }
//
//        while (stack.isNotEmpty()) {
//            postfix.append(stack.pop()).append(' ')
//        }
//
//        return postfix.toString().trim { it <= ' ' }
//    }
//
//    fun evaluatePostfix(postfix: String): Double {
//        val stack = Stack<Double>()
//        val tokens = postfix.split("\\s+".toRegex()).filter { it.isNotEmpty() }
//
//        for (token in tokens) {
//            if (isOperator(token)) {
//                val rightOperand = stack.pop()
//                val leftOperand = stack.pop()
//                val result: Double = applyOperator(token[0], leftOperand, rightOperand)
//                stack.push(result)
//            } else {
//                stack.push(token.toDoubleOrNull() ?: throw NumberFormatException("Invalid number: $token"))
//            }
//        }
//
//        return stack.pop()
//    }

}

