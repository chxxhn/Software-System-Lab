package com.example.myapplication4_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var edit1 : EditText;  lateinit var edit2 : EditText
    lateinit var btnAdd : Button;   lateinit var btnSub : Button
    lateinit var btnMul : Button;   lateinit var btnDiv : Button

    lateinit var textResult : TextView
    lateinit var num1 : String; lateinit var num2 :  String
    var result : Int? = null
    var number : Int = 0
    var tictok : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = number.toString() + "회 계산기"

        edit1 = findViewById<EditText>(R.id.Edit1)
        edit2 = findViewById<EditText>(R.id.Edit2)

        btnAdd = findViewById<Button>(R.id.BtnAdd)
        btnSub = findViewById<Button>(R.id.BtnSub)
        btnMul = findViewById<Button>(R.id.BtnMul)
        btnDiv = findViewById<Button>(R.id.BtnDiv)
        textResult = findViewById<TextView>(R.id.TextResult)

        btnAdd.setOnTouchListener{ view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                if (num1.isNotEmpty() && num2.isNotEmpty()) {
                    result = num1.toInt() + num2.toInt()
                    textResult.text = "계산결과는: $result"
                    edit1.setText(result.toString())
                    edit2.text = null
                }
            }
            true
        }

        btnSub.setOnTouchListener{ view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                if (num1.isNotEmpty() && num2.isNotEmpty()) {
                    result = num1.toInt() - num2.toInt()
                    textResult.text = "계산결과는: $result"
                    edit1.setText(result.toString())
                    edit2.text = null
                }
            }
            true
        }

        btnMul.setOnTouchListener{ view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                if (num1.isNotEmpty() && num2.isNotEmpty()) {
                    result = num1.toInt() * num2.toInt()
                    textResult.text = "계산결과는: $result"
                    edit1.setText(result.toString())
                    edit2.text = null
                }
            }
            true
        }

        btnDiv.setOnTouchListener{ view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                num1 = edit1.text.toString()
                num2 = edit2.text.toString()
                if (num1.isNotEmpty() && num2.isNotEmpty()) {
                    if (num2.toInt() != 0) {
                        result = num1.toInt() / num2.toInt()
                        textResult.text = "계산결과는: $result"
                        edit1.setText(result.toString())
                        edit2.text = null
                    } else {
                        textResult.text = "0으로 나눌 수 없습니다."
                    }
                }
            }
            true
        }

    }
}
