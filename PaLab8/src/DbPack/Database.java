package DbPack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Database db = null;
    public static Connection conn = null;

    //the actual db connection
    private Database() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/MusicAlbums";
            String user = "dba";
            String pass = "sql";
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //make it a singleton
    public static Connection Database() throws SQLException {
        if (db == null) {
            db = new Database();
        }
        return conn;
    }
}
