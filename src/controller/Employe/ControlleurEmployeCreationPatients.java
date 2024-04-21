package controller.Employe;

import view.ViewEmployeCreationPatient;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Objects;

import static controller.Employe.ControlleurEmployeGererPatients.showEmployeGererPatientWindow;
import static controller.Employe.ControlleurEmployeGererPatients.viewEmployeGererPatients;
import static model.CliniqueImpl.insertPatient;

/**
 * Classe qui va créer de nouveaux patient en étant un employe.
 * Va gerer les action listener et le renvoie vers l'affichage graphique.
 */
public class ControlleurEmployeCreationPatients {
    public static ViewEmployeCreationPatient employeCreationPatientView;

    /**
     * COnstructeur de la classe
     * @param employeCreationPatientView la vue creation patient.
     * @throws SQLException en cas d'erreur SQL
     * @throws ClassNotFoundException si la classe est introuvable.
     */
    public ControlleurEmployeCreationPatients(ViewEmployeCreationPatient employeCreationPatientView) throws SQLException, ClassNotFoundException {
        this.employeCreationPatientView = employeCreationPatientView;
        initListeners();
    }

    /**
     * Initialise les action listener qui gere les boutons.
     */
    private void initListeners() {
        // Bouton de validation de la création d'un nouveau patient
        employeCreationPatientView.getValidationCreationNouveauPatientButton().addActionListener(e -> {
            try {
                onCreateNewPatient();
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(employeCreationPatientView, "Erreur lors de la création du patient : " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException(ex);
            }
        });

        // Bouton pour retourner à la page précédente
        employeCreationPatientView.getRetourPagePrecedenteButton().addActionListener(e -> onReturnPreviousPage());
    }

    /**
     * Créer un nouveau patient qui va être envoyé vers la base de donnée.
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    private void onCreateNewPatient() throws SQLException, ClassNotFoundException {
        // Ici, insérer la logique pour créer un nouveau patient en base de données
        int age;
        String nom = employeCreationPatientView.getNom();
        String prenom = employeCreationPatientView.getPrenom();
        try
        {
            age = Integer.parseInt(employeCreationPatientView.getAge());

        }
        catch (NumberFormatException e)
        {
            System.out.println("Age n'est pas un int");
            throw e;
        }
        String email = employeCreationPatientView.getEmail();
        String password = employeCreationPatientView.getPassword();
        String details = employeCreationPatientView.getDetails();

        // Supposons que vous ayez une méthode pour insérer ces données dans la base de données
         insertPatient(nom, prenom, age, email, password, details);

        if (!Objects.equals(nom,"") && !Objects.equals(prenom,"") && !Objects.equals(email,"") &&!Objects.equals(password,"")  && age >= 0) {
            JOptionPane.showMessageDialog(employeCreationPatientView, "Patient cree avec succes.", "Succès", JOptionPane.INFORMATION_MESSAGE);
            employeCreationPatientView.dispose(); // Ferme la fenêtre après création
        } else {
            JOptionPane.showMessageDialog(employeCreationPatientView, "Echec de la creation du patient.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Retour à la page précédente.
     */
    private void onReturnPreviousPage() {
        // Logique pour retourner à la fenêtre précédente

        employeCreationPatientView.dispose();
        viewEmployeGererPatients.setVisible(true);
    }

    /**
     * Affichage de la fenètre création patient.
     */
    public static void showEmployeCreationPatientWindow() {
        SwingUtilities.invokeLater(() -> {
            employeCreationPatientView = new ViewEmployeCreationPatient(); // Create the patient creation window
            employeCreationPatientView.setTitle("Creation de Patient"); // Set the window title
            employeCreationPatientView.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            employeCreationPatientView.setLocationRelativeTo(null); // Center the window on the screen
            employeCreationPatientView.setVisible(true); // Make the window visible

            try {
                new ControlleurEmployeCreationPatients(employeCreationPatientView); // Bind the controller to the view
            } catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
