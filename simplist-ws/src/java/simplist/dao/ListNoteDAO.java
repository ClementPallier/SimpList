/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simplist.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import simplist.entities.ListNote;

/**
 *
 * @author adelplace
 */
@Stateless
public class ListNoteDAO extends AbstractDAO<ListNote> {
    @PersistenceContext(unitName = "simplist-wsPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListNoteDAO() {
        super(ListNote.class);
    }
    
}
