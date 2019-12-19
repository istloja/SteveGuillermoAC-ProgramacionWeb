/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Steve_Guillermo_AC
 */
@Embeddable
public class PrestamoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idprestamo")
    private int idprestamo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "libro_idlibro")
    private int libroIdlibro;

    public PrestamoPK() {
    }

    public PrestamoPK(int idprestamo, int libroIdlibro) {
        this.idprestamo = idprestamo;
        this.libroIdlibro = libroIdlibro;
    }

    public int getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(int idprestamo) {
        this.idprestamo = idprestamo;
    }

    public int getLibroIdlibro() {
        return libroIdlibro;
    }

    public void setLibroIdlibro(int libroIdlibro) {
        this.libroIdlibro = libroIdlibro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idprestamo;
        hash += (int) libroIdlibro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrestamoPK)) {
            return false;
        }
        PrestamoPK other = (PrestamoPK) object;
        if (this.idprestamo != other.idprestamo) {
            return false;
        }
        if (this.libroIdlibro != other.libroIdlibro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.PrestamoPK[ idprestamo=" + idprestamo + ", libroIdlibro=" + libroIdlibro + " ]";
    }
    
}
