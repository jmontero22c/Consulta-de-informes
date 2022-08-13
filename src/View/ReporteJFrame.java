package View;

import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import Controller.ReportesController;

public class ReporteJFrame extends JFrame{
    private ReportesController controller;
    private JTable table;
    private DefaultTableModel model;

    public ReporteJFrame(ReportesController controller, int informe, String titulo){
        this.controller = controller;
        setTitle(titulo);
        setBounds(600, 200, 800, 500);
        init(informe);   
        // pack();
        setVisible(true);
    }
    public void init(int informe){
        Object[] columns = {};
        if(informe == 1){ 
            columns = new Object[]{"ID_Lider", "Nombre", "Apellido", "Ciudad"};
        }
        if(informe == 2){
            columns = new Object[]{"ID Proyecto", "Constructora", "N° Habitaciones", "Ciudad"};
        }
        if(informe == 3){
            columns = new Object[]{"ID_Compra", "Constructora", "Banco Vinculado"};
        }
        TableModel m = new DefaultTableModel(new Object[][]{}, columns);
        table = new JTable(m);
        model = (DefaultTableModel) table.getModel();
        table.setFont(new Font(table.getFont().getName(),Font.PLAIN,20));
        table.setRowHeight(30);

        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Verdana", Font.BOLD, 19));
        
        add(table);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);
        if(informe == 1){ 
            addDataInfUno();
        }
        if(informe == 2){
            addDataInfDos();
        }
        if(informe == 3){
            addDataInfTres();
        }
    }
    public void addDataInfUno(){
        ResultSet result = controller.informe_uno();
        try {
            while (result.next()) {
                String id = result.getString("ID_Lider");
                String name = result.getString("Nombre");
                String surname = result.getString("Primer_Apellido");
                String city = result.getString("Ciudad_Residencia");
                model.addRow(new Object[]{id, name, surname, city});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addDataInfDos(){
        ResultSet result = controller.informe_dos();
        try {
            while (result.next()) {
                String id = result.getString("ID_Proyecto");
                String constructora = result.getString("Constructora");
                String numeroHabitaciones = result.getString("Numero_Habitaciones");
                String city = result.getString("Ciudad");
                model.addRow(new Object[]{id, constructora, numeroHabitaciones, city});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addDataInfTres(){
        ResultSet result = controller.informe_tres();
        try {
            while (result.next()) {
                String id = result.getString("ID_Compra");
                String constructora = result.getString("Constructora");
                String bancoVinculado = result.getString("Banco_Vinculado");
                model.addRow(new Object[]{id, constructora, bancoVinculado});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
