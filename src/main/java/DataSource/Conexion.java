package DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author KEVIN EP
 */
public class Conexion {
    Connection conexion;
    private final String DATABASE = "appGestionClientes";
    private final String USER = "sa";
    private final String PASSWORD = "123";
    private final String URL = "jdbc:sqlserver://localhost:1433;"
                                + "databaseName=" + DATABASE + ";"
                                + "encrypt=true;trustServerCertificate=true;";

    public Conexion() {
    }
    
    public Connection conectar() {
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,
                    """
                    Ha ocurrido un error al realizar la conexi\u00f3n al servidor de base de datos.
                    Verifique los par\u00e1metros de conexi\u00f3n.
                    
                    Detalle de error:
                    
                    """ + e
                    + "", "Error de conexión", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);
            conexion = null;
            System.exit(0);
        }
        return conexion;
    }
    
    public void desconectar() {
        if (conexion != null) {
            try {
                conexion.close();
                //System.out.println("Conexion terminada. \n Base de datos " + DATABASE + " desconectada.");
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
