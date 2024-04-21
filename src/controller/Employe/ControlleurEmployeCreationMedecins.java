package controller.Employe;

import view.ViewEmployeCreationMedecins;
import view.ViewEmployeCreationPatient;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Objects;


import static model.CliniqueImpl.insertMedecin;
import static model.CliniqueImpl.insertPatient;

public class ControlleurEmployeCreationMedecins {
    public static ViewEmployeCreationMedecins viewEmployeCreationMedecins;

    public ControlleurEmployeCreationMedecins(ViewEmployeCreationMedecins viewEmployeCreationMedecins) throws SQLException, ClassNotFoundException {
        this.viewEmployeCreationMedecins = viewEmployeCreationMedecins;
        initListeners();
    }

    private void initListeners() {
        // Bouton de validation de la création d'un nouveau patient
        viewEmployeCreationMedecins.getValidationCreationNouveauPatientButton().addActionListener(e -> {
            try {
                onCreateNewPatient();
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(viewEmployeCreationMedecins, "Erreur lors de la création du medecin : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException(ex);
            }
        });

        // Bouton pour retourner à la page précédente
        viewEmployeCreationMedecins.getRetourPagePrecedenteButton().addActionListener(e -> onReturnPreviousPage());
    }

    private void onCreateNewPatient() throws SQLException, ClassNotFoundException {
        // Ici, insérer la logique pour créer un nouveau patient en base de données
        String nom = viewEmployeCreationMedecins.getNom();
        String prenom = viewEmployeCreationMedecins.getPrenom();
        String email = viewEmployeCreationMedecins.getEmail();
        String specialisation = viewEmployeCreationMedecins.getSpecialisation();

        // Supposons que vous ayez une méthode pour insérer ces données dans la base de données


        if (!Objects.equals(nom, "" ) &&!Objects.equals(prenom, "") && !Objects.equals(email, "") && !Objects.equals(specialisation, "") ) {
            JOptionPane.showMessageDialog(viewEmployeCreationMedecins, "Patient cree avec succes.", "Succès", JOptionPane.INFORMATION_MESSAGE);
            viewEmployeCreationMedecins.dispose(); // Ferme la fenêtre après création
            insertMedecin(nom, prenom, email , specialisation);
        } else {
            JOptionPane.showMessageDialog(viewEmployeCreationMedecins, "Echec de la creation du Medecin.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void onReturnPreviousPage() {
        // Logique pour retourner à la fenêtre précédente
        viewEmployeCreationMedecins.dispose();

    }


    public static void showEmployeCreationMedecinsWindow() {
        SwingUtilities.invokeLater(() -> {
            viewEmployeCreationMedecins = new ViewEmployeCreationMedecins();
            viewEmployeCreationMedecins.setTitle("Creation de Medecin");
            viewEmployeCreationMedecins.pack();
            viewEmployeCreationMedecins.setLocationRelativeTo(null);
            viewEmployeCreationMedecins.setVisible(true);

            try {
                new ControlleurEmployeCreationMedecins(viewEmployeCreationMedecins);
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
