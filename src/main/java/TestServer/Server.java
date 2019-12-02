package TestServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

import Utilizer.Protocol;

public class Server {
	private static final String IP = "127.0.0.1";
	private static final int PORT = 10000;

	public static void main(String[] args) throws IOException {
		ServerSocket serverSock = new ServerSocket(PORT);
		Socket sock = null;
		DBmanager Database = new DBmanager();
		try {
			Database.startDB();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			while (true) {
				sock = serverSock.accept();
				System.out.println("[ " + sock.getInetAddress() + " ] : 접속");
				new SocketManager(sock, Database).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			serverSock.close();
		}
	}

}

class SocketManager extends Thread {
	DBmanager db;
	Socket sock = null;
	byte user_power = Protocol.ANYBODY;

	Sender sender;
	Receiver receiver;

	String userName;
	String userNum;

	public SocketManager(Socket socket, DBmanager database) {
		sock = socket;
		db = database;

		sender = new Sender(socket);
		receiver = new Receiver(socket);

		receiver.start();
		sender.start();
	}

	@Override
	public void run() {
		if(sock.isClosed())
			System.out.println(sock.getInetAddress() + " 와의 연결을 종료합니다.");
	}

	public int loginProtocol(String ID, String PW) throws SQLException {
		int result;
		result = db.studentLogin(ID, PW);
		if (result == 2) {
			result = db.managerLogin(ID, PW);
			if (result == 2) {
				return 0; // 로그인 실패
			} else {
				user_power = Protocol.ADMIN;
				return 1; // 관리자로그인 성공
			}
		} else {
			user_power = Protocol.STUDENT;
			return 1; // 학생로그인성공
		}
	}

}
