package simplist.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplist.entities.Note;

/**
 *
 * @author adelplace
 */
@Stateless
public class NoteDAO extends AbstractDAO<Note> {
    @PersistenceContext(unitName = "simplist-wsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NoteDAO() {
        super(Note.class);
        JPQL_SELECT_BY_IDPARENT = "SELECT n FROM Note n WHERE n.NOTELIST_ID=:notelist_id";
        PARAM_IDPARENT = "notelist_id";
    }
    
}
