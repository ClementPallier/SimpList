package simplist.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplist.entities.User;

/**
 *
 * @author adelplace
 */
@Stateless
public class UserDAO extends AbstractDAO<User> {
    @PersistenceContext(unitName = "simplist-wsPU")
    private EntityManager em;

    private static final String JPQ_SELECT_BY_LOGIN = "SELECT u FROM User u WHERE u.login=:login";
    private static final String PARAM_LOGIN = "login";
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserDAO() {
        super(User.class);
    }
    
    public User findByLogin(String login) {
        return (User) em.createQuery(JPQ_SELECT_BY_LOGIN).setParameter( PARAM_LOGIN, login).getSingleResult();
    }
    
}
