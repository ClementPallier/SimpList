package fr.mtp.epsi.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import fr.mtp.epsi.R;
import fr.mtp.epsi.entities.Note;
import fr.mtp.epsi.entities.TypeListe;

public class Note_Detail extends Activity{

    TextView Contenu_Note;
    TextView Titre_Note;
    TypeListe Liste;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_detail);

        Liste = (TypeListe) getIntent().getSerializableExtra("SER_NOTE");
        position = getIntent().getIntExtra("position",0);
        Note LaNote = Liste.ListeDeNote.get(position);
        //LaNote = (Note)getIntent().getSerializableExtra("SER_NOTE");

        Titre_Note = (TextView)findViewById(R.id.Titre_Note);
        Titre_Note.setText(LaNote.getTitre());
        Contenu_Note = (TextView)findViewById(R.id.Contenu);
        Contenu_Note.setText(LaNote.getContenu());

    }

    public void SaveContent(View LeBouton){
        Liste.ListeDeNote.get(position).setContenu(Contenu_Note.getText().toString());
    }
}
