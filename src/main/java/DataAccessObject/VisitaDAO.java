/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import DataSource.Conexion;
import TransferObject.VisitaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bryam
 */
public class VisitaDAO implements ICrud<VisitaDTO>{
    PreparedStatement ps;
    ResultSet rs;
    Conexion conexion;
    
    public VisitaDAO() {
        conexion = new Conexion();
    }
    
    @Override
    public boolean agregar(VisitaDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(VisitaDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(VisitaDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public VisitaDTO buscar(VisitaDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<VisitaDTO> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<VisitaDTO> listarVisita() {
        List<VisitaDTO> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("SELECT Visita.CodVisita, NombreEmpleado + ' ' + ApellidoPaternoEmpleado + ' ' + ApellidoMaternoEmpleado, NombreComercial, FechaVisita, \n"
                    + "CASE\n"
                    + "        WHEN CodPedido IS NULL THEN 'No'\n"
                    + "        ELSE 'Si'\n"
                    + "    END AS Venta\n"
                    + "FROM Visita\n"
                    + "INNER JOIN EMPLEADO ON VISITA.CodEmpleado = Empleado.CodEmpleado\n"
                    + "INNER JOIN CLIENTE ON VISITA.CodCliente = Cliente.CodCliente\n"
                    + "LEFT JOIN Pedido ON Visita.CodVisita = Pedido.CodVisita");
            rs = ps.executeQuery();
            while (rs.next()) {
                VisitaDTO t = new VisitaDTO();
                t.setCodVisita(rs.getInt(1));
                t.setCodempleado(rs.getString(2));
                t.setCodcliente(rs.getString(3));
                t.setFechavisita(rs.getDate(4));
                t.setVenta(rs.getString(5));
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
