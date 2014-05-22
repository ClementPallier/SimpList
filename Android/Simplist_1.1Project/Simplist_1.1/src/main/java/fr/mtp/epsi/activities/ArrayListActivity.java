package fr.mtp.epsi.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import fr.mtp.epsi.entities.Note;
import fr.mtp.epsi.entities.TypeListe;

public class ArrayListActivity extends ListActivity {
    ArrayAdapter<String> Donnees;
    //ArrayList<Note> Liste_Note;
    TypeListe CategorieNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_array_list);
        Donnees = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_multiple_choice);

        CategorieNote = (TypeListe)getIntent().getSerializableExtra("SER_CAT");
        //Recuperer les notes via WebService ou en local
        CategorieNote.AddNote(new Note("premiere note","fahamille"));
        CategorieNote.AddNote(new Note("seconde note","fahamille"));
        int L_NombreNotes = CategorieNote.ListeDeNote.size();
        for(int i=0;i<L_NombreNotes;i++){
            Donnees.add(CategorieNote.ListeDeNote.get(i).getTitre());
        }
        setListAdapter(Donnees);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, Note_Detail.class);
        Bundle L_Bundle = new Bundle();
        //Note LaNote = CategorieNote.ListeDeNote.get(position);
        L_Bundle.putSerializable("SER_NOTE",CategorieNote);
        L_Bundle.putInt("position",position);
        i.putExtras(L_Bundle);
        startActivity(i);
    }

    @Override
    public int getSelectedItemPosition() { //permet de récuperer l'indice correspondant à l'item coché.
        return super.getSelectedItemPosition();
    }

    protected void onResume(){
        super.onResume();
    }
}
