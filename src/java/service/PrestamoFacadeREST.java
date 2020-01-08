/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Beans.Prestamo;
import Beans.PrestamoPK;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Steve_Guillermo_AC
 */
@Stateless
@Path("beans.prestamo")
public class PrestamoFacadeREST extends AbstractFacade<Prestamo> {

    @PersistenceContext(unitName = "JavaWeb_SteveGuillermoACPU")
    private EntityManager em;

    private PrestamoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idprestamo=idprestamoValue;libroIdlibro=libroIdlibroValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        Beans.PrestamoPK key = new Beans.PrestamoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idprestamo = map.get("idprestamo");
        if (idprestamo != null && !idprestamo.isEmpty()) {
            key.setIdprestamo(new java.lang.Integer(idprestamo.get(0)));
        }
        java.util.List<String> libroIdlibro = map.get("libroIdlibro");
        if (libroIdlibro != null && !libroIdlibro.isEmpty()) {
            key.setLibroIdlibro(new java.lang.Integer(libroIdlibro.get(0)));
        }
        return key;
    }

    public PrestamoFacadeREST() {
        super(Prestamo.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Prestamo entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") PathSegment id, Prestamo entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        Beans.PrestamoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Prestamo find(@PathParam("id") PathSegment id) {
        Beans.PrestamoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Prestamo> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Prestamo> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
