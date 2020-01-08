/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mysql;

import Beans.Estudiante;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Steve_Guillermo_AC
 */
@Stateless
public class EstudianteFacade extends AbstractFacade<Estudiante> {

    @PersistenceContext(unitName = "JavaWeb_SteveGuillermoACPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstudianteFacade() {
        super(Estudiante.class);
    }
    
}
