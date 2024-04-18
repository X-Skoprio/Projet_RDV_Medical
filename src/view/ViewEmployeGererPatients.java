package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEmployeGererPatients extends JFrame {

    public ViewEmployeGererPatients() {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        setTitle("Gerer le patient");
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


        // Création du panel pour les boutons
        //JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10)); // 2 lignes, 1 colonne avec espacement vertical de 10 pixels

        // Bouton pour la création de nouveaux patients
        JButton nouveauPatientButton = new JButton("Création nouveaux patients");
        nouveauPatientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("Création nouveaux patients");
                new ViewEmployeCreationPatients();
                dispose();
            }
        });

        // Bouton pour ouvrir les anciens patients
        JButton ancienPatientButton = new JButton("Ouvrir anciens patients");
        ancienPatientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                System.out.println("Ouvrir anciens patients");
                new ViewEmployeAncienPatient();
                dispose();
            }
        });

        // Ajout des boutons au panel
        backgroundPanel.add(nouveauPatientButton);
        backgroundPanel.add(ancienPatientButton);

        // Ajout du panel à la fenêtre





        // Affichage de la fenêtre
       // setVisible(true);

    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ViewEmployeGererPatients(); // Crée une instance de la fenêtre avec les noms et emails spécifiés
            }
        });

    }


    public class ViewEmployeCreationPatients extends JFrame {

        public ViewEmployeCreationPatients() {

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            setTitle("Creation patient");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
/*
            JPanel backgroundPanel = new JPanel(new GridLayout(6, 2, 10, 10)) {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    // Draw the background image
                    Image backgroundImage = new ImageIcon("src/view/fond.png").getImage();
                    g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
                }
            };
            this.setContentPane(backgroundPanel); // Set the custom panel as the content pane

*/
            // Création du panel pour le formulaire
            JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10)); // 6 lignes, 2 colonnes avec espacement de 10 pixels


            JLabel labelNom = new JLabel("Nom :");
            JTextField textFieldNom = new JTextField();
            JLabel labelPrenom = new JLabel("Prénom :");
            JTextField textFieldPrenom = new JTextField();
            JLabel labelAge = new JLabel("Âge :");
            JTextField textFieldAge = new JTextField();
            JLabel labelEmail = new JLabel("Email :");
            JTextField textFieldEmail = new JTextField();
            JLabel labelMdp = new JLabel("Mot de passe :");
            JPasswordField passwordField = new JPasswordField();
            JLabel labelDetails = new JLabel("Détails :");
            JTextArea textAreaDetails = new JTextArea();

            // Ajout des composants au panel du formulaire
            formPanel.add(labelNom);
            formPanel.add(textFieldNom);
            formPanel.add(labelPrenom);
            formPanel.add(textFieldPrenom);
            formPanel.add(labelAge);
            formPanel.add(textFieldAge);
            formPanel.add(labelEmail);
            formPanel.add(textFieldEmail);
            formPanel.add(labelMdp);
            formPanel.add(passwordField);
            formPanel.add(labelDetails);
            formPanel.add(textAreaDetails);


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
            buttonPanel.add(formPanel);

            // Ajout des panels de formulaire et de boutons à la fenêtre
            add(formPanel, BorderLayout.CENTER);
            add(buttonPanel, BorderLayout.SOUTH);


            // Affichage de la fenêtre
            setVisible(true);
        }
    }



public class ViewEmployeAncienPatient extends JFrame {

    public ViewEmployeAncienPatient() {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        setTitle("Connexion du patient via l'employe");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
/*
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

*/
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

