package TestClient;

import java.util.Scanner;

public class IOHandler {
    public String selectMenu(){
        showMenu();

        return new Scanner(System.in).nextLine();
    }

    public void showMenu(){
        String menu = "1. 학생 전송\n"
                    + "2. 메시지 전송\n"
                    + "--------------"
                    + "선택 : ";
    }
}