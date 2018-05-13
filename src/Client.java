import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client {
    private static final String address = "127.0.0.1";
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ipAddress = InetAddress.getByName(address);
        new ClientThread(ipAddress);
    }
}
