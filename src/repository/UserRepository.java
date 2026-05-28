package repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import config.DatabaseConnection;

import models.User;

public class UserRepository {
	
	public void save(User user) throws IOException {
		
		String sql = "INSERT INTO users (name, email, password, phone, role)"
				+ "VALUES (?, ?, ?, ?, ?)";
		
		try (Connection connection = DatabaseConnection.getConnection();
			 PreparedStatement pst = connection.prepareStatement(sql)) {
			
			pst.setString(1, user.getName());
			pst.setString(2, user.getEmail());
			pst.setString(3, user.getPassword());
			pst.setString(4, user.getPhone());
			pst.setString(5, user.getRole());
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Usuario agregado correctamente");
			
			
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}	
	}
	
	public List<User> getUsers() throws IOException{
        
		List<User> users = new ArrayList<>();
		
		try (
			Connection connection = DatabaseConnection.getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM users");
		){
			while (rs.next()) {
				
				User user = new User(
					rs.getInt("id_user"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getString("phone"),
					rs.getString("role")
					);
				
				users.add(user);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return users;
       
	}
	
	public boolean delete(int id) {
		
		String sql = "DELETE FROM users WHERE id_user = ?";
		
		try (Connection connection = DatabaseConnection.getConnection();
			 PreparedStatement pst = connection.prepareStatement(sql)) {
			
			pst.setInt(1, id);
			int affectedRows = pst.executeUpdate();
			if (affectedRows > 0) {
				System.out.println("Se eliminó");
				return true;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean update(User updatedUser) throws IOException {
		
		String sql = "UPDATE users SET name = ?, email = ?, "
				+ "phone = ?, role = ? "
				+ "WHERE id_user = ?";
		
		try (Connection connection = DatabaseConnection.getConnection();
			 PreparedStatement pst = connection.prepareStatement(sql)) {
			
			pst.setString(1, updatedUser.getName());
			pst.setString(2, updatedUser.getEmail());
			pst.setString(3, updatedUser.getPhone());
			pst.setString(4, updatedUser.getRole());
			pst.setInt(5, updatedUser.getId());
			
			int affectedRows = pst.executeUpdate();
			
			if (affectedRows > 0) {
				return true;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return false;
	}

    public int count(){
        String sql = "SELECT COUNT(*) FROM users";

        try(Connection connection = DatabaseConnection.getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql)){

            if(rs.next()){
                return rs.getInt(1);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return 0;
    }
}
