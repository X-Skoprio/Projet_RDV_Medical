package controller.ControlleurPatientRDV;

import view.*;
import model.*;

import javax.swing.*;
import java.util.List;

public class RdvController {

    private List<RendezVous> ListRdv;
    private static ViewPatientListeRdv view;


    public RdvController(ViewPatientListeRdv view) {
        this.view = view;

        initView();
    }

    private void initView() {

       String[] columnNames = {"Date Debut", "Date Fin", "Email Patient", "Email Medecin", "Description", "Modifier", "Supprimer"};
        Object[][] data = CliniqueImpl.getRendezVousByEmailPatient(Login.getEmail()).stream().map(rdv -> new Object[] {
                rdv.getDateDebut(),
                rdv.getDateFin(),
                rdv.getEmailPatient(),
                rdv.getEmailMedecin(),
                rdv.getDescription(),
                "modifier",
                "supprimer"
        }).toArray(Object[][]::new);

        view.addRdvTable("Rendez-vous", data, columnNames);
        view.display();
    }

    public static void ShowPatientRdvWindow() {
        SwingUtilities.invokeLater(() -> {
            ViewPatientListeRdv view = new ViewPatientListeRdv();
            new RdvController(view);
        });
    }

    public static ViewPatientListeRdv getViewPatientListeRdv() {
        return view;
    }


}