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
import model.user;



/**
 *
 * @author ASUS
 */
public class user_sql {
     Connection cn = null;
     Statement st = null;
     ResultSet rs = null;
     user User;
     user[] USERS;

    public user_sql(conxBD cb){
      
        cn = cb.cn; 
        st= cb.st; 
        rs= cb.rs;
        
    }
    public void insert(String id, String mdp,String email,String dn, String statut){
         try {
             st.executeUpdate("INSERT INTO USERS " + " VALUES ('"+id+"','"+mdp+"','"+email+"','"+dn+"','"+statut+"')");
         } catch (SQLException ex) {
             Logger.getLogger(user_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    } 
    public user[] selectALL(){
        User= new user();
        int i =0;
        USERS =new user[this.count()];
         try {
             rs = st.executeQuery("SELECT * FROM users");
             while(rs.next()){
                  User.setDn(rs.getString("dn"));
                  User.setEmail(rs.getString("email"));
                  User.setId(rs.getString("id"));
                  User.setMdp(rs.getString("mdp"));
                  User.setStatut(rs.getString("statut"));
                  USERS[i]=User;
                  i++;
                  User= new user();
             }
         } catch (SQLException ex) {
             Logger.getLogger(user_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
       
      return  USERS;
    }
     public boolean selectSelonLogin(String login){
       boolean exist = false; 
       String Login = null; 
      
         try {
             rs = st.executeQuery("SELECT * FROM users where id='"+login+"'");
              if (rs.next()){
                exist = true;
            }
         } catch (SQLException ex) {
             Logger.getLogger(user_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
        
             
       return exist; 
    
     }
     public int count()
    {
        int nb = 0;
         try {
             rs = st.executeQuery("SELECT COUNT(*) AS nbLignes FROM users");
             rs.next();
            nb = rs.getInt("nbLignes");
         } catch (SQLException ex) {
             Logger.getLogger(modele_e_c_u_sql.class.getName()).log(Level.SEVERE, null, ex);
         }
        return nb;
    }
    
}
