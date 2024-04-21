package controller.ControlleurPatientRDV;

import model.CliniqueImpl;
import model.Patient;
import model.RendezVous;
import view.ViewEmployeConsulterPatients;
import view.ViewPatientListeRdv;
import view.ViewEmployeGererMedecins;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static controller.ControlleurPatientRDV.RdvController.ShowPatientRdvWindow;
import static controller.ControlleurPatientRDV.RdvController.getViewPatientListeRdv;
import static controller.Employe.ControlleurViewEmployeConsulterPatients.*;
import static controller.Employe.ControlleurViewEmployeGererMedecins.getViewEmployeGererMedecins;
import static model.CliniqueImpl.*;
import static view.ViewEmployeConsulterPatients.getModel;
import static view.ViewPatientListeRdv.getModelListeRdv;
import static view.ViewEmployeGererMedecins.getModelMedecin;
import static model.CliniqueImpl.checkEmailInPatient;
import static model.CliniqueImpl.supprimerPatient;

/**
 * La classe va nous permettre d'éditer les cellules selon nos besoins dans un tableau.
 * Elle va égalemenet editer les boutons.
 * C'est la classe Mère du controles des boutons des tableaux.
 */
public class ButtonEditor extends DefaultCellEditor {
    protected JButton button;
    private String label;
    private boolean isPushed;
    private JTable table;

    private ViewEmployeConsulterPatients viewEmployeConsulterPatient = getViewEmployeConsulterPatients();
    private ViewEmployeGererMedecins viewEmployeGererMedecins = getViewEmployeGererMedecins();

    private ViewPatientListeRdv viewPatientListeRdv = getViewPatientListeRdv();

    /**
     * Constructeur de la classe
     * Initialise l'éditeur de cellule personnalisé pour les boutons.
     *
     * @param checkBox Le composant de case à cocher utilisé pour initialiser l'éditeur.
     * @param label    Le texte affiché sur le bouton.
     */
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
    /**
     * Renvoie le composant d'édition de cellule pour la cellule donnée.
     *
     * @param table       La table à éditer.
     * @param value       La valeur de la cellule.
     * @param isSelected  Indique si la cellule est sélectionnée.
     * @param row         L'indice de la ligne de la cellule.
     * @param column      L'indice de la colonne de la cellule.
     * @return            Le composant d'édition de cellule pour la cellule donnée.
     */
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

    /**
     * Retourne la valeur de la cellule édité du tableau
     * @return la valeur de la cellule
     */
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
            else if ("Supprimer Medecin".equals(label)) {
                try {
                    supprimerMedecintButton(row);
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
            else if("Voir RDV Medecin".equals(label))
            {
                try {
                    voirRDVMedecin(row);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        isPushed = false;
        return label;
    }

    /**
     * Implémente la logique de modification pour un RDV
     *
     * @param row L'indice de la ligne à modifier.
     */
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
                JOptionPane.showMessageDialog(table, "Erreur MAJ RDV: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }

    /**
     * Permet d'actualiser le tableau après avoir fait différent changement
     * Permet aussi de modifier la ligne que l'on désire.
     * @param row  la ligne spécifié du tableau
     * @param description  texte qui va êre envoyé dans le tableau.
     */
    private void updateAndRefreshRow(int row, String description) {
        // Avec l'acces au modele table en DefaultTableModel
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.setValueAt(description, row, 4);

        // notifier la table que la valeur de la ligne a changé
        model.fireTableRowsUpdated(row, row);
    }
    /**
     * Va supprimer une ligne en fonction de l'indice qui va être envoyé.
     *
     * @param row L'indice de la ligne à modifier.
     */
    private void supprimer(int row) {
        // Avec dateDebut stocke en LocalDateTime dans la colonne 1 (index 0)
        Object dateDebutObject = table.getValueAt(row, 0);
        LocalDateTime dateDebut = null;
        if (dateDebutObject instanceof LocalDateTime) {
            dateDebut = (LocalDateTime) dateDebutObject;
        } else {
            // Gestion exception pas une LocalDateTime
            System.out.println("DateDebut n'est pas une instance de LocalDateTime");
        }

        // Avec emailMedecin un String dans la colonne 4 (index 3)
        Object emailMedecinObject = table.getValueAt(row, 3);
        String emailMedecin = null;
        if (emailMedecinObject instanceof String) {
            emailMedecin = (String) emailMedecinObject;
        } else {
            // Handle the case where emailMedecin is not a String
            System.out.println("EmailMedecin n'est pas une instance de String");
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
    /**
     * Suppression d'un patient pour la ligne spécifiée.
     *
     * @param row L'indice du patient à supprimer.
     * @throws SQLException En cas d'erreur pour accéder à la base de données.
     */
    private void supprimerPatientButton(int row) throws SQLException {

        System.out.println("Le button suppriemr patient a été cliqué sur la ligne: " + row);

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

    /**
     * Voir le RDV d'un patient à partir du tableay.
     *
     * @param row L'indice du patient auquel on veut accéder.
     * @throws SQLException En cas d'erreur pour accéder à la base de données.
     */
    private void voirRDV(int row) throws SQLException {

        System.out.println("Le button voir rdv patient a été cliqué sur la ligne: " + row);

        //récupére la case email du row correspodnant au button cliqué
        Object emailData = (table.getModel().getValueAt(row, 4));
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

            ShowPatientRdvWindow(emailString);
            System.out.println("Voir les rendez vous du patient avec le mail : " + emailString );
        }

    }
    /**
     * Voir des rendez-vous du médecin pour la ligne spécifiée.
     *
     * @param row L'indice de la ligne du médecin dont les rendez-vous doivent être vu.
     * @throws SQLException En cas d'erreur pour accéder à la base de données.
     */
    private void voirRDVMedecin(int row) throws SQLException {

        System.out.println("Le button voir rdv Medecin a été cliqué sur la ligne: " + row);

        //récupére la case email du row correspodnant au button cliqué
        Object emailData = (table.getModel().getValueAt(row, 2));
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

            ShowPatientRdvWindow(emailString, "");

            System.out.println("Voir les rendez vous du medecin avec le mail : " + emailString );
        }

    }

    /**
     * Suppression n d'un médecin pour la ligne spécifiée.
     *
     * @param row L'indice de la ligne correspondant au médecin à supprimer.
     * @throws SQLException Si une erreur survient lors de l'accès à la base de données.
     */
    private void supprimerMedecintButton(int row) throws SQLException {


        System.out.println("Supprimer Action at row: " + row);

        //récupére la case email du row correspodnant au button cliqué
        Object emailData = (table.getModel().getValueAt(row, 2));
        String emailString = null;

        if (emailData instanceof String) {
            emailString = (String) emailData;
            System.out.println("l'email est " + emailString);
        } else {
            System.out.println("La data dans la colonne email est pas du bon type" + "null");
        }
        if(emailString == null && !checkEmailInMedecin(emailString))
        {
            throw new IllegalArgumentException("L'email ne peut etre null et doit exister dans la base de donnee");
        }
        else
        {
            supprimerMedecin(emailString);
            viewEmployeGererMedecins.removeRow(getModelMedecin(), row);
            System.out.println("le patient avec le mail : " + emailString + "a ete suprrime avec succes ! ");
        }


    }

}
