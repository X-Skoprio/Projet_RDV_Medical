package controller.Employe;

import model.CliniqueImpl;
import view.ViewEmploye;

import javax.swing.*;
import java.sql.SQLException;

import static controller.Employe.ControlleurEmployeGererMedecins.viewEmployeGererMedecinsMenu;
import static controller.Employe.ControlleurEmployeGererPatients.showEmployeGererPatientWindow;
import static controller.Employe.ControlleurEmployeGererPatients.viewEmployeGererPatients;
import static controller.Employe.ControlleurViewEmployeGererMedecins.showViewEmployeGererMedecinWindow;

/**
 * Classe qui concerner l'Employe et qui va permettre de faire un choix entre medecin et patient.
 * Le choix se fait grâce  à des boutons et donc des action listeners.
 */
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

    /**
     * Constructeur de la vue employe.
     * @param viewEmploye View que l'on va afficher à l'écran.
     * @throws SQLException Si la BDD ne fonctionne pas
     * @throws ClassNotFoundException si la classe est introuvable.
     */
    public ControlleurViewEmploye(ViewEmploye viewEmploye) throws SQLException, ClassNotFoundException {
        this.viewEmploye = viewEmploye;
        initListeners();
    }

    /**
     * Initialisation des actions Listeners qui fonctionne avec les boutons.
     */
    private void initListeners() {
        // Add action listeners for the buttons
        viewEmploye.getGererMedecinButton().addActionListener(e -> gererMedecin());
        viewEmploye.getGererPatientButton().addActionListener(e -> gererPatient());
    }

    /**
     * Affichage sur l'écran de la fenètre qui s'occupe des Medecins.
     */
    private void gererMedecin() {
        System.out.println("Gérer Medecin button clicked");
        if(viewEmployeGererMedecinsMenu == null)
        {
            showViewEmployeGererMedecinWindow();
        }
        else
        {
            viewEmployeGererMedecinsMenu.setVisible(true);
        }
    }
    /**
     * Affichage sur l'écran de la fenètre qui s'occupe des Patients.
     */
    private void gererPatient() {
        System.out.println("Gerer Patient button clicked");
        if(viewEmployeGererPatients == null)
        {
            showEmployeGererPatientWindow();
        }
        else
        {
            viewEmployeGererPatients.setVisible(true);
        }
    }

    /**
     * Affichage à l'écran de la fenètre Employe où l'user va pouvoir faire un choix.
     */
    public static void showEmployeWindow() {
        SwingUtilities.invokeLater(() -> {
            ViewEmploye view = new ViewEmploye();
            view.setTitle("Fenetre Employe ");
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
