package main.java.com.weifeng.test.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() {
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            ServerSocket server = new ServerSocket(8888);// 建立服务器端
            Socket socket = server.accept();// 监听客户端
            // 得到该连接的输入流
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 得到该连接的输出流
            pw = new PrintWriter(socket.getOutputStream(), true);
            // 先读后写
            String data = br.readLine();
            System.out.println(data);// 输出到控制台
            pw.println(data);// 转发给客户端
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭读写流
                br.close();
                pw.close();
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
    }

}
