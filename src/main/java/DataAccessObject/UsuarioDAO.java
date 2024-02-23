package DataAccessObject;

import DataSource.Conexion;
import TransferObject.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KEVIN EP
 */
public class UsuarioDAO implements ICrud<UsuarioDTO> {
    PreparedStatement ps;
    ResultSet rs;
    Conexion oConexion;

    private final String INSERT = "INSERT INTO Usuario (UserName, Password, Estado, CodRolUsuario, CodEmpleado) VALUES (?,?,?,?,?)";
    private final String UPDATE = "UPDATE Usuario SET UserName=?, Password=?, Estado=?, CodRolUsuario=?, CodEmpleado=? WHERE CodEmpleado = ?";
    private final String DELETE = "DELETE FROM Usuario WHERE CodEmpleado = ?";
    private final String SELECT_ONE = "SELECT * FROM Usuario WHERE CodUsuario = ?";
    private final String SELECT_ALL = "SELECT * FROM Usuario";

    public UsuarioDAO() {
        oConexion = new Conexion();
    }

    @Override
    public boolean agregar(UsuarioDTO dtoUsuario) {
        int respuesta = 0;
        try {
            ps = oConexion.conectar().prepareStatement(INSERT);
            ps.setString(1, dtoUsuario.getUserName());
            ps.setString(2, dtoUsuario.getPassword());
            ps.setString(3, dtoUsuario.getEstado());
            ps.setInt(4, dtoUsuario.getCodRolUsuario());
            ps.setString(5, dtoUsuario.getCodEmpleado());
            respuesta = ps.executeUpdate();
            return respuesta == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e);
            return false;
        } finally {
            oConexion.desconectar();
        }
    }

    @Override
    public boolean actualizar(UsuarioDTO dtoUsuario) {
        int respuesta = 0;
        try {
            ps = oConexion.conectar().prepareStatement(UPDATE);
            ps.setString(1, dtoUsuario.getUserName());
            ps.setString(2, dtoUsuario.getPassword());
            ps.setString(3, dtoUsuario.getEstado());
            ps.setInt(4, dtoUsuario.getCodRolUsuario());
            ps.setString(5, dtoUsuario.getCodEmpleado());
            ps.setString(6, dtoUsuario.getCodEmpleado());
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
    public boolean eliminar(UsuarioDTO dtoUsuario) {
        int r = 0;
        
        try {
            ps = oConexion.conectar().prepareStatement(DELETE);
            ps.setString(1, dtoUsuario.getCodEmpleado());
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
    public UsuarioDTO buscar(UsuarioDTO dtoUsuario) {
        boolean encontrado = false;
        try {
            ps = oConexion.conectar().prepareStatement(SELECT_ONE);
            ps.setInt(1, dtoUsuario.getCodUsuario());
            rs = ps.executeQuery();
            while (rs.next()) {
                dtoUsuario.setCodUsuario(rs.getInt(1));
                dtoUsuario.setUserName(rs.getString(2));
                dtoUsuario.setPassword(rs.getString(3));
                dtoUsuario.setEstado(rs.getString(4));
                dtoUsuario.setCodRolUsuario(rs.getInt(5));
                dtoUsuario.setCodEmpleado(rs.getString(6));
                encontrado = true;
            }

            if (encontrado) {
                return dtoUsuario;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        } finally {
            oConexion.desconectar();
        }
    }

    @Override
    public List<UsuarioDTO> listar() {
        List<UsuarioDTO> lista = new ArrayList<>();
        try {
            ps = oConexion.conectar().prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {                
                UsuarioDTO dtoUsuario = new UsuarioDTO();
                dtoUsuario.setCodUsuario(rs.getInt(1));
                dtoUsuario.setUserName(rs.getString(2));
                dtoUsuario.setPassword(rs.getString(3));
                dtoUsuario.setEstado(rs.getString(4));
                dtoUsuario.setCodRolUsuario(rs.getInt(5));
                dtoUsuario.setCodEmpleado(rs.getString(6));
                
                lista.add(dtoUsuario);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            oConexion.desconectar();
        }
        return lista;
    }
    
    public boolean actualizarUserName(UsuarioDTO dtoUsuario) {
        int respuesta = 0;
        try {
            ps = oConexion.conectar().prepareStatement("UPDATE Usuario SET UserName=? WHERE CodEmpleado = ?");
            ps.setString(1, dtoUsuario.getUserName());
            ps.setString(2, dtoUsuario.getCodEmpleado());
            respuesta = ps.executeUpdate();
            return  respuesta == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            oConexion.desconectar();
        }
    }
    
    public boolean actualizaPassword(UsuarioDTO dtoUsuario) {
        int respuesta = 0;
        try {
            ps = oConexion.conectar().prepareStatement("UPDATE Usuario SET Password=? WHERE CodEmpleado = ?");
            ps.setString(1, dtoUsuario.getPassword());
            ps.setString(2, dtoUsuario.getCodEmpleado());
            respuesta = ps.executeUpdate();
            return  respuesta == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            oConexion.desconectar();
        }
    }

    public boolean buscarUsuario(String usuario) {
        try {
            ps = oConexion.conectar().prepareStatement("SELECT COUNT(*) FROM Usuario WHERE UserName = ?");
            ps.setString(1, usuario);
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
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return false;
        } finally {
            oConexion.desconectar();
        }
        return false;
    }
    
    public UsuarioDTO buscarUsuario(UsuarioDTO dtoUsuario) {
        try {        boolean encontrado = false;

            ps = oConexion.conectar().prepareStatement("SELECT * FROM Usuario WHERE UserName = ?");
            ps.setString(1, dtoUsuario.getUserName());
            rs = ps.executeQuery();
            while (rs.next()) {
                dtoUsuario.setCodUsuario(rs.getInt(1));
                dtoUsuario.setUserName(rs.getString(2));
                dtoUsuario.setPassword(rs.getString(3));
                dtoUsuario.setEstado(rs.getString(4));
                dtoUsuario.setCodRolUsuario(rs.getInt(5));
                dtoUsuario.setCodEmpleado(rs.getString(6));
                encontrado = true;
            }

            if (encontrado) {
                return dtoUsuario;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        } finally {
            oConexion.desconectar();
        }
    }
    
    public boolean buscarCodigoEmpleado(String codigoEmpleado) {
        try {
            ps = oConexion.conectar().prepareStatement("SELECT COUNT(*) FROM Usuario WHERE CodEmpleado = ?");
            ps.setString(1, codigoEmpleado);
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
    
    public UsuarioDTO buscarCodigoEmpleado(UsuarioDTO dtoUsuario) {
        boolean encontrado = false;
        try {
            ps = oConexion.conectar().prepareStatement("SELECT * FROM Usuario WHERE CodEmpleado = ?");
            ps.setString(1, dtoUsuario.getCodEmpleado());
            rs = ps.executeQuery();
            while (rs.next()) {
                dtoUsuario.setCodUsuario(rs.getInt(1));
                dtoUsuario.setUserName(rs.getString(2));
                dtoUsuario.setPassword(rs.getString(3));
                dtoUsuario.setEstado(rs.getString(4));
                dtoUsuario.setCodRolUsuario(rs.getInt(5));
                dtoUsuario.setCodEmpleado(rs.getString(6));
                encontrado = true;
            }

            if (encontrado) {
                return dtoUsuario;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        } finally {
            oConexion.desconectar();
        }
    }

    public boolean estadoUsuario(UsuarioDTO dtoUsuario) {
        try {
            ps = oConexion.conectar().prepareStatement("SELECT * FROM Usuario WHERE UserName = ? AND Estado = 1");
            ps.setString(1, dtoUsuario.getUserName());
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } finally {
            oConexion.desconectar();
        }
        return false;
    }

    public boolean verificaPassword(UsuarioDTO dtoUsuario) {
        try {
            ps = oConexion.conectar().prepareStatement("SELECT * FROM Usuario WHERE UserName = ? AND Password = ?");
            ps.setString(1, dtoUsuario.getUserName());
            ps.setString(2, dtoUsuario.getPassword());
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        } finally {
            oConexion.desconectar();
        }
        return false;
    }

    public UsuarioDTO login(UsuarioDTO dtoUsuario) {
        boolean encontrado = false;
        try {
            ps = oConexion.conectar().prepareStatement("SELECT * FROM Usuario WHERE UserName = ? AND Password = ?");
            ps.setString(1, dtoUsuario.getUserName());
            ps.setString(2, dtoUsuario.getPassword());
            rs = ps.executeQuery();
            while (rs.next()) {
                dtoUsuario.setCodUsuario(rs.getInt(1));
                dtoUsuario.setUserName(rs.getString(2));
                dtoUsuario.setPassword(rs.getString(3));
                dtoUsuario.setEstado(rs.getString(4));
                dtoUsuario.setCodRolUsuario(rs.getInt(5));
                dtoUsuario.setCodEmpleado(rs.getString(6));
                encontrado = true;
            }

            if (encontrado) {
                return dtoUsuario;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
            return null;
        } finally {
            oConexion.desconectar();
        }
    }

    
}
