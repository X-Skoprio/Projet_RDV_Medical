
package view;

import javax.swing.*;
import java.awt.*;

/**
 * La classe {@code ViewLoginDetails} est une interface graphique pour se connecter via le mail
 * On affiche le formulaire avec le bouton.
 */

public class ViewLoginDetails extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton sendLoginButton;

    /**
     * Construit une nouvelle instance de {@code ViewLoginDetails} et initialise l'interface utilisateur.
     */
    public ViewLoginDetails() {
        initializeUI();
    }

    /**
     * Initialise les composants de l'interface utilisateur et configure les paramètres de mise en page.
     * Avec cette méthode, on va afficher le formulaire, le texte les décrivant et les boutons.
     */
    private void initializeUI() {
        // Create the custom JPanel with background image
        JPanel backgroundPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                Image backgroundImage = new ImageIcon("src/view/fond.png").getImage();
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        this.setContentPane(backgroundPanel); // Set the custom panel as the content pane

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);

        JLabel titleLabel = new JLabel("Entrez vos logins");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        titleLabel.setForeground(Color.BLACK);
        backgroundPanel.add(titleLabel, gbc); // Add components to the background panel

        emailField = new JTextField(20);
        JLabel emailLabel = new JLabel("Email");
        gbc.gridx = 0;
        gbc.gridy = 1;
        emailLabel.setForeground(Color.BLACK);
        backgroundPanel.add(emailLabel, gbc);


        gbc.gridy = 2;
        backgroundPanel.add(emailField, gbc);

        JLabel mdpLabel = new JLabel("Mot de passe");
        passwordField = new JPasswordField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        mdpLabel.setForeground(Color.BLACK);
        backgroundPanel.add(mdpLabel, gbc);
        gbc.gridy = 4;
        backgroundPanel.add(passwordField, gbc);

        sendLoginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        backgroundPanel.add(sendLoginButton, gbc);

        // Frame settings
        this.setSize(new Dimension(400, 300)); // Example size
        this.setLocationRelativeTo(null); // Center the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Default close operation
    }

    // Getter methods
    /**
     * Retourne le champ de texte pour l'email.
     *
     * @return le champ de texte pour l'email.
     */
    public JTextField getEmailField() {
        return emailField;
    }

    /**
     * Retourne le champ pour le mot de passe.
     *
     * @return le champ pour le mot de passe.
     */
    public JPasswordField getPasswordField() {
        return passwordField;
    }

    /**
     * Retourne le bouton pour lancer la connexion.
     *
     * @return le bouton pour lancer la connexion.
     */
    public JButton getLoginButton() {
        return sendLoginButton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ViewLoginDetails().setVisible(true));
    }
}
