/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodisco.config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author PC-PC
 */
public class TesteBD {
    
    public static boolean testando(){
        String sql = "SELECT * FROM discos";
        
        Connection conn = ConnectionBD.getConnection();
        
        Statement stmt = null;
        
        try{
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            ConnectionBD.close(conn, stmt, rs);
            return true;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel fazer o teste de conexao ao BD");
            return false;
        }finally{
            ConnectionBD.close(conn, stmt);
            
        }
    }
    
}
