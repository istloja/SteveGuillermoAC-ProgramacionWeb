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
public class DocenteHasEstudiantePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "docente_iddocente")
    private int docenteIddocente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estudiante_idestudiante")
    private int estudianteIdestudiante;

    public DocenteHasEstudiantePK() {
    }

    public DocenteHasEstudiantePK(int docenteIddocente, int estudianteIdestudiante) {
        this.docenteIddocente = docenteIddocente;
        this.estudianteIdestudiante = estudianteIdestudiante;
    }

    public int getDocenteIddocente() {
        return docenteIddocente;
    }

    public void setDocenteIddocente(int docenteIddocente) {
        this.docenteIddocente = docenteIddocente;
    }

    public int getEstudianteIdestudiante() {
        return estudianteIdestudiante;
    }

    public void setEstudianteIdestudiante(int estudianteIdestudiante) {
        this.estudianteIdestudiante = estudianteIdestudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) docenteIddocente;
        hash += (int) estudianteIdestudiante;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocenteHasEstudiantePK)) {
            return false;
        }
        DocenteHasEstudiantePK other = (DocenteHasEstudiantePK) object;
        if (this.docenteIddocente != other.docenteIddocente) {
            return false;
        }
        if (this.estudianteIdestudiante != other.estudianteIdestudiante) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.DocenteHasEstudiantePK[ docenteIddocente=" + docenteIddocente + ", estudianteIdestudiante=" + estudianteIdestudiante + " ]";
    }
    
}
