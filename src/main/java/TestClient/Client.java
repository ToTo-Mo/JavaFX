package TestClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import Utilizer.Protocol;

public class Client{
    Socket socket;

    Sender sender;      //송신 스레드
    Receiver receiver;  //수신 스레드

    Request request;
    Response response;

    String IP;
    int PORT;

    public Client(String IP, int PORT) throws IOException {
        this.IP = IP;
        this.PORT = PORT;
        socket = new Socket(IP, PORT);

        sender = new Sender(socket);
        receiver = new Receiver(socket);

        sender.start();
        receiver.start();
    }

    public void send() {

    }

    public void send(Protocol protocol) throws IOException {
        OutputStream writer = socket.getOutputStream();
        writer.write(protocol.getPacket());
    }

    public void send(byte PROTOCOL_TYPE, byte PROTOCOL_CODE,byte USER) throws IOException {
        OutputStream writer = socket.getOutputStream();
        Protocol protocol = new Protocol(PROTOCOL_TYPE,PROTOCOL_CODE,USER);
        writer.write(protocol.getPacket());
    }

    // PROTOCOL_EXCODE means protocol extension code that explian what to do in code
    public void send(byte PROTOCOL_TYPE, byte PROTOCOL_CODE, byte PROTOCOL_EXCODE, byte USER) throws IOException {
        OutputStream writer = socket.getOutputStream();
        Protocol protocol = new Protocol(PROTOCOL_TYPE,PROTOCOL_CODE,PROTOCOL_EXCODE,USER);
        writer.write(protocol.getPacket());
    }

    public void send(byte PROTOCOL_TYPE, byte PROTOCOL_CODE, byte PROTOCOL_EXCODE, byte USER,String data) throws IOException {
        OutputStream writer = socket.getOutputStream();
        Protocol protocol = new Protocol(PROTOCOL_TYPE,PROTOCOL_CODE,PROTOCOL_EXCODE,USER,data);
        writer.write(protocol.getPacket());
    }

    public byte[] receive() throws IOException {
        InputStream reader = socket.getInputStream();
        byte[] buffer = new byte[1000];
        reader.read(buffer);
        return buffer;
    }

    public Request getRequest() {
        return request;
    }

    public Response getResponse() {
        return response;
    }

    public String getIP() {
        return IP;
    }

    public int getPORT() {
        return PORT;
    }

    public class Request {
        public Byte[] login(String student_number, String password) {
            // login_info : has that is login success or not and user power
            Byte[] login_info = new Byte[2];

            byte protocolType;
            byte protocolCode;
            boolean isExit = false;
            
            try {
                // login 정보 전송
                Protocol protocol = new Protocol(Protocol.PT_REQUEST, 
                                                 Protocol.PT_LOGIN, 
                                                 Protocol.PT_APPLY,
                                                 Protocol.STUDENT);
                protocol.setId(student_number);
                protocol.setPW(password);
                send(protocol);

                while (true) {
                    if (isExit)
                        break;

                    byte[] buffer = receive();
                    protocolType = buffer[0];

                    switch (protocolType) {
                    case Protocol.PT_EXIT:
                        isExit = true;
                        break;
                    case Protocol.PT_RESPONSE:
                        protocolCode = buffer[1];
                        if (protocolCode == Protocol.PT_LOGIN) {
                            login_info[0] = buffer[2];  //SUCCESS OR NOT
                            login_info[1] = buffer[3];  //POWER OF USER
                        }
                        else{
                            
                        }
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return login_info;
        }

        public void applyForDormitory() {

        }
    }

    public class Response {

    }
}
