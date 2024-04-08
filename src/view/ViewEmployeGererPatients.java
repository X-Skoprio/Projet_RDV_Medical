package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewEmployeGererPatients extends JFrame{

    public ViewEmployeGererPatients(){

        setTitle("Page du Site");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Création du panel pour les boutons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 0, 10)); // 2 lignes, 1 colonne avec espacement vertical de 10 pixels

        // Bouton pour la création de nouveaux patients
        JButton nouveauPatientButton = new JButton("Création nouveaux patients");
        nouveauPatientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton Création nouveaux patients est cliqué
                // Ajoutez votre logique ici
                System.out.println("Création nouveaux patients");
                new ViewEmployeCreationPatients();
            }
        });

        // Bouton pour ouvrir les anciens patients
        JButton ancienPatientButton = new JButton("Ouvrir anciens patients");
        ancienPatientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton Ouvrir anciens patients est cliqué
                // Ajoutez votre logique ici
                System.out.println("Ouvrir anciens patients");
            }
        });

        // Ajout des boutons au panel
        buttonPanel.add(nouveauPatientButton);
        buttonPanel.add(ancienPatientButton);

        // Ajout du panel à la fenêtre
        add(buttonPanel, BorderLayout.CENTER);

        // Affichage de la fenêtre
        setVisible(true);

    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ViewEmployeGererPatients(); // Crée une instance de la fenêtre avec les noms et emails spécifiés
            }
        });

    }
    }

