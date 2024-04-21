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


        super("DOCTOUBIB"); // Set the title of the JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300); // Set size of the frame
        setLocationRelativeTo(null); // Center on screen

        // Create a background panel with custom painting
        JPanel backgroundPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Assume the path to the image is correct and it's loadable
                Image backgroundImage = new ImageIcon("src/view/fond.png").getImage();
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        setContentPane(backgroundPanel); // Set the custom panel as the content pane

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Allow horizontal expansion
        gbc.insets = new Insets(5, 10, 5, 10);

        // Title label
        JLabel titre = new JLabel("DOCTOUBIB");
        titre.setFont(new Font("Serif", Font.BOLD, 26));
        titre.setForeground(Color.BLACK);
        backgroundPanel.add(titre, gbc);

        // Display patient information
        displayPatientInfo(backgroundPanel, gbc);

        // Buttons
        prendreRDVButton = new JButton("Prendre un RDV");
        consultRDVButton = new JButton("Consulter les RDV");
        prendreRDVButton.setMinimumSize(new Dimension(150, 80)); // Set preferred size for larger buttons
        consultRDVButton.setMinimumSize(new Dimension(150, 80)); // Set preferred size for larger buttons
        backgroundPanel.add(prendreRDVButton, gbc);
        backgroundPanel.add(consultRDVButton, gbc);

        setVisible(true); // Make it visible
    }

    /**
     * Methode qui va afficher les info du patient etc.
     * @param panel composantes graphique
     * @param gbc composantes graphiques
     */
    private void displayPatientInfo(JPanel panel, GridBagConstraints gbc) {
        String nom = CliniqueImpl.getNomPatient(Login.getEmail());
        String prenom = CliniqueImpl.getPrenomPatient(Login.getEmail());
        int age = CliniqueImpl.getAgePatient(Login.getEmail());

        JLabel nameLabel = new JLabel("Nom: " + nom);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 18));
        nameLabel.setForeground(Color.BLACK);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(nameLabel, gbc);

        JLabel prenomLabel = new JLabel("Prénom: " + prenom);
        prenomLabel.setFont(new Font("Serif", Font.BOLD, 18));
        prenomLabel.setForeground(Color.BLACK);
        prenomLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(prenomLabel, gbc);

        JLabel ageLabel = new JLabel("Âge: " + age + " ans");
        ageLabel.setFont(new Font("Serif", Font.BOLD, 18));
        ageLabel.setForeground(Color.BLACK);
        ageLabel.setHorizontalAlignment(JLabel.CENTER);
        panel.add(ageLabel, gbc);
    }

    /**
     * Va permettre de prendre un rdv pour le patient.
     * @return bouton pour prendre RDV
     */
    public JButton getPrendreRDVButton() {
        return prendreRDVButton;
    }
    public JButton getConsultRDVButton(){
        return consultRDVButton;
    }


}
