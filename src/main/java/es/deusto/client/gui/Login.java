package es.deusto.ingenieria.sd.eb.client.gui;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import es.deusto.ingenieria.sd.eb.client.controller.EasyBookingController;
import es.deusto.ingenieria.sd.eb.server.data.dto.UsuarioDTO;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private boolean flag = false;
	private JFrame ventana;
	
	private List<UsuarioDTO> usuarioDTO = new ArrayList<UsuarioDTO>();
	
	public Login() 
	{
		ventana = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.white);
		setTitle("Proceso de LogIn");
		
		JLabel lblFacebookgoogle = new JLabel("Introduce tus credenciales");
		lblFacebookgoogle.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		lblFacebookgoogle.setBounds(40, 40, 350, 73);
		contentPane.add(lblFacebookgoogle);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(46, 123, 101, 37);
		contentPane.add(lblUsuario);
		
		
		textField = new JTextField();
		textField.setBounds(46, 172, 146, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRegistrarse = new JButton("Entrar");
		btnRegistrarse.setBounds(132, 234, 155, 29);
		contentPane.add(btnRegistrarse);
		btnRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
					flag = comprobarUsuario(EasyBookingController.getInstance().getUsuarios());
					if (!flag)
					{
						JOptionPane.showMessageDialog(ventana, "No hay usuarios que concuerden con esa credencial. Int�ntelo otra vez.");
					}
				} 
                catch (RemoteException e1) 
                {
					e1.printStackTrace();
				}
            }
        });
	}
	private boolean comprobarUsuario(List<UsuarioDTO> usu)
	{
		usuarioDTO = usu;
		for (int i = 0; i < usuarioDTO.size(); i++)
        {
        if (usu.get(i).getEmail().compareTo(textField.getText())==0)
			{
         		System.out.println("Mi aeropuerto es: "+ usu.get(i).getAeropuerto());
         		Menu m = new Menu(usu.get(i));
         		m.setVisible(true);
         		dispose();
         		return true;
			}
        }
		return false;
	}
}