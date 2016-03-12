/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.co.sena.acs.modulo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Manzon
 */
@Embeddable
public class PropietarioPK implements Serializable {

    @Column(name = "EQUIPO_CODIGO_BARRAS")
    private String equipoCodigoBarras;
    @Column(name = "CUENTA_TIPO_DOCUMENTO_TIPO_DOCUMENTO")
    private String cuentaTipoDocumentoTipoDocumento;
    @Column(name = "CUENTA_NUMERO_DOCUMENTO")
    private String cuentaNumeroDocumento;

    public PropietarioPK() {
    }

    public PropietarioPK(String equipoCodigoBarras, String cuentaTipoDocumentoTipoDocumento, String cuentaNumeroDocumento) {
        this.equipoCodigoBarras = equipoCodigoBarras;
        this.cuentaTipoDocumentoTipoDocumento = cuentaTipoDocumentoTipoDocumento;
        this.cuentaNumeroDocumento = cuentaNumeroDocumento;
    }

    public String getEquipoCodigoBarras() {
        return equipoCodigoBarras;
    }

    public void setEquipoCodigoBarras(String equipoCodigoBarras) {
        this.equipoCodigoBarras = equipoCodigoBarras;
    }

    public String getCuentaTipoDocumentoTipoDocumento() {
        return cuentaTipoDocumentoTipoDocumento;
    }

    public void setCuentaTipoDocumentoTipoDocumento(String cuentaTipoDocumentoTipoDocumento) {
        this.cuentaTipoDocumentoTipoDocumento = cuentaTipoDocumentoTipoDocumento;
    }

    public String getCuentaNumeroDocumento() {
        return cuentaNumeroDocumento;
    }

    public void setCuentaNumeroDocumento(String cuentaNumeroDocumento) {
        this.cuentaNumeroDocumento = cuentaNumeroDocumento;
    }

}
