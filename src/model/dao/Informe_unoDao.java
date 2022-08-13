package model.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import model.ConexionDB;

public class Informe_unoDao {
    Connection conn;
    Statement stmt;
    ResultSet rset;

    public Informe_unoDao(){
        conn = new ConexionDB().getConnection();
    }

    public ResultSet consultaInforme(){
        String consulta = "SELECT ID_Lider, Nombre, Primer_Apellido, Ciudad_Residencia FROM Lider l ORDER BY Ciudad_Residencia ASC";
    
        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rset;
    }
    

}
