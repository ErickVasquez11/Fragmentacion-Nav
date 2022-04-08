package com.vasquez.navegacion_fragmentacion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// Vamos a Extender View Model
class MainViewModel: ViewModel(){
    // Declarar 2 valores , lo que queremos que ingrese el usuario, el nombre lo guardaremos en HomeFragment y el LastName en SecondFragment
    var name = MutableLiveData("")
    var lastName = MutableLiveData("")
    var university = MutableLiveData("")
    var gender = MutableLiveData("")
    var birthday = MutableLiveData("")
    var email = MutableLiveData("")
    var phone = MutableLiveData("")
    var carrer = MutableLiveData("")



}