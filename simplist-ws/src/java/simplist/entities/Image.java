package simplist.entities;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author adelplace
 */
@Entity
@Table(name="IMAGE")
public class Image extends AbstractEntity implements Serializable {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    
    @Column(name = "ORIGINAL_PATH")
    private String originalPath;
    
    @Column(name = "MIN_PATH")
    private String minPath;
    
    @Column(name = "MED_PATH")
    private String medPath;
    
    @OneToOne(mappedBy = "image")
    private Note note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalPath() {
        return originalPath;
    }

    public void setOriginalPath(String originalPath) {
        this.originalPath = originalPath;
    }

    public String getMinPath() {
        return minPath;
    }

    public void setMinPath(String minPath) {
        this.minPath = minPath;
    }

    public String getMedPath() {
        return medPath;
    }

    public void setMedPath(String medPath) {
        this.medPath = medPath;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    @Override
    public String toJSON() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
