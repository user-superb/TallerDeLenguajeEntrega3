package vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.RoundRectangle2D;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daos.CoinDAO;
import entregable1.Coin;

public class PanelCompra extends JFrame{
	
	private JPanel elPanel;
	private JComboBox<String> monedasFiat;
	private JLabel cantidadYPrecio;
	private JLabel precioActualizable;
	private JButton comprar;
	private JButton cancelar;
	private JTextField valor;	
	
	private JPanel panelExteriorCircular;
	
	public JLabel getCantidadYPrecio() {
		return cantidadYPrecio;
	}

	public void setCantidadYPrecio(JLabel cantidadYPrecio) {
		this.cantidadYPrecio = cantidadYPrecio;
	}

	public JPanel getElPanel() {
		return elPanel;
	}

	public JComboBox<String> getMonedasFiat() {
		return monedasFiat;
	}

	public JButton getComprar() {
		return comprar;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public JTextField getValor() {
		return valor;
	}
	
	public JLabel getprecioActualizable()
	{
		return this.precioActualizable;
	}

	public PanelCompra()
	{
		this.setTitle("Comprar Criptomonedas");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.elPanel = new JPanel();
		this.elPanel.setLayout(new BoxLayout(elPanel, BoxLayout.Y_AXIS));	
		this.organizarComps();
		this.add(this.elPanel);	
		this.getContentPane().setBackground(new Color(0xE4E0E1));
		this.pack();
		this.setShape(new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 15, 15));
	//	this.getRootPane().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		this.setVisible(true);

	}
	
	private void personalizarComps()
	{
		//Textfield de ingresar inputs
		this.valor.setMaximumSize(new Dimension(300, 20));
		this.valor.setForeground(Color.BLACK);
		this.valor.setBackground(new Color(0xD6C0B3));
		this.valor.setFont(new Font("Tahoma",Font.PLAIN,12));
		this.valor.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//botones
		this.comprar.setPreferredSize(new Dimension(75, 25));
		this.comprar.setBorder(null);
		this.comprar.setBackground(new Color(0xAB886D));
		this.comprar.setFont(new Font("Tahoma",Font.BOLD,14));		
		this.comprar.setFocusPainted(false);
		
		this.cancelar.setPreferredSize(new Dimension(75, 25));
		this.cancelar.setBorder(null);
		this.cancelar.setBackground(new Color(0xAB886D));
		this.cancelar.setFont(new Font("Tahoma",Font.BOLD,14));
		this.cancelar.setFocusPainted(false);
		
		//opciones
		this.monedasFiat.setMaximumSize(new Dimension(300,20));
		this.monedasFiat.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		//centro todo		
	    cantidadYPrecio.setAlignmentX(Component.CENTER_ALIGNMENT);
	    precioActualizable.setAlignmentX(Component.CENTER_ALIGNMENT);
		
	}
	
	private void organizarComps()
	{
		this.comprar = new JButton("Comprar");
		this.cancelar = new JButton("Cancelar");
		this.valor = new JTextField();		
		this.monedasFiat = new JComboBox<>();
		JLabel mensaje1 = new JLabel("Ingrese cantidad de monedas deseadas: ");
		JLabel mensaje2 = new JLabel("Elija dinero a utilizar: ");
		mensaje1.setAlignmentX(Component.CENTER_ALIGNMENT);
	    mensaje2.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.cantidadYPrecio = new JLabel(""); //llenado por el controlador
		this.precioActualizable = new JLabel("");//llenado por el controlador
		
		this.personalizarComps();
		
		//panel para que los botones sean horizontales
		JPanel botones = new JPanel();
		botones.setLayout(new BoxLayout(botones, BoxLayout.X_AXIS));
		botones.setMaximumSize(new Dimension(300,60));
		botones.setAlignmentX(Component.CENTER_ALIGNMENT);
		botones.add(Box.createHorizontalGlue());
		botones.add(comprar);
		botones.add(Box.createRigidArea(new Dimension(5, 0)));
		botones.add(cancelar);
		botones.add(Box.createHorizontalGlue());
		botones.setBackground(new Color(0xDAD6D7));
		
		Component space = Box.createVerticalStrut(1);
		
		this.elPanel.add(Box.createVerticalStrut(30));
		this.elPanel.add(mensaje1);
		this.elPanel.add(space);
		this.elPanel.add(valor);
		this.elPanel.add(space);
		this.elPanel.add(mensaje2);
		this.elPanel.add(space);
		this.elPanel.add(monedasFiat);
		this.elPanel.add(space);
		this.elPanel.add(cantidadYPrecio);
		this.elPanel.add(space);
		this.elPanel.add(precioActualizable);
		this.elPanel.add(space);
		this.elPanel.add(botones);	
		this.elPanel.setBackground(new Color(0xDAD6D7));
		this.elPanel.add(space);
		this.elPanel.setPreferredSize(new Dimension(300,200));	
		this.elPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
	


}
