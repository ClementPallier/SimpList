/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simplist.dao;

import java.util.List;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplist.entities.User;

/**
 *
 * @author adelplace
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED) 
public class Dao {
    
    @PersistenceContext
    private EntityManager em;
    
    public List<User> getAllUsers() {
        return em.createQuery("SELECT u FROM User u").getResultList();
    }
}
