package controller;

import model.Patient;

import view.ViewPatientRDV;


public class ControlleurPatientRDV {
    private ViewPatientRDV view;
    private Patient patient;

    public ControlleurPatientRDV(ViewPatientRDV view, Patient patient) {
        this.view = view;
        this.patient = patient;
        initView();
    }
    private void initView() {
        String[] columnNames = {"Date Debut", "Date Fin", "Email Patient", "Email Medecin", "Description"};
        Object[][] data = patient.getListRendezVous().stream().map(rdv -> new Object[] {
                rdv.getDateDebut(), rdv.getDateFin(), rdv.getEmailPatient(), rdv.getEmailMedecin(), rdv.getDescription()
        }).toArray(Object[][]::new);

        view.addRdvTable("Rendez-vous", data, columnNames);
        view.display();
    }



    /*
    private void initListeners() {
        for (RendezVous rdv : patient.getListRendezVous()) {
            String nomBoutton = String.valueOf(rdv.getDateDebut()) + " "+ String.valueOf(rdv.getDateDebut());
            JButton rdvButton = new JButton(nomBoutton);
            rdvButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    showRdvDetails(rdv);
                }
            });
            view.addRdvButton(rdvButton);
        }
        view.display();
    }

    private void showRdvDetails(RendezVous rdv) {
        JOptionPane.showMessageDialog(null,
                "Date: " + rdv.getDateDebut() + " " + rdv.getDateFin() + "\nDescription: " + rdv.getDescription(),
                "Détails du RDV",
                JOptionPane.INFORMATION_MESSAGE);
    }

     */
}
