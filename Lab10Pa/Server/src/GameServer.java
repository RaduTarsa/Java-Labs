import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class GameServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private boolean running = false;

    /**
     * Functia main in care se instantiaza serverul si se face handling pe clienti
     */
    public static void main(String[] args)  {
        GameServer server = new GameServer();
        server.init();
        server.waitForClients(); //... handle the exceptions!
    }

    /**
     * Functia init in care se deschide socketul
     */
    private void init() {
        try {
            serverSocket = new ServerSocket( PORT );
        } catch (IOException e) {
            e.printStackTrace();
        }
        running = true;
    }

    /**
     * Functia de asteptare/handling al clientilor
     */
    private void waitForClients(){
        while( running ) {
            System.out.println(" Asteptam un client... ");
            try {
                Socket socket = serverSocket.accept();
                new ClientThread(socket,this).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Functia de stop care inchide socketul
     * @throws IOException
     */
    public void stop() throws IOException {
        this.running = false;
        serverSocket.close();
    }

    /**
     * Functia de citire de la tastatura
     * @return scanner.nextLine()
     */
    private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
