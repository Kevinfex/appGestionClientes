package TransferObject;

import java.util.Objects;

/**
 *
 * @author KEVIN EP
 */
public class RolUsuarioDTO {
    private  int CodRolUsuario;
    private String NombreRol;

    public RolUsuarioDTO() {
    }

    public RolUsuarioDTO(int CodRolUsuario) {
        this.CodRolUsuario = CodRolUsuario;
    }

    public RolUsuarioDTO(int CodRolUsuario, String NombreRol) {
        this.CodRolUsuario = CodRolUsuario;
        this.NombreRol = NombreRol;
    }

    public RolUsuarioDTO(String NombreRol) {
        this.NombreRol = NombreRol;
    }

    public int getCodRolUsuario() {
        return CodRolUsuario;
    }

    public void setCodRolUsuario(int CodRolUsuario) {
        this.CodRolUsuario = CodRolUsuario;
    }

    public String getNombreRol() {
        return NombreRol;
    }

    public void setNombreRol(String NombreRol) {
        this.NombreRol = NombreRol;
    }

    @Override
    public String toString() {
        return NombreRol;
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
        final RolUsuarioDTO other = (RolUsuarioDTO) obj;
        return this.CodRolUsuario == other.CodRolUsuario;
    }

}
