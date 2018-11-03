/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetodisco.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import projetodisco.config.ConnectionBD;
import projetodisco.config.models.Disco;
import projetodisco.view.TelaPesquisar;

/**
 *
 * @author PC-PC
 */
public class DiscoDAO {
    
    public static boolean salvarDisco(Disco disco){
    
    String sql = "INSERT INTO discos(nome, autor_cantor, ano) VALUES('" + disco.getNome()+"', '"+disco.getAutor_cantor()+"', '"+disco.getAno() + "')";
    
    Connection conn = ConnectionBD.getConnection();
    Statement stm;
    
    try{
        stm = conn.createStatement();
        stm.executeUpdate(sql);
        ConnectionBD.close(conn, stm);
        JOptionPane.showMessageDialog(null,"Disco Adicionado ao Banco de Dados");
    }catch (SQLException e){
        JOptionPane.showMessageDialog(null, "Disco já existe");
        return true;
    }finally{
        ConnectionBD.close(conn);
    }
    return false;
}
    
    public static Disco carregarDisco(String titulo, String autor_cantor,String ano) throws SQLException{
       
        String sql = "SELECT * FROM discos WHERE titulo = ?";
        
        Connection conn = ConnectionBD.getConnection();      
        
        PreparedStatement cmd;
        
        try{
            cmd = conn.prepareStatement(sql);
            
           
            
            ResultSet rs;
            
            rs = cmd.executeQuery();
            
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Deu ruim");
        }
    
  
       
       cmd = conn.prepareStatement(sql);
       
       ResultSet rs;
       
       rs = cmd.executeQuery();
       ;
        return null;
    }
    

}

