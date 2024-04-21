package view;

import javax.swing.*;
import java.awt.*;

/**
 * Fenêtre de création de médecins destinée aux employés.
 */
public class ViewEmployeCreationMedecins extends JFrame {

    private JButton validationCreationNouveauMedecinButton;
    private JButton retourPagePrecedenteButton;
    private JTextField nomField;
    private JTextField prenomField;
    private JTextField emailField;
    private JTextField specialisationField;

    /**
     * Constructeur de la fenêtre de création de médecins.
     * Initialise la fenêtre et ses composants.
     */
    public ViewEmployeCreationMedecins() {
        // Initialisation de la fenêtre
        setTitle("Creation de Medecin");
        setSize(500, 400); // Augmentation de la taille de la fenêtre pour mieux accommoder les champs
        setLocationRelativeTo(null); // Centrer la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

    /**
     * Récupère le nom saisi dans le champ correspondant.
     * @return Le nom du médecin.
     */
    public String getNom() {
        return nomField.getText();
    }

    /**
     * Récupère le prénom saisi dans le champ correspondant.
     * @return Le prénom du médecin.
     */
    public String getPrenom() {
        return prenomField.getText();
    }

    /**
     * Récupère l'email saisi dans le champ correspondant.
     * @return L'email du médecin.
     */
    public String getEmail() {
        return emailField.getText();
    }

    /**
     * Récupère la spécialisation saisie dans le champ correspondant.
     * @return La spécialisation du médecin.
     */
    public String getSpecialisation() {
        return specialisationField.getText();
    }

    /**
     * Obtient le bouton de validation pour la création du médecin.
     * @return Le bouton de validation.
     */
    public JButton getValidationCreationNouveauPatientButton() {
        return validationCreationNouveauMedecinButton;
    }

    /**
     * Obtient le bouton de retour à la page précédente.
     * @return Le bouton de retour.
     */
    public JButton getRetourPagePrecedenteButton() {
        return retourPagePrecedenteButton;
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new ViewEmployeCreationMedecins().setVisible(true);
        });
    }
}
