/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.List;
import javax.ejb.Local;
import jpa.Line;

/**
 *
 * @author adelplace
 */
@Local
public interface LineFacadeLocal {

    void create(Line line);

    void edit(Line line);

    void remove(Line line);

    Line find(Object id);

    List<Line> findAll();

    List<Line> findRange(int[] range);

    int count();
    
}
