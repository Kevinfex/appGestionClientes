
package TransferObject;

/**
 *
 * @author KEVIN EP
 */
public class RatioVendedorDTO {
    private String codEmpleado;
    private String vendedor;
    private String totalVisitas;
    private String ventasRealizadas;

    public RatioVendedorDTO() {
    }

    public RatioVendedorDTO(String codEmpleado, String vendedor, String totalVisitas, String ventasRealizadas) {
        this.codEmpleado = codEmpleado;
        this.vendedor = vendedor;
        this.totalVisitas = totalVisitas;
        this.ventasRealizadas = ventasRealizadas;
    }

    public String getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(String codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getTotalVisitas() {
        return totalVisitas;
    }

    public void setTotalVisitas(String totalVisitas) {
        this.totalVisitas = totalVisitas;
    }

    public String getVentasRealizadas() {
        return ventasRealizadas;
    }

    public void setVentasRealizadas(String ventasRealizadas) {
        this.ventasRealizadas = ventasRealizadas;
    }
    
    
}
