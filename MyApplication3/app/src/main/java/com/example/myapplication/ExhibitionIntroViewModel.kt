package com.example.myapplication

import androidx.lifecycle.ViewModel

class ExhibitionIntroViewModel : ViewModel() {
    var exhibitionName = arrayListOf<String>("Exhibition1","Exhibition2","Exhibition3","Exhibition4","Exhibition5","Exhibition6","Exhibition7","Exhibition8")
    var exhibitionPicture = arrayListOf<Int>(R.drawable.exhibition1,R.drawable.exhibition2,R.drawable.exhibition3,R.drawable.exhibition4,R.drawable.exhibition1,R.drawable.exhibition2,R.drawable.exhibition3,R.drawable.exhibition4)
    var exhibitionInfo = arrayListOf<Int>(R.string.exhibition_info_1,R.string.  exhibition_info_2,R.string.exhibition_info_1,R.string.  exhibition_info_2,R.string.exhibition_info_1,R.string.  exhibition_info_2,R.string.exhibition_info_1,R.string.  exhibition_info_2)
    fun getExhibitionName(int : Int): String {
        return exhibitionName.get(int)
    }
    fun getExhibitionPicture(int: Int): Int {
        return exhibitionPicture.get(int)
    }
    fun getTotal(): Int {
        return exhibitionName.count()
    }
    fun getExhibitionInfo(int: Int): Int {
        return exhibitionInfo.get(int)
    }
}