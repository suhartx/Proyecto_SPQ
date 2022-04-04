package com.BGS006.Cliente.Interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Font;

public class VentanaAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public VentanaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new BorderLayout(0, 0));
		
		JPanel panelTitulo = new JPanel();
		panelCentro.add(panelTitulo, BorderLayout.NORTH);
		
		JLabel lblAdministrador = new JLabel("Vista Administrador");
		lblAdministrador.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panelTitulo.add(lblAdministrador);
		
		JPanel panelCentroDentro = new JPanel();
		panelCentro.add(panelCentroDentro, BorderLayout.CENTER);
		
		panelCentroDentro.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblZapatillas = new JLabel("Zapatillas");
		lblZapatillas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblZapatillas.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroDentro.add(lblZapatillas);
		
		JComboBox cbZapatillas = new JComboBox();
		panelCentroDentro.add(cbZapatillas);
		
		JLabel lblNumStock = new JLabel("Stock disponible : ");
		lblNumStock.setVerticalAlignment(SwingConstants.TOP);
		lblNumStock.setHorizontalAlignment(SwingConstants.RIGHT);
		panelCentroDentro.add(lblNumStock);
		
		JPanel panelCambiarStock = new JPanel();
		panelCentroDentro.add(panelCambiarStock);
		panelCambiarStock.setLayout(new GridLayout(1, 2, 0, 0));
		
		JLabel lblCambiarStock_1 = new JLabel("Cambiar Stock : ");
		lblCambiarStock_1.setHorizontalAlignment(SwingConstants.RIGHT);
		panelCambiarStock.add(lblCambiarStock_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		panelCambiarStock.add(textField);
		
		JButton btnGuardarNuevoStock = new JButton("Guardar");
		btnGuardarNuevoStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelCentroDentro.add(btnGuardarNuevoStock);
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnVerStock = new JButton("Ver stock");
		panelSur.add(btnVerStock);
	}

}
