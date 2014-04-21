/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import simplist.entities.Image;
import simplist.entities.Line;
import simplist.entities.ListNote;
import simplist.entities.Note;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ejb.EJB;


import simplist.entities.User;
import javax.json.JsonReader;

/**
 *
 * @author adelplace
 */
@WebServlet(urlPatterns = {"/test"})
public class test extends HttpServlet {

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
//        // User
//        User u = new User();
//        
//        u.setLogin("alex");
//        u.setPassword("alex");
//        
//        userDAO.create(u);
//        
//        // listeNote
//        ListNote ln = new ListNote();
//        
//        ln.setLibelle("Permière liste");
//        ln.setUser(u);
//        
//        listeNoteDAO.create(ln);
//        
//        // Note
//        Note n = new Note();
//        
//        n.setBody("onnnonnonnnnoonnn non on on n on ");
//        n.setLibelle("première note");
//        n.setListNote(ln);
//        
//        noteDAO.create(n);
//        
//        // Line
//        Line l = new Line();
//        
//        l.setBody("ma ligne");
//        l.setNote(n);
//        
//        lineDAO.create(l);
//        
//        // Image
//        Image i = new Image();
//        
//        i.setMedPath("medpath");
//        i.setMinPath("minpath");
//        i.setOriginalPath("originalpath");
//        i.setNote(n);
//        
//        imageDAO.create(i);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet test at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
