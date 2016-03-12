/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.acs.modulo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Manzon
 */
@Entity
@Table(name = "REGISTRO")
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r"),
    @NamedQuery(name = "Registro.findByIdRegistro", query = "SELECT r FROM Registro r WHERE r.idRegistro = :idRegistro"),
    @NamedQuery(name = "Registro.findByFechaEntradaHoraEntrada", query = "SELECT r FROM Registro r WHERE r.fechaEntradaHoraEntrada = :fechaEntradaHoraEntrada"),
    @NamedQuery(name = "Registro.findByFechaSalidaHoraSalida", query = "SELECT r FROM Registro r WHERE r.fechaSalidaHoraSalida = :fechaSalidaHoraSalida"),
    @NamedQuery(name = "Registro.findByEstado", query = "SELECT r FROM Registro r WHERE r.estado = :estado")})
public class Registro implements Serializable {

    @Id
    @Column(name = "ID_REGISTRO")
    private Integer idRegistro;
    @Column(name = "FECHA_ENTRADA_HORA_ENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntradaHoraEntrada;
    @Column(name = "FECHA_SALIDA_HORA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalidaHoraSalida;
    @Column(name = "ESTADO")
    private Boolean estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registro")
    private Collection<RegistroEquipo> registroEquipoCollection;
    @JoinColumns({
        @JoinColumn(name = "CUENTA_TIPO_DOCUMENTO_TIPO_DOCUMENTO", referencedColumnName = "TIPO_DOCUMENTO_TIPO_DOCUMENTO"),
        @JoinColumn(name = "CUENTA_NUMERO_DOCUMENTO", referencedColumnName = "NUMERO_DOCUMENTO")})
    @ManyToOne(optional = false)
    private Cuenta cuenta;

    public Registro() {
    }

    public Registro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Registro(Integer idRegistro, Date fechaEntradaHoraEntrada, Date fechaSalidaHoraSalida) {
        this.idRegistro = idRegistro;
        this.fechaEntradaHoraEntrada = fechaEntradaHoraEntrada;
        this.fechaSalidaHoraSalida = fechaSalidaHoraSalida;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Date getFechaEntradaHoraEntrada() {
        return fechaEntradaHoraEntrada;
    }

    public void setFechaEntradaHoraEntrada(Date fechaEntradaHoraEntrada) {
        this.fechaEntradaHoraEntrada = fechaEntradaHoraEntrada;
    }

    public Date getFechaSalidaHoraSalida() {
        return fechaSalidaHoraSalida;
    }

    public void setFechaSalidaHoraSalida(Date fechaSalidaHoraSalida) {
        this.fechaSalidaHoraSalida = fechaSalidaHoraSalida;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<RegistroEquipo> getRegistroEquipoCollection() {
        return registroEquipoCollection;
    }

    public void setRegistroEquipoCollection(Collection<RegistroEquipo> registroEquipoCollection) {
        this.registroEquipoCollection = registroEquipoCollection;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

}
