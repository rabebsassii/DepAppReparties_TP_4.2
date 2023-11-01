package Client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class ClientEcho {
    public static final int PORT=1234;
    public static byte[] buffer = new byte[1024];

    public static void main(String[] args) throws Exception {
        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner sc = new Scanner(System.in);
            String username =sc.nextLine();
            DatagramPacket data = new DatagramPacket(username.getBytes(),username.length(), InetAddress.getByName("localhost"),PORT);
            socket.send(data);
            DatagramPacket recData = new DatagramPacket(buffer, buffer.length);
            socket.receive(recData);
            System.out.println("server: "+new String(recData.getData(),0, recData.getLength()));

        }catch (Exception e){

            e.printStackTrace();
        }
    }
}
