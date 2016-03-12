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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "PROPIETARIO")
@NamedQueries({
    @NamedQuery(name = "Propietario.findAll", query = "SELECT p FROM Propietario p"),
    @NamedQuery(name = "Propietario.findByEquipoCodigoBarras", query = "SELECT p FROM Propietario p WHERE p.propietarioPK.equipoCodigoBarras = :equipoCodigoBarras"),
    @NamedQuery(name = "Propietario.findByCuentaTipoDocumentoTipoDocumento", query = "SELECT p FROM Propietario p WHERE p.propietarioPK.cuentaTipoDocumentoTipoDocumento = :cuentaTipoDocumentoTipoDocumento"),
    @NamedQuery(name = "Propietario.findByCuentaNumeroDocumento", query = "SELECT p FROM Propietario p WHERE p.propietarioPK.cuentaNumeroDocumento = :cuentaNumeroDocumento"),
    @NamedQuery(name = "Propietario.findByEstado", query = "SELECT p FROM Propietario p WHERE p.estado = :estado")})
public class Propietario implements Serializable {

    @EmbeddedId
    protected PropietarioPK propietarioPK;
    @Column(name = "ESTADO")
    private Boolean estado;
    @JoinColumns({
        @JoinColumn(name = "CUENTA_TIPO_DOCUMENTO_TIPO_DOCUMENTO", referencedColumnName = "TIPO_DOCUMENTO_TIPO_DOCUMENTO", insertable = false, updatable = false),
        @JoinColumn(name = "CUENTA_NUMERO_DOCUMENTO", referencedColumnName = "NUMERO_DOCUMENTO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Cuenta cuenta;
    @JoinColumn(name = "EQUIPO_CODIGO_BARRAS", referencedColumnName = "CODIGO_BARRAS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Equipo equipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "propietario")
    private Collection<RegistroEquipo> registroEquipoCollection;

    public Propietario() {
    }

    public Propietario(PropietarioPK propietarioPK) {
        this.propietarioPK = propietarioPK;
    }

    public Propietario(String equipoCodigoBarras, String cuentaTipoDocumentoTipoDocumento, String cuentaNumeroDocumento) {
        this.propietarioPK = new PropietarioPK(equipoCodigoBarras, cuentaTipoDocumentoTipoDocumento, cuentaNumeroDocumento);
    }

    public PropietarioPK getPropietarioPK() {
        return propietarioPK;
    }

    public void setPropietarioPK(PropietarioPK propietarioPK) {
        this.propietarioPK = propietarioPK;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @XmlTransient
    public Collection<RegistroEquipo> getRegistroEquipoCollection() {
        return registroEquipoCollection;
    }

    public void setRegistroEquipoCollection(Collection<RegistroEquipo> registroEquipoCollection) {
        this.registroEquipoCollection = registroEquipoCollection;
    }

}
