package TestClient;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import Utilizer.IOHandler;
import Utilizer.Student;
import javafx.scene.control.Menu;

public class Sender extends Thread {
    private Socket socket;
    IOHandler ioh;

    public Sender(Socket socket) {
        this.socket = socket;
        ioh = new IOHandler();
    }

    @Override
    public void run() {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            ObjectOutputStream object_writer = new ObjectOutputStream(socket.getOutputStream());
            String packet = new String();
            String menu;

            Student student = new Student("20161213", "만식이", "남");
            object_writer.writeObject(student);
            object_writer.flush();

            System.out.println("전송 성공");
            // while(true){
            // menu = ioh.selectMenu();
            // switch(menu){
            // case "1":
            // writer.write("1\r\n");
            // Student student = new Student("20161213","만식이","남");
            // object_writer.writeObject(student);
            // break;
            // case "2":
            // writer.write("2\r\n");
            // packet = setMessage("message : ");
            // writer.write(packet);
            // break;
            // default :
            // System.out.println("다시 입력해 새캬");
            // break;
            // }

            // writer.flush();
            // }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private String setMessage(String promptText) {
        System.out.print(promptText);
        return new Scanner(System.in).nextLine() + "\r\n";
    }
}