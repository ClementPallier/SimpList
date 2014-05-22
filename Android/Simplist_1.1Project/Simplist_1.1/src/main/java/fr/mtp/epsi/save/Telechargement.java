package fr.mtp.epsi.save;

import android.app.Activity;

import fr.mtp.epsi.entities.TypeListe;

/**
 * Created by pallier04 on 22/05/2014.
 */
public class Telechargement{

    private static Cache cache = new Cache();

    public TypeListe getCategory(){
        TypeListe tl = new TypeListe("test");
        tl.setId(1);

        cache.write(tl);
        cache.read();
        return null;
    }

    public void getNotes(TypeListe categorie){

    }

    public void setCategory(){

    }
}
