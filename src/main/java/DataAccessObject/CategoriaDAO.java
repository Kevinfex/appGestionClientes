package DataAccessObject;

import DataSource.Conexion;
import TransferObject.CategoriaDTO;
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
public class CategoriaDAO implements ICrud<CategoriaDTO>{
    PreparedStatement ps;
    ResultSet rs;
    Conexion oConexion;
    private final String INSERT = "INSERT INTO Categoria (NombreCategoria) VALUES (?);";
    private final String UPDATE = "UPDATE Categoria SET NombreCategoria = ? WHERE CodCategoria = ?";
    private final String DELETE = "DELETE FROM Categoria WHERE CodCategoria = ?";
    private final String SELECT_ONE = "SELECT * FROM Categoria WHERE CodCategoria = ?";
    private final String SELECT_ALL = "SELECT * FROM Categoria";

    public CategoriaDAO() {
        oConexion = new Conexion();
    }

    @Override
    public boolean agregar(CategoriaDTO dtoCategoria) {
        int respuesta = 0;
        try {
            ps = oConexion.conectar().prepareStatement(INSERT);
            ps.setString(1, dtoCategoria.getNombreCategoria());
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
    public boolean actualizar(CategoriaDTO dtoCategoria) {
        int respuesta = 0;
        try {
            ps = oConexion.conectar().prepareStatement(UPDATE);
            ps.setString(1, dtoCategoria.getNombreCategoria());
            ps.setString(2, dtoCategoria.getCodCategoria());
            respuesta = ps.executeUpdate();
            return  respuesta == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            oConexion.desconectar();
        }
    }

    @Override
    public boolean eliminar(CategoriaDTO dtoCategoria) {
        int r = 0;
        
        try {
            ps = oConexion.conectar().prepareStatement(DELETE);
            ps.setString(1, dtoCategoria.getCodCategoria());
            r = ps.executeUpdate();
            return r == 1;
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
        finally {
            oConexion.desconectar();
        }
    }

    @Override
    public CategoriaDTO buscar(CategoriaDTO dtoCategoria) {
        boolean encontrado = false;
        
        try {
            ps = oConexion.conectar().prepareStatement(SELECT_ONE);
            ps.setString(1, dtoCategoria.getCodCategoria());
            rs = ps.executeQuery();
            while (rs.next()){
                dtoCategoria.setCodCategoria(rs.getString(1));
                dtoCategoria.setNombreCategoria(rs.getString(2));
                encontrado = true;
            }
            if (encontrado) {
                return dtoCategoria;
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
    public List<CategoriaDTO> listar() {
        List<CategoriaDTO> lista = new ArrayList<>();
        try {
            ps = oConexion.conectar().prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) { 
                CategoriaDTO dtoCategoria = new CategoriaDTO();
                dtoCategoria.setCodCategoria(rs.getString(1));
                dtoCategoria.setNombreCategoria(rs.getString(2));
                
                lista.add(dtoCategoria);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            oConexion.desconectar();
        }
        return lista;
    }
    

    public boolean buscarNombre(String nombreCategoria) {
        try {
            ps = oConexion.conectar().prepareStatement("SELECT COUNT(*) FROM Categoria WHERE NombreCategoria = ?");
            ps.setString(1, nombreCategoria);
            rs = ps.executeQuery();
             if (rs.next()) {
                int cantidad = rs.getInt(1); // Obtener el valor de la primera columna (COUNT)
                if (cantidad == 0) {
                    return false;
                } else {
                    return true;
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
            return false;
        } finally {
            oConexion.desconectar();
        }
        return false;
    }
    
}
