package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BuyControlViewModel : ViewModel() {
    var controlShow1 : MutableLiveData<Boolean> = MutableLiveData(false)
    var controlShow2 : MutableLiveData<Boolean> = MutableLiveData(false)
    var totalPrice : MutableLiveData<Int> = MutableLiveData(0)
    var NormalTicketCount = 0
    var StudentTicketCount = 0
    var ChildTicketCount = 0
    var OlderTicketCount = 0
    fun setControl1(boolean: Boolean){
        controlShow1.value = boolean
    }
    fun getControl1(): Boolean? {
        return controlShow1.value
    }
    fun setControl2(boolean: Boolean){
        controlShow2.value = boolean
    }
    fun getControl2(): Boolean? {
        return controlShow2.value
    }
    fun setNormalTicket(int: Int){
        NormalTicketCount = int
    }
    fun setStudentTicket(int: Int){
        StudentTicketCount = int
    }
    fun setChildTicket(int: Int){
        ChildTicketCount = int
    }
    fun setOlderTicket(int: Int){
        OlderTicketCount = int
    }
    fun getTotal(): Int? {
        if(NormalTicketCount + StudentTicketCount + ChildTicketCount + OlderTicketCount != 0){
            totalPrice.value = NormalTicketCount*120 + StudentTicketCount*80 + ChildTicketCount*60 + OlderTicketCount*40
            return totalPrice.value
        }else{
            return 0
        }
    }
    fun setTotal(){
        totalPrice.value = NormalTicketCount*120 + StudentTicketCount*80 + ChildTicketCount*60 + OlderTicketCount*40
    }
}