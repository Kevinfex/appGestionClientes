/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TransferObject;

import java.util.Date;

/**
 *
 * @author Bryam
 */
public class VisitaDTO {
    private Integer codVisita;
    private String codempleado;
    private String codcliente;
    private Date fechavisita;
    private String venta;

    public VisitaDTO() {
    }

    public VisitaDTO(Integer codVisita) {
        this.codVisita = codVisita;
    }

    public VisitaDTO(Integer codVisita, String codempleado, String codcliente, Date fechavisita, String venta) {
        this.codVisita = codVisita;
        this.codempleado = codempleado;
        this.codcliente = codcliente;
        this.fechavisita = fechavisita;
        this.venta = venta;
    }

    public Integer getCodVisita() {
        return codVisita;
    }

    public void setCodVisita(Integer codVisita) {
        this.codVisita = codVisita;
    }

    public String getCodempleado() {
        return codempleado;
    }

    public void setCodempleado(String codempleado) {
        this.codempleado = codempleado;
    }

    public String getCodcliente() {
        return codcliente;
    }

    public void setCodcliente(String codcliente) {
        this.codcliente = codcliente;
    }

    public Date getFechavisita() {
        return fechavisita;
    }

    public void setFechavisita(Date fechavisita) {
        this.fechavisita = fechavisita;
    }

    public String getVenta() {
        return venta;
    }

    public void setVenta(String venta) {
        this.venta = venta;
    }

    
    
    
}
