package DataAccessObject;

import DataSource.Conexion;
import TransferObject.EmpleadoDTO;
import TransferObject.RatioVendedorDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KEVIN EP
 */
public class EmpleadoDAO implements ICrud<EmpleadoDTO> {

    PreparedStatement ps;
    ResultSet rs;
    Conexion oConexion;

    private final String INSERT = "INSERT INTO Empleado (CodEmpleado, DNIEmpleado, NombreEmpleado, ApellidoPaternoEmpleado, ApellidoMaternoEmpleado, CelularEmpleado) VALUES (?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE Empleado SET DNIEmpleado=?, NombreEmpleado=?, ApellidoPaternoEmpleado=?, ApellidoMaternoEmpleado=?, CelularEmpleado=? WHERE CodEmpleado = ?";
    private final String DELETE = "DELETE FROM Empleado WHERE CodEmpleado = ?";
    private final String SELECT_ONE = "SELECT * FROM Empleado WHERE CodEmpleado = ?";
    private final String SELECT_ALL = "SELECT * FROM Empleado";

    public EmpleadoDAO() {
        oConexion = new Conexion();
    }

    @Override
    public boolean agregar(EmpleadoDTO dtoEmpleado) {
        int respuesta = 0;
        try {
            ps = oConexion.conectar().prepareStatement(INSERT);
            ps.setString(1, dtoEmpleado.getCodEmpleado());
            ps.setString(2, dtoEmpleado.getDNIEmpleado());
            ps.setString(3, dtoEmpleado.getNombres());
            ps.setString(4, dtoEmpleado.getApellidoPaterno());
            ps.setString(5, dtoEmpleado.getApellidoMaterno());
            ps.setString(6, dtoEmpleado.getCelular());
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
    public boolean actualizar(EmpleadoDTO dtoEmpleado) {
        int respuesta = 0;
        try {
            ps = oConexion.conectar().prepareStatement(UPDATE);
            ps.setString(1, dtoEmpleado.getDNIEmpleado());
            ps.setString(2, dtoEmpleado.getNombres());
            ps.setString(3, dtoEmpleado.getApellidoPaterno());
            ps.setString(4, dtoEmpleado.getApellidoMaterno());
            ps.setString(5, dtoEmpleado.getCelular());
            ps.setString(6, dtoEmpleado.getCodEmpleado());
            respuesta = ps.executeUpdate();
            return respuesta == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            oConexion.desconectar();
        }
    }

    @Override
    public boolean eliminar(EmpleadoDTO dtoEmpleado) {
        int r = 0;

        try {
            ps = oConexion.conectar().prepareStatement(DELETE);
            ps.setString(1, dtoEmpleado.getCodEmpleado());
            r = ps.executeUpdate();
            return r == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            oConexion.desconectar();
        }
    }

    @Override
    public EmpleadoDTO buscar(EmpleadoDTO dtoEmpleado) {
        boolean encontrado = false;

        try {
            ps = oConexion.conectar().prepareStatement(SELECT_ONE);
            ps.setString(1, dtoEmpleado.getCodEmpleado());
            rs = ps.executeQuery();
            while (rs.next()) {
                dtoEmpleado.setCodEmpleado(rs.getString(1));
                dtoEmpleado.setDNIEmpleado(rs.getString(2));
                dtoEmpleado.setNombres(rs.getString(3));
                dtoEmpleado.setApellidoPaterno(rs.getString(4));
                dtoEmpleado.setApellidoMaterno(rs.getString(5));
                dtoEmpleado.setCelular(rs.getString(6));
                encontrado = true;
            }
            if (encontrado) {
                return dtoEmpleado;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            oConexion.desconectar();
        }
    }

    @Override
    public List<EmpleadoDTO> listar() {
        List<EmpleadoDTO> lista = new ArrayList<>();
        try {
            ps = oConexion.conectar().prepareStatement(SELECT_ALL);
            rs = ps.executeQuery();
            while (rs.next()) {
                EmpleadoDTO dtoEmpleado = new EmpleadoDTO();
                dtoEmpleado.setCodEmpleado(rs.getString(1));
                dtoEmpleado.setDNIEmpleado(rs.getString(2));
                dtoEmpleado.setNombres(rs.getString(3));
                dtoEmpleado.setApellidoPaterno(rs.getString(4));
                dtoEmpleado.setApellidoMaterno(rs.getString(5));
                dtoEmpleado.setCelular(rs.getString(6));

                lista.add(dtoEmpleado);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            oConexion.desconectar();
        }
        return lista;
    }

    public boolean buscarDNI(String dni) {
        try {
            ps = oConexion.conectar().prepareStatement("SELECT COUNT(*) FROM Empleado WHERE DNIEmpleado = ?");
            ps.setString(1, dni);
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

    public boolean buscarCodigo(String codigo) {
        try {
            ps = oConexion.conectar().prepareStatement("SELECT COUNT(*) FROM Empleado WHERE CodEmpleado = ?");
            ps.setString(1, codigo);
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

    public boolean actualizarCelular(EmpleadoDTO dtoEmpleado) {
        int respuesta = 0;
        try {
            ps = oConexion.conectar().prepareStatement("UPDATE Empleado SET CelularEmpleado=? WHERE CodEmpleado = ?");
            ps.setString(1, dtoEmpleado.getCelular());
            ps.setString(2, dtoEmpleado.getCodEmpleado());
            respuesta = ps.executeUpdate();
            return respuesta == 1;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            oConexion.desconectar();
        }
    }

    public RatioVendedorDTO calcularRatio(String codigo, String fechaInicio, String fechaFin) {
        boolean encontrado = false;
        RatioVendedorDTO dtoRatio = new RatioVendedorDTO();
        String CONSULTA_RATIO = "SELECT \n"
                + "    e.CodEmpleado,\n"
                + "    e.NombreEmpleado + ' ' + e.ApellidoPaternoEmpleado + ' ' + e.ApellidoMaternoEmpleado AS DatosVendedor,\n"
                + "    COUNT(DISTINCT v.CodVisita) AS TotalVisitas,\n"
                + "    COUNT(DISTINCT CASE WHEN p.CodPedido IS NOT NULL THEN v.CodVisita END) AS VentasRealizadas\n"
                + "FROM Visita v\n"
                + "INNER JOIN EMPLEADO e ON v.CodEmpleado = e.CodEmpleado\n"
                + "INNER JOIN CLIENTE c ON v.CodCliente = c.CodCliente\n"
                + "LEFT JOIN Pedido p ON v.CodVisita = p.CodVisita\n"
                + "\n"
                + "WHERE e.CodEmpleado = ? AND v.FechaVisita BETWEEN ?  AND ?\n"
                + "GROUP BY e.CodEmpleado, e.NombreEmpleado, e.ApellidoPaternoEmpleado, e.ApellidoMaternoEmpleado;";
        try {
            ps = oConexion.conectar().prepareStatement(CONSULTA_RATIO);
            ps.setString(1, codigo);
            ps.setString(2, fechaInicio);
            ps.setString(3, fechaFin);
            rs = ps.executeQuery();
            while (rs.next()) {
                dtoRatio.setCodEmpleado(rs.getString(1));
                dtoRatio.setVendedor(rs.getString(2));
                dtoRatio.setTotalVisitas(rs.getString(3));
                dtoRatio.setVentasRealizadas(rs.getString(4));
                encontrado = true;
            }
            if (encontrado) {
                return dtoRatio;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        } finally {
            oConexion.desconectar();
        }
    }
}
