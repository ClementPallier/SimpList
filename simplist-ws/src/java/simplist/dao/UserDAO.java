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

    private static final String JPQ_SELECT_BY_LOGIN = "SELECT u FROM User u WHERE (u.login=:login OR u.email=:login) AND u.password=:password";
    private static final String JPQ_SELECT_BY_ID = "SELECT u FROM User u WHERE u.id=:id";
    
    private static final String PARAM_LOGIN = "login";
    private static final String PARAM_PASSWORD = "password";
    private static final String PARAM_ID = "id";
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserDAO() {
        super(User.class);
    }
    
    public User findByLoginPassword(String login, String password) {
        return (User) em.createQuery(JPQ_SELECT_BY_LOGIN).setParameter(PARAM_LOGIN, login).setParameter(PARAM_PASSWORD, password).getSingleResult();
    }
    
    public User findById(int id) {
        return (User) em.createQuery(JPQ_SELECT_BY_ID).setParameter( PARAM_ID, id).getSingleResult();
    }
    
}
