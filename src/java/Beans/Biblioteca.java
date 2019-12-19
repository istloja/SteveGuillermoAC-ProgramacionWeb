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
@Table(name = "biblioteca")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Biblioteca.findAll", query = "SELECT b FROM Biblioteca b")
    , @NamedQuery(name = "Biblioteca.findByIdbiblioteca", query = "SELECT b FROM Biblioteca b WHERE b.idbiblioteca = :idbiblioteca")
    , @NamedQuery(name = "Biblioteca.findByBibliotecacol", query = "SELECT b FROM Biblioteca b WHERE b.bibliotecacol = :bibliotecacol")})
public class Biblioteca implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbiblioteca")
    private Integer idbiblioteca;
    @Size(max = 45)
    @Column(name = "bibliotecacol")
    private String bibliotecacol;

    public Biblioteca() {
    }

    public Biblioteca(Integer idbiblioteca) {
        this.idbiblioteca = idbiblioteca;
    }

    public Integer getIdbiblioteca() {
        return idbiblioteca;
    }

    public void setIdbiblioteca(Integer idbiblioteca) {
        this.idbiblioteca = idbiblioteca;
    }

    public String getBibliotecacol() {
        return bibliotecacol;
    }

    public void setBibliotecacol(String bibliotecacol) {
        this.bibliotecacol = bibliotecacol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbiblioteca != null ? idbiblioteca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biblioteca)) {
            return false;
        }
        Biblioteca other = (Biblioteca) object;
        if ((this.idbiblioteca == null && other.idbiblioteca != null) || (this.idbiblioteca != null && !this.idbiblioteca.equals(other.idbiblioteca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Biblioteca[ idbiblioteca=" + idbiblioteca + " ]";
    }
    
}
