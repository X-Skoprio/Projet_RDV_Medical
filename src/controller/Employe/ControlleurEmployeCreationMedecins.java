package controller.Employe;

import view.ViewEmployeCreationMedecins;
import view.ViewEmployeCreationPatient;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Objects;

import static controller.Employe.ControlleurEmployeGererPatients.showEmployeGererPatientWindow;
import static model.CliniqueImpl.insertMedecin;
import static model.CliniqueImpl.insertPatient;

/**
 * Classe controlleur qui va permettre de creer de nouveaux medecins par un employe
 */
public class ControlleurEmployeCreationMedecins {
    private static ViewEmployeCreationMedecins viewEmployeCreationMedecins;

    /**
     * Constructeur de la classe
     * @param viewEmployeCreationMedecins La vue de création de médecins.
     * @throws SQLException En cas d'erreur SQL.
     * @throws ClassNotFoundException Si la classe demandée est introuvable.
     */
    public ControlleurEmployeCreationMedecins(ViewEmployeCreationMedecins viewEmployeCreationMedecins) throws SQLException, ClassNotFoundException {
        this.viewEmployeCreationMedecins = viewEmployeCreationMedecins;
        initListeners();
    }

    /**
     * Initialise les action listeners que l'on va utiliser
     */
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

    /**
     * Methode pour nous permettre de créer un nouveau patient par un employe
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * Affichage du retour à la page précédente.
     */
    private void onReturnPreviousPage() {
        // Logique pour retourner à la fenêtre précédente
        viewEmployeCreationMedecins.dispose();

        showEmployeGererPatientWindow();
    }

    /**
     * Affichage de la fenètre de création du medecin.
     */
    public static void showEmployeCreationMedecinsWindow() {
        SwingUtilities.invokeLater(() -> {
            viewEmployeCreationMedecins = new ViewEmployeCreationMedecins(); // Create the patient creation window
            viewEmployeCreationMedecins.setTitle("Creation de Patient"); // Set the window title
            viewEmployeCreationMedecins.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
            viewEmployeCreationMedecins.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            viewEmployeCreationMedecins.setLocationRelativeTo(null); // Center the window on the screen
            viewEmployeCreationMedecins.setVisible(true); // Make the window visible

            try {
                new ControlleurEmployeCreationMedecins(viewEmployeCreationMedecins); // Bind the controller to the view
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
