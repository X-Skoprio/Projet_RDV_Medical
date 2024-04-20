package controller.ControlleurPatientRDV;

import model.CliniqueImpl;
import model.Patient;
import model.RendezVous;
import view.ViewEmployeConsulterPatients;
import view.ViewPatientListeRdv;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static controller.ControlleurPatientRDV.RdvController.getViewPatientListeRdv;
import static controller.Employe.ControlleurViewEmployeConsulterPatients.*;
import static model.CliniqueImpl.checkEmailInPatient;
import static model.CliniqueImpl.supprimerPatient;
import static view.ViewEmployeConsulterPatients.getModel;
import static view.ViewPatientListeRdv.getModelListeRdv;


public class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;
    private JTable table;

    private ViewEmployeConsulterPatients viewEmployeConsulterPatient = getViewEmployeConsulterPatients();
    private ViewPatientListeRdv viewPatientListeRdv = getViewPatientListeRdv();
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
        String currentDescription = (String) table.getModel().getValueAt(row, 4);
        String newDescription = JOptionPane.showInputDialog(table, "Modifier la description:", currentDescription);

        if (newDescription != null && !newDescription.equals(currentDescription)) {
            try {
                // Prend des donnees des colonnes necessaires pour la modification dans la bdd
                LocalDateTime dateDebut = (LocalDateTime) table.getModel().getValueAt(row, 0);
                String emailMedecin = (String) table.getModel().getValueAt(row, 3);

                CliniqueImpl.updateRdvDescription(dateDebut, emailMedecin, newDescription);

                // Update and refresh the table row
                updateAndRefreshRow(row, newDescription);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(table, "Error updating RDV: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    private void updateAndRefreshRow(int row, String description) {
        // Assuming you have access to the table model and it's a DefaultTableModel
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.setValueAt(description, row, 4);

        // notifier la table que la valeur de la ligne a changé
        model.fireTableRowsUpdated(row, row);
    }

    private void supprimer(int row) {
        // Assuming dateDebut is stored as LocalDateTime and is in the first column (index 0)
        Object dateDebutObject = table.getValueAt(row, 0);
        LocalDateTime dateDebut = null;
        if (dateDebutObject instanceof LocalDateTime) {
            dateDebut = (LocalDateTime) dateDebutObject;
        } else {
            // Handle the case where dateDebut is not a LocalDateTime
            System.out.println("DateDebut is not an instance of LocalDateTime");
        }

// Assuming emailMedecin is a String and is in the fourth column (index 3)
        Object emailMedecinObject = table.getValueAt(row, 3);
        String emailMedecin = null;
        if (emailMedecinObject instanceof String) {
            emailMedecin = (String) emailMedecinObject;
        } else {
            // Handle the case where emailMedecin is not a String
            System.out.println("EmailMedecin is not an instance of String");
        }

        if(emailMedecin == null && dateDebut == null)
        {
            throw new IllegalArgumentException("Le rdv doit exister dans la base de donnee");
        }
        else
        {
            CliniqueImpl.SupprimerRdv(dateDebut, emailMedecin);
            viewPatientListeRdv.removeRow(getModelListeRdv(), row);
            System.out.println("le rdv du : " + dateDebut + " a ete suprrime avec succes ! ");
        }
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
            viewEmployeConsulterPatient.removeRow(getModel(), row);
            System.out.println("le patient avec le mail : " + emailString + "a ete suprrime avec succes ! ");
        }


    }

    private void voirRDV(int row) throws SQLException {

    }
}
