package TransferObject;

/**
 *
 * @author KEVIN EP
 */
public class UsuarioDTO {
    private int CodUsuario;
    private String UserName;
    private String Password;
    private String Estado;
    private int CodRolUsuario;
    private String CodEmpleado;
    

    public UsuarioDTO() {
    }

    public UsuarioDTO(int CodUsuario) {
        this.CodUsuario = CodUsuario;
    }

    public UsuarioDTO(String UserName) {
        this.UserName = UserName;
    }

    public UsuarioDTO(String UserName, String Password) {
        this.UserName = UserName;
        this.Password = Password;
    }

    public UsuarioDTO(String UserName, String Password, String Estado, int CodRolUsuario, String CodEmpleado) {
        this.UserName = UserName;
        this.Password = Password;
        this.Estado = Estado;
        this.CodRolUsuario = CodRolUsuario;
        this.CodEmpleado = CodEmpleado;
    }


    public int getCodUsuario() {
        return CodUsuario;
    }

    public void setCodUsuario(int CodUsuario) {
        this.CodUsuario = CodUsuario;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getCodRolUsuario() {
        return CodRolUsuario;
    }

    public void setCodRolUsuario(int CodRolUsuario) {
        this.CodRolUsuario = CodRolUsuario;
    }

    public String getCodEmpleado() {
        return CodEmpleado;
    }

    public void setCodEmpleado(String CodEmpleado) {
        this.CodEmpleado = CodEmpleado;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "CodUsuario=" + CodUsuario + ", UserName=" + UserName + ", Password=" + Password + ", Estado=" + Estado + ", CodRolUsuario=" + CodRolUsuario + ", CodEmpleado=" + CodEmpleado + '}';
    }

}
