package view;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ControlleurPatient.*;

public class ViewPatient extends JFrame{
    private Patient patient;

    public ViewPatient(Patient patient) {
        this.patient = patient;
        setTitle("Doctoubib Menu Patient");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creation d'un paneau pour contenir les composants
        JPanel panel = new JPanel(new BorderLayout());


        // cree la zone de texte en haut de la fenetre pour profil patient
        JTextArea infoPatient = new JTextArea();
        Font largerFont = new Font(infoPatient.getFont().getName(), Font.PLAIN, 20); // Change 16 to the desired font size

        // Edit la taille du texte
        infoPatient.setFont(largerFont);

        infoPatient.setEditable(false);
        displayPatientInfo(infoPatient, patient);
        panel.add(infoPatient, BorderLayout.NORTH);

        // Creation bouttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        JButton prendreRDVButton = new JButton("Prendre RDV");
        JButton consulterRDVButton = new JButton("Prendre RDV");


        // Ajoutez les écouteurs d'événements aux boutons
        prendreRDVButton.addActionListener(new PrendreRDVListener());
        consulterRDVButton.addActionListener(new ConsulterRDVListener());

        // Ajout des boutons au paneau
        buttonPanel.add(prendreRDVButton);
        buttonPanel.add(consulterRDVButton);

        // Place le paneau au centre de la fenêtre
        panel.add(buttonPanel, BorderLayout.CENTER);

        // Place le paneau sur la fenêtre
        add(panel);

        // taille de la fenêtre
        setSize(500, 500); // Width: 400 pixels, Height: 300 pixels


        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    // Methode pour afficher le profil du patient
    private void displayPatientInfo(JTextArea textArea, Patient patient) {
        String patientInfo = patient.getNom() + "  " + patient.getPrenom() + "\n" +
                patient.getAge() + " ans\n";
        textArea.setText(patientInfo);
    }

    public static void main(String[] args) {
        // Simulation du login patient
        Patient patient = new Patient("John", "Doe","joh.doe@example.com" , "mdp", 30, "Additional details");

        // Creation et affichage de la fenêtre
        SwingUtilities.invokeLater(() -> new ViewPatient(patient));
    }
}
