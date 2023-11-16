package com.example.corecomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()

        }
    }
}

//All states will be in MainScreen composable
@Composable
fun MainScreen(){
    val listOfItemsState=
        remember {
            mutableStateListOf<String>("John","Kane")
        }
    val newNameState= remember {
        mutableStateOf("")
    }

    Surface(color = Color.DarkGray, modifier =
    Modifier.fillMaxSize()) {
        Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
//            Text(text = "Wrapped content", modifier = Modifier
//                .wrapContentSize()
//                .padding(10.dp),
//                style = MaterialTheme.typography.headlineMedium
//            )
            Column(verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally) {
                RenderGreetItem(listOfItemsState ,
                { listOfItemsState.add(newNameState.value) },
                newNameState.value,
                    {newName->newNameState.value=newName}

                )
            }
        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RenderGreetItem(
    listOfItemsState: SnapshotStateList<String>,
    buttonClick: () -> Unit,
    textFieldValue: String,
    textFieldUpdate:(newName:String)->Unit
) {

    for(name in listOfItemsState){
        Text(text = name, style = MaterialTheme.typography.labelLarge)
    }

    TextField(value = textFieldValue, onValueChange = textFieldUpdate)

    Button(onClick = buttonClick) {
        Text(text = "Add new name")
    }

}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainScreen()
}