package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.view.View
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    var lastnumber=0.0
    var currentoperation:operation?=null

lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addcallbacks()
    }

    private fun addcallbacks() {
       binding.digitC.setOnClickListener{
           clearInput()
       }
        binding.plus.setOnClickListener{
            prepareoperation(operation.Plus)
            currentoperation=operation.Plus
        }
        binding.minus.setOnClickListener{
            prepareoperation(operation.Minus)

        }
        binding.mul.setOnClickListener{
            prepareoperation(operation.Mul)
        }
        binding.div.setOnClickListener {
            prepareoperation(operation.Div)
        }
        binding.div2.setOnClickListener {
            prepareoperation(operation.Div2)
        }
        binding.negative.setOnClickListener {
            prepareoperation(operation.Negative)
        }
        binding.result.setOnClickListener {
      val result=  Docurrentoperation()
            binding.number.text=result.toString()
        }
    }

    private fun Docurrentoperation():Double {
        val secondnumber=binding.number.text.toString().toDouble()
        val num=-binding.number.text.toString().toDouble()
       return when(currentoperation){
            operation.Plus -> lastnumber+secondnumber
            operation.Minus -> lastnumber-secondnumber
            operation.Mul ->lastnumber*secondnumber
            operation.Div -> lastnumber/secondnumber
           operation.Negative -> lastnumber+num
           operation.Div2 -> lastnumber%secondnumber
            null -> 0.0

       }
    }

    fun clearInput(){
        binding.number.text=""
    }
    fun onClickNumber(v:View){
        val newDigit=(v as Button).text.toString()
        val oldDigits =binding.number.text.toString()
        val newTextNumber=oldDigits+newDigit
        binding.number.text=newTextNumber
    }
    fun prepareoperation(operation: operation){
        lastnumber=binding.number.text.toString().toDouble()
        clearInput()
        currentoperation=operation
    }
}
