package repository;

import config.DatabaseConnection;
import models.Book;
import models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class LibroRepository {

    Book libro;

    public LibroRepository(){
    }

    public boolean save(Book libro){

        String sql =
                "INSERT INTO libro (" +
                "title, autor, publish_year, categoria_id, " +
                "pages, language, available_books, total_books, " +
                "isbn, cover_path, publisher, description" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
                Connection connection =
                        DatabaseConnection.getConnection();

                PreparedStatement pst =
                        connection.prepareStatement(sql)
        ){

            pst.setString(1, libro.getTitle());
            pst.setString(2, libro.getAuthor());
            pst.setInt(3, libro.getPublishYear());
            pst.setInt(4, libro.getCategory().getIdCategoria());
            pst.setInt(5, libro.getPages());
            pst.setString(6, libro.getLanguage());
            pst.setInt(7, libro.getAvailableBooks());
            pst.setInt(8, libro.getTotalBooks());
            pst.setString(9, libro.getIsbn());
            pst.setString(10, libro.getCoverPath());
            pst.setString(11, libro.getPublisher());
            pst.setString(12, libro.getDescription());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }
    
    public List<Book> getLibros(){

        List<Book> libros = new ArrayList<>();
        String sql = "select l.*, c.id_categoria, " +
                "c.nombre, c.descripcion " +
                "from libro as l " +
                "join categoria as c " +
                "on l.categoria_id = c.id_categoria;";

        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
        ){
            while(rs.next()){

                Categoria categoria = new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
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
                libros.add(libro);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return libros;
    }

    public boolean delete(int id){

        String sql = "DELETE FROM libro WHERE id_libro = ?";//consulta slq

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

    public boolean update(Book libro){
        String sql = "UPDATE libro SET title = ?, publish_year = ?, categoria_id = ?," +
                "pages = ?, language = ?, available_books = ?, total_books = ?," +
                "isbn = ?, cover_path = ?, publisher = ?, description = ?, autor = ?" +
                " WHERE id_libro = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.setString(1, libro.getTitle());
            pst.setInt(2, libro.getPublishYear());
            pst.setInt(3, libro.getCategory().getIdCategoria());
            pst.setInt(4, libro.getPages());
            pst.setString(5, libro.getLanguage());
            pst.setInt(6, libro.getAvailableBooks());
            pst.setInt(7, libro.getTotalBooks());
            pst.setString(8, libro.getIsbn());
            pst.setString(9, libro.getCoverPath());
            pst.setString(10, libro.getPublisher());
            pst.setString(11, libro.getDescription());
            pst.setString(12, libro.getAuthor());
            pst.setInt(13, libro.getIdLibro());

            return pst.executeUpdate() > 0;

        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean actualizarAvailability(int idLibro, int availableBooks) {
        String sql = "UPDATE libro SET available_books = ? WHERE id_libro = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.setInt(1, availableBooks);
            pst.setInt(2, idLibro);
            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public int count() {
        String sql = "SELECT COUNT(*) FROM libro";

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

    public int countTotalCopias() {
        String sql = "SELECT SUM(total_books) FROM libro";

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

    public int contarCopiasDisponibles() {
        String sql = "SELECT SUM(available_books) FROM libro";

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

    public int totalCopiasPrestadas() {
        String sql = "SELECT SUM(total_books - available_books) FROM libro";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql))
        {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }

    public Map<String, Integer> totalLibrosCategoria() {
        Map<String, Integer> result = new LinkedHashMap<>();

        String sql = "SELECT c.nombre, COUNT(l.id_libro) AS total " +
                "FROM libro l " +
                "JOIN categoria c ON l.categoria_id = c.id_categoria " +
                "GROUP BY c.nombre ORDER BY total DESC";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql))
        {
            while (rs.next()){
                result.put(rs.getString("nombre"), rs.getInt("total"));
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }

    public Map<Integer, Integer> totalLibrosYear() {
        Map<Integer, Integer> result = new LinkedHashMap<>();

        String sql = "SELECT publish_year, COUNT(*) AS total FROM libro " +
                "GROUP BY publish_year ORDER BY publish_year DESC";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)){

            while (rs.next()) {
                result.put(rs.getInt("publish_year"), rs.getInt("total"));
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return result;
    }

}
