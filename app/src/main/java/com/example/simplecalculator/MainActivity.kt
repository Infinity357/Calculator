package com.example.simplecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.simplecalculator.ui.theme.SimpleCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleCalculatorTheme (darkTheme = true) {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                CalculatorUI(state = state , onAction = {viewModel::onAction})
            }
        }
    }
}
