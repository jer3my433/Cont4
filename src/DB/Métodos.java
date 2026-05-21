package DB;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Métodos {

    public void ActualizarDatosJornalizacion(int cod, String correlativo, String fecha, String cuenta, double deudor, double acreedor, int idPeriodo) {
        String sql = "UPDATE jornalizacion SET Correlativo=?, Fecha=?, Cuenta=?, Deudor=?, Acreedor=? WHERE Codigo=? AND fk_idPeriodo=?";
        try {
            Connection con = dbConexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, correlativo);
            ps.setString(2, fecha);
            ps.setString(3, cuenta);
            ps.setDouble(4, deudor);
            ps.setDouble(5, acreedor);
            ps.setInt(6, cod);
            ps.setInt(7, idPeriodo);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void EliminarDatosJornalizacion(int codigo) {
        String sql = "DELETE FROM jornalizacion WHERE Codigo=?";
        try {
            Connection con = dbConexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void EliminarTodoJornalizacion(int idPeriodo) {
        String sql = "DELETE FROM jornalizacion WHERE fk_idPeriodo=?";
        try {
            Connection con = dbConexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPeriodo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public DefaultTableModel LeerBancCuentas() {
        String[] titulos = {"No.", "Cuenta", "Debe", "Haber", "Perdida", "Ganancia", "Activo", "Pasivo"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);

        String query = "SELECT * FROM `cuentas_contables` text";

        try {
            Connection con = dbConexion.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            Object[] fila = new Object[8];
            while (rs.next()) {
                fila[0] = rs.getString(1);
                fila[1] = rs.getString(2);
                fila[2] = rs.getString(3);
                fila[3] = rs.getString(4);
                fila[4] = rs.getString(5);
                fila[5] = rs.getString(6);
                fila[6] = rs.getString(7);
                fila[7] = rs.getString(8);
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return modelo;
    }

    public boolean autenticarUsuario(String usuario, String contraseña) {
        Connection con = dbConexion.conectar();
        String sql = "SELECT * FROM usuario WHERE Nombre_usuario = ? AND Contraseña = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.err.println("Error " + e);
            return false;
        }
    }

    public boolean existeRegistroJornalizacion(int codigo, int idPeriodo) {
        Connection con = dbConexion.conectar();
        String sql = "SELECT Codigo FROM jornalizacion WHERE Codigo = ? AND fk_idPeriodo = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.setInt(2, idPeriodo);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            return false;
        }
    }

    public void InsertarDatosPeriodo(String fechainicio, String fechafin, String Descripcion) {
        String query = "insert into periodo (Fecha_inicio, Fecha_fin, Descripcion, Estado) values (?,?,?,?)";
        try {
            Connection con = dbConexion.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, fechainicio);
            ps.setString(2, fechafin);
            ps.setString(3, Descripcion);
            ps.setString(4, "Cerrado");
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }

    public DefaultTableModel LeerDatosPeriodo() {
        String[] titulos = {"Periodo", "Fecha inicio", "Fecha fin", "Descripción", "Estado", "Archivo"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4 || column == 5;
            }
        };

        String query = "select * from periodo";
        try {
            Connection con = dbConexion.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            Object[] fila = new Object[6];
            while (rs.next()) {
                fila[0] = rs.getInt("idPeriodo");
                fila[1] = rs.getString("Fecha_inicio");
                fila[2] = rs.getString("Fecha_fin");
                fila[3] = rs.getString("Descripcion");
                fila[4] = rs.getString("Estado");
                fila[5] = "Ingresar";
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return modelo;
    }

    public void ActualizarEstadoPeriodo(int idPeriodo, String estado) {
        String sql = "UPDATE periodo SET Estado = ? WHERE idPeriodo = ?";
        try (Connection con = dbConexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, estado);
            ps.setInt(2, idPeriodo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void EliminarPeriodo(int idPeriodo) {
        String sql = "DELETE FROM periodo WHERE idPeriodo = ?";
        try {
            Connection con = dbConexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPeriodo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public boolean existeRegistroPeriodo(int idPeriodo) {
        Connection con = dbConexion.conectar();
        String sql = "SELECT idPeriodo FROM periodo WHERE idPeriodo = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPeriodo);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            return false;
        }
    }

    public void ActualizarDatosPeriodo(String Fechainicio, String Fechafin, String Descripción, int idPeriodo) {
        String sql = "UPDATE periodo SET Fecha_inicio=?, Fecha_fin=?, Descripcion=? WHERE idPeriodo=?";
        try {
            Connection con = dbConexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, Fechainicio);
            ps.setString(2, Fechafin);
            ps.setString(3, Descripción);
            ps.setInt(4, idPeriodo);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public DefaultTableModel LeerDatosPeriodoLibroDiario() {
        String[] titulos = {"Periodo", "Fecha inicio", "Fecha fin", "Descripción", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String query = "select * from periodo";
        try {
            Connection con = dbConexion.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            Object[] fila = new Object[5];
            while (rs.next()) {
                fila[0] = rs.getInt("idPeriodo");
                fila[1] = rs.getString("Fecha_inicio");
                fila[2] = rs.getString("Fecha_fin");
                fila[3] = rs.getString("Descripcion");
                fila[4] = rs.getString("Estado");
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return modelo;
    }

    public DefaultTableModel LeerJornalizacionParaLibroDiario(int idPeriodo) {
        String[] titulos = {"Fecha", "Código", "Correlativo", "Descripción", "Debe", "Haber"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String query = "SELECT Fecha, Codigo, Correlativo, Cuenta, Deudor, Acreedor FROM jornalizacion WHERE fk_idPeriodo = ?";

        try (Connection con = dbConexion.conectar(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idPeriodo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getString("Fecha");
                fila[1] = rs.getInt("Codigo");
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

    public DefaultTableModel LeerDatosPeriodoLibroMayor() {
        String[] titulos = {"Periodo", "Fecha inicio", "Fecha fin", "Descripción", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String query = "select * from periodo";
        try {
            Connection con = dbConexion.conectar();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            Object[] fila = new Object[5];
            while (rs.next()) {
                fila[0] = rs.getInt("idPeriodo");
                fila[1] = rs.getString("Fecha_inicio");
                fila[2] = rs.getString("Fecha_fin");
                fila[3] = rs.getString("Descripcion");
                fila[4] = rs.getString("Estado");
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return modelo;
    }

    public DefaultTableModel LeerCuentasMayor() {
        DefaultTableModel modelo = new DefaultTableModel() {
            // Hacemos que las celdas no sean editables por el usuario al hacer doble clic
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo.addColumn("Cuentas de Diario");

        String sql = "SELECT DISTINCT Cuenta FROM jornalizacion WHERE Cuenta IS NOT NULL AND Cuenta != '' ORDER BY Cuenta ASC";

        try {
            Connection con = dbConexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Object[] fila = new Object[1];
                fila[0] = rs.getString("Cuenta");
                modelo.addRow(fila);
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return modelo;
    }

    public DefaultTableModel LeerDetalleCuentaMayor(String nombreCuenta) {
        String[] titulos = {"Fecha", "Código", "Descripción", "Debe", "Haber", "Saldo"};
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String query = "SELECT Codigo, Fecha, Deudor, Acreedor, fk_idPeriodo, Cuenta "
                + "FROM jornalizacion WHERE Cuenta = ? ORDER BY Fecha ASC, Codigo ASC";

        try (Connection con = dbConexion.conectar(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, nombreCuenta);
            ResultSet rs = ps.executeQuery();
            double saldoAcumulado = 0.0;
            while (rs.next()) {
                Object[] fila = new Object[6];
                double Debe = rs.getDouble("Deudor");
                double Haber = rs.getDouble("Acreedor");
                saldoAcumulado += (Debe - Haber);
                fila[0] = rs.getString("Fecha");
                fila[1] = rs.getInt("Codigo");
                fila[2] = rs.getString("Cuenta");
                fila[3] = Debe;
                fila[4] = Haber;
                fila[5] = String.format("%.2f", saldoAcumulado);
                modelo.addRow(fila);
                System.out.println("¡Total guardado exitosamente con la fecha de la tabla: ");
            }
        } catch (SQLException ex) {
            System.out.println("Error " + ex.getMessage());
        }
        return modelo;
    }

    public void insertarDatosLibroMayor(String codigo, String fecha, String cuenta, double debe, double haber) {
        String sql = "INSERT INTO libro_mayor (Código, Fecha, Descripción, Debe, Haber) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection con = dbConexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            String fechaMySQL = fecha;
            try {
                java.text.SimpleDateFormat formatoEntrada = new java.text.SimpleDateFormat("dd/MM/yyyy");
                java.text.SimpleDateFormat formatoMySQL = new java.text.SimpleDateFormat("yyyy-MM-dd");
                formatoEntrada.setLenient(false);
                fechaMySQL = formatoMySQL.format(formatoEntrada.parse(fecha));
            } catch (java.text.ParseException ex) {
                System.err.println("Advertencia: fecha con formato inesperado («" + fecha + "»), se inserta tal cual.");
            }
            ps.setString(2, fechaMySQL);
            ps.setString(3, cuenta);
            ps.setDouble(4, debe);
            ps.setDouble(5, haber);

            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Registro insertado en libro_mayor: [" + codigo + " - " + cuenta + "]");
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar en libro_mayor: " + e.getMessage());
            System.err.println("Estado SQL: " + e.getSQLState());
        }
    }

    public void eliminarCuentaLibroMayor(String cuenta) {
        String sql = "DELETE FROM libro_mayor WHERE Descripción = ?";
        try (Connection con = dbConexion.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cuenta);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al limpiar cuenta en libro_mayor: " + e.getMessage());
        }
    }

   public DefaultTableModel obtenerTotalesDesdeLibroMayor() {
    String[] titulos = {"Código", "Cuenta", "Debe", "Haber", "Saldo Deudor", "Saldo Acreedor"};
    DefaultTableModel modelo = new DefaultTableModel(null, titulos);

    // Consulta directa a jornalizacion agrupando por Codigo y Cuenta
    String sql = "SELECT Codigo, Cuenta, "
               + "SUM(Deudor) AS TotalDebe, "
               + "SUM(Acreedor) AS TotalHaber "
               + "FROM jornalizacion "
               + "GROUP BY Codigo, Cuenta "
               + "ORDER BY Codigo ASC";

    double sumaTotalDebe     = 0;
    double sumaTotalHaber    = 0;
    double sumaTotalDeudor   = 0;
    double sumaTotalAcreedor = 0;

    try {
        Connection con = dbConexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String codigo = rs.getString("Codigo");
            String cuenta = rs.getString("Cuenta");
            double debe   = rs.getDouble("TotalDebe");   // ← alias correcto
            double haber  = rs.getDouble("TotalHaber");  // ← alias correcto

            if (debe == 0 && haber == 0) continue;

            // Lógica contable: saldo deudor o acreedor según cuál sea mayor
            double saldoDeudor   = (debe > haber)  ? debe - haber  : 0;
            double saldoAcreedor = (haber > debe)   ? haber - debe  : 0;

            sumaTotalDebe     += debe;
            sumaTotalHaber    += haber;
            sumaTotalDeudor   += saldoDeudor;
            sumaTotalAcreedor += saldoAcreedor;

            modelo.addRow(new Object[]{
                codigo != null ? codigo : "---",
                cuenta,
                String.format("%.2f", debe),
                String.format("%.2f", haber),
                String.format("%.2f", saldoDeudor),
                String.format("%.2f", saldoAcreedor)
            });
        }

        // Fila de totales al final, igual que en la imagen
        if (modelo.getRowCount() > 0) {
            modelo.addRow(new Object[]{
                "",
                "Sumas",
                String.format("%.2f", sumaTotalDebe),
                String.format("%.2f", sumaTotalHaber),
                String.format("%.2f", sumaTotalDeudor),
                String.format("%.2f", sumaTotalAcreedor)
            });
        }

    } catch (SQLException e) {
        System.out.println("Error en la base de datos: " + e.getMessage());
    }

    return modelo;
}
public DefaultTableModel obtenerTotalesPorPeriodo(int idPeriodo) {
    String[] titulos = {"Código", "Cuenta", "Debe", "Haber", "Saldo Deudor", "Saldo Acreedor"};
    DefaultTableModel modelo = new DefaultTableModel(null, titulos) {
        @Override
        public boolean isCellEditable(int row, int column) { return false; }
    };

    String sql = "SELECT Codigo, Cuenta, "
               + "SUM(Deudor) AS TotalDebe, "
               + "SUM(Acreedor) AS TotalHaber "
               + "FROM jornalizacion "
               + "WHERE fk_idPeriodo = ? "
               + "GROUP BY Codigo, Cuenta "
               + "ORDER BY Codigo ASC";

    double sumaDebe = 0, sumaHaber = 0, sumaDeudor = 0, sumaAcreedor = 0;

    try {
        Connection con = dbConexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idPeriodo);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String codigo = rs.getString("Codigo");
            String cuenta = rs.getString("Cuenta");
            double debe   = rs.getDouble("TotalDebe");
            double haber  = rs.getDouble("TotalHaber");

            if (debe == 0 && haber == 0) continue;

            double saldoDeudor   = (debe  > haber) ? debe  - haber : 0;
            double saldoAcreedor = (haber > debe)  ? haber - debe  : 0;

            sumaDebe     += debe;
            sumaHaber    += haber;
            sumaDeudor   += saldoDeudor;
            sumaAcreedor += saldoAcreedor;

            modelo.addRow(new Object[]{
                codigo != null ? codigo : "---",
                cuenta,
                String.format("%.2f", debe),
                String.format("%.2f", haber),
                String.format("%.2f", saldoDeudor),
                String.format("%.2f", saldoAcreedor)
            });
        }

        if (modelo.getRowCount() > 0) {
            modelo.addRow(new Object[]{
                "", "Sumas",
                String.format("%.2f", sumaDebe),
                String.format("%.2f", sumaHaber),
                String.format("%.2f", sumaDeudor),
                String.format("%.2f", sumaAcreedor)
            });
        }

    } catch (SQLException e) {
        System.out.println("Error al filtrar por período: " + e.getMessage());
    }

    return modelo;
}
}
