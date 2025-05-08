package Unit3;

import java.io.*;
import java.net.*;

public class ClientHandler extends Thread {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        String msg = "";
        try {
            while (!msg.equalsIgnoreCase("end")) {
                msg = in.readUTF();
                System.out.println("Client said: " + msg);

                String response = "Server also said " + msg;

                if (msg.equalsIgnoreCase("hi")) {
                    response = "hello bhai";
                } else if (msg.equalsIgnoreCase("kaisa hai bhai")) {
                    response = "Sab sahi hai";
                }

                out.writeUTF(response);
            }
        } catch (IOException e) {
            System.out.println("Client disconnected: " + socket);
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
