package views;

import java.awt.*;
import java.io.File;
import java.net.CookieHandler;
import java.util.Locale;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import tablemodels.UserTableModel;
import utils.AppFont;

public class UsersView extends JPanel{
	
	private JTable table;
	private JButton btnEdit;
	private JButton btnAdd;
	private JButton btnDelete;
    private JButton btnPdf;


	
	public UsersView() {
		setLayout(new BorderLayout());
		table = new JTable();
        styleTable();

        add(new JScrollPane(table), BorderLayout.CENTER);
        
        editarUsuarios();
	}
	
	public void editarUsuarios() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		btnEdit = new JButton("Editar");
		btnAdd = new JButton("Añadir");
		btnDelete = new JButton("Borrar");
        btnPdf = new JButton("Exportar a PDF");
		
		panel.add(btnEdit);
		panel.add(btnAdd);
		panel.add(btnDelete);
        panel.add(btnPdf);
		
		add(panel, BorderLayout.NORTH);
	}

    public void styleTable(){
        table.setRowHeight(25);
        table.setShowGrid(true);
        table.setGridColor(new Color(230, 230, 230));
        table.setBackground(Color.WHITE);
        table.setForeground(Color.BLACK);
        table.setFont(AppFont.medium());

        table.setSelectionBackground(new Color(52, 152, 219));
        table.setSelectionForeground(Color.WHITE);

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(44, 62, 80));
        header.setForeground(Color.WHITE);
        header.setFont(AppFont.large());
        header.setPreferredSize(new Dimension(0, 35));
        header.setReorderingAllowed(false);

        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){

            @Override
            public Component getTableCellRendererComponent(
                JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column)
            {

            Component c = super.getTableCellRendererComponent(
                    table,
                    value,
                    isSelected,
                    hasFocus,
                    row,
                    column
            );

            if (!isSelected) {
                if (row % 2 == 0) {
                    c.setBackground(Color.WHITE);
                } else {
                    c.setBackground(new Color(245, 245, 245));
                }

                c.setForeground(Color.BLACK);
            }

            if(column == 1) {
                c.setFont(AppFont.medium());
                if(!isSelected) {
                    c.setForeground(new Color(41, 128, 185));
                }
            } else {
                c.setFont(AppFont.medium());
            }
            return c;
        }
        });
    }

	public void setTableModel(UserTableModel model) {
		table.setModel(model);

        if (table.getColumnCount() >= 1){
            table.getColumnModel().getColumn(0).setPreferredWidth(100);
        }

        if (table.getColumnCount() >= 2){
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
        }

        if (table.getColumnCount() >= 3){
            table.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(SwingConstants.CENTER);

        if(table.getColumnCount() >= 1) {
            table.getColumnModel().getColumn(0).setCellRenderer(center);
        }
	}

    public File selectPdfFile(){
        String path = System.getProperty("user.home");
        JFileChooser chooser = new JFileChooser();

        chooser.setSelectedFile(new File("reporte-usuarios"));

        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY); //solo permite seleccionar archivos, no carpetas
        chooser.setAcceptAllFileFilterUsed(false);

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Documentos PDF", "pdf");
        chooser.addChoosableFileFilter(filter);
        chooser.setFileFilter(filter);

        int option = chooser.showDialog(this, "Exportar PDF de usuarios");

        if (option != JFileChooser.APPROVE_OPTION){
            return null;
        }

        File file = chooser.getSelectedFile();

        if (!file.getName().toLowerCase().endsWith(".pdf")){
            file = new File(file.getAbsolutePath() + ".pdf");
        }

        return file;
    }
	
	public JTable getTable() {
		return table;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

    public JButton getBtnPdf() {
        return btnPdf;
    }

    public void setBtnPdf(JButton btnPdf) {
        this.btnPdf = btnPdf;
    }

    public int getSelectedRow() {
    	return table.getSelectedRow();
    }

}
