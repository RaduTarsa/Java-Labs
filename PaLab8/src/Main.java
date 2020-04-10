import DbPack.AlbumController;
import DbPack.ArtistController;
import DbPack.Database;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        int id;//primary key
        Connection conn = Database.Database(); //Db connection

        //add artists
        ArtistController artist = new ArtistController(conn);
        id = artist.getLastId();
        artist.create(id, "Florin Salam", "Romania");
        id = artist.getLastId();
        artist.create(id, "Justin Bieber", "Canada");
        id = artist.getLastId();
        artist.create(id, "Maluma", "Columbia");
        id = artist.getLastId();
        artist.create(id, "Will Smith", "USA");
        artist.findByName("Will Smith");

        //add albums
        AlbumController album = new AlbumController(conn);
        id = album.getLastId();
        album.create(id, "11:11", 3, 2019);
        id = album.getLastId();
        album.create(id, "Purpose", 2, 2015);
        album.findByName(3);

        //close the database
        conn.close();
    }
}