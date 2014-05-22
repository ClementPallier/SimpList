package fr.mtp.epsi.entities;

import java.io.Serializable;

/**
 * Created by pallier04 on 21/04/2014.
 */
public class Note implements Serializable{
    private int id;
    private String Titre;
    private String Contenu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Note(){
        this.Titre = "aucun titre";
        this.Contenu = "Ecrivez ici";
    }

    public Note(String P_Titre, String P_Contenu){
        this.Titre = P_Titre;
        this.Contenu = P_Contenu;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String contenu) {
        Contenu = contenu;
    }
}
