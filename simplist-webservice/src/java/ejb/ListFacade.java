/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.List;

/**
 *
 * @author adelplace
 */
@Stateless
public class ListFacade extends AbstractFacade<List> implements ListFacadeLocal {
    @PersistenceContext(unitName = "simplist-webservicePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
	return em;
    }

    public ListFacade() {
	super(List.class);
    }
    
}
