package fr.mtp.epsi.entities;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by pallier04 on 21/04/2014.
 */
public class TypeListe implements Serializable{
    private int id;
    private String Titre;
    public ArrayList<Note> ListeDeNote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeListe(){
        this.Titre = "aucun titre";
        this.ListeDeNote = new ArrayList<Note>();
    }

    public TypeListe(String P_Titre){
        this.Titre = P_Titre;
        this.ListeDeNote = new ArrayList<Note>();
    }

    public void AddNote(Note P_NouvelleNote){
        this.ListeDeNote.add(P_NouvelleNote);
    }

    public void DeleteNote(Note P_NoteAsupprimer){
        this.ListeDeNote.remove(P_NoteAsupprimer);
        //penser a supprimer cette note hors de la liste
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }
}
