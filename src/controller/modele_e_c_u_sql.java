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
import model.modele_e_c_u;


/**
 *
 * @author ASUS
 */
public class modele_e_c_u_sql {
     Connection cn = null;
     Statement st = null;
     ResultSet rs = null;
     modele_e_c_u moecu;
     modele_e_c_u[] moecus;
  

    public modele_e_c_u_sql( conxBD cb) {
       
        cn = cb.cn; 
        st= cb.st; 
        rs= cb.rs;
       
    }
    public void insert( String nomModeleECU, int marqueECU_id){
        try {
             st.executeUpdate("INSERT INTO modele_e_c_u " + " VALUES (null,'"+nomModeleECU+"',"+marqueECU_id+")");
         } catch (SQLException ex) {
             Logger.getLogger(modele_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    }
    public modele_e_c_u[] selectALL(){
         moecu = new modele_e_c_u();
         int i=0;
         moecus = new modele_e_c_u[this.count()];
         try {
             rs = st.executeQuery("SELECT * FROM modele_e_c_u");
             while (rs.next()){
                 moecu.setId(rs.getInt("id"));
                 moecu.setMarqueECU_id(rs.getInt("marqueECU_id"));
                 moecu.setNomModeleECU(rs.getString("nomModeleECU"));
                 moecus[i]=moecu;
                 i++;
                 moecu = new modele_e_c_u();
             }
            } catch (SQLException ex) {
             Logger.getLogger(modele_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return moecus;
    }
     public modele_e_c_u[] selectSelonmarqueECU_id(int nb){
         int i=0;
         moecu = new modele_e_c_u();
         try {
             rs = st.executeQuery("SELECT COUNT(*) as bb FROM modele_e_c_u where marqueECU_id="+nb);
             rs.next();
             moecus = new modele_e_c_u[rs.getInt("bb")];
             System.out.println("bb"+rs.getInt("bb"));
             rs = st.executeQuery("SELECT * FROM modele_e_c_u where marqueECU_id="+nb);
             while (rs.next()){
                 moecu.setId(rs.getInt("id"));
                 moecu.setMarqueECU_id(rs.getInt("marqueECU_id"));
                 moecu.setNomModeleECU(rs.getString("nomModeleECU"));
                 moecus[i]=moecu;
                 i++;
                 moecu = new modele_e_c_u();
             }
            } catch (SQLException ex) {
             Logger.getLogger(modele_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return moecus;
    }
       public int selectIDSelonNomModeleECU(String nomModeleECU){
         moecu = new modele_e_c_u();
         int i=0;
         int id = 0;
         moecus = new modele_e_c_u[this.count()];
         try {
            rs = st.executeQuery("SELECT * FROM modele_e_c_u where nomModeleECU='"+nomModeleECU+"'");
           while (rs.next()){
                 id =rs.getInt("id");
             }
            } catch (SQLException ex) {
             Logger.getLogger(modele_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return id;
    }
    public int count()
    {
        int nb = 0;
         try {
             rs = st.executeQuery("SELECT count(*) as nb FROM modele_e_c_u");
             rs.next();
            nb = rs.getInt("nb");
         } catch (SQLException ex) {
             Logger.getLogger(modele_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
        return nb;
    }
     public int countModelmarqueECU_id(int id)
    {
        int nb = 0;
         try {
              rs = st.executeQuery("SELECT count(*) as nb FROM modele_e_c_u where marqueECU_id="+id);
              rs.next();
              nb = rs.getInt("nb");
         } catch (SQLException ex) {
             Logger.getLogger(modele_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
        return nb;
    }
}
