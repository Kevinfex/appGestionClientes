/*
*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import DataAccessObject.ICrud;
import DataSource.Conexion;
import TransferObject.productoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EDGAR
 */

public class productoDAO implements ICrud <productoDTO>{
    PreparedStatement ps;
    ResultSet rs;
    Conexion conexion;
    
    public productoDAO() {
        conexion = new Conexion();
    }
    @Override
   public boolean agregar(productoDTO t) {
    int r = 0;
    try {
        String codigo = "P" + obtenerContador() + t.getNombre().substring(0, 1).toUpperCase();

        PreparedStatement ps = conexion.conectar().prepareStatement("INSERT INTO Producto (CodProducto, NombreProducto,DescripcionProducto,PresentacionProducto , PrecioProducto, StockProducto) VALUES (?, ?, ?, ?, ?,?)");
        ps.setString(1, codigo);
        ps.setString(2, t.getNombre());
        ps.setString(3, t.getDescripcion());
        ps.setString(4, t.getPresentacion());
        ps.setFloat(5, t.getPrecio());
        ps.setInt(6, t.getStock());

        r = ps.executeUpdate();
        return r == 1;
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false;
    } finally {
        conexion.desconectar();
    }
}

private int obtenerContador() {
    int contador = 1;
    try {
        String consulta = "SELECT COUNT(*) AS total FROM Producto";
        ResultSet resultado = conexion.conectar().createStatement().executeQuery(consulta);
        
        if (resultado.next()) {
            contador = resultado.getInt("total") + 1;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return contador;
}

  
    @Override
    public boolean actualizar(productoDTO t) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
     int r = 0;   
        try {
            ps = conexion.conectar().prepareStatement("update producto set NombreProducto=?,DescripcionProducto=?,PresentacionProducto=?,PrecioProducto=?,StockProducto=? where CodProducto=?");
            //ps.setString(1, t.getCodproducto());           
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getDescripcion());
            ps.setString(3, t.getPresentacion());
            ps.setFloat(4, t.getPrecio());
            ps.setInt(5, t.getStock());
            ps.setString(6, t.getCodProducto());
            r = ps.executeUpdate();
            return r == 1;
        }
        catch (SQLException ex) {
            return false;
        }
        finally {
            conexion.desconectar();
        }
    
    }

    @Override
    public boolean eliminar(productoDTO t) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int r = 0;
    try {
        ps = conexion.conectar().prepareStatement("delete from producto where codproducto=?");
        ps.setString(1, t.getCodProducto());
        r = ps.executeUpdate();
        return r == 1;
    } catch (SQLException ex) {
        return false;
    } finally {
        conexion.desconectar();
    }
    }

    @Override
    public productoDTO buscar(productoDTO t) {
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       boolean encontrado = false;
        
        try {
            ps = conexion.conectar().prepareStatement("select * from producto where NombreProducto=?");
            ps.setString(1, t.getCodProducto());
            rs = ps.executeQuery();
            while (rs.next()){
                t.setCodProducto(rs.getString(1));
                t.setNombre(rs.getString(2));
                t.setDescripcion(rs.getString(3));
                t.setPresentacion(rs.getString(4));
                t.setPrecio(rs.getFloat(5));
                t.setStock(rs.getInt(6));
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
    public List<productoDTO> listar() {
      //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
      List<productoDTO> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from producto");
            rs = ps.executeQuery();
            while (rs.next()) {
                productoDTO t = new productoDTO();
                t.setCodProducto(rs.getString(1));
                t.setNombre(rs.getString(2));
                t.setDescripcion(rs.getString(3));
                t.setPresentacion(rs.getString(4));
                t.setPrecio(rs.getFloat(5));
                t.setStock(rs.getInt(6));
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
    
}




