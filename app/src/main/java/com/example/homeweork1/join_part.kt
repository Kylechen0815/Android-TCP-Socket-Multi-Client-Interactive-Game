package com.example.homeweork1


import android.widget.Button
import java.io.IOException

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.net.Socket
import java.io.OutputStreamWriter
import java.io.InputStreamReader
import android.widget.EditText
import android.view.View
import com.google.android.material.snackbar.Snackbar
import android.system.Os.socket
import android.widget.TextView
import androidx.core.content.ContextCompat
import java.io.BufferedReader
import java.io.FileDescriptor
import java.io.OutputStream
import java.util.Scanner
import android.graphics.drawable.ColorDrawable
import android.content.res.ColorStateList






class Join_part : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.join)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.join)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        val buttonback: Button = findViewById(R.id.button6)//返回Button6
        buttonback.setOnClickListener {

            val intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)





        }

        val buttonconnect: Button = findViewById(R.id.button7) //button7 開始start
        buttonconnect.setOnClickListener {
         //   val rootView: View = findViewById(android.R.id.content)

            val intent = Intent(this,resultrace::class.java)
            var text:TextView = findViewById(R.id.textView2)
            startActivity(intent)


        }

        val buttonjoinsurface1 : Button  = findViewById(R.id.buttonjoin1)
        buttonjoinsurface1.setOnClickListener {
            buttonjoinsurface1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface1.text = "1"
            GlobalData.dataList.add("1")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }

        val buttonjoinsurface2 : Button  = findViewById(R.id.buttonjoin2)
        buttonjoinsurface2.setOnClickListener {
            buttonjoinsurface2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface2.text = "2"
            GlobalData.dataList.add("2")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }

        val buttonjoinsurface3 : Button  = findViewById(R.id.buttonjoin3)
        buttonjoinsurface3.setOnClickListener {
            buttonjoinsurface3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface3.text = "3"
            GlobalData.dataList.add("3")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }

        val buttonjoinsurface4 : Button  = findViewById(R.id.buttonjoin4)
        buttonjoinsurface4.setOnClickListener {
            buttonjoinsurface4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface4.text = "4"
            GlobalData.dataList.add("4")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }

        val buttonjoinsurface5 : Button  = findViewById(R.id.buttonjoin5)
        buttonjoinsurface5.setOnClickListener {
            buttonjoinsurface5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface5.text = "5"
            GlobalData.dataList.add("5")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }
        val buttonjoinsurface6 : Button  = findViewById(R.id.buttonjoin6)
        buttonjoinsurface6.setOnClickListener {
            buttonjoinsurface6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface6.text = "6"
            GlobalData.dataList.add("6")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }

        val buttonjoinsurface7 : Button  = findViewById(R.id.buttonjoin7)
        buttonjoinsurface7.setOnClickListener {
            buttonjoinsurface7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface7.text = "7"
            GlobalData.dataList.add("7")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }

        val buttonjoinsurface8 : Button  = findViewById(R.id.buttonjoin8)
        buttonjoinsurface8.setOnClickListener {
            buttonjoinsurface8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface8.text = "8"
            GlobalData.dataList.add("8")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }
        val buttonjoinsurface9: Button = findViewById(R.id.buttonjoin9)
        buttonjoinsurface9.setOnClickListener {
            buttonjoinsurface9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface9.text = "9"
            GlobalData.dataList.add("9")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }

        val buttonjoinsurface10: Button = findViewById(R.id.buttonjoin10)
        buttonjoinsurface10.setOnClickListener {
            buttonjoinsurface10.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface10.text = "10"
            GlobalData.dataList.add("10")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }

        val buttonjoinsurface11: Button = findViewById(R.id.buttonjoin11)
        buttonjoinsurface11.setOnClickListener {
            buttonjoinsurface11.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface11.text = "11"
            GlobalData.dataList.add("11")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }

        val buttonjoinsurface12: Button = findViewById(R.id.buttonjoin12)
        buttonjoinsurface12.setOnClickListener {
            buttonjoinsurface12.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface12.text = "12"
            GlobalData.dataList.add("12")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }

        val buttonjoinsurface13: Button = findViewById(R.id.buttonjoin13)
        buttonjoinsurface13.setOnClickListener {
            buttonjoinsurface13.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface13.text = "13"
            GlobalData.dataList.add("13")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }

        val buttonjoinsurface14: Button = findViewById(R.id.buttonjoin14)
        buttonjoinsurface14.setOnClickListener {
            buttonjoinsurface14.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface14.text = "14"
            GlobalData.dataList.add("14")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }

        val buttonjoinsurface15: Button = findViewById(R.id.buttonjoin15)
        buttonjoinsurface15.setOnClickListener {
            buttonjoinsurface15.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface15.text = "15"
            GlobalData.dataList.add("15")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }

        val buttonjoinsurface16: Button = findViewById(R.id.buttonjoin16)
        buttonjoinsurface16.setOnClickListener {
            buttonjoinsurface16.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonjoinsurface16.text = "16"
            GlobalData.dataList.add("16")
            println("Current Global Data List: ${GlobalData.dataList.joinToString(", ")}")
        }






    }


















}