package es.deusto.client.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.*;

import es.deusto.client.FestivalCineController;
import es.deusto.server.data.PeliculaDTO;
import es.deusto.server.data.UsuarioDTO;

/**
 * Implementación de la ventana para que un usuario pueda obtener un
 * informe de una película.
 * @author Grupo RMBJ
 * @version 3.0
 * @since 3.0
 */
public class InformePelicula extends JFrame {

    static Logger logger = Logger.getLogger(InformePelicula.class.getName());

    public InformePelicula(PeliculaDTO pelicula, UsuarioDTO aux) {
        initComponents(pelicula, aux);
    }

    private void initComponents(PeliculaDTO pelicula, UsuarioDTO aux) {
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        label16 = new JLabel();
        label17 = new JLabel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        label14 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label15 = new JLabel();
        label18 = new JLabel();

        ventana = this;

        //======== this ========

        String myPath = System.getProperty("user.dir");
        this.setIconImage(new ImageIcon(myPath
                + "/src/main/resources/img/filmicon.png").getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Informe: " + pelicula.getTitulo() + " - "
                + aux.getLogin());
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(pelicula.getTitulo());
        label1.setFont(label1.getFont().deriveFont(label1.getFont()
                .getSize() + 18f));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1);
        label1.setBounds(120, 85, 720, 40);

        //---- label2 ----
        label2.setText("A\u00f1o");
        label2.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label2);
        label2.setBounds(105, 165, 75, 20);

        //---- label3 ----
        label3.setText("Duraci\u00f3n");
        label3.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label3);
        label3.setBounds(105, 200, 75, 20);

        //---- label4 ----
        label4.setText("G\u00e9nero");
        label4.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label4);
        label4.setBounds(105, 240, 75, 20);

        //---- label15 ----
        label15.setText("Director");
        label15.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label15);
        label15.setBounds(115, 280, 65, label15
                .getPreferredSize().height);

        //---- label5 ----
        label5.setText("Reparto");
        label5.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label5);
        label5.setBounds(105, 315, 75, 20);

        //---- label6 ----
        label6.setText("Sinopsis");
        label6.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label6);
        label6.setBounds(105, 355, 75, 20);

        //---- label7 ----
        label7.setText("Premios");
        label7.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label7);
        label7.setBounds(105, 470, 75, 20);

        //---- label8 ----
        label8.setText("Valoraci\u00f3n");
        label8.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label8);
        label8.setBounds(105, 525, 75, 20);

        //---- label9 ----
        label9.setText("Tr\u00e1iler");
        label9.setHorizontalAlignment(SwingConstants.RIGHT);
        contentPane.add(label9);
        label9.setBounds(105, 565, 75, 20);

        //---- label10 ----
        label10.setText(Integer.toString(pelicula.getAnyo()));
        contentPane.add(label10);
        label10.setBounds(230, 170, 130, 15);

        //---- label11 ----
        label11.setText(Integer.toString(pelicula.getDuracion())
                + " m.");
        contentPane.add(label11);
        label11.setBounds(230, 205, 140, 15);

        //---- label12 ----
        label12.setText(pelicula.getGenero());
        contentPane.add(label12);
        label12.setBounds(230, 245, 225, 15);

        //---- label18 ----
        label18.setText(pelicula.getDirector());
        contentPane.add(label18);
        label18.setBounds(230, 280, 270, label18
                .getPreferredSize().height);

        //---- label13 ----
        label13.setText(pelicula.getActores());
        contentPane.add(label13);
        label13.setBounds(230, 320, 265, 15);

        //---- label16 ----
        label16.setText(Double.toString(pelicula.getValoracionMedia())
                + "/10");
        contentPane.add(label16);
        label16.setBounds(230, 530, 265, 15);

        //---- label17 ----
        label17.setText(pelicula.getEnlaceTrailer());
        contentPane.add(label17);
        label17.setBounds(230, 570, 265, 15);

        //======== scrollPane1 ========
        //---- textArea1 ----
        textArea1.setText(pelicula.getSinopsis());
        scrollPane1.setViewportView(textArea1);
        textArea1.setEditable(false);

        contentPane.add(scrollPane1);
        scrollPane1.setBounds(230, 360, 270, 90);

        //---- textArea2 ----
        textArea2.setText(pelicula.getPremios());
        contentPane.add(textArea2);
        textArea2.setBounds(230, 470, 270, 45);
        textArea2.setEditable(false);

        //---- label14 ----
        label14.setBounds(580, 165, 270, 160);
        label14.setIcon(ResizeImage(myPath
                + pelicula.getURIimagen(), label14));
        contentPane.add(label14);

        //---- button1 ----
        button1.setText("Mira los Comentarios");
        contentPane.add(button1);
        button1.setBounds(405, 665, 190, 40);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VerComentariosPelicula m =
                        new VerComentariosPelicula(aux, pelicula);
                m.setVisible(true);
                dispose();
            }
        });

        //---- button2 ----
        button2.setText("\u00a1Comenta!");
        contentPane.add(button2);
        button2.setBounds(405, 605, 190, 40);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ComentarPelicula m = new ComentarPelicula(aux, pelicula);
                m.setVisible(true);
                dispose();
            }
        });

        //---- button3 ----
        button3.setText("Vuelve al Men\u00fa Principal");
        contentPane.add(button3);
        button3.setBounds(680, 630, 190, 40);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu m = new Menu(aux);
                m.setVisible(true);
                dispose();
            }
        });

        //---- button4 ----
        button4.setText("Valora la Pel\u00edcula");
        contentPane.add(button4);
        button4.setBounds(130, 630, 190, 40);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // prompt the user to enter their name
                String valoracion = JOptionPane.showInputDialog(ventana,
                        "Indica la puntuación de 1 a 10 por favor");
                try {
                    if (Float.parseFloat(valoracion) < 1
                            || Float.parseFloat(valoracion) > 10) {
                        JOptionPane.showMessageDialog(ventana,
                                "Inserte un valor entre el 1 y el"
                                        + " 10 , por favor.");
                    } else {
                        FestivalCineController.getInstance().valorarPelicula(
                                pelicula.getTitulo(),
                                Float.parseFloat(valoracion));
                        logger.info("La pelicula se ha valorado "
                                + "correctamente.");
                        JOptionPane.showConfirmDialog(ventana,
                                "La pelicula se ha valorado "
                                        + "correctamente. Recarga el informe"
                                        + " de película para ver la valoración"
                                        + "actualizada.",
                                "CONF-A01 - Confirmación de película"
                                        + " valorada",
                                JOptionPane.DEFAULT_OPTION);
                    }
                } catch (NumberFormatException exc) {
                    JOptionPane.showMessageDialog(ventana,
                            "Inserte un valor numérico en el campo "
                                    + "de la puntuación, por favor.");
                }
            }
        });

        Dimension preferredSize = new Dimension();
        for (int i = 0; i < contentPane.getComponentCount(); i++) {
            Rectangle bounds = contentPane.getComponent(i).getBounds();
            preferredSize.width = Math.max(bounds.x
                    + bounds.width, preferredSize.width);
            preferredSize.height = Math.max(bounds.y
                    + bounds.height, preferredSize.height);
        }
        Insets insets = contentPane.getInsets();
        preferredSize.width += insets.right;
        preferredSize.height += insets.bottom;
        contentPane.setMinimumSize(preferredSize);
        contentPane.setPreferredSize(preferredSize);

        pack();
        setLocationRelativeTo(getOwner());
        Rectangle r = ventana.getBounds();
        r.grow(45, 45);
        ventana.setBounds(r);
    }

    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JLabel label16;
    private JLabel label17;
    private JScrollPane scrollPane1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JLabel label14;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label15;
    private JLabel label18;
    private JButton button4;
    private JFrame ventana;

    /**
     * Método para redimensionar un ImageIcon al mismo tamaño que un JLabel.
     * @param ImagePath Ruta de la imagen a modificar.
     * @param label Jlabel sobre el cual se hará el ajuste de la imagen.
     * @return Icono de Imagen con el tamaño ajustado.
     */
    public ImageIcon ResizeImage(String ImagePath, JLabel label) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(),
                label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
}
