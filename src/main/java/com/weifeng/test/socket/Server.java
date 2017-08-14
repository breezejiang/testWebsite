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
            ServerSocket server = new ServerSocket(8888);// ������������
            Socket socket = server.accept();// �����ͻ���
            // �õ������ӵ�������
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // �õ������ӵ������
            pw = new PrintWriter(socket.getOutputStream(), true);
            // �ȶ���д
            String data = br.readLine();
            System.out.println(data);// ���������̨
            pw.println(data);// ת�����ͻ���
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // �رն�д��
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
