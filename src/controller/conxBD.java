/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class conxBD {
     String url= "jdbc:mysql://localhost/ess";
     String login="root";
     String mdp="";
     Connection cn = null;
     Statement st = null;
     ResultSet rs = null;
    public void connexionBD(){
      
         try {
             // Class.forName("com.mysql.jdbc.Driver");
             cn = (Connection) DriverManager.getConnection(url, login, mdp);
             st = (Statement) cn.createStatement();
             rs = st.executeQuery("select id from users");
             while (rs.next()){
                 System.out.println(rs.getString("id"));
             }
         } catch (SQLException ex) {
             Logger.getLogger(conxBD.class.getName()).log(Level.SEVERE, null, ex);
         }
      
    }
    
}
