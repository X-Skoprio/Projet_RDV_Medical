package view;

import javax.swing.*;
import java.awt.*;

/**
 * Affichage graphique de la fenètre Employe après s'est connecté.
 * Contient le fond d'écran ainsi que les boutons pour choisir la prochaine action.
 */
public class ViewEmploye extends JFrame {
    private JButton gererMedecinButton;
    private JButton gererPatientButton;

    /**
     * Constructeur du programme graphique Employe
     */
    public ViewEmploye() {
        initializeUI();
    }

    /**
     * Initialise l'affichage des UI de l'écran
     */
    private void initializeUI() {
        // Custom JPanel with background image
        JPanel backgroundPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = new ImageIcon("src/view/fond.png").getImage();
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        this.setContentPane(backgroundPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);

        JLabel titleLabel = new JLabel("Gestion des Medecins et Patients");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundPanel.add(titleLabel, gbc);

        gererMedecinButton = new JButton("Gerer Medecin");
        gbc.gridx = 0;
        gbc.gridy = 1;
        backgroundPanel.add(gererMedecinButton, gbc);

        gererPatientButton = new JButton("Gerer Patient");
        gbc.gridx = 0;
        gbc.gridy = 2;
        backgroundPanel.add(gererPatientButton, gbc);

        // Frame settings
        this.setSize(new Dimension(512, 512));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Envoie vers la prochaine fenètre qui gere les Medecins.
     * @return bouton Medecins
     */
    public JButton getGererMedecinButton() {
        return gererMedecinButton;
    }
    /**
     * Envoie vers la prochaine fenètre qui gere les Patients.
     * @return bouton Patients
     */
    public JButton getGererPatientButton() {
        return gererPatientButton;
    }

    /**
     * Main qui permet de tester de manière intermédiaire.
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ViewEmploye().setVisible(true));
    }
}
