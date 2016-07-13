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

/**
 * Created by teodor on 01.07.2016.
 */
public class VizualizationFrame extends JFrame {
    private JPanel rootPanel;
    private JButton inapoiButton;
    private JTable table1;
    private JButton saptamanaAnterioaraButton;
    private JButton saptamanaUrmatoareButton;
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
            "Marti",
            "Miercuri",
            "Joi",
            "Vineri",
            "Sambata",
            "Duminica"
        };

        // interval orar, luni, marti, miercuri, joi, vineri, sambata, duminica
        Object[][] data = {
                {"9-10", "Alex + \nTeodor = \nLove", "", "", "", "", "", ""},
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
