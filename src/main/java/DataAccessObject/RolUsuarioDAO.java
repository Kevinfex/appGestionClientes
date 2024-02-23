package DataAccessObject;

import DataSource.Conexion;
import TransferObject.RolUsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KEVIN EP
 */
public class RolUsuarioDAO implements ICrud<RolUsuarioDTO>{
    PreparedStatement ps;
    ResultSet rs;
    Conexion oConexion;
    private final String INSERT = "INSERT INTO RolUsuario (NombreRol) VALUES (?)";
    
    private final String SELECT_ONE = "SELECT * FROM RolUsuario WHERE CodRolUsuario = ?";
    private final String SELECT_ALL = "SELECT * FROM RolUsuario";
    
    public RolUsuarioDAO() {
        oConexion = new Conexion();
    }
    @Override
    public boolean agregar(RolUsuarioDTO dtoRolUsuario) {
        int respuesta = 0;
        try {
            ps = oConexion.conectar().prepareStatement(INSERT);
            ps.setString(2, dtoRolUsuario.getNombreRol());
            respuesta = ps.executeUpdate();
            return respuesta == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            oConexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(RolUsuarioDTO dtoRolUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(RolUsuarioDTO dtoRolUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public RolUsuarioDTO buscar(RolUsuarioDTO dtoRolUsuario) {
        boolean encontrado = false;
        
        try {
            ps = oConexion.conectar().prepareStatement(SELECT_ONE);
            ps.setInt(1, dtoRolUsuario.getCodRolUsuario());
            rs = ps.executeQuery();
            while (rs.next()){
                dtoRolUsuario.setCodRolUsuario(rs.getInt(1));
                dtoRolUsuario.setNombreRol(rs.getString(2));
                encontrado = true;
            }
            if (encontrado) {
                return dtoRolUsuario;
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
            oConexion.desconectar();
        }
    }

    @Override
    public List<RolUsuarioDTO> listar() {
        List<RolUsuarioDTO> lista = new ArrayList<>();
        try {
            ps = oConexion.conectar().prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {                
                RolUsuarioDTO dtoRolUsuario = new RolUsuarioDTO();
                dtoRolUsuario.setCodRolUsuario(rs.getInt(1));
                dtoRolUsuario.setNombreRol(rs.getString(2));
                
                lista.add(dtoRolUsuario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            oConexion.desconectar();
        }
        return lista;
    }
    
}
