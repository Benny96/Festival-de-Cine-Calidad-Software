package es.deusto.client.gui;

import es.deusto.server.data.UsuarioDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//TODO: Esto debería cambiarse por una ventana medio bien hecha que muestre la información como en el prototipo.
//TODO: Es decir: https://marvelapp.com/d2h27dh/screen/63129721
public class ResultadoFiltrados extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField2;
    private JComboBox listafiltros;
    private boolean flag = false;
    private JFrame ventana;

    public ResultadoFiltrados(UsuarioDTO aux)
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

        JLabel lblFiltrar = new JLabel("Filtra las peliculas");
        lblFiltrar.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        lblFiltrar.setBounds(40, 40, 350, 73);
        contentPane.add(lblFiltrar);

        JLabel lblCategoria = new JLabel("Categoria");
        lblCategoria.setBounds(46, 123, 101, 37);
        contentPane.add(lblCategoria);

        JButton btnPeliculas = new JButton("Ver listado de peliculas filtradas");
        btnPeliculas.setBounds(46, 220, 175, 29);
        contentPane.add(btnPeliculas);

        btnPeliculas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: POR EL MOMENTO ENSENADOS POR CONSOLA. POSTERIORMENTE SE APLICARA GUI (FILTRADOS.JAVA).
//                PeliculaList peliculaList = FestivalCineController.getInstance().getFilteredPeliculaList((String)(listafiltros.getSelectedItem()));
//                for (PeliculaDTO aux : peliculaList.getPeliculasDTO()) {
//                    System.out.println(aux.toString());
//                }
//                Menu m = new Menu(aux);
//                m.setVisible(true);
//                dispose();
//            	Filtrados filtrados = new Filtrados(aux);
//            	filtrados.setVisible(true);
//            	dispose();
            }
        });
    }
}