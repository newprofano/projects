/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodisco.config;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author PC-PC
 */
public class ConnectionBD {
    
    private static String user;
    private static String password;
    
    public static Connection getConnection(){
    
        String url = "jdbc:mysql://localhost:3306/bdisco?useSSL = false";
        String driver = "com.mysql.jdbc.Driver";
        
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        }catch (SQLException | ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Não foi possivel fazer a conexão com o Banco de dados"
                    + "\n erro: " + ex.getMessage());
        }
        
        return null;
    
    }
    
    public static void close (Connection conn){
        try{
            if (conn!= null) {
                conn.close();
                
            }
        }catch (SQLException ex){
            Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE,null,ex);
            
        }
        
        }
    public static void close (Connection conn, Statement stm){
        close(conn);
        if (stm != null) {
            try{
                stm.close();
            }catch (SQLException ex){
                Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    } 
    
    public static void close (Connection conn, Statement stm, ResultSet rs){
        close(conn, stm);
        
        if (rs != null) {
            try{
                rs.close();
            }catch(SQLException ex){
                Logger.getLogger(ConnectionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public static String getUser(){
        return user;
    }
    
    public static void setUser (String user){
        ConnectionBD.user = user;
    }
    
    public static String getPassword(){
        return password;
    }
    
    public static void setPassword(String password){
        ConnectionBD.password = password;
    }
}
    
