package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.*;

import Controller.ReportesController;
import java.awt.Font;


public class MenuJFrame extends JFrame{
    private ReportesController controller;
    private JButton informe_uno;
    private JButton informe_dos;
    private JButton informe_tres;

    public MenuJFrame(){
        controller = new ReportesController();
        setTitle("Menú");
        setBounds(600, 200, 800, 500);
        getContentPane().setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        informe_uno = new JButton("Informe 1");
        informe_uno.setBounds(200, 50, 400, 100);
        informe_uno.setFont(new Font(informe_uno.getFont().getName(),Font.PLAIN,30));


        informe_dos = new JButton("Informe 2");
        informe_dos.setBounds(200, 180, 400, 100);
        informe_dos.setFont(new Font(informe_uno.getFont().getName(),Font.PLAIN,30));

        informe_tres = new JButton("Informe 3");
        informe_tres.setBounds(200, 310, 400, 100);
        informe_tres.setFont(new Font(informe_uno.getFont().getName(),Font.PLAIN,30));

        informe_uno.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new ReporteJFrame(controller, 1, "Información de lideres");

            }
        });

        informe_dos.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new ReporteJFrame(controller, 2, "Información de proyectos");

            }
        });

        informe_tres.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                new ReporteJFrame(controller, 3, "Información de compra");

            }
        });

        add(informe_uno);
        add(informe_dos);
        add(informe_tres);


        setVisible(true);

    }
}
