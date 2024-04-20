package controller.Employe;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.Patient;
import view.ViewEmployeGererPatients;

import java.sql.SQLException;
import java.util.List;

import static controller.Employe.ControlleurEmployeCreationPatients.showEmployeCreationPatientWindow;
import static controller.Employe.ControlleurViewEmployeConsulterPatients.showViewEmployeConsulterPatientWindow;



public class ControlleurEmployeGererPatients {
    private static ViewEmployeGererPatients viewEmployeGererPatients;


    public ControlleurEmployeGererPatients(ViewEmployeGererPatients view) {
        ControlleurEmployeGererPatients.viewEmployeGererPatients = view;
        initListeners();
    }

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


    private static void onCreationNouveauxPatientClicked()
    {
        System.out.println("Creation nouveau patient Clicked");
        showEmployeCreationPatientWindow();
    }
    private static void onConsulterPatientButtonClicked() throws SQLException {
        System.out.println("Consulter nouveau patient Clicked");
        showViewEmployeConsulterPatientWindow();

    }

    public static void disposeViewEmployeConsulterPatientWindow()
    {
        viewEmployeGererPatients.dispose();
    }

    public static void showEmployeGererPatientWindow() {
        SwingUtilities.invokeLater(() -> {
            if (viewEmployeGererPatients == null) {
                viewEmployeGererPatients = new ViewEmployeGererPatients(); // Create the window if it doesn't exist
            }
            viewEmployeGererPatients.setTitle("Gerer Patients Window"); // Set the window title
            viewEmployeGererPatients.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
            viewEmployeGererPatients.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            viewEmployeGererPatients.setLocationRelativeTo(null); // Center the window on the screen
            viewEmployeGererPatients.setVisible(true); // Make the window visible

            initListeners();


        });
    }
}
