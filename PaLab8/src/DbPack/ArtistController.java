package DbPack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController {

    Connection conn;
    int id;
    String name;
    String country;

    //constructor
    public ArtistController(Connection conn) {
        this.conn = conn;
    }

    //this method helps us find the lastId in order to add more items in the database
    public int getLastId() throws SQLException {
        int id = 0;
        Statement stat = conn.createStatement();
        ResultSet res = stat.executeQuery("SELECT id FROM artists");
        while (res.next())
            id = res.getInt("id");
        return id;
    }

    //insert into database
    public void create(int id, String name, String country) throws SQLException {
        id++;
        Statement stat = conn.createStatement();
        stat.executeUpdate(String.format("INSERT INTO artists (id, name, country) VALUES (%d, '%s','%s')", id, name, country));
    }

    //search query
    public void findByName(String name) throws SQLException {
        Statement stat = conn.createStatement();
        ResultSet res = stat.executeQuery(String.format("SELECT * FROM artists WHERE name='%s'", name));
        while (res.next()) {
            System.out.println("Artist:" + res.getString("name") + " " + res.getString("country"));
        }
    }
}
