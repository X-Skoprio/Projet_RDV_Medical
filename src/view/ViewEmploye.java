package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEmploye extends JFrame {

    private JButton GererPatientsButton;
    private JButton GererMedecinButton;
    private Runnable OUI;
    private Runnable NON;

    public ViewEmploye() {
        String nom = "John Doe";
        String email = "john.doe@example.com";

        this.setLayout(new BorderLayout()); // Use BorderLayout for the JFrame

// Background panel with null layout for absolute positioning of components
        JPanel backgroundPanel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                Image backgroundImage = new ImageIcon("src/view/fond.png").getImage();
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };


        GererPatientsButton = new JButton("Gerer patients");
        Dimension buttonSize = GererPatientsButton.getPreferredSize();
        GererPatientsButton.setBounds((512 - buttonSize.width) -230, 512 - buttonSize.height -50, // Position the button at the bottom middle
                buttonSize.width, buttonSize.height);
        GererMedecinButton = new JButton("Gerer medecin");
        GererMedecinButton.setBounds((512 - buttonSize.width) -100, 512 - buttonSize.height -100, // Position the button at the bottom middle
                buttonSize.width, buttonSize.height);

        // Add the button directly to the background panel
        backgroundPanel.add(GererPatientsButton);
        backgroundPanel.add(GererMedecinButton);

        // Add the background panel to the frame
        this.add(backgroundPanel, BorderLayout.CENTER);

        // Frame settings
        this.setTitle("Employe");
        this.setSize(512, 512); // Set the size of the window
        this.setLocationRelativeTo(null); // Center on screen
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Default close operation
        // Make the window visible

        //Affichage de la fenètre sur tt la longueur de l'écran

    }


    public JButton getGererPatientButton() {
        System.out.println(" Gérer Patient button clicked");
        return GererPatientsButton;
    }
    public JButton getGererMedecinButton() {
        return GererMedecinButton;
    }



/*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ViewEmploye().setVisible(true));
    }*/
}
