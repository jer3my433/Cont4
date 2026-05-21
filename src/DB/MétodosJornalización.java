
package DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class MétodosJornalización {

    Connection con = dbConexion.conectar();

    public DefaultTableModel LeerPartidasPorPeriodo(int idPeriodo) {
       String[] titulos = {"Codigo", "Fecha", "Correlativo", "Cuenta", "Deudor", "Acreedor"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String query = "SELECT * FROM jornalizacion WHERE fk_idPeriodo = ?";

        try (Connection con = dbConexion.conectar(); 
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, idPeriodo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[6];
                
                fila[0] = rs.getInt("Codigo");
                fila[1] = rs.getString("Fecha");
                fila[2] = rs.getString("Correlativo");
                fila[3] = rs.getString("Cuenta");
                fila[4] = rs.getDouble("Deudor");
                fila[5] = rs.getDouble("Acreedor");
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return modelo;
    }

    public void InsertarPartida(int codigo, String Correlativo, String Fecha, String Cuenta, double Deudor, double Acreedor, int idPeriodo) {
       String query = "INSERT INTO jornalizacion (Codigo, Correlativo, Fecha, Cuenta, Deudor, Acreedor, fk_idPeriodo) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = dbConexion.conectar(); 
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, codigo);
            ps.setString(2, Correlativo);
            ps.setString(3, Fecha); 
            ps.setString(4, Cuenta);
            ps.setDouble(5, Deudor);
            ps.setDouble(6, Acreedor);
            ps.setInt(7, idPeriodo);

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }
}
