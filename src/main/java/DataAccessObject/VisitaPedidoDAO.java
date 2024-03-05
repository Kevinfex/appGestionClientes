/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import DataSource.Conexion;
import TransferObject.VisitaPedidoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryam
 */
public class VisitaPedidoDAO implements ICrud<VisitaPedidoDTO>{
    PreparedStatement ps;
    ResultSet rs;
    Conexion conexion;
    
    public VisitaPedidoDAO() {
        conexion = new Conexion();
    }
    
    @Override
    public boolean agregar(VisitaPedidoDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(VisitaPedidoDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(VisitaPedidoDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public VisitaPedidoDTO buscar(VisitaPedidoDTO t) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        boolean encontrado = false;
        
        try {
            ps = conexion.conectar().prepareStatement("SELECT Pedido.CodPedido, NumeroSerie, NombreProducto, PrecioProducto, CantidadPedido, ImportePedido\n"
                    + "FROM PEDIDO\n"
                    + "INNER JOIN VISITA ON PEDIDO.CodVisita = VISITA.CodVisita\n"
                    + "INNER JOIN EMPLEADO ON VISITA.CodEmpleado = EMPLEADO.CodEmpleado\n"
                    + "INNER JOIN CLIENTE ON VISITA.CodCliente = CLIENTE.CodCliente\n"
                    + "INNER JOIN DETALLEPEDIDO ON PEDIDO.CodPedido = DETALLEPEDIDO.CodPedido\n"
                    + "INNER JOIN PRODUCTO ON DETALLEPEDIDO.CodProducto = PRODUCTO.CodProducto\n"
                    + "WHERE PEDIDO.CodVisita = ?");
            ps.setInt(1, t.getCodigopedido());
            rs = ps.executeQuery();
            while (rs.next()){
                t.setCodigopedido(rs.getInt(1));
                t.setNumeroserie(rs.getString(2));
                t.setProducto(rs.getString(3));
                t.setPrecio(rs.getFloat(4));
                t.setCantidad(rs.getInt(5));
                t.setImporte(rs.getFloat(6));
                encontrado = true;
            }
            if (encontrado) {
                return t;
            }
            else {
                return null;
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        finally {
            conexion.desconectar();
        }
    }

    @Override
    public List<VisitaPedidoDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<VisitaPedidoDTO> listarVisitaPedido() {
        List<VisitaPedidoDTO> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("SELECT Pedido.CodPedido, NumeroSerie, NombreProducto, PrecioProducto, CantidadPedido, ImportePedido\n"
                    + "FROM PEDIDO\n"
                    + "INNER JOIN VISITA ON PEDIDO.CodVisita = VISITA.CodVisita\n"
                    + "INNER JOIN EMPLEADO ON VISITA.CodEmpleado = EMPLEADO.CodEmpleado\n"
                    + "INNER JOIN CLIENTE ON VISITA.CodCliente = CLIENTE.CodCliente\n"
                    + "INNER JOIN DETALLEPEDIDO ON PEDIDO.CodPedido = DETALLEPEDIDO.CodPedido\n"
                    + "INNER JOIN PRODUCTO ON DETALLEPEDIDO.CodProducto = PRODUCTO.CodProducto\n"
                    + "WHERE PEDIDO.NumeroSerie = '0000001'");
            rs = ps.executeQuery();
            while (rs.next()) {
                VisitaPedidoDTO t = new VisitaPedidoDTO();
                t.setCodigopedido(rs.getInt(1));
                t.setNumeroserie(rs.getString(2));
                t.setProducto(rs.getString(3));
                t.setPrecio(rs.getFloat(4));
                t.setCantidad(rs.getInt(5));
                t.setImporte(rs.getFloat(6));
                lista.add(t);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        finally {
            conexion.desconectar();
        }
        return lista;
    }
    
    public List<VisitaPedidoDTO> buscarVisitaPedido(Integer codVisita) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
        List<VisitaPedidoDTO> lista = new ArrayList<>();
        
        try {
            ps = conexion.conectar().prepareStatement("SELECT Pedido.CodPedido, NumeroSerie, NombreProducto, PrecioProducto, CantidadPedido, ImportePedido\n"
                    + "FROM PEDIDO\n"
                    + "INNER JOIN VISITA ON PEDIDO.CodVisita = VISITA.CodVisita\n"
                    + "INNER JOIN EMPLEADO ON VISITA.CodEmpleado = EMPLEADO.CodEmpleado\n"
                    + "INNER JOIN CLIENTE ON VISITA.CodCliente = CLIENTE.CodCliente\n"
                    + "INNER JOIN DETALLEPEDIDO ON PEDIDO.CodPedido = DETALLEPEDIDO.CodPedido\n"
                    + "INNER JOIN PRODUCTO ON DETALLEPEDIDO.CodProducto = PRODUCTO.CodProducto\n"
                    + "WHERE PEDIDO.CodVisita = ?");
            ps.setInt(1, codVisita);
            rs = ps.executeQuery();
            while (rs.next()){
                VisitaPedidoDTO t = new VisitaPedidoDTO();
                t.setCodigopedido(rs.getInt(1));
                t.setNumeroserie(rs.getString(2));
                t.setProducto(rs.getString(3));
                t.setPrecio(rs.getFloat(4));
                t.setCantidad(rs.getInt(5));
                t.setImporte(rs.getFloat(6));
                //encontrado = true;
                lista.add(t);
            }
            
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
        finally {
            conexion.desconectar();
        }
        return lista;
    }
    
}
