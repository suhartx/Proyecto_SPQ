package com.BGS006.cliente.interfaz;

import javax.swing.JPanel;
import java.awt.*;

import com.BGS006.cliente.bbdd.BD;
import com.BGS006.cliente.jdo.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.text.html.ImageView;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;

public class panelArticuloHome extends JPanel {
    /**
     * Create the panel.corazon favorito
     */
    Usuario u;
    public panelArticuloHome(final Articulo a) {
        setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

        setLayout(new BorderLayout(0, 0));
        JPanel panelCentro = new JPanel();
        panelCentro.setBackground(new Color(248, 196, 113));
        add(panelCentro, BorderLayout.CENTER);
        ImageIcon im = new ImageIcon(a.getRutaImagen());
        ImageIcon imagenConDimensiones = new ImageIcon(im.getImage().getScaledInstance(200,200,ImageView.CENTER));

        JLabel lblImagen = new JLabel();
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        lblImagen.setIcon(imagenConDimensiones);
        lblImagen.setPreferredSize(new DimensionUIResource(300, 300));
        panelCentro.add(lblImagen);

        JPanel panelSur = new JPanel();
        panelSur.setBackground(new Color(248, 196, 113));
        add(panelSur, BorderLayout.SOUTH);
        panelSur.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblNombre = new JLabel(a.getNombre());
        lblNombre.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 26));
        lblNombre.setForeground(new Color(255, 255, 255));
        lblNombre.setBackground(new Color(255, 255, 255));
        panelSur.add(lblNombre, "cell 0 0,aligny center");

        JLabel lblPrecio = new JLabel("Precio : " + a.getPrecio()+ "€ ");
        lblPrecio.setForeground(new Color(255, 255, 255));
        lblPrecio.setFont(new Font("Microsoft YaHei", Font.PLAIN, 19));
        panelSur.add(lblPrecio, "cell 0 1,alignx left,aligny bottom");

        JLabel lblStock = new JLabel("Stock : "+a.getStock());
        lblStock.setForeground(new Color(255, 255, 255));
        lblStock.setFont(new Font("Microsoft YaHei", Font.PLAIN, 19));
        lblStock.setHorizontalAlignment(SwingConstants.LEFT);
        panelSur.add(lblStock, "flowx,cell 0 2,alignx left,aligny bottom");

        ImageIcon im3 = new ImageIcon("src/main/resources/imagenes/carrito.png");
        ImageIcon imagenConDimensiones3 = new ImageIcon(im3.getImage().getScaledInstance(30,30,ImageView.CENTER));
        JButton btnComprar = new JButton(imagenConDimensiones3);
        btnComprar.setFont(new Font("Trebuchet MS", Font.PLAIN, 15));
        btnComprar.setForeground(new Color(51, 51, 153));
        btnComprar.setBackground(new Color(153, 255, 0));
        panelSur.add(btnComprar, "cell 1 1");

        /*EVENTOS*/
        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(a instanceof Zapatillas){
                    Zapatillas z = new Zapatillas(a.getNombre(), a.getPrecio(), a.getId(), a.getRutaImagen(), a.getStock());
                    u.addCarrito(z);
                }else if(a instanceof Limpiador) {
                    Limpiador l = new Limpiador(a.getNombre(), a.getPrecio(), a.getId(), a.getRutaImagen(), a.getStock());
                    u.addCarrito(l);
                }else if(a instanceof Calcetines) {
                    Calcetines z = new Calcetines(a.getNombre(), a.getPrecio(), a.getId(), a.getRutaImagen(), a.getStock());
                    u.addCarrito(z);
                }
                    JOptionPane.showMessageDialog(null, "Artículo añadido a compras ","DONE", JOptionPane.INFORMATION_MESSAGE);
                    for(Articulo a : u.getCarro()) {
                    System.out.println(a);
                }

        }
    });

    }
}

