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

public class VentanaAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField txtStockNuevo;

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
		panelTitulo.add(lblAdministrador);
		
		JPanel panelCentroDentro = new JPanel();
		panelCentro.add(panelCentroDentro, BorderLayout.CENTER);
		panelCentroDentro.setLayout(new MigLayout("", "[grow]", "[][][][][21.00][][]"));
		
		JLabel lblNumStock = new JLabel("");
		panelCentroDentro.add(lblNumStock, "flowx,cell 0 0");
		
		JComboBox cbZapatillas = new JComboBox();
		panelCentroDentro.add(cbZapatillas, "cell 0 1,growx");
		
		JLabel lblStocksDispo = new JLabel("Strock disponible:");
		panelCentroDentro.add(lblStocksDispo, "cell 0 2");
		
		JLabel lblCambiarStock = new JLabel("Cambiar Stock :");
		panelCentroDentro.add(lblCambiarStock, "flowx,cell 0 4");
		
		txtStockNuevo = new JTextField();
		panelCentroDentro.add(txtStockNuevo, "cell 0 4");
		txtStockNuevo.setColumns(10);
		
		JButton btnGuardarNuevoStock = new JButton("Guardar");
		btnGuardarNuevoStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelCentroDentro.add(btnGuardarNuevoStock, "cell 0 5,alignx left");
		
		JLabel lblZapatillas = new JLabel("Zapatillas");
		lblZapatillas.setHorizontalAlignment(SwingConstants.CENTER);
		panelCentroDentro.add(lblZapatillas, "cell 0 0,growx");
		
		JPanel panelSur = new JPanel();
		contentPane.add(panelSur, BorderLayout.SOUTH);
		
		JButton btnVerStock = new JButton("Ver stock");
		panelSur.add(btnVerStock);
	}

}
