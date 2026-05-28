package repository;

import config.DatabaseConnection;
import models.Multa;
import models.Prestamo;
import models.Book;
import models.Categoria;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MultaRepository {

    public MultaRepository() {}

    public boolean save(Multa multa) {
        String sql = "INSERT INTO multa (monto, fecha_creacion, fecha_limite_pago, estado, id_prestamo) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.setDouble(1, multa.getMonto());
            pst.setString(2, multa.getFechaCreacion());
            pst.setString(3, multa.getFechaLimitePago());
            pst.setString(4, multa.getEstado());
            pst.setInt(5, multa.getPrestamo().getIdPrestamo());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public List<Multa> getMultas() {
        List<Multa> multas = new ArrayList<>();

        String sql = "SELECT " +
                "m.id_multa, m.monto, m.fecha_creacion, m.fecha_limite_pago, m.estado AS estado_multa, " +
                "p.id_prestamo, p.fecha_prestamo, p.fecha_devolucion, p.estado AS estado_prestamo, " +
                "u.id_user, u.name, u.email, u.phone, u.role, " +
                "l.id_libro, l.title, l.autor, " +
                "c.id_categoria, c.nombre AS nombre_categoria, c.descripcion AS desc_categoria " +
                "FROM multa AS m " +
                "JOIN prestamo AS p ON m.id_prestamo = p.id_prestamo " +
                "JOIN users AS u ON p.id_user = u.id_user " +
                "JOIN libro AS l ON p.id_libro = l.id_libro " +
                "JOIN categoria AS c ON l.categoria_id = c.id_categoria";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Categoria categoria = new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre_categoria"),
                        rs.getString("desc_categoria")
                );

                Book libro = new Book(
                        rs.getInt("id_libro"),
                        rs.getString("title"),
                        rs.getString("autor"),
                        categoria,
                        0, 0, null, 0, 0, null, null, null, null
                );

                User user = new User(
                        rs.getInt("id_user"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("role")
                );

                Prestamo prestamo = new Prestamo(
                        rs.getInt("id_prestamo"),
                        rs.getString("fecha_prestamo"),
                        rs.getString("fecha_devolucion"),
                        rs.getString("estado_prestamo"),
                        user,
                        libro
                );

                Multa multa = new Multa(
                        rs.getInt("id_multa"),
                        rs.getDouble("monto"),
                        rs.getString("fecha_creacion"),
                        rs.getString("fecha_limite_pago"),
                        rs.getString("estado_multa"),
                        prestamo
                );

                multas.add(multa);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return multas;
    }

    public List<Multa> getMultasPendientes() {
        List<Multa> multas = new ArrayList<>();

        String sql = "SELECT " +
                "m.id_multa, m.monto, m.fecha_creacion, m.fecha_limite_pago, m.estado AS estado_multa, " +
                "p.id_prestamo, p.fecha_prestamo, p.fecha_devolucion, p.estado AS estado_prestamo, " +
                "u.id_user, u.name, u.email, u.phone, u.role, " +
                "l.id_libro, l.title, l.autor, " +
                "c.id_categoria, c.nombre AS nombre_categoria, c.descripcion AS desc_categoria " +
                "FROM multa AS m " +
                "JOIN prestamo AS p ON m.id_prestamo = p.id_prestamo " +
                "JOIN users AS u ON p.id_user = u.id_user " +
                "JOIN libro AS l ON p.id_libro = l.id_libro " +
                "JOIN categoria AS c ON l.categoria_id = c.id_categoria " +
                "WHERE m.estado = 'pendiente'";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Categoria categoria = new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre_categoria"),
                        rs.getString("desc_categoria")
                );

                Book libro = new Book(
                        rs.getInt("id_libro"),
                        rs.getString("title"),
                        rs.getString("autor"),
                        categoria,
                        0, 0, null, 0, 0, null, null, null, null
                );

                User user = new User(
                        rs.getInt("id_user"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("role")
                );

                Prestamo prestamo = new Prestamo(
                        rs.getInt("id_prestamo"),
                        rs.getString("fecha_prestamo"),
                        rs.getString("fecha_devolucion"),
                        rs.getString("estado_prestamo"),
                        user,
                        libro
                );

                Multa multa = new Multa(
                        rs.getInt("id_multa"),
                        rs.getDouble("monto"),
                        rs.getString("fecha_creacion"),
                        rs.getString("fecha_limite_pago"),
                        rs.getString("estado_multa"),
                        prestamo
                );

                multas.add(multa);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return multas;
    }

    public boolean update(Multa multa) {
        String sql = "UPDATE multa SET monto = ?, fecha_creacion = ?, " +
                "fecha_limite_pago = ?, estado = ? " +
                "WHERE id_multa = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.setDouble(1, multa.getMonto());
            pst.setString(2, multa.getFechaCreacion());
            pst.setString(3, multa.getFechaLimitePago());
            pst.setString(4, multa.getEstado());
            pst.setInt(5, multa.getIdMulta());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM multa WHERE id_multa = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.setInt(1, id);
            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public int count() {
        String sql = "SELECT COUNT(*) FROM multa";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) return rs.getInt(1);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    public int countPendientes() {
        String sql = "SELECT COUNT(*) FROM multa WHERE estado = 'pendiente'";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    public double totalMontoPendiente() {
        String sql = "SELECT SUM(monto) FROM multa WHERE estado = 'pendiente'";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) return rs.getDouble(1);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0.0;
    }
}