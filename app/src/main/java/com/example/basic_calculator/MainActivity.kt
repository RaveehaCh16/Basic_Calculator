package com.example.basic_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

//class MainActivity : AppCompatActivity(), View.OnClickListener {

abstract class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var edittext1: EditText
    lateinit var edittext2: EditText
    lateinit var btnadd: Button
    lateinit var btnsub: Button
    lateinit var btnmul: Button
    lateinit var btndiv: Button
    lateinit var resultTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main )
        edittext1 = findViewById(R.id.edit1)
        edittext2 = findViewById(R.id.edit2)
        btnadd = findViewById(R.id.btnadd)
        btnsub = findViewById(R.id.btnsub)
        btnmul = findViewById(R.id.btnmul)
        btndiv = findViewById(R.id.btndiv)
        resultTV = findViewById(R.id.result)

        btnadd.setOnClickListener(this)
        btnsub.setOnClickListener(this)
        btnmul.setOnClickListener(this)
        btndiv.setOnClickListener(this)



    }
    override fun onClick(v: View?) {
            val ed1 = edittext1.text.toString().toDoubleOrNull()
            val ed2 = edittext2.text.toString().toDoubleOrNull()
            if (ed1 == null || ed2 == null) {
                "Please enter valid numbers".also { resultTV.text = it }
                return
            }

            var result =0.0
            when (v?.id) {
                R.id.btnadd -> result = ed1 + ed2
                R.id.btnsub -> result = ed1 - ed2
                R.id.btnmul -> result = ed1 * ed2
                R.id.btndiv -> {
                    if (ed2 != 0.0) {
                        result = ed1 / ed2
                    } else {
                        resultTV.text = "Cannot divide by zero"
                        return
                    }
                }
            }

        resultTV.text = "Result: $result"
    }
}


