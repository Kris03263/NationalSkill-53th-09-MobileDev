package com.example.myapplication

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentExhibitionChipBinding

class ExhibitionChipFragment : Fragment() {

    companion object {
        fun newInstance() = ExhibitionChipFragment()
    }

    private lateinit var viewModel: ExhibitionChipViewModel
    private lateinit var binding: FragmentExhibitionChipBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExhibitionChipBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ExhibitionChipViewModel::class.java]
        var bundle = requireArguments()
        binding.exhibitionImage.setImageResource(bundle.getInt("ImageID"))
        binding.exhibitionName.text = bundle.getString("ImageName")
        binding.imageInfo.text = resources.getString(bundle.getInt("ImageInfo"))
    }

}