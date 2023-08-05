package com.example.myapplication

import android.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.myapplication.databinding.FragmentCommentBinding
import org.json.JSONObject

class CommentFragment : Fragment() {

    companion object {
        fun newInstance() = CommentFragment()
    }

    private lateinit var viewModel: CommentViewModel
    private lateinit var binding : FragmentCommentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[CommentViewModel::class.java]
        binding.ConfirmButton.setOnClickListener{
            if(binding.editTextTextMultiLine.text.toString() == ""){
                var Builder = AlertDialog.Builder(context)
                Builder.setMessage("Comment Cannot be Null!")
                Builder.setPositiveButton("OK",null)
                Builder.show()
                return@setOnClickListener
            }
            viewModel.setComment(binding.editTextTextMultiLine.text.toString())
            var httpRequest = HttpRequest()
            var url = "http://10.16.31.20:8082/api/comment/userComment";
            var star = viewModel.getRating()
            var comment = viewModel.getComment()
            var json =
                """
                   {"star" : ${star},
                   "comment" : "${comment}"}
                """.trimIndent()
            var data = JSONObject(json)
            httpRequest.PostReques(url,data) {

            }
            var Builder = AlertDialog.Builder(context)
            Builder.setMessage("我們已收到您的訊息")
            Builder.setPositiveButton("OK",null)
            Builder.show()
            Navigation.findNavController(it).navigate(R.id.action_CommentFragment_to_HomeFragment)
        }
        binding.ratingBar.onRatingBarChangeListener = RatingBar.OnRatingBarChangeListener { _, fl, _ ->
            viewModel.setRating(fl.toInt())
        }
    }

}