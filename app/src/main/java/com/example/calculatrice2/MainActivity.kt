package com.example.calculatrice2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val btn0=findViewById<Button>(R.id.btn_0)
    val btn1=findViewById<Button>(R.id.btn_1)
    val btn2=findViewById<Button>(R.id.btn_2)
    val btn3=findViewById<Button>(R.id.btn_3)
    val btn4=findViewById<Button>(R.id.btn_4)
    val btn5=findViewById<Button>(R.id.btn_5)
    val btn6=findViewById<Button>(R.id.btn_6)
    val btn7=findViewById<Button>(R.id.btn_7)
    val btn8=findViewById<Button>(R.id.btn_8)
    val btn9=findViewById<Button>(R.id.btn_9)
    val btnplus=findViewById<Button>(R.id.btn_plus)
    val input=findViewById<TextView>(R.id.input)
    val output=findViewById<TextView>(R.id.output)
    val btn_equal=findViewById<Button>(R.id.btn_equal)
    val btn_c=findViewById<Button>(R.id.btn_c)
    val btn_leftp=findViewById<Button>(R.id.left_parentes)
        val btn_rightp=findViewById<Button>(R.id.right_parentes)
        val btn_div=findViewById<Button>(R.id.btn_dev)
        val btn_mult=findViewById<Button>(R.id.btn_mult)
        val btn_minus=findViewById<Button>(R.id.btn_minus)
        val btn_point=findViewById<Button>(R.id.btn_point)
        var buttons = listOf(btn0,btn1,btn2,btn3,
            btn4,btn5,btn6,btn7,btn8,btn9,btnplus,btn_leftp,
            btn_rightp,btn_div,btn_minus,btn_mult,btn_point)
    fun addlistner(){
          for(button in buttons){
              button.setOnClickListener{
                  input.text= input.text.toString()+button.text
              }
          }
    }
        addlistner()
        btn_equal.setOnClickListener {
            val equation = input.text.toString().replace("x", "*")
            try {
                val expression = ExpressionBuilder(equation.toString()).build()
                val result = expression.evaluate()
                output.text= DecimalFormat("0.######").format(result).toString()
                output.setTextColor(Color.GREEN)
            }catch ( e:Exception){
                output.text="error"
                output.setTextColor(Color.RED)
            }



        }
        btn_c.setOnClickListener{
            if(input.text.isNotEmpty())
       input.text = input.text.subSequence(0, input.text.length - 1)

        }
    }

}