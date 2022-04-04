package com.BGS006.Cliente.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.BGS006.Cliente.jdo.Usuario;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;

public class VentanaAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public VentanaAdmin(JFrame frame, Usuario u) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
	
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.setForeground(new Color(255, 165, 0));
		panelTitulo.setBackground(new Color(255, 222, 173));
		panelCentro.add(panelTitulo, BorderLayout.NORTH);
		
		JLabel lblAdministrador = new JLabel("Vista Administrador");
		lblAdministrador.setForeground(new Color(255, 165, 0));
		lblAdministrador.setFont(new Font("Lato", Font.BOLD, 22));
		panelTitulo.add(lblAdministrador);
		
		JPanel panelCentroDentro = new JPanel();
		panelCentroDentro.setBackground(new Color(255, 228, 196));
		panelCentro.add(panelCentroDentro, BorderLayout.CENTER);
		
		panelCentroDentro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblArticulos = new JLabel("Articulos");
		lblArticulos.setForeground(new Color(255, 165, 0));
		lblArticulos.setFont(new Font("Lato", Font.PLAIN, 12));
		lblArticulos.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroDentro.add(lblArticulos);
		
		JComboBox cbZapatillas = new JComboBox();
		cbZapatillas.setBackground(new Color(255, 228, 196));
		panelCentroDentro.add(cbZapatillas);
		
		JLabel lblNumStock = new JLabel("Stock disponible : ");
		lblNumStock.setForeground(new Color(255, 165, 0));
		lblNumStock.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroDentro.add(lblNumStock);
		
		JPanel panelCambiarStock = new JPanel();
		panelCentroDentro.add(panelCambiarStock);
		panelCambiarStock.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblCambiarStock_1 = new JLabel("Cambiar Stock : ");
		lblCambiarStock_1.setForeground(new Color(255, 165, 0));
		lblCambiarStock_1.setBackground(new Color(255, 228, 196));
		lblCambiarStock_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panelCambiarStock.add(lblCambiarStock_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 228, 196));
		textField.setColumns(10);
		panelCambiarStock.add(textField);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		panelCentroDentro.add(panel);
		panel.setLayout(null);
		
		JButton btnGuardarNuevoStock = new JButton("Guardar");
		btnGuardarNuevoStock.setBackground(new Color(255, 222, 173));
		btnGuardarNuevoStock.setForeground(new Color(255, 165, 0));
		btnGuardarNuevoStock.setBounds(285, 11, 87, 30);
		panel.add(btnGuardarNuevoStock);
		
		JPanel panelSur = new JPanel();
		panelSur.setBackground(new Color(255, 228, 181));
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVolver.setForeground(new Color(255, 165, 0));
		btnVolver.setBackground(new Color(255, 222, 173));
		panelSur.add(btnVolver);
	}

}
