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
public class RegistroEquipoPK implements Serializable {

    @Column(name = "REGISTRO_ID_REGISTRO")
    private int registroIdRegistro;
    @Column(name = "PROPIETARIO_EQUIPO_CODIGO_BARRAS")
    private String propietarioEquipoCodigoBarras;
    @Column(name = "PROPIETARIO_CUENTA_TIPO_DOCUMENTO_TIPO_DOCUMENTO")
    private String propietarioCuentaTipoDocumentoTipoDocumento;
    @Column(name = "PROPIETARIO_CUENTA_NUMERO_DOCUMENTO")
    private String propietarioCuentaNumeroDocumento;

    public RegistroEquipoPK() {
    }

    public RegistroEquipoPK(int registroIdRegistro, String propietarioEquipoCodigoBarras, String propietarioCuentaTipoDocumentoTipoDocumento, String propietarioCuentaNumeroDocumento) {
        this.registroIdRegistro = registroIdRegistro;
        this.propietarioEquipoCodigoBarras = propietarioEquipoCodigoBarras;
        this.propietarioCuentaTipoDocumentoTipoDocumento = propietarioCuentaTipoDocumentoTipoDocumento;
        this.propietarioCuentaNumeroDocumento = propietarioCuentaNumeroDocumento;
    }

    public int getRegistroIdRegistro() {
        return registroIdRegistro;
    }

    public void setRegistroIdRegistro(int registroIdRegistro) {
        this.registroIdRegistro = registroIdRegistro;
    }

    public String getPropietarioEquipoCodigoBarras() {
        return propietarioEquipoCodigoBarras;
    }

    public void setPropietarioEquipoCodigoBarras(String propietarioEquipoCodigoBarras) {
        this.propietarioEquipoCodigoBarras = propietarioEquipoCodigoBarras;
    }

    public String getPropietarioCuentaTipoDocumentoTipoDocumento() {
        return propietarioCuentaTipoDocumentoTipoDocumento;
    }

    public void setPropietarioCuentaTipoDocumentoTipoDocumento(String propietarioCuentaTipoDocumentoTipoDocumento) {
        this.propietarioCuentaTipoDocumentoTipoDocumento = propietarioCuentaTipoDocumentoTipoDocumento;
    }

    public String getPropietarioCuentaNumeroDocumento() {
        return propietarioCuentaNumeroDocumento;
    }

    public void setPropietarioCuentaNumeroDocumento(String propietarioCuentaNumeroDocumento) {
        this.propietarioCuentaNumeroDocumento = propietarioCuentaNumeroDocumento;
    }

}
