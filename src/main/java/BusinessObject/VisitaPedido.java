/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessObject;

import DataAccessObject.VisitaPedidoDAO;
import TransferObject.VisitaPedidoDTO;
import java.util.List;

/**
 *
 * @author Bryam
 */
public class VisitaPedido {
    private VisitaPedidoDAO visitaPedidoDAO;
    private VisitaPedidoDTO visitaPedidoDTO;
    
    public VisitaPedido() {
        visitaPedidoDAO = new VisitaPedidoDAO();
    }
    
    public VisitaPedidoDTO buscar(Integer codpedido){
        visitaPedidoDTO = visitaPedidoDAO.buscar(new VisitaPedidoDTO(codpedido));
        if (visitaPedidoDTO!=null)
            return visitaPedidoDTO;
        return null;
    }
    
    public List<VisitaPedidoDTO>listarVisitaPedido(){
        if(visitaPedidoDAO.listarVisitaPedido()!=null){
            List<VisitaPedidoDTO>lista = visitaPedidoDAO.listarVisitaPedido();
            return lista;
        }
        return null;
    }
    
    public List<VisitaPedidoDTO>buscarVisitaPedido(Integer codVisita){
        /*if(visitaPedidoDAO.buscarVisitaPedido(visitaPedidoDTO)!=null){
            List<VisitaPedidoDTO>lista = visitaPedidoDAO.listarVisitaPedido();
            return lista;
        }
        return null;*/
        return visitaPedidoDAO.buscarVisitaPedido(codVisita);
    }
}
