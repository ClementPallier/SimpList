/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.List;
import javax.ejb.Local;
import jpa.Geoloc;

/**
 *
 * @author adelplace
 */
@Local
public interface GeolocFacadeLocal {

    void create(Geoloc geoloc);

    void edit(Geoloc geoloc);

    void remove(Geoloc geoloc);

    Geoloc find(Object id);

    List<Geoloc> findAll();

    List<Geoloc> findRange(int[] range);

    int count();
    
}
