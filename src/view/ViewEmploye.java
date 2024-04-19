package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;

/**
 * Cette classe fournit un interface graphique que l'Employe verra après sa connexion.
 */

public class ViewEmploye extends JFrame {
    private JButton gererMedecinButton;
    private JButton gererPatientButton;

    /**
     * Construit la fenêtre principale avec tous les composants UI nécessaires.
     */
    public ViewEmploye() {
        initializeUI();
    }

    /**
     * Initialise l'interface Employe de {@code ViewEmploye}.
     * Cette méthode configure le layout, ajoute les composants UI
     * et définit les paramètres du cadre.
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
     * Retourne le bouton de gestion des médecins.
     *
     * @return Le bouton {@code gererMedecinButton}.
     */

    public JButton getGererMedecinButton() {
        return gererMedecinButton;
    }

    /**
     * Retourne le bouton de gestion des patients.
     *
     * @return Le bouton {@code gererPatientButton}.
     */
    public JButton getGererPatientButton() {
        return gererPatientButton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ViewEmploye().setVisible(true));
    }
}
