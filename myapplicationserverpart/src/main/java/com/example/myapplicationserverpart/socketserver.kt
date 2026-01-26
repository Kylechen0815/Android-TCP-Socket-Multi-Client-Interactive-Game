import android.os.Build
import androidx.annotation.RequiresApi
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Socket
import java.nio.ByteBuffer
import java.nio.channels.ServerSocketChannel
import java.nio.channels.SocketChannel
import java.util.*

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    // Create a socket
    val listening = ServerSocketChannel.open()
    listening.bind(InetSocketAddress(InetAddress.getByName("0.0.0.0"), 54000))

    // Wait for connection
    val clientSocket = listening.accept()

    val host = ByteArray(NI_MAXHOST)
    val service = ByteArray(NI_MAXHOST)

    if (getnameinfo(clientSocket.remoteAddress as InetSocketAddress, host, service) == 0) {
        println("${String(host)} connected on port ${String(service)}")
    } else {
     //   println("${clientSocket.remoteAddress} connected on port ${clientSocket.String(service)}")
    }

    // While loop: receive and echo message back to client
    val buf = ByteArray(4096)

    while (true) {
        buf.fill(0)

        // Wait for client to send data
        val bytesReceived = clientSocket.read(ByteBuffer.wrap(buf))

        if (bytesReceived == SOCKET_ERROR) {
            println("Error in recv(). Quitting")
            break
        }

        if (bytesReceived == 0) {
            println("Client disconnected")
            break
        }

        println("From Client: ${String(buf, 0, bytesReceived)}")

        // Send message to client
        println("Your message to client:")
        val userInput = readLine()
        if (userInput != null && userInput.isNotEmpty()) {
            clientSocket.write(ByteBuffer.wrap(userInput.toByteArray()))
        }
    }

    // Close the socket
    listening.close()
}

private fun getnameinfo(address: InetSocketAddress, host: ByteArray, service: ByteArray): Int {
    val hostString = address.hostString
    val portString = address.port.toString()
    hostString.toByteArray().copyInto(host)
    portString.toByteArray().copyInto(service)
    return 0
}

private const val SOCKET_ERROR = -1
private const val NI_MAXHOST = 1025
