/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.Note;

/**
 *
 * @author adelplace
 */
@Stateless
public class NoteFacade extends AbstractFacade<Note> implements NoteFacadeLocal {
    @PersistenceContext(unitName = "simplist-webservicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    public NoteFacade() {
	super(Note.class);
    }
    
}
