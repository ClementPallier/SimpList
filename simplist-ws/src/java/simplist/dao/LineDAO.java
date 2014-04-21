/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    }
    
}
