package simplist.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplist.entities.NoteList;

/**
 *
 * @author adelplace
 */
@Stateless
public class NoteListDAO extends AbstractDAO<NoteList> {
    @PersistenceContext(unitName = "simplist-wsPU")
    private EntityManager em;
    
    private final static String JPQL_SELECT_BY_LIBELLE = "SELECT l FROM ListNote l WHERE l.libelle=:libelle";
    private final static String PARAM_LIBELLE = "libelle";

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NoteListDAO() {
        super(NoteList.class);
        JPQL_SELECT_BY_IDPARENT = "SELECT l FROM NoteList l WHERE l.user.id=:user_id";
        PARAM_IDPARENT = "user_id";
    }
    
    public NoteList findOneByLibelle(String libelle) {
        return (NoteList)em.createQuery(JPQL_SELECT_BY_LIBELLE).setParameter(PARAM_LIBELLE, libelle).getSingleResult();
    }
    
}
