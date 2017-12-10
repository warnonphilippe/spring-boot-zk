package be.civadis.stc.web.servlet;

import org.restlet.ext.servlet.ServerServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Descendant de la servlet REST définie pour le cas où
 * on souhaiterait surcharger l'une ou l'autre méthode
 * @author yvp
 */
public class StcRestServlet extends ServerServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }
}
