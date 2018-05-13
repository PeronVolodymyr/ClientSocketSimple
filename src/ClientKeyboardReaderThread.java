import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientKeyboardReaderThread extends Thread {

    private DataOutputStream out;

    public ClientKeyboardReaderThread(DataOutputStream out)
    {
        this.out = out;
        start();
    }

    @Override
    public void run(){
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            while (true) {
                line = keyboard.readLine();
                if (line.equals("quit"))
                    break;
//                System.out.println("Sending this line to the server...");
                out.writeUTF(line); // отсылаем введенную строку текста серверу.
                out.flush(); // заставляем поток закончить передачу данных.
            }
            out.writeUTF("quit");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
