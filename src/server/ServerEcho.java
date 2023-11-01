package server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerEcho {
    public static final int PORT=1234;
    public static byte[] buffer = new byte[1024];

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("Demarrage du serveur 'Echo'");
            while (true){
                DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
                socket.receive(packet);
                String username = new String (packet.getData(),0,packet.getLength());
                String message = "Bienvenue "+username;
                DatagramPacket messageToSend = new DatagramPacket(message.getBytes(),message.length(),packet.getAddress(),packet.getPort());
                socket.send(messageToSend);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
