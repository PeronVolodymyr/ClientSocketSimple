import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientServerReaderThread extends Thread {
    private DataInputStream in;
    private Socket socket;

    public ClientServerReaderThread(Socket socket) throws IOException {
        this.socket = socket;
        this.in = new DataInputStream(socket.getInputStream());
        start();
    }

    @Override
    public void run(){
        String line;
        try {
            while (true) {
                line = in.readUTF(); // ждем пока сервер отошлет строку текста.
                if(line.equals("quit"))
                    break;
                System.out.println(this.socket.toString() + "sent me : \t" + line);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
