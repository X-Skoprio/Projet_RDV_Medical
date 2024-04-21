package controller.Employe;

import javax.swing.*;
import view.ViewEmployeGererMedecinsMenu;
import java.sql.SQLException;

import static controller.Employe.ControlleurEmployeCreationMedecins.showEmployeCreationMedecinsWindow;
import static controller.Employe.ControlleurEmployeCreationMedecins.viewEmployeCreationMedecins;
import static controller.Employe.ControlleurViewEmployeGererMedecins.showViewEmployeGererMedecinWindow;


public class ControlleurViewEmployeGererMedecinsMenu {
    public static ViewEmployeGererMedecinsMenu viewEmployeGererMedecinsMenu;


    public ControlleurViewEmployeGererMedecinsMenu(ViewEmployeGererMedecinsMenu view) {
        ControlleurViewEmployeGererMedecinsMenu.viewEmployeGererMedecinsMenu = view;
        initListeners();
    }

    private static void initListeners() {

        viewEmployeGererMedecinsMenu.getCreationNouveauxMedecinsButton().addActionListener(e -> onCreationNouveauxMedecinsClicked());
        viewEmployeGererMedecinsMenu.getConsulterLesMedecinsButton().addActionListener(e -> {
            try {
                onConsulterMedecinsButtonClicked();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


    private static void onCreationNouveauxMedecinsClicked()
    {
        System.out.println("Creation nouveau medecin Clicked");
        viewEmployeGererMedecinsMenu.dispose();

        if(viewEmployeCreationMedecins == null)
        {
            showEmployeCreationMedecinsWindow();
        }
        else
        {
            viewEmployeCreationMedecins.setVisible(true);
        }
    }


    private static void onConsulterMedecinsButtonClicked() throws SQLException {
        System.out.println("Consulter nouveau medecin Clicked");
        viewEmployeGererMedecinsMenu.dispose();
        showViewEmployeGererMedecinWindow();
    }

    public static void showEmployeGererMedecinWindow() {
        SwingUtilities.invokeLater(() -> {
            if (viewEmployeGererMedecinsMenu == null) {
                viewEmployeGererMedecinsMenu = new ViewEmployeGererMedecinsMenu(); // Create the window if it doesn't exist
            }
            viewEmployeGererMedecinsMenu.setTitle("Gerer Medecins Menu"); // Set the window title
            viewEmployeGererMedecinsMenu.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            viewEmployeGererMedecinsMenu.setLocationRelativeTo(null); // Center the window on the screen
            viewEmployeGererMedecinsMenu.setVisible(true); // Make the window visible

            initListeners();
        });
    }
}
