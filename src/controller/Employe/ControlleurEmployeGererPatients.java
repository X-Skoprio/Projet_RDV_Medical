package controller.Employe;

import javax.swing.*;

import view.ViewEmployeGererPatients;

import java.sql.SQLException;

import static controller.Employe.ControlleurEmployeCreationPatients.employeCreationPatientView;
import static controller.Employe.ControlleurEmployeCreationPatients.showEmployeCreationPatientWindow;
import static controller.Employe.ControlleurViewEmployeConsulterPatients.showViewEmployeConsulterPatientWindow;


public class ControlleurEmployeGererPatients {
    public static ViewEmployeGererPatients viewEmployeGererPatients;


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


    private static void onConsulterPatientButtonClicked() throws SQLException {
        System.out.println("Consulter nouveau patient Clicked");
        viewEmployeGererPatients.dispose();
        showViewEmployeConsulterPatientWindow();
    }

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
