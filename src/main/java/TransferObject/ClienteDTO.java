
package TransferObject;

/**
 *
 * @author Bryam
 * @author KEVIN EP 
 */
public class ClienteDTO {
    private String codCliente;
    private String ruc;
    private String razonsocial;
    private String nombrecomercial;
    private String direccionfiscal;
    private String celular;
    private String distrito;
    private String provincia;

    public ClienteDTO() {
    }

    public ClienteDTO(String codCliente) {
        this.codCliente = codCliente;
    }

    public ClienteDTO(String codCliente, String ruc, String razonsocial, String nombrecomercial, String direccionfiscal, String celular, String distrito, String provincia) {
        this.codCliente = codCliente;
        this.ruc = ruc;
        this.razonsocial = razonsocial;
        this.nombrecomercial = nombrecomercial;
        this.direccionfiscal = direccionfiscal;
        this.celular = celular;
        this.distrito = distrito;
        this.provincia = provincia;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getNombrecomercial() {
        return nombrecomercial;
    }

    public void setNombrecomercial(String nombrecomercial) {
        this.nombrecomercial = nombrecomercial;
    }

    public String getDireccionfiscal() {
        return direccionfiscal;
    }

    public void setDireccionfiscal(String direccionfiscal) {
        this.direccionfiscal = direccionfiscal;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    

    
    
    
}
