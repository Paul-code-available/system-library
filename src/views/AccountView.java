package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import utils.ThemeManager;

public class AccountView extends JPanel {
	
	JButton btnTheme;
	
	public AccountView() {
		setLayout(new BorderLayout());
		
		setMenu();
	}
	
	public void setMenu() {
		JPanel panelMenu = new JPanel();
        panelMenu.setPreferredSize(new Dimension(0, 70));
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.Y_AXIS));
        add(panelMenu, BorderLayout.NORTH);
        
		btnTheme = new JButton("Cambiar modo");
		btnTheme.setMaximumSize(new Dimension(120, 40));
		
	    btnTheme.addActionListener(e -> {
	    	ThemeManager.toggle();
	    });
	    
	    panelMenu.add(btnTheme);
	}
	

}
