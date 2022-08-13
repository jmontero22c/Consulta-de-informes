package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import model.ConexionDB;

public class InformeTreDao {
    Connection conn;
    Statement stmt;
    ResultSet rset;

    public InformeTreDao(){
        conn = new ConexionDB().getConnection();
    }

    public ResultSet consultaInforme(){
        String consulta = "SELECT ID_Compra, p.Constructora, p.Banco_Vinculado "+
        "FROM Compra c "+
        "INNER JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto "+
        "WHERE Proveedor = 'Homecenter' AND p.Ciudad = 'Salento'";


        try {
            stmt = conn.createStatement();
            rset = stmt.executeQuery(consulta);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rset;
    } 
}
