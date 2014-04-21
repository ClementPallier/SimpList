package simplist.resources;

import java.util.List;
import simplist.dao.AbstractDAO;
import simplist.entities.AbstractEntity;

/**
 *
 * @author adelplace
 * @param <T>
 */
public abstract class AbstractRS<T extends AbstractEntity> {

    public abstract String getAll();
    public abstract String getOne(String param);
    public abstract void put();

    public abstract void deleteAll();
    public abstract void deleteOne(String param);
    
    public String findAllProcess(AbstractDAO dao) {
        List<T> objs = null;
        
        try {
            objs = dao.findAll();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        
        StringBuilder rt = new StringBuilder();
        
        if (objs != null) {
            for (T obj : objs) {
                rt.append(obj.toJSON());
            }
        }
        return rt.toString();
    }
    
}
