package controller.Employe;

import view.*;
import model.*;

import javax.swing.*;
import java.sql.SQLException;

public class ControlleurViewEmployeConsulterMedecins {


    public static ViewEmployeConsulterMedecins viewEmployeConsulterMedecins;


    public ControlleurViewEmployeConsulterMedecins(ViewEmployeConsulterMedecins view) throws SQLException {
        ControlleurViewEmployeConsulterMedecins.viewEmployeConsulterMedecins = view;
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

        viewEmployeConsulterMedecins.addListPatientTable("Liste des Medecins", data, columnNames);
        viewEmployeConsulterMedecins.display();

    }


    public static void showViewEmployeConsulterMedecinWindow() throws SQLException {
        SwingUtilities.invokeLater(() -> {

            ViewEmployeConsulterMedecins view = new ViewEmployeConsulterMedecins();
            try {
                new ControlleurViewEmployeConsulterMedecins(view);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static ViewEmployeConsulterMedecins getViewEmployeConsulterMedecins() {
        return viewEmployeConsulterMedecins;
    }
}
