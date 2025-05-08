package Unit3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server is listening at port 8000 successfully");

            Socket socket = new Socket();
            socket = serverSocket.accept();
            System.out.println("Client has succesfully connecteed to the server");

//            while (true) {
//                Socket socket = serverSocket.accept();
//                System.out.println("New client connected: " + socket);
//                new ClientHandler(socket).start(); // handle each client in a thread
//            }

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // messege sent by client
            String msg = "";

            while (!msg.equalsIgnoreCase("end")){

                msg = in.readUTF();
                System.out.println("Client said to server : " + msg);

                // default response
                String response = "Server also said " + msg;
                // customized responses
                if (msg.equals("hi")){
                    response = "hello bhai";
                }
                else if (msg.equalsIgnoreCase("Kaisa hai bhai")){
                    response = "Sab sahi hai";
                }

                out.writeUTF(response);

            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}