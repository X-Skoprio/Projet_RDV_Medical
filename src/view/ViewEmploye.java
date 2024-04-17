package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEmploye extends JFrame {

    private JButton GererPatientsButton;
    private JButton GererMedecinButton;
    public ViewEmploye() {
        String nom = "John Doe";
        String email = "john.doe@example.com";

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        // Configuration de la fenêtre
        setTitle("Page du Site");
        setSize(600, 400); // Taille de la fenêtre modifiée
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
        this.setContentPane(backgroundPanel); // Set the custom panel as the content pane


        // Création des composants
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Ajout de padding


        // Composantes en haut de l'écran
        JLabel labelNom = new JLabel("Nom : " + nom);
        labelNom.setFont(new Font("Arial", Font.BOLD, 18)); // Augmentation de la taille de police
        JLabel labelEmail = new JLabel("Adresse Email : " + email);
        labelEmail.setFont(new Font("Arial", Font.BOLD, 18)); // Augmentation de la taille de police
        JPanel infoPanel = new JPanel(new FlowLayout());
        infoPanel.add(labelNom);
        infoPanel.add(labelEmail);

        // Composantes au centre de l'écran
        JButton bouton1 = new JButton("Gérer RDV");
        GererPatientsButton = new JButton("Gérer Patients");
        JButton GererMedecinButton = new JButton("Gérer Medecins");
        JButton boutonQuitter = new JButton("Quitter le programme");
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // GridLayout pour disposer les boutons en grille
        buttonPanel.add(bouton1);
        buttonPanel.add(GererPatientsButton);
        buttonPanel.add(GererMedecinButton);
        buttonPanel.add(boutonQuitter);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); // Ajout de padding
        // Réduction de la taille des boutons
        Dimension buttonSize = new Dimension(50, 30);
        bouton1.setPreferredSize(buttonSize);
        GererPatientsButton.setPreferredSize(buttonSize);
        GererMedecinButton.setPreferredSize(buttonSize);
        boutonQuitter.setPreferredSize(buttonSize);


        // Ajout des écouteurs d'événements aux boutons
        bouton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton 1 est cliqué
                System.out.println("Gérer RDV");
            }
        });

        GererPatientsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton 2 est cliqué
                System.out.println("Gérer Patients");
            }
        });
/*
        GererMedecinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton 3 est cliqué
                System.out.println("Gérer Médecins");
                new ViewEmployeGererMedecin();
                dispose();
            }
        });*/

        boutonQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton 4 est cliqué
                System.out.println("On quitte le programme !");
                dispose();
            }
        });


        // Ajout des composants au panel principal
        panel.add(infoPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);

        // Ajout du panel principal à la fenêtre
        add(panel);
        setVisible(true);



    }
    public JButton getGererPatientButton() {
        System.out.println(" Gérer Patient button clicked");
        return GererPatientsButton;
    }
    public JButton getGererMedecinButton() {
        return GererMedecinButton;
    }



    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ViewEmploye();
            }
        });

    }
}
