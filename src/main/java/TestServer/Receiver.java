package TestServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
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
            Student student;

            do{
                student = (Student)object_reader.readObject();
                System.out.println(student.toString());
                System.out.println("수신 성공");
            }while(student != null);
            // while (true) {
            //     menu = reader.readLine();
            //     switch (menu) {
            //     case "1":
            //         try {
            //             Student student = (Student) obecjt_reader.readObject();
            //             System.out.println(student.toString());
            //         } catch (ClassNotFoundException e) {
            //             TODO Auto-generated catch block
            //             e.printStackTrace();
            //         }

            //         break;
            //     case "2":
            //         System.out.println(reader.readLine());
            //         break;
            //     }

            // }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}