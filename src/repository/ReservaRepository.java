package repository;

import config.DatabaseConnection;
import models.Book;
import models.Categoria;
import models.Reserva;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepository {

    public ReservaRepository() {}

    public boolean save(Reserva reserva) {
        String sql = "INSERT INTO reserva (fecha_reserva, fecha_expiracion, estado, id_user, id_libro) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.setString(1, reserva.getFechaReserva());
            pst.setString(2, reserva.getFechaExpiracion());
            pst.setString(3, reserva.getEstado());
            pst.setInt(4, reserva.getUser().getId());
            pst.setInt(5, reserva.getLibro().getIdLibro());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public List<Reserva> getReservas() {
        List<Reserva> reservas = new ArrayList<>();

        String sql = "SELECT " +
                "r.id_reserva, r.fecha_reserva, r.fecha_expiracion, r.estado AS estado_reserva, " +
                "u.id_user, u.name, u.email, u.phone, u.role, " +
                "l.id_libro, l.title, l.autor, " +
                "c.id_categoria, c.nombre AS nombre_categoria, c.descripcion AS desc_categoria " +
                "FROM reserva AS r " +
                "JOIN users AS u ON r.id_user = u.id_user " +
                "JOIN libro AS l ON r.id_libro = l.id_libro " +
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

                Reserva reserva = new Reserva(
                        rs.getInt("id_reserva"),
                        rs.getString("fecha_reserva"),
                        rs.getString("fecha_expiracion"),
                        rs.getString("estado_reserva"),
                        user,
                        libro
                );

                reservas.add(reserva);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return reservas;
    }

    public List<Reserva> getReservasActivas() {
        List<Reserva> reservas = new ArrayList<>();

        String sql = "SELECT " +
                "r.id_reserva, r.fecha_reserva, r.fecha_expiracion, r.estado AS estado_reserva, " +
                "u.id_user, u.name, u.email, u.phone, u.role, " +
                "l.id_libro, l.title, l.autor, " +
                "c.id_categoria, c.nombre AS nombre_categoria, c.descripcion AS desc_categoria " +
                "FROM reserva AS r " +
                "JOIN users AS u ON r.id_user = u.id_user " +
                "JOIN libro AS l ON r.id_libro = l.id_libro " +
                "JOIN categoria AS c ON l.categoria_id = c.id_categoria " +
                "WHERE r.estado = 'activa'";

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

                Reserva reserva = new Reserva(
                        rs.getInt("id_reserva"),
                        rs.getString("fecha_reserva"),
                        rs.getString("fecha_expiracion"),
                        rs.getString("estado_reserva"),
                        user,
                        libro
                );

                reservas.add(reserva);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return reservas;
    }

    public boolean update(Reserva reserva) {
        String sql = "UPDATE reserva SET fecha_reserva = ?, fecha_expiracion = ?, " +
                "estado = ?, id_user = ?, id_libro = ? " +
                "WHERE id_reserva = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.setString(1, reserva.getFechaReserva());
            pst.setString(2, reserva.getFechaExpiracion());
            pst.setString(3, reserva.getEstado());
            pst.setInt(4, reserva.getUser().getId());
            pst.setInt(5, reserva.getLibro().getIdLibro());
            pst.setInt(6, reserva.getIdReserva());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM reserva WHERE id_reserva = ?";

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
        String sql = "SELECT COUNT(*) FROM reserva";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) return rs.getInt(1);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    public int countActivas() {
        String sql = "SELECT COUNT(*) FROM reserva WHERE estado = 'activa'";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) return rs.getInt(1);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }
}