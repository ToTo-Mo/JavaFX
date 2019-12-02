package TestServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.Socket;

import Utilizer.Student;

public class Receiver extends Thread {
    private Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ObjectInputStream object_reader = new ObjectInputStream(socket.getInputStream());

            String menu;

            while (true) {
                menu = reader.readLine();
                if(menu != null)
                    System.out.println(menu);
                switch (menu) {
                case "1":
                    try {
                        Student student = (Student) object_reader.readObject();
                        System.out.println(student.toString());
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case "2":
                    System.out.println(reader.readLine());
                    break;
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}