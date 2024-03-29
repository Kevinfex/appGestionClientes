package TransferObject;

import java.util.Objects;

/**
 *
 * @author KEVIN EP
 */
public class EmpleadoDTO {
    private String CodEmpleado;
    private String DNIEmpleado;
    private String Nombres;
    private String ApellidoPaterno;
    private String ApellidoMaterno;
    private String Celular;

    public EmpleadoDTO() {
    }

    public EmpleadoDTO(String CodEmpleado) {
        this.CodEmpleado = CodEmpleado;
    }

    public EmpleadoDTO(String CodEmpleado, String DNIEmpleado, String Nombres, String ApellidoPaterno, String ApellidoMaterno, String Celular) {
        this.CodEmpleado = CodEmpleado;
        this.DNIEmpleado = DNIEmpleado;
        this.Nombres = Nombres;
        this.ApellidoPaterno = ApellidoPaterno;
        this.ApellidoMaterno = ApellidoMaterno;
        this.Celular = Celular;
    }

    public String getCodEmpleado() {
        return CodEmpleado;
    }

    public void setCodEmpleado(String CodEmpleado) {
        this.CodEmpleado = CodEmpleado;
    }

    public String getDNIEmpleado() {
        return DNIEmpleado;
    }

    public void setDNIEmpleado(String DNIEmpleado) {
        this.DNIEmpleado = DNIEmpleado;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidoPaterno() {
        return ApellidoPaterno;
    }

    public void setApellidoPaterno(String ApellidoPaterno) {
        this.ApellidoPaterno = ApellidoPaterno;
    }

    public String getApellidoMaterno() {
        return ApellidoMaterno;
    }

    public void setApellidoMaterno(String ApellidoMaterno) {
        this.ApellidoMaterno = ApellidoMaterno;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String CelularCliente) {
        this.Celular = CelularCliente;
    }

    @Override
    public String toString() {
        return Nombres + " " + ApellidoPaterno + " " + ApellidoMaterno;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmpleadoDTO other = (EmpleadoDTO) obj;
        return Objects.equals(this.CodEmpleado, other.CodEmpleado);
    }
    
}
