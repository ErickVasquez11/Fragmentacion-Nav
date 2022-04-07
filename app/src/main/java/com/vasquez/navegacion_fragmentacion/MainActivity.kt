package com.vasquez.navegacion_fragmentacion

// https://developer.android.com/jetpack/androidx/releases/activity
// Añadir Librerias necesarias que nos permiten el uso del ViewModel, tanto para los fragmentos y activar DataBinding
    // 1.0 La propiedad Activity, que la llevaremos a
        // Gradle Scripts
            // Build.gradle del projecto en esta caso seria - build.gradle(Project: Navegacion-Fragmentacion)
                // Pondriamos abajo de Pulgins, despues del ultimo corchete antes de task clean(type:Delete) {
            // pondremos
                // ext {
                    // activity_version = "1.4.0"
                // }
            // depues la libreria la mandaremos a buil.gradle(Module: Navegacion-Fragmentacion.app)
                // La pondremos en la categoria de dependencies {
                    // debajo de ->   implementation 'androidx.constraintlayout:constraintlayout:2.1.3'
                    // implementation "androidx.activity:activity-ktx:$activity_version"
                // }
//----- Hoy vamos con la Fragmentacion -> https://developer.android.com/jetpack/androidx/releases/fragment
    //   // 2.0 La propiedad Activity, que la llevaremos a
//        // Gradle Scripts
//            // Build.gradle del projecto en esta caso seria - build.gradle(Project: Navegacion-Fragmentacion)
//                // Pondriamos abajo de Pulgins, despues del ultimo corchete antes de task clean(type:Delete) {
//            // pondremos
//                // ext {
//                    // fragment_version = "1.4.1"
//                // }
// depues la libreria la mandaremos a buil.gradle(Module: Navegacion-Fragmentacion.app)
// La pondremos en la categoria de dependencies {
// debajo de ->  implementation "androidx.activity:activity-ktx:$activity_version"
// El cual es la dependencia de Kotlin asi como la implementacion de Testing
// implementation "androidx.fragment:fragment-ktx:$fragment_version"
// Testing
// debugImplementation "androidx.fragment:fragment-testing:$fragment_version"
// }

// ------ Ahora vamos con DataBinding  ->https://developer.android.com/jetpack/androidx/releases/databinding
// Que ese ira buil.gradle(Module: Navegacion-Fragmentacion.app) en la parte de :
// Justo debajo de defaultConfig {}
//buildFeatures {
  //  dataBinding true
//}

//------- Ahora vamos con Navigation -> https://developer.android.com/jetpack/androidx/releases/navigation
    // 1.0 Primero sacaremos la version del Navigation para - > build.gradle(Project: Navigacion-Fragmentacion)
    // que seria -> nav_version = "2.4.1"
        // 2.0 Ahora añadimos las dependencias en buil.gradle(Module: Navegacion-Fragmentacion.app)
            // Agregaremos las primeras dos dependencias de Kotlin
                    // Kotlin
                        //  implementation "androidx.navigation:navigation-fragment-ktx:$nav_version"
                        //  implementation "androidx.navigation:navigation-ui-ktx:$nav_version"
        // 3.0 Implementaremos tambien  Tesing Navigation en buil.gradle(Module: Navegacion-Fragmentacion.app)
                // ->Testing Navigation
            //  androidTestImplementation "androidx.navigation:navigation-testing:$nav_version"
        // 4.0 Implementaremos tambien Safe Args
            // Incluiremos -> classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
                // En build.gradle(Project: Navegacion-Fragmentacion)
                // dependencies {
                    //classpath "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
                //}
        // 5.0 Dentro del buil.gradle(Module: Navegacion-Fragmentacion.app)
            // Añadiremos un Plugins para poder hacer uso de la navegacion
                // id 'androidx.navigation.safeargs.kotlin'

// IMPORTANTE
    // Ver el orden build.gradle(Project: Navegacion-Fragmentacion)

// En El Archivo RES, crear un archivo grafico de navegacion
    //Click Derecho, Nuevo, Android Resource File y le pondremos de
    // File Name: -> nav_graph
    // Resource type: -> Navigation
// Crear Fragmentos en com.vasquez.navegacion_fragmentacion
    // com.vasquez.navegacion_fragmentacion + Click Derecho * New * Fragment + Fragment (Blank)
    // Fragment Name -> HomeFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.vasquez.navegacion_fragmentacion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // Creando binding: ActivityMainBinding
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Creamos que el Data binding se enlace con el activity main
       binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // Lo que hacemos es buscar adentro  del NavHostFragment el contralador de navegacion y apartir de eso
        // podemos controlar como se navega
        val navHomeFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHomeFragment.navController

            // Con el binding se cambia, para pasar al otro fragmento
        binding.actionChange.setOnClickListener {
            // la acccion es la que se nombro con la flecha, que es de HomeFragment a SecondFragment
           // navController.navigate(R.id.action_homeFragment_to_secondFragment)
            // Se manda a llamar l segundo fragmento de golpe
            navController.navigate(R.id.secondFragment)
        }

    }
}
