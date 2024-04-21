package controller.Employe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Patient;
import view.ViewEmployeConsulterPatients;
import view.ViewEmployeGererPatients;

import java.sql.SQLException;
import java.util.List;

import static controller.Employe.ControlleurEmployeCreationPatients.employeCreationPatientView;
import static controller.Employe.ControlleurEmployeCreationPatients.showEmployeCreationPatientWindow;
import static controller.Employe.ControlleurViewEmployeConsulterPatients.showViewEmployeConsulterPatientWindow;
import static controller.Employe.ControlleurViewEmployeConsulterPatients.*;

/**
 * Classe qui va nous permettre de choisir entre créer un nouveau patient ou en consulter un ancien patient
 */
public class ControlleurEmployeGererPatients {
    public static ViewEmployeGererPatients viewEmployeGererPatients;

    /**
     * Constructeur de la classe EmployeGererPatient.
     * @param view
     */
    public ControlleurEmployeGererPatients(ViewEmployeGererPatients view) {
        ControlleurEmployeGererPatients.viewEmployeGererPatients = view;
        initListeners();
    }

    /**
     * Initialisation des actions listeners.
     */
    private static void initListeners() {

        viewEmployeGererPatients.getCreationNouveauxPatientButton().addActionListener(e -> onCreationNouveauxPatientClicked());
        viewEmployeGererPatients.getConsulterLesPatientsButton().addActionListener(e -> {
            try {
                onConsulterPatientButtonClicked();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    /**
     * Contrôle du bouton de la creation du nouveau patient.
     * Efface également l'écran pour afficher une nouvelle fenètre.
     */
    private static void onCreationNouveauxPatientClicked()
    {
        System.out.println("Creation nouveau patient Clicked");
        viewEmployeGererPatients.dispose();

        if(employeCreationPatientView== null)
        {
            showEmployeCreationPatientWindow();
        }
        else
        {
            employeCreationPatientView.setVisible(true);
        }
    }

    /**
     * Contrôle du bouton de la consulation de l'ancien patient.
     * Efface également l'écran pour afficher une nouvelle fenètre.
     */
    private static void onConsulterPatientButtonClicked() throws SQLException {
        System.out.println("Consulter nouveau patient Clicked");
        viewEmployeGererPatients.dispose();
            showViewEmployeConsulterPatientWindow();
    }
    /**
     * Gere l'affichage graphique de la fenetre GererMedecin.
     */
    public static void showEmployeGererPatientWindow() {
        SwingUtilities.invokeLater(() -> {
            if (viewEmployeGererPatients == null) {
                viewEmployeGererPatients = new ViewEmployeGererPatients(); // Create the window if it doesn't exist
            }
            viewEmployeGererPatients.setTitle("Gerer Patients Window"); // Set the window title
            viewEmployeGererPatients.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            viewEmployeGererPatients.setLocationRelativeTo(null); // Center the window on the screen
            viewEmployeGererPatients.setVisible(true); // Make the window visible

            initListeners();


        });
    }
}
