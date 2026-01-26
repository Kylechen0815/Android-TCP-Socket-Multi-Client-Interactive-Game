import android.os.Bundle
import android.os.StrictMode
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.homeweork1.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.InetAddress
import java.net.ServerSocket
import java.net.Socket

class server : AppCompatActivity() {

    private val port = 54000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 允许在主线程中进行网络操作，仅用于示例
        if (android.os.Build.VERSION.SDK_INT > 9) {
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
        }

        // 启动服务器
        GlobalScope.launch(Dispatchers.IO) {
            startServer()
        }
    }

    private fun startServer() {
        try {
            val serverSocket = ServerSocket(port)
            println("Server is listening on port $port")

            while (true) {
                val clientSocket = serverSocket.accept()
                println("New client connected: ${clientSocket.inetAddress.hostAddress}")

                // 创建线程处理客户端
                GlobalScope.launch(Dispatchers.IO) {
                    handleClient(clientSocket)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun handleClient(clientSocket: Socket) {
        try {
            val reader = BufferedReader(InputStreamReader(clientSocket.getInputStream()))
            val writer = PrintWriter(clientSocket.getOutputStream(), true)

            var message: String?
            while (reader.readLine().also { message = it } != null) {
                println("Received from client: $message")
                // Echo message back to client
                writer.println("Echo: $message")

                // Send message to client
                val userInput = getUserInput()
                if (userInput.isNotEmpty()) {
                    writer.println(userInput)
                }
            }

            clientSocket.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getUserInput(): String {
        print("Your message to client: ")
        return readLine() ?: ""
    }
}
