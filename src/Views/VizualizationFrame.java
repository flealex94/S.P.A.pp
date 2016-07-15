package Views;

import GA.AG;
import Utils.AppUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VizualizationFrame extends JFrame {
    private JPanel rootPanel;
    private JButton inapoiButton;
    private JTable table1;
    private JButton săptămânaAnterioarăButton;
    private JButton săptămânaUrmatoareButton;
    private JButton optimizareButton;
    private int currentWeek = 1;
    private Object[][] data;

    public VizualizationFrame() {
        // add root component
        setContentPane(rootPanel);

        // AppUtils
        AppUtils.setFrameDimension(this);
        AppUtils.centerFrame(this);

        inapoiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                setVisible(false); //you can't see me!
                JFrame nextFrame = new MainFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });

        optimizareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                data = AG.Optimizare();
                setVisible(false); //you can't see me!
                JFrame nextFrame = new VizualizationFrame();
                dispose(); //Destroy the JFrame object
                nextFrame.setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        String[] columnNames = {"",
            "Luni",
            "Marți",
            "Miercuri",
            "Joi",
            "Vineri",
            "Sambătă",
            "Duminică"
        };


        // interval orar, luni, marti, miercuri, joi, vineri, sambata, duminica
        if (AppUtils.getProgramariNecalculate().isEmpty())
            data = new Object[][]{
                {"9-10", "", "", "", "", "", "", ""},
                {"10-11", "", "", "", "", "", "", ""},
                {"11-12", "", "", "", "", "", "", ""},
                {"12-13", "", "", "", "", "", "", ""},
                {"13-14", "", "", "", "", "", "", ""},
                {"14-15", "", "", "", "", "", "", ""},
                {"15-16", "", "", "", "", "", "", ""},
                {"16-17", "", "", "", "", "", "", ""},
                {"17-18", "", "", "", "", "", "", ""},
                {"18-19", "", "", "", "", "", "", ""}
             };
        else
            data = AG.Optimizare();
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };


        table1 = new JTable(model);

        for (String columnName : columnNames) {
            table1.getColumn(columnName).setCellRenderer(new TextAreaRenderer());
        }

        table1.setColumnSelectionAllowed(false);

        table1.setRowSelectionAllowed(true);
        table1.setRowHeight(60);
        table1.getTableHeader().setReorderingAllowed(false);
    }


    public class TextAreaRenderer extends JTextArea
            implements TableCellRenderer {
        JTextArea textarea;

        public TextAreaRenderer() {

        }
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            
            this.setText((String) value);
            this.setCaretPosition(0);
            return this;
        }
    }

}
