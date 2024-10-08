package com.example.simplecalculator

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplecalculator.ui.theme.BackgroundBlack
import com.example.simplecalculator.ui.theme.DarkGray
import com.example.simplecalculator.ui.theme.DarkPurple
import com.example.simplecalculator.ui.theme.LightGray

@Composable
fun CalculatorButton(
    modifier: Modifier = Modifier,
    content : String ,
    fontSize: TextUnit = 20.sp,
    backGroundColor: Color = DarkGray,
    fontColor : Color = Color.White,
    textPadding : Dp = 15.dp,
    onCLick:()->Unit ={}
){
    Box(modifier = Modifier
        .clip(RoundedCornerShape(corner = CornerSize(15.dp)))
        .clickable { onCLick() }
        .background(color = backGroundColor)
        .then(modifier),
        contentAlignment = Alignment.Center
    ){
        Text(text = content , fontSize = fontSize , color = fontColor , modifier = Modifier.padding(textPadding) )
    }
}

@Composable
fun CalculatorUI(
    state: State<String>,
    onAction: (CalculatorAction)->Unit
){

    var textPadding : Dp = 15.dp
    var DisplayWeight = 7f
    var ButtonText = 30.sp
    var ScreenText = 40.sp
    var ScreenPadding = 20.dp
    var ScreenLineHeight = 40.sp
    val  config = LocalConfiguration.current
    if(config.orientation == Configuration.ORIENTATION_LANDSCAPE){
        DisplayWeight = 3f
        textPadding = 5.dp
        ButtonText = 20.sp
        ScreenPadding = 10.dp
        ScreenText = 25.sp
        ScreenLineHeight = 25.sp
    }

    Box(modifier = Modifier.fillMaxSize().background(color = BackgroundBlack),
        contentAlignment = Alignment.BottomCenter){
        Column(modifier = Modifier.fillMaxWidth().padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            Text(text = state.value , modifier = Modifier
                .fillMaxWidth()
                .padding(ScreenPadding)
                .weight(DisplayWeight)
                .fillMaxHeight()
                , textAlign = TextAlign.End ,
                fontWeight = FontWeight.Bold ,
                maxLines = 10,
                fontSize = ScreenText,
                color = Color.White,
                lineHeight = ScreenLineHeight)

            Row (horizontalArrangement = Arrangement.spacedBy(15.dp) , modifier = Modifier.weight(1f)){
                CalculatorButton(content = "CE", modifier = Modifier.weight(1f) , fontSize = ButtonText, textPadding = textPadding , backGroundColor = LightGray, onCLick = {onAction(CalculatorAction.Clear)})
                CalculatorButton(content = "Del", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , backGroundColor = LightGray, onCLick = {onAction(CalculatorAction.Delete)})
                CalculatorButton(content = "%", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , backGroundColor = LightGray, onCLick = {onAction(CalculatorAction.inputOperation(Operator.Modulus))})
                CalculatorButton(content = "/", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , backGroundColor = LightGray, onCLick = {onAction(CalculatorAction.inputOperation(Operator.Divide))})
            }
            Row (horizontalArrangement = Arrangement.spacedBy(15.dp) , modifier = Modifier.weight(1f)){
                CalculatorButton(content = "7", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , onCLick = {onAction(CalculatorAction.inputNumber(7))})
                CalculatorButton(content = "8", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , onCLick = {onAction(CalculatorAction.inputNumber(8))})
                CalculatorButton(content = "9", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , onCLick = {onAction(CalculatorAction.inputNumber(9))})
                CalculatorButton(content = "*", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , backGroundColor = LightGray, onCLick = {onAction(CalculatorAction.inputOperation(Operator.Multiply))})
            }
            Row (horizontalArrangement = Arrangement.spacedBy(15.dp) , modifier = Modifier.weight(1f)){
                CalculatorButton(content = "4", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , onCLick = {onAction(CalculatorAction.inputNumber(4))})
                CalculatorButton(content = "5", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , onCLick = {onAction(CalculatorAction.inputNumber(5))})
                CalculatorButton(content = "6", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , onCLick = {onAction(CalculatorAction.inputNumber(6))})
                CalculatorButton(content = "-", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , backGroundColor = LightGray, onCLick = {onAction(CalculatorAction.inputOperation(Operator.Subtract))})
            }
            Row (horizontalArrangement = Arrangement.spacedBy(15.dp) , modifier = Modifier.weight(1f)){
                CalculatorButton(content = "1", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , onCLick = {onAction(CalculatorAction.inputNumber(1))})
                CalculatorButton(content = "2", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , onCLick = {onAction(CalculatorAction.inputNumber(2))})
                CalculatorButton(content = "3", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , onCLick = {onAction(CalculatorAction.inputNumber(3))})
                CalculatorButton(content = "+", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , backGroundColor = LightGray, onCLick = {onAction(CalculatorAction.inputOperation(Operator.Add))})
            }
            Row (horizontalArrangement = Arrangement.spacedBy(15.dp) , modifier = Modifier.weight(1f)){
                CalculatorButton(content = "^", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , onCLick = {onAction(CalculatorAction.inputOperation(Operator.Power))})
                CalculatorButton(content = "0", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , onCLick = {onAction(CalculatorAction.inputNumber(0))})
                CalculatorButton(content = ".", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , onCLick = {onAction(CalculatorAction.inputDecimal)})
                CalculatorButton(content = "=", modifier = Modifier.weight(1f), fontSize = ButtonText, textPadding = textPadding , backGroundColor = DarkPurple, onCLick = {onAction(CalculatorAction.Answer)})
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true )
@Composable
fun ButtonPreview() {
    var a = mutableStateOf("435555555555555555555555555555555555556666666666666666666666666666666666666666666666666666666666666666666")
    var z : State<String> = a
    CalculatorUI(a,{})
}