package DataAccessObject;

import DataSource.Conexion;
import TransferObject.CategoriaDTO;
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
public class RatioVendedorDAO {

    PreparedStatement ps;
    ResultSet rs;
    Conexion oConexion;

    public RatioVendedorDAO() {
        oConexion = new Conexion();
    }
    
    public List<RatioVendedorDTO>  buscar(String codigo, String fechaInicio, String fechaFin) {
        List<RatioVendedorDTO> lista = new ArrayList<>();
        
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
                RatioVendedorDTO dtoRatio = new RatioVendedorDTO();
                dtoRatio.setCodEmpleado(rs.getString(1));
                dtoRatio.setVendedor(rs.getString(2));
                dtoRatio.setTotalVisitas(rs.getString(3));
                dtoRatio.setVentasRealizadas(rs.getString(4));
                lista.add(dtoRatio);
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
