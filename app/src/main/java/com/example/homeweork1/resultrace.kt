package com.example.homeweork1

import android.widget.Button
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket


class resultrace : AppCompatActivity() {
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
    private lateinit var buttonjoinsurface17: Button

    private lateinit var buttons: List<Button>
    private var buttonColorChangeCount = 0 // 计数器变量


    private fun connectToServer(buttons: List<Button>) {

       //buttons[0].backgroundTintList = ColorStateList.valueOf(Color.parseColor("#669900"))
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val socket = Socket("192.168.10.227", 54000)
                val output = PrintWriter(socket.getOutputStream(), true)
                val input = BufferedReader(InputStreamReader(socket.getInputStream()))

                // 发送数据到服务器
                output.println("Hello Server!")
                Log.d("SocketClient", "Message sent to server: Hello Server!")

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
                    val numericResponse = response.filter { it.isDigit() }
                    val value = numericResponse.toInt()

                    if(buttonColorChangeCount >= 3){
                        runOnUiThread {
                            buttonjoinsurface17.invalidate()
                            buttonjoinsurface17.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#669900"))
                            buttonjoinsurface17.text = "success"
                        }
                    }


                    if (value == 1)
                        println("testsuccess")
                   // else
                       // println("$value failed")

                    withContext(Dispatchers.Main) {
                        when (value) {
                            1 -> {
                                val button = buttons[0]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                // 检查当前背景颜色
                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            2 -> {
                                val button = buttons[1]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            3 -> {
                                val button = buttons[2]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            // Repeat for buttons[3] to buttons[15]
                            4 -> {
                                val button = buttons[3]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            5 -> {
                                val button = buttons[4]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            6 -> {
                                val button = buttons[5]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            7 -> {
                                val button = buttons[6]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            8 -> {
                                val button = buttons[7]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            9 -> {
                                val button = buttons[8]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            10 -> {
                                val button = buttons[9]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            11 -> {
                                val button = buttons[10]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            12 -> {
                                val button = buttons[11]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            13 -> {
                                val button = buttons[12]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            14 -> {
                                val button = buttons[13]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            15 -> {
                                val button = buttons[14]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            16 -> {
                                val button = buttons[15]
                                val initialColor = Color.parseColor("#B00020")
                                val newColor = Color.parseColor("#669900")
                                val defaultColor = Color.parseColor("#FFB4A8")

                                val currentColor = button.backgroundTintList?.defaultColor
                                Log.d("ColorChange", "Current color: $currentColor, Initial color: $initialColor")

                                if (currentColor == initialColor) {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(newColor)
                                        buttonColorChangeCount++
                                        println(buttonColorChangeCount)
                                    }
                                    Log.d("ColorChange", "Color changed to: $newColor")
                                } else {
                                    runOnUiThread {
                                        button.invalidate()
                                        button.backgroundTintList = ColorStateList.valueOf(defaultColor)
                                    }
                                    Log.d("ColorChange", "Color changed to default: $defaultColor")
                                }
                            }
                            else -> {
                                Log.d("ColorChange", "No action for value: $value")
                            }
                        }

                    }


                    // 根据服务器响应修改按钮背景颜色
                 // withContext(Dispatchers.Main) {
                        // 示例: 根据response修改第一个按钮的背景颜色

                 //  }
                }

                // 不关闭连接
                // output.close()
                // input.close()
                // socket.close()


            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("SocketClient", "Error connecting to server: ${e.message}")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.socketclient)

        buttonjoinsurface1 = findViewById(R.id.buttonjoin1)
        buttonjoinsurface2 = findViewById(R.id.buttonjoin2)
        buttonjoinsurface3 = findViewById(R.id.buttonjoin3)
        buttonjoinsurface4 = findViewById(R.id.buttonjoin4)
        buttonjoinsurface5 = findViewById(R.id.buttonjoin5)
        buttonjoinsurface6 = findViewById(R.id.buttonjoin6)
        buttonjoinsurface7 = findViewById(R.id.buttonjoin7)
        buttonjoinsurface8 = findViewById(R.id.buttonjoin8)
        buttonjoinsurface9 = findViewById(R.id.buttonjoin9)
        buttonjoinsurface10 = findViewById(R.id.buttonjoin10)
        buttonjoinsurface11 = findViewById(R.id.buttonjoin11)
        buttonjoinsurface12 = findViewById(R.id.buttonjoin12)
        buttonjoinsurface13 = findViewById(R.id.buttonjoin13)
        buttonjoinsurface14 = findViewById(R.id.buttonjoin14)
        buttonjoinsurface15 = findViewById(R.id.buttonjoin15)
        buttonjoinsurface16 = findViewById(R.id.buttonjoin16)
        buttonjoinsurface17 = findViewById(R.id.buttoncheck)

        buttons = listOf(
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

        GlobalData.dataList.forEach { item ->
            when (item) {
                "1" -> buttonjoinsurface1.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "2" -> buttonjoinsurface2.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "3" -> buttonjoinsurface3.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "4" -> buttonjoinsurface4.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "5" -> buttonjoinsurface5.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "6" -> buttonjoinsurface6.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "7" -> buttonjoinsurface7.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "8" -> buttonjoinsurface8.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "9" -> buttonjoinsurface9.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "10" -> buttonjoinsurface10.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "11" -> buttonjoinsurface11.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "12" -> buttonjoinsurface12.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "13" -> buttonjoinsurface13.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "14" -> buttonjoinsurface14.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "15" -> buttonjoinsurface15.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
                "16" -> buttonjoinsurface16.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#B00020"))
            }
        }

        connectToServer(buttons)

        val buttonback2: Button = findViewById(R.id.button6) //返回Button6
        buttonback2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
            GlobalData.dataList.clear()
        }
    }
}
