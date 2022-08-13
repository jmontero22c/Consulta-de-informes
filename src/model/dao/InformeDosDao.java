package model.dao;

import java.sql.Statement;

import model.ConexionDB;

import java.sql.Connection;
import java.sql.ResultSet;

public class InformeDosDao {
    Connection conn;
    Statement stmt;
    ResultSet rset;

    public InformeDosDao(){
        conn = new ConexionDB().getConnection();
    }

    public ResultSet consultaInforme(){
        String consulta = "SELECT ID_Proyecto, Constructora, Numero_Habitaciones, Ciudad "+  
        "FROM Proyecto p "+
        "WHERE Clasificacion = 'Casa Campestre' AND (Ciudad = 'Cartagena' OR Ciudad = 'Santa Marta' OR Ciudad = 'Barranquilla')";
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rset;
    }
}
