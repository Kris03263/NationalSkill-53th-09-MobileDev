package com.example.myapplication

import android.app.AlertDialog
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Spinner
import androidx.annotation.RequiresApi
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import com.example.myapplication.databinding.FragmentBuyControlBinding
import org.w3c.dom.Text
import java.nio.file.attribute.AclEntry.Builder
import java.text.SimpleDateFormat
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.Int as Int1

class BuyControlFragment : Fragment() {

    companion object {
        fun newInstance() = BuyControlFragment()
    }

    private lateinit var viewModel: BuyControlViewModel
    private lateinit var binding : FragmentBuyControlBinding
    var exhibitionsList = arrayListOf<String>()
    var date = arrayListOf<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuyControlBinding.inflate(layoutInflater)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[BuyControlViewModel::class.java]
        viewModel.totalPrice.observe(viewLifecycleOwner, androidx.lifecycle.Observer { binding.TotalPrice.text = it.toString() })
        var firstTime1 = true
        var firstTime2 = true
        binding.ControlView.visibility =  View.GONE
        binding.spinner2.visibility = View.GONE
        binding.imageView6.visibility = View.GONE
        for(i in 1..6){
            exhibitionsList.add("展場$i")
        }
        val simpleDate = SimpleDateFormat("yyyy/MM/dd")
        for(i in 0..30){
            var calender = Calendar.getInstance()
            calender.add(Calendar.DATE, i)
            date.add(simpleDate.format(calender.time))
        }
        val adapter1 = ArrayAdapter(requireContext(),
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,exhibitionsList)
        val adapter2 = ArrayAdapter(requireContext(),
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,date)
        adapter1.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        with(binding.spinner){
            adapter = adapter1
            prompt= "請選擇場次"
        }
        with(binding.spinner2){
            adapter = adapter2
            prompt= "請選擇日期"
        }
        binding.spinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int1, p3: Long) {
                if(firstTime1){
                    firstTime1 = false
                    return
                }
                binding.spinner2.visibility = View.VISIBLE
                binding.imageView6.visibility = View.VISIBLE
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        binding.spinner2.onItemSelectedListener = object: OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int1, p3: Long) {
                if(firstTime2){
                    firstTime2 = false
                    return
                }
                binding.ControlView.visibility = View.VISIBLE
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        binding.NormalTicketText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int1, p2: Int1, p3: Int1) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int1, p2: Int1, p3: Int1) {
                if(p0 != "" && p3 > 0){
                    if(p0.toString().toInt() > 4){
                        var builder = AlertDialog.Builder(context)
                        builder.setMessage("不可大於4張!")
                        builder.setPositiveButton("OK",null)
                        binding.NormalTicketText.text.clear()
                        viewModel.setNormalTicket(0)
                        viewModel.setTotal()
                        builder.show()
                        return
                    }
                    viewModel.setNormalTicket(p0.toString().toInt())
                    viewModel.setTotal()
                    return
                }
                viewModel.setNormalTicket(0)
                viewModel.setTotal()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.StudentTicketText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int1, p2: Int1, p3: Int1) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int1, p2: Int1, p3: Int1) {
                if(p0 != "" && p3 > 0){
                    if(p0.toString().toInt() > 4){
                        var builder = AlertDialog.Builder(context)
                        builder.setMessage("不可大於4張!")
                        builder.setPositiveButton("OK",null)
                        binding.StudentTicketText.text.clear()
                        viewModel.setStudentTicket(0)
                        viewModel.setTotal()
                        builder.show()
                        return
                    }
                    viewModel.setStudentTicket(p0.toString().toInt())
                    viewModel.setTotal()
                    return
                }
                viewModel.setStudentTicket(0)
                viewModel.setTotal()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        binding.ChildTicketText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int1, p2: Int1, p3: Int1) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int1, p2: Int1, p3: Int1) {
                if(p0 != "" && p3 > 0){
                    if(p0.toString().toInt() > 4){
                        var builder = AlertDialog.Builder(context)
                        builder.setMessage("不可大於4張!")
                        builder.setPositiveButton("OK",null)
                        binding.ChildTicketText.text.clear()
                        viewModel.setChildTicket(0)
                        viewModel.setTotal()
                        builder.show()
                        return
                    }
                    viewModel.setChildTicket(p0.toString().toInt())
                    viewModel.setTotal()
                    return
                }
                viewModel.setChildTicket(0)
                viewModel.setTotal()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
        binding.OlderTicketText.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(
                p0: CharSequence?,
                p1: kotlin.Int,
                p2: kotlin.Int,
                p3: kotlin.Int
            ) {
            }

            override fun onTextChanged(
                p0: CharSequence?,
                p1: kotlin.Int,
                p2: kotlin.Int,
                p3: kotlin.Int
            ) {
                if(p0 != "" && p3 > 0){
                    if(p0.toString().toInt() > 4){
                        var builder = AlertDialog.Builder(context)
                        builder.setMessage("不得超過4張!")
                        builder.setPositiveButton("OK",null)
                        viewModel.setOlderTicket(0)
                        binding.OlderTicketText.text.clear()
                        viewModel.setTotal()
                        builder.show()
                        return
                    }
                    viewModel.setOlderTicket(p0.toString().toInt())
                    viewModel.setTotal()
                    return
                }
                viewModel.setOlderTicket(0)
                viewModel.setTotal()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }
}