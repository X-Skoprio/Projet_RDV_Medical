package view;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEmployeGererMedecin extends JFrame {

    public ViewEmployeGererMedecin() {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        setTitle("Gerer les Medecins");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran

        JPanel backgroundPanel = new JPanel(new GridLayout(2, 1, 0, 10)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                Image backgroundImage = new ImageIcon("src/view/fond.png").getImage();
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        this.setContentPane(backgroundPanel); // Set the custom panel as the content pane


       // JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10)); // 2 lignes, 1 colonne avec espacement vertical de 10 pixels

        // Bouton pour la création de nouveaux patients
        JButton nouveauMedecinButton = new JButton("Création nouveaux Medecins");
        JButton ancienMedcinButton = new JButton("Connexion anciens Medecins");


        nouveauMedecinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Création nouveaux patients");
                new ViewEmployeNouveauMedecin();
                dispose();
            }
        });

        ancienMedcinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Création nouveaux patients");
                 new ViewEmployeAncienMedecin();
                dispose();
            }
        });

        backgroundPanel.add(nouveauMedecinButton);
        backgroundPanel.add(ancienMedcinButton);

        // Ajout du panel à la fenêtre
        //add(buttonPanel, BorderLayout.CENTER);

        // Affichage de la fenêtre
        setVisible(true);

    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ViewEmployeGererMedecin(); // Crée une instance de la fenêtre avec les noms et emails spécifiés
            }
        });

    }




    public class ViewEmployeNouveauMedecin extends JFrame{

        public ViewEmployeNouveauMedecin(){

            setTitle("Inscrire les Medecins");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran


            JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10)); // 6 lignes, 2 colonnes avec espacement de 10 pixels

            JLabel labelNom = new JLabel("Nom :");
            JTextField textFieldNom = new JTextField();
            JLabel labelPrenom = new JLabel("Prénom :");
            JTextField textFieldPrenom = new JTextField();
            JLabel labelEmail = new JLabel("Email :");
            JTextField textFieldEmail = new JTextField();
            JLabel labelSpe = new JLabel("Spécialisation :");
            JTextField textFieldSpe = new JTextField();

            formPanel.add(labelNom);
            formPanel.add(textFieldNom);
            formPanel.add(labelPrenom);
            formPanel.add(textFieldPrenom);
            formPanel.add(labelEmail);
            formPanel.add(textFieldEmail);
            formPanel.add(labelSpe);
            formPanel.add(textFieldSpe);

            JButton boutonCreer = new JButton("Créer");
            JButton boutonAnnuler = new JButton("Quitter le programme");

            boutonCreer.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String nom = textFieldNom.getText();
                    String prenom = textFieldPrenom.getText();

                    System.out.println("Nom: " + nom);
                    System.out.println("Prénom: " + prenom);
                    dispose();

                }
            });
            boutonAnnuler.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    dispose();

                }
            });



            JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // 1 ligne, 2 colonnes avec espacement de 10 pixels
            buttonPanel.add(boutonCreer);
            buttonPanel.add(boutonAnnuler);

            // Ajout des panels de formulaire et de boutons à la fenêtre
            add(formPanel, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);


            // Affichage de la fenêtre
            setVisible(true);
        }

    }

    public class ViewEmployeAncienMedecin extends JFrame {
        public ViewEmployeAncienMedecin(){

            setTitle("Connexion Medecins");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran

            // Création du panel pour le formulaire
            JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10)); // 6 lignes, 2 colonnes avec espacement de 10 pixels

            //Creation des variables que l'on va utiliser

            JLabel labelEmail = new JLabel("Email :");
            JTextField textFieldEmail = new JTextField();
            JLabel labelMdp = new JLabel("Mot de passe :");
            JPasswordField passwordField = new JPasswordField();

            formPanel.add(labelEmail);
            formPanel.add(textFieldEmail);
            formPanel.add(labelMdp);
            formPanel.add(passwordField);

            JButton boutonConnexion = new JButton("Connexion");
            JButton boutonAnnuler = new JButton("Quitter le programme");

            boutonConnexion.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String Email = textFieldEmail.getText();
                    String Mdp = passwordField.getText();

                    System.out.println("Email : " + Email);
                    System.out.println("Mdp : " + Mdp);
                    dispose();

                }
            });
            boutonAnnuler.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    dispose();

                }
            });

            JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // 1 ligne, 2 colonnes avec espacement de 10 pixels
            buttonPanel.add(boutonConnexion);
            buttonPanel.add(boutonAnnuler);

            // Ajout des panels de formulaire et de boutons à la fenêtre
            add(formPanel, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);


            // Affichage de la fenêtre
            setVisible(true);


        }
    }

}
