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
public class UsuarioPK implements Serializable {

    @Column(name = "CUENTA_TIPO_DOCUMENTO_TIPO_DOCUMENTO")
    private String cuentaTipoDocumentoTipoDocumento;
    @Column(name = "CUENTA_NUMERO_DOCUMENTO")
    private String cuentaNumeroDocumento;

    public UsuarioPK() {
    }

    public UsuarioPK(String cuentaTipoDocumentoTipoDocumento, String cuentaNumeroDocumento) {
        this.cuentaTipoDocumentoTipoDocumento = cuentaTipoDocumentoTipoDocumento;
        this.cuentaNumeroDocumento = cuentaNumeroDocumento;
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
