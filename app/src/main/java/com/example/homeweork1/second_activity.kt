package com.example.homeweork1

import android.widget.Button
import android.content.Intent

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket
import java.net.Socket


class SecondActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val button2: Button = findViewById(R.id.button2)
        button2.setOnClickListener {

            val intent3 = Intent(this,MainActivity::class.java)
            startActivity(intent3)
        }



        val hostButton: Button = findViewById(R.id.button3)
        // 设置主持游戏按钮的点击事件
        hostButton.setOnClickListener {
            // 创建 Intent，并将其指向 JoinGameActivity
            val action = Intent(this, hostpart::class.java)
            // 启动 JoinGameActivity
            startActivity(action)





        }


        val joinButton: Button = findViewById(R.id.button4)
        // 设置加入游戏按钮的点击事件
        joinButton.setOnClickListener {
            // 创建 Intent，并将其指向 JoinGameActivity
            val intent2 = Intent(this, Join_part::class.java)
            // 启动 JoinGameActivity
            startActivity(intent2)


        }





    }
}

