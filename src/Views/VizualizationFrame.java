package Views;

import Utils.AppUtils;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;


public class VizualizationFrame extends JFrame {
    private JPanel rootPanel;
    private JButton inapoiButton;
    private JTable table1;
    private JButton săptămânaAnterioarăButton;
    private JButton săptămânaUrmatoareButton;
    private JButton reoptimizareButton;
    private int currentWeek = 1;


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
        Object[][] data = {
                {"9-10", "Client 1 + \nTerapeut 1 = \nTerapie 1", "", "", "Grigore Costache + \nAlex Georgescu = \nMasaj de relaxare", "", "", ""},
                {"10-11", "Client 1 + \nTerapeut 2 = \nTerapie 3", "", "", "", "", "", ""},
                {"11-12", "", "", "", "", "", "", ""},
                {"12-13", "", "Grigore Costache + \nAlex Georgescu = \nMasaj de relaxare", "", "", "", "", ""},
                {"13-14", "", "", "", "", "", "", ""},
                {"14-15", "", "Grigore Costache + \nAlex Georgescu = \nMasaj de relaxare", "", "", "", "", "Client 1 + \nTerapeut 2 = \nTerapie 3"},
                {"15-16", "", "", "", "Grigore Costache + \nValentin Ionescu = \nMasaj reflexogen", "", "", "Client 1 + \nTerapeut 2 = \nTerapie 3"},
                {"16-17", "", "", "", "Grigore Costache + \nValentin Ionescu = \nMasaj reflexogen", "", "", "Client 1 + \nTerapeut 2 = \nTerapie 3"},
                {"17-18", "", "Grigore Costache + \nAlex Georgescu = \nMasaj de relaxare", "", "", "", "", ""},
                {"18-19", "", "Grigore Costache + \nValentin Ionescu = \nMasaj reflexogen", "", "", "", "", ""}
        };

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
