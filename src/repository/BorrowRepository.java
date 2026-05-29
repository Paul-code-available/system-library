package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import config.DatabaseConnection;
import models.Book;
import models.Borrow;
import models.User;

public class BorrowRepository {
	
	public void save(Borrow borrow) throws SQLException {
		
		String sql = "INSERT INTO borrows (user_id, book_id, loan_date, return_date, status)"
				+ "VALUES(?, ?, ?, ?, ?";
		
		try (Connection connection = DatabaseConnection.getConnection();
			 PreparedStatement pst = connection.prepareStatement(sql)) {
			
			pst.setInt(1, borrow.getUser().getId());
			pst.setInt(2, borrow.getBook().getIdLibro());
			pst.setDate(3, Date.valueOf(borrow.getLoanDate()));
			pst.setDate(4, Date.valueOf(borrow.getReturnDate()));
			pst.setString(5, borrow.getStatus());
			
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Prestamo agregado correctamente");
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}
	
	public List<Borrow> getBorrows() throws SQLException {
		
		List<Borrow> borrows = new ArrayList<>();
		
		try (
			Connection connection = DatabaseConnection.getConnection();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("""
					SELECT 
						b.id,
						
						u.id AS user_id,
						u.name,
						u.email,
						u.phone,
						u.role,
						
						bk.id as book_id,
						bk.title,
						bk.author,
						bk.category,
						
						b.loan_date,
						b.return_date,
						b.status
					
					FROM borrows b
					
					JOIN users u
						ON b.user_id = u.id
					JOIN books bk
						ON b.book_id = bk.id
					""");
			) {
	
			while (rs.next()) {
				
			User user = 
					new User(
							rs.getInt("user_id"),
							rs.getString("name"),
							rs.getString("email"),
							rs.getString("phone"),
							rs.getString("role")
							);
			Book book = new Book();
			
			book.setIdLibro(rs.getInt("book_id"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			//book.setCategory(rs.getString("category"));
							
			Borrow borrow = new Borrow();
			
			borrow.setId(rs.getInt("id"));
			borrow.setUser(user);
			borrow.setBook(book);
			borrow.setLoanDate(rs.getDate("loan_date").toLocalDate());
			borrow.setReturnDate(rs.getDate("return_date").toLocalDate());
			borrow.setStatus(rs.getString("status"));
			
			borrows.add(borrow);
		
			}
			
			return borrows;
		}
		
	}
	

}
