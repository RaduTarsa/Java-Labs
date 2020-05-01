import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.util.TimerTask;

public class ClientThread extends Thread {
    private Socket socket = null;
    private final GameServer server;
    private Game joc;

    /**
     * Constructori
     * @param socket
     * @param server
     */
    ClientThread( Socket socket , GameServer server ) throws SocketException {
        this.socket = socket;
        this.server = server;
        this.joc = null;
    }

    /**
     * Functia de creare a socketului
     */
    public void run() {
        BufferedReader fin = null; //client -> server stream
        String request = null;
        String response = null;
        PrintWriter fout = null;
        try {
            fin = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            fout = new PrintWriter(socket.getOutputStream()); //server -> client stream
            while(true) {
                request = fin.readLine();
                if( request == null )
                    break;
                response = execute(request);
                if( response.equals("You got it!") ) {
                    joc = null;
                    this.socket.setSoTimeout(0);
                }
                fout.println(response);
                fout.flush();
                if( response.equals("exit") ) {
                    break;
                }
            }
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
            System.out.println("Socket timed out!!!");
            fout.println("exit");

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
     * Functia de execute a jocului in care se manageriaza jocurile si se primesc/trimit date
     * @param request
     * @return String
     * @throws IOException
     */
    private String execute(String request) throws IOException {
        System.out.println( request );
        String[] parts = request.split(" ");
        System.out.println("Server received the request " + request );
        switch ( parts[0] ) {
            case "create":
                if( parts.length == 3 ) {
                    if( joc != null )
                        return "Game already in progress!";
                    joc = new Game(parts[1], Integer.parseInt(parts[2]));
                    this.socket.setSoTimeout(3000); // 3 sec
                    return "Game created! Remember: you got only 10 second to guess!";
                }
                break;
            case "submit":
                if( joc == null ) {
                    return "First create a game!";
                }
                if( parts.length == 2 ) {
                    return joc.submit(Integer.parseInt(parts[1]));
                }
                break;
            case "quit":
                if( joc != null ) {
                    request = "Loser, the number was " + joc.getRandomNumber();
                    joc = null;
                    return request;
                }
                else {
                    return "First create a game!";
                }
            case "stop":
                socket.close();
        }
        return "Syntax";
        // display the message: "Server received the request ... "
    }
}
