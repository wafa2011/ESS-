/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.solution_ecu;

/**
 *
 * @author ASUS
 */
public class solution_ecu_sql {
     Connection cn = null;
     Statement st = null;
     ResultSet rs = null;
     solution_ecu solecu;

    public solution_ecu_sql(conxBD cb) {
        cn = cb.cn; 
        st= cb.st; 
        rs= cb.rs;
        solecu= new solution_ecu();
        
    }
    public void insert(int id_ecu,int id_solution){
         try {
             st.executeUpdate("INSERT INTO solution_ecu " + " VALUES ("+id_ecu+", "+id_solution+")");
         } catch (SQLException ex) {
             Logger.getLogger(marque_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
      }
    public solution_ecu select(){
        try {
             rs = st.executeQuery("SELECT * FROM solution_ecu");
            while(rs.next()){
               solecu.setId_ecu(rs.getInt("id_ecu"));
               solecu.setId_solution(rs.getInt("id_solution"));
            }
    } catch (SQLException ex) {
             Logger.getLogger(marque_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
        return solecu;
    }
    
    
    
    
}
