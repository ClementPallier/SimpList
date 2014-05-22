package fr.mtp.epsi.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import fr.mtp.epsi.R;
import fr.mtp.epsi.entities.TypeListe;
import fr.mtp.epsi.save.Telechargement;

public class MainActivity extends ListActivity {

    ArrayList<TypeListe> ListeDeType;
    ArrayAdapter<String> AdapterCategorie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ListeDeType = new ArrayList<TypeListe>();
        this.ListeDeType.add(new TypeListe("Courses"));
        Telechargement T = new Telechargement();
        T.getCategory();
        AdapterCategorie = new ArrayAdapter<String>(this , R.layout.categrories_cell,R.id.Categorie);
        AdapterCategorie.add(ListeDeType.get(0).getTitre());
        setListAdapter(AdapterCategorie);
    }




    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, ArrayListActivity.class);
        Bundle L_Bundle = new Bundle();
        L_Bundle.putSerializable("SER_CAT",ListeDeType.get(position));
        i.putExtras(L_Bundle);
        startActivity(i);
    }
}
