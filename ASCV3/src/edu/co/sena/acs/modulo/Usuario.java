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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Manzon
 */
@Entity
@Table(name = "USUARIO")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado"),
    @NamedQuery(name = "Usuario.findByCuentaTipoDocumentoTipoDocumento", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.cuentaTipoDocumentoTipoDocumento = :cuentaTipoDocumentoTipoDocumento"),
    @NamedQuery(name = "Usuario.findByCuentaNumeroDocumento", query = "SELECT u FROM Usuario u WHERE u.usuarioPK.cuentaNumeroDocumento = :cuentaNumeroDocumento"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")})
public class Usuario implements Serializable {

    @EmbeddedId
    protected UsuarioPK usuarioPK;
    @Column(name = "ESTADO")
    private Boolean estado;
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumns({
        @JoinColumn(name = "CUENTA_TIPO_DOCUMENTO_TIPO_DOCUMENTO", referencedColumnName = "TIPO_DOCUMENTO_TIPO_DOCUMENTO", insertable = false, updatable = false),
        @JoinColumn(name = "CUENTA_NUMERO_DOCUMENTO", referencedColumnName = "NUMERO_DOCUMENTO", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Cuenta cuenta;

    public Usuario() {
    }

    public Usuario(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public Usuario(UsuarioPK usuarioPK, String password) {
        this.usuarioPK = usuarioPK;
        this.password = password;
    }

    public Usuario(String cuentaTipoDocumentoTipoDocumento, String cuentaNumeroDocumento) {
        this.usuarioPK = new UsuarioPK(cuentaTipoDocumentoTipoDocumento, cuentaNumeroDocumento);
    }

    public UsuarioPK getUsuarioPK() {
        return usuarioPK;
    }

    public void setUsuarioPK(UsuarioPK usuarioPK) {
        this.usuarioPK = usuarioPK;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}
