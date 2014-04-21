package simplist.resources;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import simplist.dao.UserDAO;
import simplist.entities.User;

/**
 *
 * @author adelplace
 */
@Path("/users")
public class UserRS extends AbstractRS<User> {

    @EJB
    private final UserDAO userDAO;
    
    public UserRS() {
        userDAO = new UserDAO();
    }

    @GET
    @Override
    public String getAll() {
        return this.findAllProcess(userDAO);
    }
    
    @GET
    @Path("{param}")
    @Override
    public String getOne(@PathParam("param") String param) {
        return userDAO.findByLogin(param).toJSON();
    }
    
    @PUT
    @Override
    public void put() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void postOne(
            @FormParam("login") String login,
            @FormParam("email") String email,
            @FormParam("password") String password) {
        User user = new User();
        user.setEmail(email);
        user.setLogin(login);
        user.setPassword(password);
        userDAO.create(user);
    }
    
    @DELETE
    @Override
    public void deleteAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @DELETE
    @Path("{param}")
    @Override
    public void deleteOne(@PathParam("param") String param) {
        userDAO.remove(userDAO.findByLogin(param));
    }

    
    
}
