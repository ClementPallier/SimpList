package simplist.entities;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;


/**
 *
 * @author adelplace
 */

@Entity
@Table(name="USER")
public class User extends AbstractEntity implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    
    @Column(name="LOGIN", unique = true)
    private String login;
    
    @Column(name="PASSWORD")
    private String password;
    
    @OneToMany(mappedBy = "user")
    private List<ListNote> listNotes;
    
    @Column(name="EMAIL", unique = true)
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toJSON() {
        return "{ login : " + login + " , email : " + email + " , password : " + password + " }";
    }

}
