package BusinessObject;

import DataAccessObject.EmpleadoDAO;
import TransferObject.EmpleadoDTO;
import java.util.List;

/**
 *
 * @author KEVIN EP
 */
public class Empleado {
    private EmpleadoDTO dtoEmpleado;
    private EmpleadoDAO daoEmpleado;

    
    public Empleado() {
        daoEmpleado = new EmpleadoDAO();
    }
    
    public String agregar(String codEmpleado, String dni, String nombres, String apellidoPat, String apellidoMat, String celular){
        String mensaje;

        dtoEmpleado = new EmpleadoDTO(codEmpleado, dni, nombres, apellidoPat, apellidoMat, celular);
        if (daoEmpleado.agregar(dtoEmpleado))
            mensaje = "Empleado Guardado Correctamente";
        else
            mensaje = "Registro no guardado";
        return mensaje;
    }
    
    public String actualizar(String codEmpleado, String dni, String nombres, String apellidoPat, String apellidoMat, String celular) {
        String mensaje; 
        dtoEmpleado = new EmpleadoDTO(codEmpleado, dni, nombres, apellidoPat, apellidoMat, celular);
        if (daoEmpleado.actualizar(dtoEmpleado)) 
            mensaje = "Se actualizó correctamente al empleado";
        else
            mensaje = "Error, no se pudo actualizar";
        return mensaje;
    }
    
    public String eliminar(String codEmpleado){
        String mensaje;
        dtoEmpleado = new EmpleadoDTO(codEmpleado);
        if (daoEmpleado.eliminar(dtoEmpleado))
            mensaje = "Empleado eliminado con éxito";
        else
            mensaje = "Registro no Eliminado";
        return mensaje;
    }
    
    public EmpleadoDTO buscar(String codEmpleado){
        dtoEmpleado = daoEmpleado.buscar(new EmpleadoDTO(codEmpleado));
        if (dtoEmpleado!=null)
            return dtoEmpleado;
        return null;
    }
    
    public List<EmpleadoDTO>listar() {
        if (daoEmpleado.listar() != null) {
            List<EmpleadoDTO> lista = daoEmpleado.listar();
            return lista;
        }
        return null;
    }
    
    
    public String actualizarCelular(String codEmpleado, String celular) {
        String mensaje; 
        dtoEmpleado = new EmpleadoDTO();
        dtoEmpleado.setCodEmpleado(codEmpleado);
        dtoEmpleado.setCelular(celular);
        
        if (daoEmpleado.actualizarCelular(dtoEmpleado)) 
            mensaje = "Se actualizó correctamente el Celular";
        else
            mensaje = "Error, no se pudo actualizar";
        return mensaje;
    }
}
