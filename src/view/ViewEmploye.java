package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEmploye extends JFrame {

    private JButton GererPatientsButton;
    public ViewEmploye(String nom, String email) {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        // Configuration de la fenêtre
        setTitle("Page du Site");
        setSize(600, 400); // Taille de la fenêtre modifiée
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
        JButton bouton3 = new JButton("Gérer Medecins");
        JButton bouton4 = new JButton("Quitter le programme");
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // GridLayout pour disposer les boutons en grille
        buttonPanel.add(bouton1);
        buttonPanel.add(GererPatientsButton);
        buttonPanel.add(bouton3);
        buttonPanel.add(bouton4);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); // Ajout de padding
        // Réduction de la taille des boutons
        Dimension buttonSize = new Dimension(50, 30);
        bouton1.setPreferredSize(buttonSize);
        GererPatientsButton.setPreferredSize(buttonSize);
        bouton3.setPreferredSize(buttonSize);
        bouton4.setPreferredSize(buttonSize);

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
                new ViewEmployeGererPatients();
            }
        });

        bouton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton 3 est cliqué
                System.out.println("Gérer Médecins");
            }
        });

        bouton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton 4 est cliqué
                System.out.println("On quitte le programme !");
            }
        });

        // Ajout des composants au panel principal
        panel.add(infoPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);

        // Ajout du panel principal à la fenêtre
        add(panel);

        // Affichage de la fenêtre
        setVisible(true);

    }
    public JButton getGererPatientButton() {
        return GererPatientsButton;
    }


    public static void main(String[] args) {
        // Vous pouvez remplacer les valeurs ci-dessous par les noms et emails que vous souhaitez afficher
        String nom = "John Doe";
        String email = "john.doe@example.com";

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ViewEmploye(nom, email); // Crée une instance de la fenêtre avec les noms et emails spécifiés
            }
        });
    }
}
