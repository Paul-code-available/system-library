package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import models.Book;
import models.Prestamo;
import models.User;
import repository.LibroRepository;
import repository.PrestamoRepository;
import repository.UserRepository;
import utils.AppFont;
import utils.SwingUtils;

public class FormNewBorrowView extends JDialog {
	
	private JComboBox<User> cbUsers;
	private JComboBox<Book> cbBooks;
	private JComboBox<String> cbEstado;
	 
	private JTextField txtFechaPrestamo;
	private JTextField txtFechaDevolucion;

	private JButton btnGuardar;
	private JButton btnCancelar;
	
	private Prestamo prestamo;
	private boolean saved = false;

	
	public FormNewBorrowView(JFrame parent, Prestamo prestamo) throws IOException {
		super(parent, true);
		
		setTitle(prestamo == null ? "Agregar Prestamo" : "Editar prestamo");
		
		setLayout(new BorderLayout());
		
		setSize(340, 420);
		
		setLocationRelativeTo(parent);
		
		panelSuperior();
		panelCentro();
		panelInferior();
		
		loadBooks();
		loadData();
		loadEstado();
		loadUsers();
		
	}
	

	public void panelSuperior() {
		JPanel panelSuperior = new JPanel();
		panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
		panelSuperior.setBackground(Color.decode("#0F1524"));
		
		JLabel lblTitulo = new JLabel("Formulario");
		
		lblTitulo.setFont(AppFont.title());
		lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelSuperior.add(lblTitulo);
		
		add(panelSuperior, BorderLayout.NORTH);
		
	}
	
	public void panelCentro() {
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
		panelCentro.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		panelCentro.setBackground(Color.decode("#0F1524"));
		
		cbUsers = new JComboBox<>(); 
		cbUsers.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		cbUsers.setBackground(Color.decode("#141D30"));
		
		panelCentro.add(cbUsers);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		cbBooks = new JComboBox<>(); 
		cbBooks.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		cbBooks.setBackground(Color.decode("#141D30"));
		
		panelCentro.add(cbBooks);
		
		panelCentro.add(Box.createVerticalStrut(10));

		cbEstado = new JComboBox<>(); 
		cbEstado.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
		cbEstado.setBackground(Color.decode("#141D30"));
		panelCentro.add(cbEstado);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		txtFechaPrestamo = SwingUtils.crearJtfText("Fecha prestamo");
		panelCentro.add(txtFechaPrestamo);
		
		panelCentro.add(Box.createVerticalStrut(10));
		
		txtFechaDevolucion = SwingUtils.crearJtfText("Fecha devolución");
		panelCentro.add(txtFechaDevolucion);
		
		add(panelCentro, BorderLayout.CENTER);
		
	}
	
	public void panelInferior() {
		JPanel panelInferior = new JPanel();
		panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.X_AXIS));
		panelInferior.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelInferior.setBackground(Color.decode("#0F1524"));
		
		panelInferior.add(Box.createHorizontalGlue());
		
		btnGuardar = new JButton("Agregar");
		panelInferior.add(btnGuardar);
		
		panelInferior.add(Box.createHorizontalStrut(10));

		btnCancelar = new JButton("Cancelar");
		panelInferior.add(btnCancelar);
		
		btnGuardar.addActionListener(e -> handleRegister());
		btnCancelar.addActionListener(e -> dispose());
		
		add(panelInferior, BorderLayout.SOUTH);
		
		
	}
	
	public void handleRegister() {

	    try {

	        if (!validateForm()) {
	            return;
	        }

	        save();

	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(this, "Error al guardar préstamo");
	    }
	}
	
	public void save() {

	    User user = (User) cbUsers.getSelectedItem();
	    Book book = (Book) cbBooks.getSelectedItem();
	    String estado = (String) cbEstado.getSelectedItem();

	    LocalDate fechaPrestamo = LocalDate.parse(txtFechaPrestamo.getText());
	    LocalDate fechaDevolucion = LocalDate.parse(txtFechaDevolucion.getText());

	    Prestamo nuevo = new Prestamo(
	            user,
	            book,
	            fechaPrestamo,
	            fechaDevolucion,
	            estado
	    );

	    PrestamoRepository repo = new PrestamoRepository();

	    boolean ok = repo.save(nuevo);
	    
	    System.out.println(ok);

	    if (ok) {
	        saved = true;
	        prestamo = nuevo;
	        dispose();
	    } else {
	        JOptionPane.showMessageDialog(this, "No se pudo guardar el préstamo");
	    }
	}
	
	public void loadData() {

	    if (prestamo != null) {

	        cbUsers.setSelectedItem(prestamo.getUser());
	        cbBooks.setSelectedItem(prestamo.getLibro());

	        txtFechaPrestamo.setText(
	                prestamo.getFechaPrestamo().toString()
	        );

	        txtFechaDevolucion.setText(
	                prestamo.getFechaDevolucion().toString()
	        );

	        cbEstado.setSelectedItem(prestamo.getEstado());
	    }
	}
	
	public void loadUsers() throws IOException {

	    UserRepository repo = new UserRepository();

	    List<User> users = repo.getUsers();

	    for (User user : users) {
	        cbUsers.addItem(user);
	    }
	}
	
	public void loadBooks() {

	    LibroRepository repo = new LibroRepository();

	    List<Book> books = repo.getLibros();

	    for (Book book : books) {
	        cbBooks.addItem(book);
	    }
	}
	
	public void loadEstado() {

	    cbEstado.addItem("Prestado");
	    cbEstado.addItem("Devuelto");
	    cbEstado.addItem("Retrasado");
	    cbEstado.addItem("Pendiente");
	}
	
	public boolean validateForm() {

	    if (cbUsers.getSelectedItem() == null) {
	        JOptionPane.showMessageDialog(this, "Selecciona un usuario");
	        return false;
	    }

	    if (cbBooks.getSelectedItem() == null) {
	        JOptionPane.showMessageDialog(this, "Selecciona un libro");
	        return false;
	    }

	    if (txtFechaPrestamo.getText().isEmpty() ||
	        txtFechaDevolucion.getText().isEmpty()) {

	        JOptionPane.showMessageDialog(this, "Completa las fechas");
	        return false;
	    }

	    try {
	        LocalDate start = LocalDate.parse(txtFechaPrestamo.getText());
	        LocalDate end = LocalDate.parse(txtFechaDevolucion.getText());

	        if (end.isBefore(start)) {
	            JOptionPane.showMessageDialog(this,
	                    "La fecha de devolución no puede ser menor a la de préstamo");
	            return false;
	        }

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(this,
	                "Formato de fecha inválido (yyyy-MM-dd)");
	        return false;
	    }

	    return true;
	}
	
	public boolean isSaved() {
		return saved;
	}


	public Prestamo getPrestamo() {
		return prestamo;
	}


	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
	
	

}
