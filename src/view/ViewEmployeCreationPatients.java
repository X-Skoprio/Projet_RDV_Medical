package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEmployeCreationPatients extends JFrame{

    public ViewEmployeCreationPatients(){

        setTitle("Page du Site");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran


        // Création du panel pour le formulaire
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10)); // 6 lignes, 2 colonnes avec espacement de 10 pixels

        // Labels et champs de texte pour les informations du patient
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

        // Boutons pour soumettre et annuler le formulaire
        JButton boutonSoumettre = new JButton("Soumettre");
        JButton boutonAnnuler = new JButton("Annuler");


        // Ajout d'un ActionListener pour le bouton Soumettre
        boutonSoumettre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton Soumettre est cliqué
                // Ici, vous pouvez récupérer les valeurs des champs de texte et effectuer le traitement approprié
                String nom = textFieldNom.getText();
                String prenom = textFieldPrenom.getText();
                // Récupérez les autres valeurs des champs de texte de la même manière
                System.out.println("Nom: " + nom);
                System.out.println("Prénom: " + prenom);
                // Affichez les autres valeurs des champs de texte de la même manière
            }
        });

        // Création du panel pour les boutons
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10)); // 1 ligne, 2 colonnes avec espacement de 10 pixels
        buttonPanel.add(boutonSoumettre);
        buttonPanel.add(boutonAnnuler);

        // Ajout des panels de formulaire et de boutons à la fenêtre
        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);



        // Affichage de la fenêtre
        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ViewEmployeCreationPatients(); // Crée une instance de la fenêtre avec les noms et emails spécifiés
            }
        });

    }
}

