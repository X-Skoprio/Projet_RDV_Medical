package view;

import javax.swing.*;
import java.awt.*;

/**
 * Le {@code ViewLogin} classe permet à l'utilisateur de se connecter.
 * Le processus est lancé à l'aide d'un seul bouton LOGIN
 * On se connecte à l'aide du mail et du mot de passe
 * @author JOUD PREVOST MAAREK
 */

public class ViewLogin extends JFrame {
    private JButton loginButton;


    /**
     * Construit une nouvelle vue de connexion en configurant les composants de l'interface utilisateur.
     */

    public ViewLogin() {
        this.setLayout(new BorderLayout()); // Use BorderLayout for the JFrame


        // Background panel with null layout for absolute positioning of components
        JPanel backgroundPanel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                Image backgroundImage = new ImageIcon("src/view/ArrierePlan.png").getImage();
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };

        // Create the login button and set its size and margins
        loginButton = new JButton("Login");
        Dimension buttonSize = loginButton.getPreferredSize();
        loginButton.setBounds((512 - buttonSize.width) -230, 512 - buttonSize.height -50, // Position the button at the bottom middle
                buttonSize.width, buttonSize.height);

        // Add the button directly to the background panel
        backgroundPanel.add(loginButton);

        // Add the background panel to the frame
        this.add(backgroundPanel, BorderLayout.CENTER);

        // Frame settings
        this.setTitle("Login");
        this.setSize(512, 512); // Set the size of the window
        this.setLocationRelativeTo(null); // Center on screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Default close operation
        // Make the window visible
    }

    /**
     * Obtient le bouton de connexion.
     *
     * @return Le bouton de connexion pour renvoyer les infos
     */
    public JButton getLoginButton() {
        return loginButton;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ViewLogin().setVisible(true));
    }
}
