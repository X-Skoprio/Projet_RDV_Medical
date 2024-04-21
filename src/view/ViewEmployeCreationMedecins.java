package view;

import javax.swing.*;
import java.awt.*;

public class ViewEmployeCreationMedecins extends JFrame {

    private JButton validationCreationNouveauMedecinButton;
    private JButton retourPagePrecedenteButton;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField emailField;
    private JTextField specialisationField;

    // Constructeur
    public ViewEmployeCreationMedecins() {
        // Initialisation de la fenêtre
        setTitle("Creation de Medecin");
        setSize(500, 400); // Augmentation de la taille de la fenêtre pour mieux accommoder les champs
        setLocationRelativeTo(null); // Centrer la fenêtre


        JPanel backgroundPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                Image backgroundImage = new ImageIcon("src/view/fond.png").getImage();
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        this.setContentPane(backgroundPanel);

        // Utilisation de GridBagLayout pour la mise en page
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10); // Padding autour des éléments
        constraints.weightx = 1.0;  // Donne un poids supplémentaire aux éléments en largeur pour qu'ils s'élargissent

        // Champs de texte et leurs labels
        nomField = addLabelAndTextField("Nom :", 0);
        prenomField = addLabelAndTextField("Prenom :", 1);
        emailField = addLabelAndTextField("Email :", 2);
        specialisationField = addLabelAndTextField("Specialisation :", 3);

        // Boutons
        validationCreationNouveauMedecinButton = new JButton("Creer Medecin");
        retourPagePrecedenteButton = new JButton("Retour");

        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER; // Centrage des boutons
        add(validationCreationNouveauMedecinButton, constraints);

        constraints.gridy = 6;
        add(retourPagePrecedenteButton, constraints);
    }

    // Méthode pour ajouter un label et un champ de texte
    private JTextField addLabelAndTextField(String label, int yPos) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = yPos;
        constraints.gridwidth = 1;
        constraints.weightx = 0.1;  // Poids en largeur pour le label

        JLabel jLabel = new JLabel(label);
        jLabel.setForeground(Color.BLACK); // Définir la couleur du texte du label en noir
        add(jLabel, constraints);

        JTextField jTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.weightx = 0.9;  // Poids en largeur augmenté pour le champ de texte
        add(jTextField, constraints);
        return jTextField;
    }

    public String getNom() {
        return nomField.getText();
    }

    public String getPrenom() {
        return prenomField.getText();
    }
    public String getEmail() {
        return emailField.getText();
    }

    public String getSpecialisation() {
        return specialisationField.getText();
    }

    public JButton getValidationCreationNouveauPatientButton() {
        return validationCreationNouveauMedecinButton;
    }

    public JButton getRetourPagePrecedenteButton() {
        return retourPagePrecedenteButton;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new ViewEmployeCreationMedecins().setVisible(true);
        });
    }
}
