/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Modelo.Usuarios;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Steve_Guillermo_AC
 */
@WebFilter("*.xhtml")
public class SessionUrlFilter implements Filter {


    public SessionUrlFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest hsrequest = (HttpServletRequest) request;
        HttpServletResponse hsresponse = (HttpServletResponse) response;
        boolean loginn = false;
        boolean redireccionar = true;
        String pag[] = {"/sga/index.xhtml"};
        HttpSession htpsesionguardado = hsrequest.getSession(true);
        Usuarios usuario001 = (Usuarios) htpsesionguardado.getAttribute("usuario");

        if (usuario001 != null) {
            System.out.println("");
            redireccionar = false;
            System.out.println("filter");

        } else {
            System.out.println("aca");
            for (String item : pag) {
                if (hsrequest.getRequestURI().contains(item)) {
                    redireccionar = false;
                }
            }
        }

//        if (loginn) {
//            chain.doFilter(request, response);
//            System.out.println("filter 2");
//        } else {
//            for (String item : pag) {
//                if (hsrequest.getRequestURI().contains(item)) {
//                    redireccionar = false;
//                }
//            }
//
//        }
        if (redireccionar) {
            hsresponse.sendRedirect(hsrequest.getContextPath() + "/sga/index.xhtml");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Return the filter configuration object for this filter.
     */
    

}
