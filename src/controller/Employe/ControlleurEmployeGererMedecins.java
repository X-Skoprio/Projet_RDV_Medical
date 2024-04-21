package controller.Employe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Patient;
import view.ViewEmployeGererMedecinsMenu;
import view.ViewEmployeGererPatients;

import java.sql.SQLException;
import java.util.List;

import static controller.Employe.ControlleurEmployeCreationMedecins.showEmployeCreationMedecinsWindow;
import static controller.Employe.ControlleurEmployeCreationPatients.showEmployeCreationPatientWindow;
import static controller.Employe.ControlleurViewEmployeConsulterPatients.showViewEmployeConsulterPatientWindow;
import static controller.Employe.ControlleurViewEmployeGererMedecins.showViewEmployeGererMedecinWindow;


public class ControlleurEmployeGererMedecins {
    private static ViewEmployeGererMedecinsMenu viewEmployeGererMedecinsMenu;


    public ControlleurEmployeGererMedecins(ViewEmployeGererMedecinsMenu view) {
        ControlleurEmployeGererMedecins.viewEmployeGererMedecinsMenu = view;
        initListeners();
    }

    private static void initListeners() {

        viewEmployeGererMedecinsMenu.getCreationNouveauxMedecinsButton().addActionListener(e -> onCreationNouveauxMedecinsClicked());
        viewEmployeGererMedecinsMenu.getConsulterLesMedecinsButton().addActionListener(e -> {
            try {
                onConsulterPatientButtonClicked();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


    private static void onCreationNouveauxMedecinsClicked()
    {
        System.out.println("Creation nouveau Medecin Clicked");
        showEmployeCreationMedecinsWindow();
    }
    private static void onConsulterPatientButtonClicked() throws SQLException {
        System.out.println("Consulter nouveau Medecin Clicked");
        showViewEmployeGererMedecinWindow();

    }

    public static void disposeViewEmployeConsulterPatientWindow()
    {
        viewEmployeGererMedecinsMenu.dispose();
    }

    public static void showEmployeGererMedecinsWindow() {
        SwingUtilities.invokeLater(() -> {
            if (viewEmployeGererMedecinsMenu == null) {
                viewEmployeGererMedecinsMenu = new ViewEmployeGererMedecinsMenu(); // Create the window if it doesn't exist
            }
            viewEmployeGererMedecinsMenu.setTitle("Gerer Medecin Window"); // Set the window title
            viewEmployeGererMedecinsMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
            viewEmployeGererMedecinsMenu.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            viewEmployeGererMedecinsMenu.setLocationRelativeTo(null); // Center the window on the screen
            viewEmployeGererMedecinsMenu.setVisible(true); // Make the window visible

            initListeners();


        });
    }
}
