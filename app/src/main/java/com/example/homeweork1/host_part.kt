package com.example.homeweork1

import android.widget.Button
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.net.Socket
import java.net.ServerSocket
import java.net.InetSocketAddress
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter


//記得添加新類別一定要在manifest 加入！！！！！！！！

class hostpart :  AppCompatActivity() {
    private lateinit var buttonjoinsurface1: Button
    private lateinit var buttonjoinsurface2: Button
    private lateinit var buttonjoinsurface3: Button
    private lateinit var buttonjoinsurface4: Button
    private lateinit var buttonjoinsurface5: Button
    private lateinit var buttonjoinsurface6: Button
    private lateinit var buttonjoinsurface7: Button
    private lateinit var buttonjoinsurface8: Button
    private lateinit var buttonjoinsurface9: Button
    private lateinit var buttonjoinsurface10: Button
    private lateinit var buttonjoinsurface11: Button
    private lateinit var buttonjoinsurface12: Button
    private lateinit var buttonjoinsurface13: Button
    private lateinit var buttonjoinsurface14: Button
    private lateinit var buttonjoinsurface15: Button
    private lateinit var buttonjoinsurface16: Button

    private lateinit var buttons1: List<Button>

    private fun connectToServer(buttons: List<Button>,number : String) {

        //buttons[0].backgroundTintList = ColorStateList.valueOf(Color.parseColor("#669900"))
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val socket = Socket("192.168.10.227", 54000)
                val output = PrintWriter(socket.getOutputStream(), true)
                val input = BufferedReader(InputStreamReader(socket.getInputStream()))

                // 发送数据到服务器
                output.println("$number")
                Log.d("SocketClient", "Message sent to server: $number!")

                // 读取服务器响应
                val buffer = CharArray(4096)
                var response: String

                while (true) {
                    val bytesReceived = input.read(buffer)
                    if (bytesReceived == -1) {
                        Log.d("SocketClient", "Connection closed by server.")
                        break
                    }
                    response = String(buffer, 0, bytesReceived)

                    Log.d("SocketClient", "Message received from server: $response")


                    // else
                    // println("$value failed")


                }


                // 不关闭连接
                // output.close()
                // input.close()
                // socket.close()


            } catch (e: Exception) {
                Log.e("SocketClient", "Error connecting to server: ${e.message}")
            }

        }
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.host)
        /* ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.host)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/


        buttonjoinsurface1 = findViewById(R.id.buttonone)
        buttonjoinsurface2 = findViewById(R.id.buttontwo)
        buttonjoinsurface3 = findViewById(R.id.buttonthree)
        buttonjoinsurface4 = findViewById(R.id.buttonfour)
        buttonjoinsurface5 = findViewById(R.id.buttonfive)
        buttonjoinsurface6 = findViewById(R.id.buttonsix)
        buttonjoinsurface7 = findViewById(R.id.buttonseven)
        buttonjoinsurface8 = findViewById(R.id.buttoneight)
        buttonjoinsurface9 = findViewById(R.id.buttonnine)
        buttonjoinsurface10 = findViewById(R.id.buttonten)
        buttonjoinsurface11 = findViewById(R.id.buttoneleven)
        buttonjoinsurface12 = findViewById(R.id.buttontwelve)
        buttonjoinsurface13 = findViewById(R.id.button13)
        buttonjoinsurface14 = findViewById(R.id.button14)
        buttonjoinsurface15 = findViewById(R.id.button15)
        buttonjoinsurface16 = findViewById(R.id.buttonsixteen)







        buttons1 = listOf(
            buttonjoinsurface1,
            buttonjoinsurface2,
            buttonjoinsurface3,
            buttonjoinsurface4,
            buttonjoinsurface5,
            buttonjoinsurface6,
            buttonjoinsurface7,
            buttonjoinsurface8,
            buttonjoinsurface9,
            buttonjoinsurface10,
            buttonjoinsurface11,
            buttonjoinsurface12,
            buttonjoinsurface13,
            buttonjoinsurface14,
            buttonjoinsurface15,
            buttonjoinsurface16
        )





        val buttonback: Button = findViewById(R.id.buttonback)
        buttonback.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)


        }



        val buttonhost1 : Button  = findViewById(R.id.buttonone)
        buttonhost1.setOnClickListener {
            buttonhost1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost1.text = "1"
            connectToServer(buttons1,"1")


        }


        val buttonhost2 :Button= findViewById(R.id.buttontwo)
        buttonhost2.setOnClickListener {
            buttonhost2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost2.text = "2"
            connectToServer(buttons1,"2")
        }

         val buttonhost3 :Button= findViewById(R.id.buttonthree)
        buttonhost3.setOnClickListener {
            buttonhost3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost3.text = "3"
            connectToServer(buttons1,"3")
        }

        val buttonhost4 : Button= findViewById(R.id.buttonfour)
        buttonhost4.setOnClickListener {
            buttonhost4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost4.text = "4"
            connectToServer(buttons1,"4")
        }


        val buttonhost5 :Button= findViewById(R.id.buttonfive)
        buttonhost5.setOnClickListener {
            buttonhost5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost5.text = "5"
            connectToServer(buttons1,"5")
        }

        val buttonhost6 :Button= findViewById(R.id.buttonsix)
        buttonhost6.setOnClickListener {
            buttonhost6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost6.text = "6"
            connectToServer(buttons1,"6")
        }
        val buttonhost7 :Button= findViewById(R.id.buttonseven)
        buttonhost7.setOnClickListener {
            buttonhost7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost7.text = "7"
            connectToServer(buttons1,"7")
        }

        val buttonhost8 :Button= findViewById(R.id.buttoneight)
        buttonhost8.setOnClickListener {
            buttonhost8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost8.text = "8"
            connectToServer(buttons1,"8")
        }

        val buttonhost9 :Button= findViewById(R.id.buttonnine)
        buttonhost9.setOnClickListener {
            buttonhost9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost9.text = "9"
            connectToServer(buttons1,"9")
        }

        val buttonhost10 :Button= findViewById(R.id.buttonten)
        buttonhost10.setOnClickListener {
            buttonhost10.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost10.text = "10"
            connectToServer(buttons1,"10")
        }

        val buttonhost11 :Button= findViewById(R.id.buttoneleven)
        buttonhost11.setOnClickListener {
            buttonhost11.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost11.text = "11"
            connectToServer(buttons1,"11")
        }

        val buttonhost12 :Button= findViewById(R.id.buttontwelve)
        buttonhost12.setOnClickListener {
            buttonhost12.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost12.text = "12"
            connectToServer(buttons1,"12")
        }

        val buttonhost13 :Button= findViewById(R.id.button13)
        buttonhost13.setOnClickListener {
            buttonhost13.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost13.text = "13"
            connectToServer(buttons1,"13")
        }

        val buttonhost14 :Button= findViewById(R.id.button14)
        buttonhost14.setOnClickListener {
            buttonhost14.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost14.text = "14"
            connectToServer(buttons1,"14")
        }

        val buttonhost15 :Button= findViewById(R.id.button15)
        buttonhost15.setOnClickListener {
            buttonhost15.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost15.text = "15"
            connectToServer(buttons1,"15")
        }

        val buttonhost16 :Button= findViewById(R.id.buttonsixteen)
        buttonhost16.setOnClickListener {
            buttonhost16.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#03DAC6"))
            buttonhost16.text = "16"
            connectToServer(buttons1,"16")
        }












    }
}






