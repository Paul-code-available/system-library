package repository;

import config.DatabaseConnection;
import models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepository {

    public CategoriaRepository() {}

    public boolean save(Categoria categoria) {
        String sql = "INSERT INTO categoria (nombre, descripcion) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.setString(1, categoria.getNombre());
            pst.setString(2, categoria.getDescripcion());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public List<Categoria> getCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Categoria categoria = new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
                );
                categorias.add(categoria);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return categorias;
    }

    public boolean update(Categoria categoria) {
        String sql = "UPDATE categoria SET nombre = ?, descripcion = ? WHERE id_categoria = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)) {

            pst.setString(1, categoria.getNombre());
            pst.setString(2, categoria.getDescripcion());
            pst.setInt(3, categoria.getIdCategoria());

            return pst.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";

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
        String sql = "SELECT COUNT(*) FROM categoria";

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