package com.vasquez.navegacion_fragmentacion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.vasquez.navegacion_fragmentacion.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    // Implementando DataBinding HomeFragment
    private lateinit var binding: FragmentHomeBinding

    // Implementando el ViewModel, le pondremos activityViewModels para compartirlo con la actividades
    private val viewModel: MainViewModel by activityViewModels()
    // Eliminar todo lo que no Usamos -> Importar DataBinding En HomeFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }
    // Implementando onViewCreated, para obtener el nombre
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //
        binding.viewModel = viewModel
        // donde este en el ciclo de vista se movera
        binding.lifecycleOwner = viewLifecycleOwner
        //
        val navController = findNavController()
        binding.actionContinu.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToSecondFragment()
            navController.navigate(action)
        }
    }
}
