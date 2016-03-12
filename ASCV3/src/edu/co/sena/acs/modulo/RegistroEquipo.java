/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.acs.modulo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Manzon
 */
@Entity
@Table(name = "REGISTRO_EQUIPO")
@NamedQueries({
    @NamedQuery(name = "RegistroEquipo.findAll", query = "SELECT r FROM RegistroEquipo r"),
    @NamedQuery(name = "RegistroEquipo.findByRegistroIdRegistro", query = "SELECT r FROM RegistroEquipo r WHERE r.registroEquipoPK.registroIdRegistro = :registroIdRegistro"),
    @NamedQuery(name = "RegistroEquipo.findByPropietarioEquipoCodigoBarras", query = "SELECT r FROM RegistroEquipo r WHERE r.registroEquipoPK.propietarioEquipoCodigoBarras = :propietarioEquipoCodigoBarras"),
    @NamedQuery(name = "RegistroEquipo.findByPropietarioCuentaTipoDocumentoTipoDocumento", query = "SELECT r FROM RegistroEquipo r WHERE r.registroEquipoPK.propietarioCuentaTipoDocumentoTipoDocumento = :propietarioCuentaTipoDocumentoTipoDocumento"),
    @NamedQuery(name = "RegistroEquipo.findByPropietarioCuentaNumeroDocumento", query = "SELECT r FROM RegistroEquipo r WHERE r.registroEquipoPK.propietarioCuentaNumeroDocumento = :propietarioCuentaNumeroDocumento"),
    @NamedQuery(name = "RegistroEquipo.findByEstado", query = "SELECT r FROM RegistroEquipo r WHERE r.estado = :estado")})
public class RegistroEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RegistroEquipoPK registroEquipoPK;
    @Column(name = "ESTADO")
    private Boolean estado;
    @JoinColumns({
        @JoinColumn(name = "PROPIETARIO_EQUIPO_CODIGO_BARRAS", referencedColumnName = "EQUIPO_CODIGO_BARRAS", insertable = false, updatable = false),
        @JoinColumn(name = "PROPIETARIO_CUENTA_TIPO_DOCUMENTO_TIPO_DOCUMENTO", referencedColumnName = "CUENTA_TIPO_DOCUMENTO_TIPO_DOCUMENTO", insertable = false, updatable = false),
        @JoinColumn(name = "PROPIETARIO_CUENTA_NUMERO_DOCUMENTO", referencedColumnName = "CUENTA_NUMERO_DOCUMENTO", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Propietario propietario;
    @JoinColumn(name = "REGISTRO_ID_REGISTRO", referencedColumnName = "ID_REGISTRO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Registro registro;

    public RegistroEquipo() {
    }

    public RegistroEquipo(RegistroEquipoPK registroEquipoPK) {
        this.registroEquipoPK = registroEquipoPK;
    }

    public RegistroEquipo(int registroIdRegistro, String propietarioEquipoCodigoBarras, String propietarioCuentaTipoDocumentoTipoDocumento, String propietarioCuentaNumeroDocumento) {
        this.registroEquipoPK = new RegistroEquipoPK(registroIdRegistro, propietarioEquipoCodigoBarras, propietarioCuentaTipoDocumentoTipoDocumento, propietarioCuentaNumeroDocumento);
    }

    public RegistroEquipoPK getRegistroEquipoPK() {
        return registroEquipoPK;
    }

    public void setRegistroEquipoPK(RegistroEquipoPK registroEquipoPK) {
        this.registroEquipoPK = registroEquipoPK;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

}
