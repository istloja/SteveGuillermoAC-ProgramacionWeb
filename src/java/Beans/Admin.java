/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Steve_Guillermo_AC
 */
@Entity
@Table(name = "admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a")
    , @NamedQuery(name = "Admin.findByIdadmin", query = "SELECT a FROM Admin a WHERE a.idadmin = :idadmin")
    , @NamedQuery(name = "Admin.findByNombre", query = "SELECT a FROM Admin a WHERE a.nombre = :nombre")
    , @NamedQuery(name = "Admin.findByApellido", query = "SELECT a FROM Admin a WHERE a.apellido = :apellido")
    , @NamedQuery(name = "Admin.findByTelefono", query = "SELECT a FROM Admin a WHERE a.telefono = :telefono")
    , @NamedQuery(name = "Admin.findByDireccion", query = "SELECT a FROM Admin a WHERE a.direccion = :direccion")
    , @NamedQuery(name = "Admin.findByBibliotecaIdbiblioteca", query = "SELECT a FROM Admin a WHERE a.bibliotecaIdbiblioteca = :bibliotecaIdbiblioteca")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idadmin")
    private Integer idadmin;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "apellido")
    private String apellido;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "biblioteca_idbiblioteca")
    private int bibliotecaIdbiblioteca;

    public Admin() {
    }

    public Admin(Integer idadmin) {
        this.idadmin = idadmin;
    }

    public Admin(Integer idadmin, int bibliotecaIdbiblioteca) {
        this.idadmin = idadmin;
        this.bibliotecaIdbiblioteca = bibliotecaIdbiblioteca;
    }

    public Integer getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Integer idadmin) {
        this.idadmin = idadmin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getBibliotecaIdbiblioteca() {
        return bibliotecaIdbiblioteca;
    }

    public void setBibliotecaIdbiblioteca(int bibliotecaIdbiblioteca) {
        this.bibliotecaIdbiblioteca = bibliotecaIdbiblioteca;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idadmin != null ? idadmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.idadmin == null && other.idadmin != null) || (this.idadmin != null && !this.idadmin.equals(other.idadmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Admin[ idadmin=" + idadmin + " ]";
    }
    
}
