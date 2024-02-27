package BusinessObject;

import DataAccessObject.CategoriaDAO;
import TransferObject.CategoriaDTO;
import java.util.List;

/**
 *
 * @author KEVIN EP
 */
public class Categoria {

    private CategoriaDAO daoCategoria;
    private CategoriaDTO dtoCategoria;
    
    public Categoria() {
        daoCategoria = new CategoriaDAO();
    }
    
    public String agregar(String nombreCategoria) {
        String mensaje;
        
        dtoCategoria = new CategoriaDTO(nombreCategoria);
        if (daoCategoria.agregar(dtoCategoria)) {
            mensaje = "Categoria Generado Correctamente";
        } else {
            mensaje = "Registro no guardado";
        }
        return mensaje;
    }
    
    public String actualizar(String codCategoria, String nombreCategoria) {
        String mensaje;        
        dtoCategoria = new CategoriaDTO(codCategoria, nombreCategoria);
        if (daoCategoria.actualizar(dtoCategoria)) {
            mensaje = "Se actualizó correctamente";
        } else {
            mensaje = "Error, no se pudo actualizar";
        }
        return mensaje;
    }
    
    public String eliminar(String codCategoria) {
        String mensaje;
        dtoCategoria = new CategoriaDTO();
        dtoCategoria.setCodCategoria(codCategoria);
        if (daoCategoria.eliminar(dtoCategoria)) {
            mensaje = "Categoria eliminado con éxito";
        } else {
            mensaje = "Registro no Eliminado";
        }
        return mensaje;
    }
    
    public CategoriaDTO buscar(String codCategoria) {
        dtoCategoria = new CategoriaDTO();
        dtoCategoria.setCodCategoria(codCategoria);
        dtoCategoria = daoCategoria.buscar(dtoCategoria);
        
        if (dtoCategoria != null) {
            return dtoCategoria;
        }
        return null;
    }
    
    public List<CategoriaDTO> listar() {
        if (daoCategoria.listar() != null) {
            List<CategoriaDTO> lista = daoCategoria.listar();
            return lista;
        }
        return null;
    }
    
    public boolean isBuscarNombre(String nombreCategoria) {
        if (daoCategoria.buscarNombre(nombreCategoria)) {
            return true;
        }
        return false;
    }
}
