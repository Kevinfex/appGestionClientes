/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject; 

import DataAccessObject.ClienteDAO;
import TransferObject.ClienteDTO;
import TransferObject.EmpleadoDTO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bryam
 */
public class Cliente {
    private ClienteDAO clienteDAO;
    private ClienteDTO clienteDTO;
        DefaultTableModel modelo;

    
    public Cliente() {
        clienteDAO = new ClienteDAO();
    }
    
    public String agregar(String codcliente, String ruc, String razonsocial, String nombrecomercial, String direccion, String celular, String distrito, String provincia){
        String mensaje="";
        
        /*String[] dato = new String[6];
        dato[0] = codcliente;
        dato[1] = ruc;
        dato[2] = razonsocial;
        dato[3] = nombrecomercial;
        dato[4] = direccion;
        dato[5] = celular;*/
        //ob[0] = clienteDTO.getCodCliente();
        //clienteDTO = new ClienteDTO(codcliente, ruc, apellido, nombre, celular, direccion, distrito, provincia);
        
        /*for (int i=0; i<=dato.length-1; i++) {
            clienteDTO = this.buscar(ruc);
            
            if (clienteDTO != null) {
                mensaje = "Registro " + ruc + " ya existe";
            }
            
            
        }
        return mensaje;
        */
        
        String[] dato = new String[6];
        dato[0] = codcliente;
        dato[1] = ruc;
        dato[2] = razonsocial;
        dato[3] = nombrecomercial;
        dato[4] = direccion;
        dato[5] = celular;
        
        for (int i=0; i<=dato.length-1; i++) {
            clienteDTO = this.buscar(dato[i]);
            if (clienteDTO != null)
                mensaje = "Registro " + dato[i] + " ya existe";
            
        }
        /*clienteDTO = this.buscar(dato[5]);
        if (clienteDTO == null)
            
            clienteDTO = new ClienteDTO(codcliente, ruc, razonsocial, nombrecomercial, direccion, celular, distrito, provincia);
            if (clienteDAO.agregar(clienteDTO)) {
                mensaje = "Registro Guardado";
            }
        
        else            
            mensaje = "Registro " + dato[5] + " ya existe";*/
            
        return mensaje;
        
        //else 
            //mensaje = "Registro no guardado";
        //return mensaje;
    }
    
    public String actualizar(String codcliente, String ruc, String razonsocial, String nombrecomercial, String direccion, String celular, String distrito, String provincia){
        String mensaje;
        clienteDTO = new ClienteDTO(codcliente, ruc, razonsocial, nombrecomercial, direccion, celular, distrito, provincia);
        if (clienteDAO.actualizar(clienteDTO))
            mensaje = "Se actualizó correctamente";
        else
            mensaje = "Error, no se pudo actualizar";
        return mensaje;
    }
    
    public String eliminar(String codcliente){
        String mensaje;
        clienteDTO = new ClienteDTO(codcliente);
        if (clienteDAO.eliminar(clienteDTO))
            mensaje = "Registro Eliminado";
        else
            mensaje = "Registro no Eliminado";
        return mensaje;
    }
    
    public ClienteDTO buscar(String codcliente){
        clienteDTO = clienteDAO.buscar(new ClienteDTO(codcliente));
        if (clienteDTO!=null)
            return clienteDTO;
        return null;
    }
    
    public List<ClienteDTO>listar(){
        if(clienteDAO.listar()!=null){
            List<ClienteDTO>lista = clienteDAO.listar();
            return lista;
        }
        return null;
    }
}