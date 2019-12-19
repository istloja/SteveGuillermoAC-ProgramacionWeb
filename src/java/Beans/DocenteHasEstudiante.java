/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Steve_Guillermo_AC
 */
@Entity
@Table(name = "docente_has_estudiante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocenteHasEstudiante.findAll", query = "SELECT d FROM DocenteHasEstudiante d")
    , @NamedQuery(name = "DocenteHasEstudiante.findByDocenteIddocente", query = "SELECT d FROM DocenteHasEstudiante d WHERE d.docenteHasEstudiantePK.docenteIddocente = :docenteIddocente")
    , @NamedQuery(name = "DocenteHasEstudiante.findByEstudianteIdestudiante", query = "SELECT d FROM DocenteHasEstudiante d WHERE d.docenteHasEstudiantePK.estudianteIdestudiante = :estudianteIdestudiante")})
public class DocenteHasEstudiante implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DocenteHasEstudiantePK docenteHasEstudiantePK;

    public DocenteHasEstudiante() {
    }

    public DocenteHasEstudiante(DocenteHasEstudiantePK docenteHasEstudiantePK) {
        this.docenteHasEstudiantePK = docenteHasEstudiantePK;
    }

    public DocenteHasEstudiante(int docenteIddocente, int estudianteIdestudiante) {
        this.docenteHasEstudiantePK = new DocenteHasEstudiantePK(docenteIddocente, estudianteIdestudiante);
    }

    public DocenteHasEstudiantePK getDocenteHasEstudiantePK() {
        return docenteHasEstudiantePK;
    }

    public void setDocenteHasEstudiantePK(DocenteHasEstudiantePK docenteHasEstudiantePK) {
        this.docenteHasEstudiantePK = docenteHasEstudiantePK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (docenteHasEstudiantePK != null ? docenteHasEstudiantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocenteHasEstudiante)) {
            return false;
        }
        DocenteHasEstudiante other = (DocenteHasEstudiante) object;
        if ((this.docenteHasEstudiantePK == null && other.docenteHasEstudiantePK != null) || (this.docenteHasEstudiantePK != null && !this.docenteHasEstudiantePK.equals(other.docenteHasEstudiantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Beans.DocenteHasEstudiante[ docenteHasEstudiantePK=" + docenteHasEstudiantePK + " ]";
    }
    
}
