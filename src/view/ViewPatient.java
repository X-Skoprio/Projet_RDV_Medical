package view;

import model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Affichage graphique des informations du patient
 * Affiche les boutons pour lui permettre de faire différente actions.
 * Toutes les actions sont après géré dans le controlleur.
 */
public class ViewPatient extends JFrame{

    private JButton prendreRDVButton;
    private JButton  consultRDVButton;

    /**
     * Construicteur des composantes graphiques etc etc
     */
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

    /**
     * Va permettre de prendre un rdv pour le patient.
     * @return bouton pour prendre RDV
     */
    public JButton getPrendreRDVButton() {
        return prendreRDVButton;
    }

    /**
     * Affiche le boutton qui permet de consulter les RDV du patient en question
     * @return bouton pour afficher les RDV.
     */
    public JButton getConsultRDVButton(){
        return consultRDVButton;
    }


}
