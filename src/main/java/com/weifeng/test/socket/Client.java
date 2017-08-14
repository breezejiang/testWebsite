package main.java.com.weifeng.test.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public Client() {
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            Socket socket = new Socket("localhost", 8888);// ��������������ӣ�������Ҫ����
            // �õ�Socket�������������
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(), true);
            // ��д���
            pw.println("Client:��ã�");
            String data = null;
            while (true) {
                data = br.readLine();
                if (data != null)
                    break;
            }
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                pw.close();
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) {
        Client c = new Client();
    }
}
