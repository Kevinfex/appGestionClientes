
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;
import TransferObject.EmpleadoDTO;
import DataAccessObject.productoDAO;
import TransferObject.productoDTO;
import java.util.List;
/**
 *
 * @author EDGAR
 */
public class producto {
    private productoDAO productoDAO;
    private productoDTO productoDTO;
     
    public  producto() {
      productoDAO= new productoDAO();
    }
    public String agregar(String CodProducto, String nombre,String descripcion,String presentacion,float precio,int stock){
        String mensaje;

        productoDTO = new productoDTO(CodProducto, nombre, descripcion,presentacion, precio,stock);
        if (productoDAO.agregar(productoDTO))
            mensaje = "Producto guardado correctamente";
        else
            mensaje = "El producto no se guardo";
        return mensaje;
    }   
    public String actualizar(String CodProducto, String nombre,String descripcion,String presentacion,float precio,int stock){
        String mensaje;
        productoDTO = new productoDTO(CodProducto, nombre, descripcion,presentacion, precio,stock);
        if (productoDAO.actualizar(productoDTO))
            mensaje = "Se actualizó correctamente";
        else
            mensaje = "Error, no se pudo actualizar";
        return mensaje;
    }
    
    public String eliminar(String codProducto){
         String mensaje;
         productoDTO = new productoDTO(codProducto); 
        if (productoDAO.eliminar(productoDTO)) 
            mensaje = "Producto Eliminado";
        else
            mensaje = "El producto no se eliminó";
        return mensaje;
    }
    public productoDTO buscar(String CodProducto){
        productoDTO = productoDAO.buscar(new productoDTO(CodProducto));
        if (productoDTO!=null)
            return productoDTO;
        return null;
    }
    
    public List<productoDTO>listar(){
        if(productoDAO.listar()!=null){
            List<productoDTO>lista = productoDAO.listar();
            return lista;
        }
        return null;
    } 
}



