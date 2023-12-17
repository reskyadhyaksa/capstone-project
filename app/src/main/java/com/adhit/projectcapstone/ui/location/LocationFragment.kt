package com.adhit.projectcapstone.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.adhit.projectcapstone.databinding.FragmentLocationBinding

class LocationFragment : Fragment() {

    private var _binding: FragmentLocationBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val locationViewModel =
            ViewModelProvider(this).get(LocationViewModel::class.java)

        _binding = FragmentLocationBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val searchView: View = binding.searchView
        val textView: TextView = binding.textLocation
        locationViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
