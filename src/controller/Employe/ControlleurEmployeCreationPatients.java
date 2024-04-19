package controller.Employe;

import view.ViewEmployeCreationPatients;
import javax.swing.*;

public class ControlleurEmployeCreationPatients {
    private ViewEmployeCreationPatients view;

    public ControlleurEmployeCreationPatients(ViewEmployeCreationPatients view) {
        this.view = view;
        initListeners();
    }

    private void initListeners() {
        view.getBoutonSoumettre().addActionListener(e -> submitPatientForm());
        view.getBoutonAnnuler().addActionListener(e -> cancelPatientForm());
    }


    public static void showEmployeGererPatientWindow() {
        SwingUtilities.invokeLater(() -> {
            ViewEmployeCreationPatients view = new ViewEmployeCreationPatients();
            new ControlleurEmployeCreationPatients(view);  // Connect the view with the controller
            view.setVisible(true);  // Make sure the view is visible
        });
    }


    private void submitPatientForm() {
        // Implement the logic to handle form submission
        System.out.println("Form submitted");
        // Possibly gather the data from the form fields and process them
    }

    private void cancelPatientForm() {
        // Handle the cancelation logic
        System.out.println("Form cancellation");
        view.dispose();  // Close the window
    }
}
