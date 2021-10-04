package com.example.week3_sec1calculator_app

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
var isNewOp=true
var oldNumber="0"
var newNumber="0"
var op="+"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun numberEvent(view:View){
         if(isNewOp)
             display_ED.setText("")
        isNewOp=false
        var buclick = display_ED.text.toString()
        var buSelect=view as Button
        when(buSelect.id){
            btn0.id -> { buclick += "0"}
            btn1.id -> { buclick += "1"}
            btn2.id -> { buclick += "2"}
            btn3.id -> { buclick += "3"}
            btn4.id -> { buclick += "4"}
            btn5.id -> { buclick += "5"}
            btn6.id -> { buclick += "6"}
            btn7.id -> { buclick += "7"}
            btn8.id -> { buclick += "8"}
            btn9.id -> { buclick += "9"}
            btn9.id -> { buclick += "9"}
            btnDot.id -> { buclick += "."}
            btnSign.id -> {
                if (buclick.startsWith("-")){
                   buclick= buclick.substring(1,buclick.length)
                }

                else
                    buclick = "-$buclick"
            }
        }
display_ED.setText(buclick)
    }


    fun oparatorEvent(view:View) {
        isNewOp=true
        oldNumber=display_ED.text.toString()
        var buSelect=view as Button
        when(buSelect.id){
            btnAdd.id->{op="+"}
            btnSubtract.id->{op="-"}
            btnMultiply.id->{op="*"}
            btnDivide.id->{op="/"}
        }
    }

    fun equlEvent(view: View) {

        if(newNumber.isEmpty())
            newNumber="0.0"
        else  newNumber=display_ED.text.toString()

        var result=0.0
        when(op){
            "+"->{result= oldNumber.toDouble() + newNumber.toDouble()}
            "-"->{result= oldNumber.toDouble() - newNumber.toDouble()}
            "*"->{result= oldNumber.toDouble() * newNumber.toDouble()}
            "/"->{
                if (newNumber.toInt()==0){
                    Toast.makeText(applicationContext, "can't devide by Zero", Toast.LENGTH_SHORT).show()
                }
                else{
                    result=oldNumber.toDouble()/ newNumber.toDouble()
                }}

        }
        display_ED.setText(result.toString())
    }

    fun acEvent(view:View) {
        display_ED.setText("0")
        isNewOp=true

    }

    fun delEvent(view:View) {

        var del=display_ED.text.toString()
        if(del.length>0)
        display_ED.setText( del.substring(0,del.length-1))
        else if(del.length<=0)
            display_ED.setText("0")
    }





}