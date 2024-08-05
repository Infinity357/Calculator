package com.example.simplecalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
    state: State<CalcultorState>,
    onAction: (CalculatorAction)->Unit
){
    Box(modifier = Modifier.fillMaxSize().background(color = BackgroundBlack),
        contentAlignment = Alignment.BottomCenter){
        Column(modifier = Modifier.fillMaxWidth().padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            Text(text = state.value.num1 + (state.value.operator?:"")+state.value.num2 , modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .weight(7f)
                , textAlign = TextAlign.End , maxLines = 2 , fontWeight = FontWeight.Bold , fontSize = 60.sp)

            Row (horizontalArrangement = Arrangement.spacedBy(15.dp) , modifier = Modifier.weight(1f)){
                CalculatorButton(content = "AC", modifier = Modifier.weight(1f) , fontSize = 30.sp, backGroundColor = LightGray, onCLick = {onAction(CalculatorAction.Clear)})
                CalculatorButton(content = "Del", modifier = Modifier.weight(1f), fontSize = 30.sp, backGroundColor = LightGray, onCLick = {onAction(CalculatorAction.Delete)})
                CalculatorButton(content = "%", modifier = Modifier.weight(1f), fontSize = 30.sp, backGroundColor = LightGray, onCLick = {onAction(CalculatorAction.inputOperation(Operator.Modulus))})
                CalculatorButton(content = "/", modifier = Modifier.weight(1f), fontSize = 30.sp, backGroundColor = LightGray, onCLick = {onAction(CalculatorAction.inputOperation(Operator.Divide))})
            }
            Row (horizontalArrangement = Arrangement.spacedBy(15.dp) , modifier = Modifier.weight(1f)){
                CalculatorButton(content = "7", modifier = Modifier.weight(1f), fontSize = 30.sp, onCLick = {onAction(CalculatorAction.inputNumber(7))})
                CalculatorButton(content = "8", modifier = Modifier.weight(1f), fontSize = 30.sp, onCLick = {onAction(CalculatorAction.inputNumber(8))})
                CalculatorButton(content = "9", modifier = Modifier.weight(1f), fontSize = 30.sp, onCLick = {onAction(CalculatorAction.inputNumber(9))})
                CalculatorButton(content = "*", modifier = Modifier.weight(1f), fontSize = 30.sp, backGroundColor = LightGray, onCLick = {onAction(CalculatorAction.inputOperation(Operator.Multiply))})
            }
            Row (horizontalArrangement = Arrangement.spacedBy(15.dp) , modifier = Modifier.weight(1f)){
                CalculatorButton(content = "4", modifier = Modifier.weight(1f), fontSize = 30.sp, onCLick = {onAction(CalculatorAction.inputNumber(4))})
                CalculatorButton(content = "5", modifier = Modifier.weight(1f), fontSize = 30.sp, onCLick = {onAction(CalculatorAction.inputNumber(5))})
                CalculatorButton(content = "6", modifier = Modifier.weight(1f), fontSize = 30.sp, onCLick = {onAction(CalculatorAction.inputNumber(6))})
                CalculatorButton(content = "-", modifier = Modifier.weight(1f), fontSize = 30.sp, backGroundColor = LightGray, onCLick = {onAction(CalculatorAction.inputOperation(Operator.Subtract))})
            }
            Row (horizontalArrangement = Arrangement.spacedBy(15.dp) , modifier = Modifier.weight(1f)){
                CalculatorButton(content = "1", modifier = Modifier.weight(1f), fontSize = 30.sp, onCLick = {onAction(CalculatorAction.inputNumber(1))})
                CalculatorButton(content = "2", modifier = Modifier.weight(1f), fontSize = 30.sp, onCLick = {onAction(CalculatorAction.inputNumber(2))})
                CalculatorButton(content = "3", modifier = Modifier.weight(1f), fontSize = 30.sp, onCLick = {onAction(CalculatorAction.inputNumber(3))})
                CalculatorButton(content = "+", modifier = Modifier.weight(1f), fontSize = 30.sp, backGroundColor = LightGray, onCLick = {onAction(CalculatorAction.inputOperation(Operator.Add))})
            }
            Row (horizontalArrangement = Arrangement.spacedBy(15.dp) , modifier = Modifier.weight(1f)){
                CalculatorButton(content = "00", modifier = Modifier.weight(1f), fontSize = 30.sp, onCLick = {onAction(CalculatorAction.inputNumber(-1))})
                CalculatorButton(content = "0", modifier = Modifier.weight(1f), fontSize = 30.sp, onCLick = {onAction(CalculatorAction.inputNumber(0))})
                CalculatorButton(content = ".", modifier = Modifier.weight(1f), fontSize = 30.sp, onCLick = {onAction(CalculatorAction.inputDecimal)})
                CalculatorButton(content = "=", modifier = Modifier.weight(1f), fontSize = 30.sp , backGroundColor = DarkPurple, onCLick = {onAction(CalculatorAction.Answer)})
            }
        }
    }
}

@Preview(showBackground = true )
@Composable
fun ButtonPreview() {
//    CalculatorUI()
}