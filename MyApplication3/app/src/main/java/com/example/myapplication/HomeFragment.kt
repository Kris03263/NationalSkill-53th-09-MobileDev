package com.example.myapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding.commentButton.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_HomeFragment_to_CommentFragment)
        }
        binding.trafficButton.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_HomeFragment_to_trafficFragment)
        }
        binding.exhibitionButton.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_HomeFragment_to_exhibitionIntroFragment)
        }
    }

}