/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.List;
import javax.ejb.Local;
import jpa.TypeList;

/**
 *
 * @author adelplace
 */
@Local
public interface TypeListFacadeLocal {

    void create(TypeList typeList);

    void edit(TypeList typeList);

    void remove(TypeList typeList);

    TypeList find(Object id);

    List<TypeList> findAll();

    List<TypeList> findRange(int[] range);

    int count();
    
}
