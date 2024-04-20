package controller.ControlleurPatientRDV;

import model.CliniqueImpl;
import model.RendezVous;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;


public class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;
    private JTable table;

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
        }
        isPushed = false;
        return label;
    }

    private void modifier(int row) {
        System.out.println("Modifier Action at row: " + row);
        // Code pour la modification
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
            System.out.println("le rdv du : " + dateDebut + " a ete suprrime avec succes ! ");
        }
    }
}
