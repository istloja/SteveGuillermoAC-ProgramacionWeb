/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;

@Named(value = "primerBean")
@ViewScoped
public class PrimerBean implements Serializable {

    /**
     * Creates a new instance of PrimerBean
     */
    private int valor1;
    private String nombre;
    private String opcion;
    private List <String> lista;
    private String nombreUsuario ;
    private String claveUsuario ;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public String getOpcion() {
        System.out.println("Opcion"+opcion);
        return opcion;
        
    }

    public List<String> getLista() {
        return lista;
    }

    public void setLista(List<String> lista) {
        this.lista = lista;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor1() {
        return valor1;
    }

    public void setValor1(int valor1) {
        this.valor1 = valor1;
    }
    
    public PrimerBean() {
    }
    public String add() {
        String url=null;
        FacesMessage message;
        if(nombreUsuario.equals("usuario001") && claveUsuario.equals("123456")){
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido","");
            url="/pagina_cliente2.xhtml?faces-redirect=true";
        }
        else{
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Datos Incorrectos","");
        }
        FacesContext.getCurrentInstance().addMessage(null, message);
      return url;  
    }

    
}

