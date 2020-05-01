import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class GameClient {
    private final static String SERVER_ADDRESS = "127.0.0.1";
    private final static int PORT = 8100;
    private static PrintWriter fout = null ;
    private static BufferedReader fin = null ;

    /**
     * Functia main in care folosim socketul deschis pentru a ne conecta la server pentru a putea juca
     */
    public static void main(String[] args) {
        Socket socket = null;
        GameClient client = new GameClient();
        try {
            socket = new Socket(SERVER_ADDRESS, PORT);
            fin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            fout = new PrintWriter(socket.getOutputStream());
            while (true) {
                String request = client.readFromKeyboard();
                if (request.equalsIgnoreCase("exit")) {
                    fin.close();
                    fout.close();
                    break;
                } else {
                    client.sendRequestToServer(request);
                }
            }
            System.out.println("terminat");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Functia care trimite request la server
     * @param request
     * @throws IOException
     */
    private void sendRequestToServer(String request) throws IOException {
        try {
            fout.println(request);
            fout.flush();
            request = fin.readLine();
            System.out.println(request);
        } catch (SocketException e) {
            System.out.println("A expirat timpul de joc.");
        }
    }

    /**
     * Functia de read care citeste de la tastatura comenzi
     * @return scanner.nextLine()
     */
    private String readFromKeyboard() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
