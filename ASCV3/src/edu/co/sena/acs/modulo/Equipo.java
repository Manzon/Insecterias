/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.acs.modulo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Manzon
 */
@Entity
@Table(name = "EQUIPO")
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByCodigoBarras", query = "SELECT e FROM Equipo e WHERE e.codigoBarras = :codigoBarras"),
    @NamedQuery(name = "Equipo.findByMarca", query = "SELECT e FROM Equipo e WHERE e.marca = :marca"),
    @NamedQuery(name = "Equipo.findByDescripcion", query = "SELECT e FROM Equipo e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "Equipo.findByEstado", query = "SELECT e FROM Equipo e WHERE e.estado = :estado")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "CODIGO_BARRAS")
    private String codigoBarras;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ESTADO")
    private Boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipo")
    private Collection<Propietario> propietarioCollection;

    public Equipo() {
    }

    public Equipo(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Equipo(String codigoBarras, String marca) {
        this.codigoBarras = codigoBarras;
        this.marca = marca;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Propietario> getPropietarioCollection() {
        return propietarioCollection;
    }

    public void setPropietarioCollection(Collection<Propietario> propietarioCollection) {
        this.propietarioCollection = propietarioCollection;
    }
    
}
