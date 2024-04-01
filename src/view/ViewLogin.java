package view;

import javax.swing.*;
import java.awt.*;

public class ViewLogin {
    private JButton patientButton;
    private JButton employeeButton;

    public ViewLogin() {
        // Création de la fenêtre
        JFrame fenetre = new JFrame("DOCTOUBIB");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(400, 300); // Taille de la fenêtre

        // Création du panneau qui contiendra les boutons et le titre
        JPanel panneau = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Configuration pour centrer les composants
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Création et ajout du titre
        JLabel titre = new JLabel("DOCTOUBIB");
        titre.setFont(new Font("Serif", Font.BOLD, 24));
        gbc.weighty = 0.1;
        panneau.add(titre, gbc);

        // Création des boutons
        patientButton = new JButton("Patient");
        patientButton.setMargin(new Insets(20, 50, 20, 50));
        employeeButton = new JButton("Employé");
        employeeButton.setMargin(new Insets(20, 50, 20, 50));

        // Ajout des boutons au panneau avec les contraintes
        panneau.add(patientButton, gbc);
        panneau.add(employeeButton, gbc);

        // Ajout du panneau à la fenêtre
        fenetre.add(panneau);

        // Affichage de la fenêtre
        fenetre.setVisible(true);
    }

    public JButton getPatientButton() {
        return patientButton;
    }

    public JButton getEmployeeButton() {
        return employeeButton;
    }
}
