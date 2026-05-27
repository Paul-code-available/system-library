package repository;

import com.sun.jdi.event.StepEvent;
import config.DatabaseConnection;
import models.Categoria;
import models.Libro;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LibroRepository {

    Libro libro;

    public LibroRepository(){

    }

    public void save(){

        String sql = "INSERT INTO libro (id_libro, nombre, ano_publicacion, categoria_id) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement pst = connection.prepareStatement(sql)
        ){
            pst.setInt(1, libro.getIdLibro());
            pst.setString(2, libro.getNombre());
            pst.setString(3, libro.getAnoPublicacion());
            pst.setInt(4, libro.getCategoria().getIdCategoria());

            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public List<Libro> getLibros(){

        List<Libro> libros = new ArrayList<>();

        try(Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM libro")
        ){
            while(rs.next()){

                Categoria categoria = new Categoria();
                categoria.setIdCategoria(rs.getInt("categoria_id"));

                Libro libro = new Libro(
                        rs.getInt("id_libro"),
                        rs.getString("nombre"),
                        rs.getString("ano_publicacion"),
                        categoria
                );
                libros.add(libro);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return libros;
    }

    public boolean delete(int id){

        String sql = "DELETE FROM libros WHERE id_libro = ?";//consulta slq

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


}
