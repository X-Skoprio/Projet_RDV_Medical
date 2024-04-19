package controller.Employe;

import javax.swing.*;

import view.ViewEmployeGererPatients;
import controller.Employe.ControlleurEmployeCreationPatients;

public class ControlleurEmployeGererPatients {
    private static ViewEmployeGererPatients employeGererPatientsView;

    public ControlleurEmployeGererPatients(ViewEmployeGererPatients view) {
        ControlleurEmployeGererPatients.employeGererPatientsView = view;
        initListeners();
    }

    private void initListeners() {
        // Initialize event listeners for the view's components here
        // For example:
        // employeGererPatientsView.getNouveauPatientButton().addActionListener(e -> createNewPatient());
        employeGererPatientsView.getcreationNouveauxPatientButton().addActionListener(e -> creationNouveauxPatientClicked());
    }


    public static void creationNouveauxPatientClicked()
    {
        employeGererPatientsView.dispose();
        //implementer le lancement de gerer patient
    }


    public static void showEmployeGererPatientWindow() {
        SwingUtilities.invokeLater(() -> {
            if (employeGererPatientsView == null) {
                employeGererPatientsView = new ViewEmployeGererPatients(); // Create the window if it doesn't exist
            }
            employeGererPatientsView.setTitle("Gérer Patients Window"); // Set the window title
            employeGererPatientsView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
            employeGererPatientsView.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            employeGererPatientsView.setLocationRelativeTo(null); // Center the window on the screen
            employeGererPatientsView.setVisible(true); // Make the window visible

            // It's assumed that event listeners are set up elsewhere in the controller's constructor or a similar setup method
        });
    }
}
