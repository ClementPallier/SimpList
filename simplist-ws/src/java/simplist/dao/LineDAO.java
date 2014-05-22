package simplist.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplist.entities.Line;

/**
 *
 * @author adelplace
 */
@Stateless
public class LineDAO extends AbstractDAO<Line> {
    @PersistenceContext(unitName = "simplist-wsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineDAO() {
        super(Line.class);
        JPQL_SELECT_BY_IDPARENT = "SELECT l FROM Line WHERE NOTE_ID=:note_id";
        PARAM_IDPARENT = "note_id";
    }
    
    
}
