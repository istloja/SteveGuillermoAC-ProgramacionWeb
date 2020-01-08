/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mysql;

import Beans.Libro;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Steve_Guillermo_AC
 */
@Stateless
public class LibroFacade extends AbstractFacade<Libro> {

    @PersistenceContext(unitName = "JavaWeb_SteveGuillermoACPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LibroFacade() {
        super(Libro.class);
    }
    public List <Libro> Libros (){
    
        String valor =" ";
        List <Libro> libro = null;
    
        TypedQuery<Libro> consulta =getEntityManager().createQuery("SELECT l FROM Libro l WHERE l.idlibro = :idlibro\")\n" +
        "",Libro.class);
        
        libro = consulta.getResultList();
        consulta.setParameter("codigo",valor);
        
    return libro;
    }
    
}
