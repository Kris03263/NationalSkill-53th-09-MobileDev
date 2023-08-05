package com.example.myapplication

import androidx.lifecycle.ViewModel

class CommentViewModel : ViewModel() {
    private var comment : String = ""
    private var rating : Int = 0
    public fun setComment(ty: String){
        comment = ty
    }
    public fun setRating(nu:Int){
        rating = nu
    }
    public fun getComment() : String{
        return comment
    }
    public fun getRating() : Int{
        return rating
    }
}