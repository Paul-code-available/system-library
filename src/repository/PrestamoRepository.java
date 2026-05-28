package repository;

import config.DatabaseConnection;
import models.Book;
import models.Categoria;
import models.Prestamo;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestamoRepository {

    Prestamo prestamo;

    public PrestamoRepository() {
    }

    public boolean save(Prestamo prestamo){

        String sql = "INSERT INTO prestamo (id_prestamo, fecha_prestamo, fecha_devolucion, estado, id_user, id_libro)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)
        ){

            pst.setInt(1, prestamo.getIdPrestamo());
            pst.setString(2, prestamo.getFechaPrestamo());
            pst.setString(3, prestamo.getFechaDevolucion());
            pst.setString(4, prestamo.getEstado());
            pst.setInt(5, prestamo.getUser().getId());
            pst.setInt(6, prestamo.getLibro().getIdLibro());

            return pst.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public List<Prestamo> getPrestamos(){

        List<Prestamo> prestamos = new ArrayList<>();
        String sql = "SELECT " +
                "p.id_prestamo, p.fecha_prestamo, p.fecha_devolucion, p.estado AS estado_prestamo, " +
                "u.id_user, u.name, u.email, u.phone, u.role, " +
                "l.id_libro, l.title, l.autor, l.publish_year, l.pages, l.language, " +
                "l.available_books, l.total_books, l.isbn, l.cover_path, l.publisher, l.description, " +
                "c.id_categoria, c.nombre AS nombre_categoria, c.descripcion AS desc_categoria " +
                "FROM prestamo AS p " +
                "JOIN users AS u ON p.id_user = u.id_user " +
                "JOIN libro AS l ON p.id_libro = l.id_libro " +
                "JOIN categoria AS c ON l.categoria_id = c.id_categoria";

        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ){
            while(rs.next()){

                User user = new User(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("password"),
                        rs.getString("phone"),
                        rs.getString("role")
                );

                Categoria categoria = new Categoria(
                        rs.getInt("categoria_id"),
                        rs.getString("nombre_categoria"),
                        rs.getString("desc_categoria")
                );

                Book libro = new Book(
                        rs.getInt("id_libro"),
                        rs.getString("title"),
                        rs.getString("autor"),
                        categoria,
                        rs.getInt("pages"),
                        rs.getInt("publish_year"),
                        rs.getString("language"),
                        rs.getInt("available_books"),
                        rs.getInt("total_books"),
                        rs.getString("isbn"),
                        rs.getString("cover_path"),
                        rs.getString("publisher"),
                        rs.getString("description")
                );

                Prestamo prestamo = new Prestamo(
                        rs.getInt("id_prestamo"),
                        rs.getString("fecha_prestamo"),
                        rs.getString("fecha_devolucion"),
                        rs.getString("estado_prestamo"),
                        user,
                        libro
                );
                prestamos.add(prestamo);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return prestamos;
    }

    public List<Prestamo> getPrestamosActivos() {
        List<Prestamo> prestamos = new ArrayList<>();

        String sql = "SELECT " +
                "p.id_prestamo, p.fecha_prestamo, p.fecha_devolucion, p.estado AS estado_prestamo, " +
                "u.id_user, u.name, u.email, u.phone, u.role, " +
                "l.id_libro, l.title, l.autor, " +
                "c.id_categoria, c.nombre AS nombre_categoria, c.descripcion AS desc_categoria " +
                "FROM prestamo AS p " +
                "JOIN users AS u ON p.id_user = u.id_user " +
                "JOIN libro AS l ON p.id_libro = l.id_libro " +
                "JOIN categoria AS c ON l.categoria_id = c.id_categoria " +
                "WHERE p.estado = 'activo'";

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
                        rs.getString("author"),
                        categoria,
                        0, 0, null, 0, 0, null, null, null, null
                );

                User user = new User(
                        rs.getInt("id"),
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
                prestamos.add(prestamo);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return prestamos;
    }

    public boolean delete(int id){

        String sql = "DELETE FROM prestamo WHERE id_prestamo = ?";//consulta slq

        try(Connection connection = DatabaseConnection.getConnection();//establece connection con base de datos
            PreparedStatement pst = connection.prepareStatement(sql);//permite rellenar los ? despues, ademas evita inyeccion sql
        ){
            pst.setInt(1, id);
            int affectedRows = pst.executeUpdate(); //devuelve cuantas filas fueron afectadas
            if (affectedRows > 0){
                System.out.println("Se elimino");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean update(Prestamo prestamo){
        String sql = "UPDATE prestamo SET fecha_prestamo = ?, fecha_devolucion = ?, " +
                "estado = ?, id_user = ?, id_libro = ? " +
                "WHERE id_prestamo = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.setString(1, prestamo.getFechaPrestamo());
            pst.setString(2, prestamo.getFechaDevolucion());
            pst.setString(3, prestamo.getEstado());
            pst.setInt(4, prestamo.getUser().getId());
            pst.setInt(5, prestamo.getLibro().getIdLibro());
            pst.setInt(6, prestamo.getIdPrestamo());

            return pst.executeUpdate() > 0;

        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    public int count() {
        String sql = "SELECT COUNT(*) FROM prestamo";

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

    public int countActivos() {
        String sql = "SELECT COUNT(*) FROM prestamo WHERE estado = 'activo'";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            if (rs.next()) return rs.getInt(1);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return 0;
    }

    public List<Prestamo> getRecentPrestamos(int limit) {
        List<Prestamo> prestamos = new ArrayList<>();

        String sql = "SELECT p.id_prestamo, p.fecha_prestamo, p.fecha_devolucion, p.estado AS estado_prestamo, " +
                "u.id_user, u.name, u.email, u.phone, u.role, " +
                "l.id_libro, l.title, l.autor, " +
                "c.id_categoria, c.nombre AS nombre_categoria, c.descripcion AS desc_categoria " +
                "FROM prestamo AS p " +
                "JOIN users AS u ON p.id_user = u.id_user " +
                "JOIN libro AS l ON p.id_libro = l.id_libro " +
                "JOIN categoria AS c ON l.categoria_id = c.id_categoria " +
                "ORDER BY p.id_prestamo DESC LIMIT " + limit;

        try (Connection connection = DatabaseConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {

                Categoria categoria = new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre_categoria"),
                        rs.getString("desc_categoria"));

                Book libro = new Book(
                        rs.getInt("id_libro"),
                        rs.getString("title"),
                        rs.getString("autor"),
                        categoria,
                        0,
                        0,
                        null,
                        0,
                        0,
                        null,
                        null,
                        null,
                        null);

                User user = new User(
                        rs.getInt("id_user"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("role"));

                prestamos.add(new Prestamo(
                                rs.getInt("id_prestamo"),
                                rs.getString("fecha_prestamo"),
                                rs.getString("fecha_devolucion"),
                                rs.getString("estado_prestamo"),
                                user,
                                libro)
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return prestamos;
    }
}
