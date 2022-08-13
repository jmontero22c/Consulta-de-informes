package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private Connection conn;

    public ConexionDB() {
        try {            
            conn = DriverManager.getConnection("jdbc:sqlite:ProyectosConstruccion.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }
}
