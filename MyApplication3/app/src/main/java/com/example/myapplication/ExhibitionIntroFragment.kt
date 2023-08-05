package com.example.myapplication

import android.content.res.Resources
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentExhibitionIntroBinding
public lateinit var viewModel: ExhibitionIntroViewModel
class ExhibitionIntroFragment : Fragment() {

    companion object {
        fun newInstance() = ExhibitionIntroFragment()
    }
    private lateinit var binding : FragmentExhibitionIntroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExhibitionIntroBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExhibitionIntroViewModel::class.java)
        binding.exhibitionView.apply {
            adapter = TheAdapter()
            layoutManager = LinearLayoutManager(this@ExhibitionIntroFragment.context,LinearLayoutManager.VERTICAL,false)
            setHasFixedSize(true)
        }
    }
    class TheHolder(v: View) : RecyclerView.ViewHolder(v){
        var theImage = v.findViewById<ImageView>(R.id.exhibitionImage)
        var theName = v.findViewById<TextView>(R.id.exhibitionTextView)
        var theButton = v.findViewById<Button>(R.id.infoButton)
    }
    class TheAdapter : RecyclerView.Adapter<TheHolder>(){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TheHolder {
            return TheHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false))
        }

        override fun getItemCount(): Int {
            return viewModel.getTotal()
        }

        override fun onBindViewHolder(holder: TheHolder, position: Int) {
            holder.theName.text = viewModel.getExhibitionName(position)
            holder.theImage.setImageResource(viewModel.getExhibitionPicture(position))
            holder.theButton.setOnClickListener{
                var bundle = Bundle()
                bundle.putInt("ImageID", viewModel.getExhibitionPicture(position))
                bundle.putString("ImageName", viewModel.getExhibitionName(position))
                bundle.putInt("ImageInfo", viewModel.getExhibitionInfo(position))
                Navigation.findNavController(it).navigate(R.id.action_exhibitionIntroFragment_to_exhibitionChipFragment,bundle)
            }
        }

    }


}