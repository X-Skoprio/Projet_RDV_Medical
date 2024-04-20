package controller.ControlleurPatientRDV;

import model.Patient;
import view.ViewEmployeConsulterPatients;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static controller.Employe.ControlleurViewEmployeConsulterPatients.*;
import static model.CliniqueImpl.checkEmailInPatient;
import static model.CliniqueImpl.supprimerPatient;
import static view.ViewEmployeConsulterPatients.getModel;

public class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;
    private JTable table;

    private ViewEmployeConsulterPatients view = getViewEmployeConsulterPatients();

    public ButtonEditor(JCheckBox checkBox, String label) {
        super(checkBox);
        this.label = label;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isPushed = true;
                fireEditingStopped();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.table = table;
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        //label = (value == null) ? "" : value.toString();
        button.setText(label);
        return button;
    }

    public Object getCellEditorValue() {
        if (isPushed) {
            int row = table.convertRowIndexToModel(table.getEditingRow());
            // Déclenche les actions spécifiques basées sur le label du bouton
            if ("Modifier".equals(label)) {
                modifier(row);
            } else if ("Supprimer".equals(label)) {
                supprimer(row);
            }
            else if ("Supprimer Patient".equals(label)) {
                try {
                    supprimerPatientButton(row);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            else if("Voir RDV".equals(label))
            {
                try {
                    voirRDV(row);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        isPushed = false;
        return label;
    }

    private void modifier(int row) {
        System.out.println("Modifier Action at row: " + row);
        // Code pour la modification
    }

    private void supprimer(int row) {
        System.out.println("Supprimer Action at row: " + row);
        // Code pour la suppression
    }

    private void supprimerPatientButton(int row) throws SQLException {


        System.out.println("Supprimer Action at row: " + row);
        System.out.println("Le button voir rdv a été cliqué sur la ligne : " + row);


        //récupére la case email du row correspodnant au button cliqué
        Object emailData = (table.getModel().getValueAt(row, 3));
        String emailString = null;

        if (emailData instanceof String) {
            emailString = (String) emailData;
            System.out.println("l'email est " + emailString);
        } else {
            System.out.println("La data dans la colonne email est pas du bon type" + "null");
        }
        if(emailString == null && !checkEmailInPatient(emailString))
        {
            throw new IllegalArgumentException("L'email ne peut etre null et doit exister dans la base de donnee");
        }
        else
        {
            supprimerPatient(emailString);
            view.removeRow(getModel(), row);
            System.out.println("le patient avec le mail : " + emailString + "a ete suprrime avec succes ! ");
        }


    }

    private void voirRDV(int row) throws SQLException {

    }
}
