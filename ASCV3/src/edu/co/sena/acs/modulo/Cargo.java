/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.acs.modulo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Manzon
 */
@Entity
@Table(name = "CARGO")
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByIdCargo", query = "SELECT c FROM Cargo c WHERE c.idCargo = :idCargo"),
    @NamedQuery(name = "Cargo.findByDescripcionCargo", query = "SELECT c FROM Cargo c WHERE c.descripcionCargo = :descripcionCargo"),
    @NamedQuery(name = "Cargo.findByEstado", query = "SELECT c FROM Cargo c WHERE c.estado = :estado")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID_CARGO")
    private String idCargo;
    @Column(name = "DESCRIPCION_CARGO")
    private String descripcionCargo;
    @Column(name = "ESTADO")
    private Boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cargoIdCargo")
    private Collection<Cuenta> cuentaCollection;

    public Cargo() {
    }

    public Cargo(String idCargo) {
        this.idCargo = idCargo;
    }

    public String getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(String idCargo) {
        this.idCargo = idCargo;
    }

    public String getDescripcionCargo() {
        return descripcionCargo;
    }

    public void setDescripcionCargo(String descripcionCargo) {
        this.descripcionCargo = descripcionCargo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Cuenta> getCuentaCollection() {
        return cuentaCollection;
    }

    public void setCuentaCollection(Collection<Cuenta> cuentaCollection) {
        this.cuentaCollection = cuentaCollection;
    }

}
