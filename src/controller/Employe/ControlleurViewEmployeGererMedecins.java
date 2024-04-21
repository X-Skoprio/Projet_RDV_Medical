package controller.Employe;

import view.*;
import model.*;

import javax.swing.*;
import java.sql.SQLException;

public class ControlleurViewEmployeGererMedecins {


    public static ViewEmployeGererMedecins viewEmployeGererMedecins;


    public ControlleurViewEmployeGererMedecins(ViewEmployeGererMedecins view) throws SQLException {
        ControlleurViewEmployeGererMedecins.viewEmployeGererMedecins = view;
        iniViewEmployeConsulterMedecins();
    }

    public static void iniViewEmployeConsulterMedecins() throws SQLException {

        //a refaire adapter sans l'objet patient
        String[] columnNames = {"Nom", "Prenom", "Email", "Specialisation", "Voir RDV Medecin", "Supprimer Medecin"};
        Object[][] data = CliniqueImpl.getAllMedecin().stream().map(Medecin -> new Object[] {
                Medecin.getNom(),
                Medecin.getPrenom(),
                Medecin.getEmail(),
                Medecin.getSpecialisation(),
                "Voir RDV Medecin",
                "Supprimer Medecin"
        }).toArray(Object[][]::new);

        viewEmployeGererMedecins.addListPatientTable("Liste des Medecins", data, columnNames);
        viewEmployeGererMedecins.display();

    }


    public static void showViewEmployeGererMedecinWindow() throws SQLException {
        SwingUtilities.invokeLater(() -> {

            ViewEmployeGererMedecins view = new ViewEmployeGererMedecins();
            try {
                new ControlleurViewEmployeGererMedecins(view);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static ViewEmployeGererMedecins getViewEmployeGererMedecins() {
        return viewEmployeGererMedecins;
    }
}
