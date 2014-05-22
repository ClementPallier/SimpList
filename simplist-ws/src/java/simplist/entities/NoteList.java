package simplist.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author adelplace
 */
@Entity
@Table(name="NOTE_LIST")
@XmlRootElement
public class NoteList extends AbstractEntity implements Serializable {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    
    @Column(name="libelle", unique = true)
    private String libelle;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    
    @OneToMany(mappedBy = "noteList")
    private List<Note> notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toJSON() {
        return "{ libelle : " + libelle + ", user_id : " + user.getId() + "}";
    }
    
    
}
