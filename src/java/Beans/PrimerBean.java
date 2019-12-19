/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import Modelo.Usuarios;
import javax.servlet.http.HttpSession;
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
    List <Usuarios> listaUsuarios;

   
    

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
     
        listaUsuarios = new ArrayList<Usuarios>();
        listaUsuarios.add(new Usuarios("Steve","12345","qwerty","Estudiante"));
        listaUsuarios.add(new Usuarios("Jefferson","11111","asdfg","Docente"));
        listaUsuarios.add(new Usuarios("Juan","22222","xcvb","Administrador"));
        listaUsuarios.add(new Usuarios("Luis","33333","qazws","Estudiante"));
    }
    public String IniciarSesion() {
        
        String url = "";
        FacesMessage message;
        for (Usuarios user :listaUsuarios) {
 
            if (nombreUsuario != null && nombreUsuario.equals(user.getUsuario())&& claveUsuario != null && claveUsuario.equals(user.getClave()) ) {
                if (user.getRol().equals("Administrador")) {
                    url = "pagAdministrador.xhtml?faces-redirect=true";
                    HttpSession sesion=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    sesion.setAttribute("usuario",user);
                }
                else{
                
                    if (user.getRol().equals("Estudiante")) {
                        url = "pagEstudiante.xhtml?faces-redirect=true";
                        
                    }
                    else{
                        if (user.getRol().equals("Docente")) {
                            url = "pagDocente.xhtml?faces-redirect=true";
                            
                        }
                    }
                
                }
            }
        }
        
//        if(nombreUsuario.equals("usuario001") && claveUsuario.equals("123456")){
//            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido","");
//           url="pagAdministrador?faces-redirect=true0";
//        }
//        else{
//            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Datos Incorrectos","");
//        }
//        FacesContext.getCurrentInstance().addMessage(null, message);
      return url;  
      
    }   
}

