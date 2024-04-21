package view;

import javax.swing.*;
import java.awt.*;
/**
 * Porgramme qui va gerer le formulaire de création du patient
 * Va controler le graphique du formulaire en renvoyant les informations vers le controleur.
 */
public class ViewEmployeCreationPatient extends JFrame {

    private JButton validationCreationNouveauPatientButton;
    private JButton retourPagePrecedenteButton;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField ageField;
    private JTextField emailField;
    private JTextField passwordField;
    private JTextField detailsField;

    // Constructeur
    /**
     * Constructeur de la classe
     * Initialise la fenêtre et ses composants graphiques pour la création d'un nouveay patient.
     */
    public ViewEmployeCreationPatient() {
        // Initialisation de la fenêtre
        setTitle("Creation de Patient");
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
        ageField = addLabelAndTextField("Age :", 2);
        emailField = addLabelAndTextField("Email :", 3);
        passwordField = addLabelAndTextField("Mot de passe :", 4);
        detailsField = addLabelAndTextField("Details :", 5);

        // Boutons
        validationCreationNouveauPatientButton = new JButton("Creer Patient");
        retourPagePrecedenteButton = new JButton("Retour");

        constraints.gridx = 0;
        constraints.gridy = 6;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER; // Centrage des boutons
        add(validationCreationNouveauPatientButton, constraints);

        constraints.gridy = 7;
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
    /**
     * Renvoie le nom saisi dans le champ correspondant.
     *
     * @return Le nom du nouveau patient.
     */
    public String getNom() {
        return nomField.getText();
    }

    /**
     * Renvoie le prénom saisi dans le champ correspondant.
     *
     * @return Le prénom du nouveau patient.
     */
    public String getPrenom() {
        return prenomField.getText();
    }

    /**
     * Renvoie l'âge saisi dans le champ correspondant.
     *
     * @return L'âge du nouveau patient.
     */
    public String getAge() {
        return ageField.getText();
    }

    /**
     * Renvoie l'email saisi dans le champ correspondant.
     *
     * @return L'email du nouveau patient.
     */
    public String getEmail() {
        return emailField.getText();
    }

    /**
     * Renvoie le mot de passe saisi dans le champ correspondant.
     *
     * @return Le mot de passe du nouveau patient.
     */
    public String getPassword() {
        return passwordField.getText();
    }

    /**
     * Renvoie les détails saisis dans le champ correspondant.
     *
     * @return Les détails du nouveau patient.
     */
    public String getDetails() {
        return detailsField.getText();
    }

    /**
     * Renvoie le bouton de validation de la création du nouveau patient.
     *
     * @return Le bouton de validation de la création du nouveau patient.
     */
    public JButton getValidationCreationNouveauPatientButton() {
        return validationCreationNouveauPatientButton;
    }

    /**
     * Renvoie le bouton de retour à la page précédente.
     *
     * @return Le bouton de retour à la page précédente.
     */
    public JButton getRetourPagePrecedenteButton() {
        return retourPagePrecedenteButton;
    }

    /**
     * Permet de tester le programme avec l'affichage graphique.
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new ViewEmployeCreationPatient().setVisible(true);
        });
    }
}
