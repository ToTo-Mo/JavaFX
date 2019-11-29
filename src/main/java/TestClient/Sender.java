package TestClient;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {
    private Socket socket;

    public Sender(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            String packet = new String();
            String menu;

            while(true){

                menu = selectMenu();
                switch(menu)

                packet = setMessage("message : ");
                writer.write(packet);
                writer.flush();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String selectMenu() {
        return null;
    }

    private String setMessage(String promptText) {
        System.out.print(promptText);
        return new Scanner(System.in).nextLine() + "\r\n";
    }
}