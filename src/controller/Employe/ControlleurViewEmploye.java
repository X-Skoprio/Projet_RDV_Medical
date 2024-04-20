package controller.Employe;

import model.CliniqueImpl;
import view.ViewEmploye;

import javax.swing.*;
import java.sql.SQLException;

import static controller.Employe.ControlleurEmployeGererPatients.showEmployeGererPatientWindow;
import static controller.Employe.ControlleurViewEmployeGererMedecins.showViewEmployeGererMedecinWindow;

public class ControlleurViewEmploye {
    private ViewEmploye viewEmploye;
    private static CliniqueImpl clinique;

    static {
        try {
            clinique = new CliniqueImpl();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public ControlleurViewEmploye(ViewEmploye viewEmploye) throws SQLException, ClassNotFoundException {
        this.viewEmploye = viewEmploye;
        initListeners();
    }

    private void initListeners() {
        // Add action listeners for the buttons
        viewEmploye.getGererMedecinButton().addActionListener(e -> gererMedecin());
        viewEmploye.getGererPatientButton().addActionListener(e -> gererPatient());
    }

    private void gererMedecin() {
        System.out.println("Gérer Medecin button clicked");
        showViewEmployeGererMedecinWindow();

    }

    private void gererPatient() {
        System.out.println("Gerer Patient button clicked");
        showEmployeGererPatientWindow();
    }

    public static void showEmployeWindow() {
        SwingUtilities.invokeLater(() -> {
            ViewEmploye view = new ViewEmploye();
            view.setTitle("Employe Management Window");
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            view.pack();
            view.setLocationRelativeTo(null);
            view.setVisible(true);
            try {
                new ControlleurViewEmploye(view);
            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error initializing the controller: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
