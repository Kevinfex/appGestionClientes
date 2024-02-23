package BusinessObject;

import DataAccessObject.RolUsuarioDAO;
import TransferObject.RolUsuarioDTO;
import java.util.List;

/**
 *
 * @author KEVIN EP
 */
public class RolUsuario {
    private RolUsuarioDTO dtoRolUsuario;
    private RolUsuarioDAO daoRolUsuario;

    public RolUsuario() {
        daoRolUsuario = new RolUsuarioDAO();
    }
    
    public String agregar(String nombreRol){
        String mensaje;

        dtoRolUsuario = new RolUsuarioDTO(nombreRol);
        if (daoRolUsuario.agregar(dtoRolUsuario))
            mensaje = "Rol Generado Correctamente";
        else
            mensaje = "Registro no guardado";
        return mensaje;
    }
    

    public RolUsuarioDTO buscar(int codRolUsuario){
        dtoRolUsuario = daoRolUsuario.buscar(new RolUsuarioDTO(codRolUsuario));

        if (dtoRolUsuario!=null)
            return dtoRolUsuario;
        return null;
    }
    
    public List<RolUsuarioDTO>listar() {
        if (daoRolUsuario.listar() != null) {
            List<RolUsuarioDTO> lista = daoRolUsuario.listar();
            return lista;
        }
        return null;
    }
}
