package DbPack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {

    Connection conn;
    String name, country;
    int id;

    //constructor
    public AlbumController(Connection conn) {
        this.conn = conn;
    }

    //this method helps us find the lastId in order to add more items in the database
    public int getLastId() throws SQLException {
        int id = 0;
        Statement stat = conn.createStatement();
        ResultSet res = stat.executeQuery("SELECT id FROM albums");
        while (res.next())
            id = res.getInt("id");
        return id;
    }

    //insert into database
    public void create(int id, String name, int artistId, int releaseYear) throws SQLException {
        id++;
        Statement stat = conn.createStatement();
        stat.executeUpdate(String.format("INSERT INTO albums (id, name, artist_id,release_year) VALUES (%d, '%s',%d,%d)", id, name, artistId, releaseYear));
    }

    //search query
    public void findByName(int artistId) throws SQLException {
        this.name = name;
        Statement stat = conn.createStatement();
        ResultSet res = stat.executeQuery(String.format("SELECT * FROM albums WHERE artist_id=%d", artistId));
        while (res.next()) {
            System.out.println("Album:" + res.getString("name") + " " + res.getInt("release_year"));
        }
    }
}