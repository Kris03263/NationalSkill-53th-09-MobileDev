package com.example.myapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myapplication.databinding.FragmentBuyTicketBinding

class BuyTicketFragment : Fragment() {

    companion object {
        fun newInstance() = BuyTicketFragment()
    }

    private lateinit var viewModel: BuyTicketViewModel
    private lateinit var binding : FragmentBuyTicketBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuyTicketBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.confrimButton.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_BuyTicketFragment_to_buyControlFragment)
        }
    }
}