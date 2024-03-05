/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccessObject;

import DataSource.Conexion;
import TransferObject.ClienteDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author Bryam
 */
public class ClienteDAO implements ICrud<ClienteDTO> {
    PreparedStatement ps;
    ResultSet rs;
    Conexion conexion;
    
    public ClienteDAO() {
        conexion = new Conexion();
    }

    @Override
    public boolean agregar(ClienteDTO t) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int r = 0;
        
        try {
            ps = conexion.conectar().prepareStatement("insert into cliente (codcliente, ruccliente, razonsocial, " +
                    "nombrecomercial, direccionfiscal, celularcliente, distritocliente, provinciacliente) values (?,?,?,?,?,?,?,?)");
            ps.setString(1, "C"+t.getRuc().substring(Math.max(0, t.getRuc().length() - 3))+t.getRazonsocial().substring(0,1).toUpperCase()+t.getNombrecomercial().substring(0,1).toUpperCase());
            ps.setString(2, t.getRuc());
            ps.setString(3, t.getRazonsocial());
            ps.setString(4, t.getNombrecomercial());
            ps.setString(5, t.getDireccionfiscal());
            ps.setString(6, t.getCelular());
            ps.setString(7, t.getDistrito());
            ps.setString(8, t.getProvincia());
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
    public boolean actualizar(ClienteDTO t) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int r = 0;
        
        try {
            ps = conexion.conectar().prepareStatement("update cliente set ruccliente=?,razonsocial=?,nombrecomercial=?,direccionfiscal=?, " + 
                    "celularcliente=?, distritocliente=?, provinciacliente=? where codcliente=?");
            
            //ps.setString(1, t.getCodCliente());
            ps.setString(1, t.getRuc());
            ps.setString(2, t.getRazonsocial());
            ps.setString(3, t.getNombrecomercial());
            ps.setString(4, t.getDireccionfiscal());
            ps.setString(5, t.getCelular());
            ps.setString(6, t.getDistrito());
            ps.setString(7, t.getProvincia());
            ps.setString(8, t.getCodCliente());
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
    public boolean eliminar(ClienteDTO t) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        int r = 0;
        
        try {
            ps = conexion.conectar().prepareStatement("delete from cliente where codcliente=?");
            ps.setString(1, t.getCodCliente());
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
    public ClienteDTO buscar(ClienteDTO t) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        boolean encontrado = false;
        
        try {
            ps = conexion.conectar().prepareStatement("select * from cliente where ruccliente=?");
            ps.setString(1, t.getCodCliente());
            rs = ps.executeQuery();
            while (rs.next()){
                t.setCodCliente(rs.getString(1));
                t.setRuc(rs.getString(2));
                t.setRazonsocial(rs.getString(3));
                t.setNombrecomercial(rs.getString(4));
                t.setDireccionfiscal(rs.getString(5));
                t.setCelular(rs.getString(6));
                t.setDistrito(rs.getString(7));
                t.setProvincia(rs.getString(8));
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
    public List<ClienteDTO> listar() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<ClienteDTO> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from Cliente");
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteDTO t = new ClienteDTO();
                t.setCodCliente(rs.getString(1));
                t.setRuc(rs.getString(2));
                t.setRazonsocial(rs.getString(3));
                t.setNombrecomercial(rs.getString(4));
                t.setDireccionfiscal(rs.getString(5));
                t.setCelular(rs.getString(6));
                t.setDistrito(rs.getString(7));
                t.setProvincia(rs.getString(8));
                
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
    
    public boolean buscarRuc(ClienteDTO dtocliente) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //boolean encontrado = false;
        
        try {
            ps = conexion.conectar().prepareStatement("select count(*) from cliente where ruccliente=?");
            ps.setString(1, dtocliente.getRuc());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int cantidad = rs.getInt(1); // Obtener el valor de la primera columna (COUNT)
                if (cantidad == 0) {
                    return false;
                } else {
                    return true;
                }
            }
           
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        finally {
            conexion.desconectar();
        }
        return false;
    }
    
    public boolean buscarRazonSocial(String razonsocial) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //boolean encontrado = false;
        
        try {
            ps = conexion.conectar().prepareStatement("select count(*) from cliente where razonsocial=?");
            ps.setString(1, razonsocial);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int cantidad = rs.getInt(1); // Obtener el valor de la primera columna (COUNT)
                if (cantidad == 0) {
                    return false;
                } else {
                    return true;
                }
            }
           
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        finally {
            conexion.desconectar();
        }
        return false;
    }
    
    public boolean buscarNombreComercial(ClienteDTO dtocliente) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //boolean encontrado = false;
        
        try {
            ps = conexion.conectar().prepareStatement("select count(*) from cliente where nombrecomercial=?");
            ps.setString(1, dtocliente.getNombrecomercial());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int cantidad = rs.getInt(1); // Obtener el valor de la primera columna (COUNT)
                if (cantidad == 0) {
                    return false;
                } else {
                    return true;
                }
            }
           
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        finally {
            conexion.desconectar();
        }
        return false;
    }
    
    public boolean buscarDireccionFiscal(ClienteDTO dtocliente) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //boolean encontrado = false;
        
        try {
            ps = conexion.conectar().prepareStatement("select count(*) from cliente where direccionfiscal=?");
            ps.setString(1, dtocliente.getDireccionfiscal());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int cantidad = rs.getInt(1); // Obtener el valor de la primera columna (COUNT)
                if (cantidad == 0) {
                    return false;
                } else {
                    return true;
                }
            }
           
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        finally {
            conexion.desconectar();
        }
        return false;
    }
    
    public boolean buscarCelular(ClienteDTO dtocliente) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        //boolean encontrado = false;
        
        try {
            ps = conexion.conectar().prepareStatement("select count(*) from cliente where celularcliente=?");
            ps.setString(1, dtocliente.getCelular());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int cantidad = rs.getInt(1); // Obtener el valor de la primera columna (COUNT)
                if (cantidad == 0) {
                    return false;
                } else {
                    return true;
                }
            }
           
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        finally {
            conexion.desconectar();
        }
        return false;
    }
    
    public List<ClienteDTO> listarPersonaNatural() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<ClienteDTO> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from Cliente where ruccliente like '1%'");
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteDTO t = new ClienteDTO();
                t.setCodCliente(rs.getString(1));
                t.setRuc(rs.getString(2));
                t.setRazonsocial(rs.getString(3));
                t.setNombrecomercial(rs.getString(4));
                t.setDireccionfiscal(rs.getString(5));
                t.setCelular(rs.getString(6));
                t.setDistrito(rs.getString(7));
                t.setProvincia(rs.getString(8));
                
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
    
    public List<ClienteDTO> listarPersonaJuridica() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        List<ClienteDTO> lista = new ArrayList<>();
        try {
            ps = conexion.conectar().prepareStatement("select * from Cliente where ruccliente like '2%'");
            rs = ps.executeQuery();
            while (rs.next()) {
                ClienteDTO t = new ClienteDTO();
                t.setCodCliente(rs.getString(1));
                t.setRuc(rs.getString(2));
                t.setRazonsocial(rs.getString(3));
                t.setNombrecomercial(rs.getString(4));
                t.setDireccionfiscal(rs.getString(5));
                t.setCelular(rs.getString(6));
                t.setDistrito(rs.getString(7));
                t.setProvincia(rs.getString(8));
                
                lista.add(t);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            conexion.desconectar();
        }
        return lista;
    }


    public List<ClienteDTO> rellenarClientes(){
        
        List<ClienteDTO> lista = new ArrayList<>();
        try{
            ps = conexion.conectar().prepareStatement("SELECT RAZONSOCIAL FROM CLIENTE");
            rs = ps.executeQuery();
            
            while (rs.next()) {
                ClienteDTO t = new ClienteDTO();
                t.setRuc(rs.getString(1));
                
                lista.add(t);
            }
        }catch(SQLException ex){
            
        }finally{

            conexion.desconectar();
        }
        return lista;
    }
    
    public void mostrarCliente(){
        try{
            ps = conexion.conectar().prepareStatement("SELECT NOMBRECOMERCIAL FROM CLIENTE");
            rs = ps.executeQuery();
        }catch(SQLException ex){
            
        }finally{
            conexion.desconectar();
        }
    }
}
