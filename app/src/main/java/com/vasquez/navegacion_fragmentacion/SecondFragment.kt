package com.vasquez.navegacion_fragmentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.vasquez.navegacion_fragmentacion.databinding.FragmentSecondBinding

// 1. 0 Borrar todo lo que no necesitamos
class SecondFragment : Fragment() {
//3.0 declarar  de un elemento
    private lateinit var binding: FragmentSecondBinding

    private val viewModel: MainViewModel by activityViewModels()
 //2.0 declarando la construccion del objeto que el navArgs ya viene en la libreria.
    val args: SecondFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inicializar el DataBinding, aqui es inflate porque devuelve con su direccion y el contenerdor, en el return devolvemos todo lo creado
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        return binding.root
    }
    // Con esta funcion ya podremos modificar la vista, aqui solo se muestra
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Para pasar el argumento del MainActivity
       // binding.greetingTextView.text = getString(R.string.greeting_text, args.name)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        val navController = findNavController()
        binding.actionContinu.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToResultFragment()
            navController.navigate(action)
        }
    }
}