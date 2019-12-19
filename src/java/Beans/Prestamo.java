/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Steve_Guillermo_AC
 */
@Entity
@Table(name = "prestamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prestamo.findAll", query = "SELECT p FROM Prestamo p")
    , @NamedQuery(name = "Prestamo.findByIdprestamo", query = "SELECT p FROM Prestamo p WHERE p.prestamoPK.idprestamo = :idprestamo")
    , @NamedQuery(name = "Prestamo.findByIngreso", query = "SELECT p FROM Prestamo p WHERE p.ingreso = :ingreso")
    , @NamedQuery(name = "Prestamo.findBySalida", query = "SELECT p FROM Prestamo p WHERE p.salida = :salida")
    , @NamedQuery(name = "Prestamo.findByLibroIdlibro", query = "SELECT p FROM Prestamo p WHERE p.prestamoPK.libroIdlibro = :libroIdlibro")
    , @NamedQuery(name = "Prestamo.findByBibliotecaIdbiblioteca", query = "SELECT p FROM Prestamo p WHERE p.bibliotecaIdbiblioteca = :bibliotecaIdbiblioteca")})
public class Prestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PrestamoPK prestamoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ingreso")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ingreso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "salida")
    private String salida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "biblioteca_idbiblioteca")
    private int bibliotecaIdbiblioteca;

    public Prestamo() {
    }

    public Prestamo(PrestamoPK prestamoPK) {
        this.prestamoPK = prestamoPK;
    }

    public Prestamo(PrestamoPK prestamoPK, Date ingreso, String salida, int bibliotecaIdbiblioteca) {
        this.prestamoPK = prestamoPK;
        this.ingreso = ingreso;
        this.salida = salida;
        this.bibliotecaIdbiblioteca = bibliotecaIdbiblioteca;
    }

    public Prestamo(int idprestamo, int libroIdlibro) {
        this.prestamoPK = new PrestamoPK(idprestamo, libroIdlibro);
    }

    public PrestamoPK getPrestamoPK() {
        return prestamoPK;
    }

    public void setPrestamoPK(PrestamoPK prestamoPK) {
        this.prestamoPK = prestamoPK;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
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
        hash += (prestamoPK != null ? prestamoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prestamo)) {
            return false;
        }
        Prestamo other = (Prestamo) object;
        if ((this.prestamoPK == null && other.prestamoPK != null) || (this.prestamoPK != null && !this.prestamoPK.equals(other.prestamoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.Prestamo[ prestamoPK=" + prestamoPK + " ]";
    }
    
}
