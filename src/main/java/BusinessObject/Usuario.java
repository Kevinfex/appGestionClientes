package BusinessObject;

import DataAccessObject.RolUsuarioDAO;
import DataAccessObject.UsuarioDAO;
import TransferObject.RolUsuarioDTO;
import TransferObject.UsuarioDTO;
import java.util.List;

/**
 *
 * @author KEVIN EP
 */
public class Usuario {

    private UsuarioDAO usuarioDAO;
    private UsuarioDTO usuarioDTO;
    private RolUsuarioDTO rolUsuarioDTO;
    private RolUsuarioDAO rolUsuarioDAO;

    public Usuario() {
        usuarioDAO = new UsuarioDAO();
        rolUsuarioDAO = new RolUsuarioDAO();
    }

    public String validarUsuario(String userName, String password) {
        String mensaje = null;
        usuarioDTO = usuarioDAO.login(new UsuarioDTO(userName, password));

        if (!usuarioDAO.buscarUsuario(userName)) {
            mensaje = "El usuario no existe en la base de datos";
        } else if (!usuarioDAO.estadoUsuario(new UsuarioDTO(userName))) {
            mensaje = "El usuario está deshabilitado";
        } else if (usuarioDTO != null) {
            int codRolUsuario = usuarioDTO.getCodRolUsuario();
            rolUsuarioDTO = rolUsuarioDAO.buscar(new RolUsuarioDTO(codRolUsuario));
            if (rolUsuarioDTO.getNombreRol().equals("Administrador")) {
                mensaje = "Administrador";
            } else if (rolUsuarioDTO.getNombreRol().equals("Vendedor")) {
                mensaje = "Vendedor";
            }

        } else {
            mensaje = "La contraseña no es correcta";
        }
        return mensaje;
    }

    public UsuarioDTO loginUsuario(String userName, String password) {
        usuarioDTO = usuarioDAO.login(new UsuarioDTO(userName, password));
        if (usuarioDTO != null) {
            return usuarioDTO;
        }
        return null;
    }
    
    public UsuarioDTO buscarCodigoEmpleado(String codEmpleado) {
        UsuarioDTO dtoUsuario = new UsuarioDTO();
        dtoUsuario.setCodEmpleado(codEmpleado);
        usuarioDTO = usuarioDAO.buscarCodigoEmpleado(dtoUsuario);
        if (usuarioDTO != null) {
            return usuarioDTO;
        }
        return null;
    }
    
    public UsuarioDTO buscarUsuarioDTO(String userName) {
        usuarioDTO = usuarioDAO.buscarUsuario(new UsuarioDTO(userName));

        if (usuarioDTO != null) {
            return usuarioDTO;
        }
        return null;
    }
    
    public boolean isBuscarUsuario(String userName) {
        if (usuarioDAO.buscarUsuario(userName)) {
            return true;
        }
        return false;
    }
    
    public boolean isBuscarCodEmpleado (String codigoEmpleado) {
        if (usuarioDAO.buscarCodigoEmpleado(codigoEmpleado)) {
            return true;
        }
        return false;
    }
    
    // CRUD
    public String agregar(String userName, String password, String estado, int codRolUsuario, String codEmpleado){
        String mensaje;

        usuarioDTO = new UsuarioDTO( userName, password, estado, codRolUsuario, codEmpleado);
        if (usuarioDAO.agregar(usuarioDTO))
            mensaje = "Usuario Generado Correctamente";
        else
            mensaje = "Registro no guardado";
        return mensaje;
    }
    
    public String actualizar(String userName, String password, String estado, int codRolUsuario, String codEmpleado) {
        String mensaje; 
        usuarioDTO = new UsuarioDTO(userName, password, estado, codRolUsuario, codEmpleado);
        if (usuarioDAO.actualizar(usuarioDTO)) 
            mensaje = "Se actualizó correctamente el Usuario";
        else
            mensaje = "Error, no se pudo actualizar";
        return mensaje;
    }
    
    public String eliminar(String codEmpleado){
        String mensaje;
        usuarioDTO = new UsuarioDTO();
        usuarioDTO.setCodEmpleado(codEmpleado);
        if (usuarioDAO.eliminar(usuarioDTO))
            mensaje = "Empleado eliminado con éxito";
        else
            mensaje = "Registro no Eliminado";
        return mensaje;
    }

    public UsuarioDTO buscar(int codUsuario) {
        usuarioDTO = usuarioDAO.buscar(new UsuarioDTO(codUsuario));

        if (usuarioDTO != null) {
            return usuarioDTO;
        }
        return null;
    }
    
    public List<UsuarioDTO>listar() {
        if (usuarioDAO.listar() != null) {
            List<UsuarioDTO> lista = usuarioDAO.listar();
            return lista;
        }
        return null;
    }
    
    
    // Metodos par actualizar solamente un atributo
    
    public String actualizarUserName(String userName, String codEmpleado) {
        String mensaje; 
        usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUserName(userName);
        usuarioDTO.setCodEmpleado(codEmpleado);
        if (usuarioDAO.actualizarUserName(usuarioDTO)) 
            mensaje = "Se actualizó correctamente el Nombre de Usuario";
        else
            mensaje = "Error, no se pudo actualizar";
        return mensaje;
    }
     public String actualizarPassword(String newPassword, String codEmpleado) {
        String mensaje; 
        usuarioDTO = new UsuarioDTO();
        usuarioDTO.setPassword(newPassword);
        usuarioDTO.setCodEmpleado(codEmpleado);
        if (usuarioDAO.actualizaPassword(usuarioDTO)) 
            mensaje = "Se actualizó correctamente tu contraseña";
        else
            mensaje = "Error, no se pudo actualizar";
        return mensaje;
    }
}
