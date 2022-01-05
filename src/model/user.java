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
public class user {
 String id; 
 String mdp;
 String email;
 String dn;
 String statut;

    public user() {
    }

    public user(String id, String mdp, String email, String dn, String statut) {
        this.id = id;
        this.mdp = mdp;
        this.email = email;
        this.dn = dn;
        this.statut = statut;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }
 
    
    
}
