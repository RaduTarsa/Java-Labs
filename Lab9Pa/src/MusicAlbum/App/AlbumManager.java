package MusicAlbum.App;

import java.util.Scanner;

public class AlbumManager {
    /**
     * Functia run in care folosim comenzile date de la tastatura pentru a folosi functiile de mai jos
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Input:");
            String command = scanner.nextLine();
            if (command.equals("exit")) break;
            String[] params = command.trim().split("\\s+");
            if(params[0].equals("CreateAlbum")) {
                createAlbum(params[1]);
            } else if(params[0].equals("CreateArtist")) {
                createArtist(params[1], params[2]);
            } else if(params[0].equals("Show-Albums")){
                listAlbums(params[1]);
            }
        }
    }

    /**
     * Functia de creare al artistului
     * @param name
     * @param country
     */
    private void createArtist(String name, String country) {
        //...
    }

    /**
     * Functia de creare al albumului
     * @param name
     */
    private void createAlbum(String name) {
        //...
    }

    /**
     * Functia de listare al albumului
     * @param name
     */
    private void listAlbums(String name) {
        //...
    }
}
