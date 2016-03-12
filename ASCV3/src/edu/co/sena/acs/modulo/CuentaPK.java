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
public class CuentaPK implements Serializable {

    @Column(name = "TIPO_DOCUMENTO_TIPO_DOCUMENTO")
    private String tipoDocumentoTipoDocumento;
    @Column(name = "NUMERO_DOCUMENTO")
    private String numeroDocumento;

    public CuentaPK() {
    }

    public CuentaPK(String tipoDocumentoTipoDocumento, String numeroDocumento) {
        this.tipoDocumentoTipoDocumento = tipoDocumentoTipoDocumento;
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumentoTipoDocumento() {
        return tipoDocumentoTipoDocumento;
    }

    public void setTipoDocumentoTipoDocumento(String tipoDocumentoTipoDocumento) {
        this.tipoDocumentoTipoDocumento = tipoDocumentoTipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

}
