package Unit3;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);
        // has all hte inputStream
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        Scanner sc = new Scanner(System.in);

        String msg;
        String response; // server bhej raha

        System.out.println("Enter your messege:");

        while (!(msg = sc.nextLine()).equals("end")){
            out.writeUTF(msg);
            response = in.readUTF();
            System.out.println("Server: " + response);
        }




    }

}
