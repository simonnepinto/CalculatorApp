package com.simonne.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button0.setOnClickListener(){addData("0", true)}
        button1.setOnClickListener(){addData("1", true)}
        button2.setOnClickListener(){addData("2", true)}
        button3.setOnClickListener(){addData("3", true)}
        button4.setOnClickListener(){addData("4", true)}
        button5.setOnClickListener(){addData("5", true)}
        button6.setOnClickListener(){addData("6", true)}
        button7.setOnClickListener(){addData("7", true)}
        button8.setOnClickListener(){addData("8", true)}
        button9.setOnClickListener(){addData("9", true)}
        buttonDec.setOnClickListener(){addData(".", false)}

        addButton.setOnClickListener(){ addData("+", false)}
        subButton.setOnClickListener(){ addData("-", false)}
        mulButton.setOnClickListener(){ addData("*", false)}
        divButton.setOnClickListener(){ addData("/", false)}
        ButtonRightP.setOnClickListener(){addData("(", false)}
        ButtonLeftP.setOnClickListener(){addData(")", false)}

        buttonClear.setOnClickListener(){
            clear()
        }
        buttonEqual.setOnClickListener(){
            calculate()
        }
    }

    private fun addData(string:String, clear:Boolean){
        if(clear){
            output.text = ""
            input.append(string)
        }
        else{
            input.append(output.text)
            input.append(string)
            output.text = ""
        }
    }

    private fun clear(){
        input.text = ""
        output.text = ""
    }

    private fun calculate(){
        try {
            val num = ExpressionBuilder(input.text.toString()).build()
            val num2 = num.evaluate().toFloat()
            output.text = num2.toString()
            input.text = ""
        }
        catch (e:Exception){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }
    }
}