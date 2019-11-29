package TestClient;

import java.io.IOException;

import Utilizer.Property;

public class Start {
    public static void main(String[] args) throws IOException {
        Client client = new Client(Property.IP,Property.PORT);
    }
} 