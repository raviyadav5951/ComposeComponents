package com.example.corecomposeapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    val textFieldState= MutableLiveData<String>("")

    fun onTextChanged(newText:String){
        textFieldState.value=newText
    }
}