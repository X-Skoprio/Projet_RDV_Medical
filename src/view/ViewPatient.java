package view;

import model.*;

import javax.swing.*;
import java.awt.*;

public class ViewPatient extends JFrame{

    private JButton prendreRDVButton;
    private JButton  consultRDVButton;

    public ViewPatient() {


        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;
        gbc.insets = new Insets(5, 10, 10, 10);

        JLabel titre = new JLabel("DOCTOUBIB Menu Patient");
        titre.setFont(new Font("Serif", Font.BOLD, 24));
        gbc.weighty = 0.1;
        this.add(titre, gbc);

        JTextArea profilPatient = new JTextArea();
        displayPatientInfo(profilPatient);
        titre.setFont(new Font("Serif", Font.BOLD, 20));
        gbc.weighty = 0.1;
        this.add(titre, gbc);

        prendreRDVButton = new JButton("Prendre un RDV");
        consultRDVButton = new JButton("Consulter les RDV");
        prendreRDVButton.setMargin(new Insets(20, 50, 20, 50));
        consultRDVButton.setMargin(new Insets(20, 50, 20, 50));


        this.add(prendreRDVButton, gbc);
        this.add(consultRDVButton, gbc);


    }

    // Methode pour afficher le profil du patient
    private void displayPatientInfo(JTextArea textArea) {
        String ppatient = CliniqueImpl.getNomPatient(Login.getEmail()) + "  " + CliniqueImpl.getPrenomPatient(Login.getEmail()) + "\n" +
                CliniqueImpl.getAgePatient(Login.getEmail()) + " ans\n"; ;
        textArea.setText(ppatient);
    }


    public JButton getPrendreRDVButton() {
        return prendreRDVButton;
    }
    public JButton getConsultRDVButton(){
        return consultRDVButton;
    }


}
