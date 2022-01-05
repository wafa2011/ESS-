/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ASUS
 */
public class historique_dernier_acces {
   String id_user;
   String date_acces;

    public historique_dernier_acces() {
    }

    public historique_dernier_acces(String id_user, String date_acces) {
        this.id_user = id_user;
        this.date_acces = date_acces;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getDate_acces() {
        return date_acces;
    }

    public void setDate_acces(String date_acces) {
        this.date_acces = date_acces;
    }
   
}
