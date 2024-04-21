package view;

import model.Medecin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;
import java.awt.event.ActionEvent;

/**
 * La classe affiche l'interface graphique permettant à un patient de prendre un rendez-vous.
 */
public class ViewPatientPrendreRdv extends JFrame {
    private JComboBox<Medecin> doctorComboBox;
    private JList<String> dateList;
    private JComboBox<String> timeComboBox;

    private JPanel doctorPanel = new JPanel(new GridLayout(0, 1));
    private JScrollPane scrollPane = new JScrollPane(doctorPanel);

    /**
     * Constructeur qui va initialiser les composants graphiques.
     */
    public ViewPatientPrendreRdv() {
        setTitle("Patient - Prise de rdv");
        setSize(500, 700);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(scrollPane, BorderLayout.CENTER);
        this.setLocationRelativeTo(null); // Center on screen
    }

    /**
     * Affiche les docteurs disponibles
     * @param doctors liste des docteurs.
     * @param actionListener    action à effectuer qd on va selectionner un medecin.
     */
    public void displayDoctors(List<Medecin> doctors, ActionListener actionListener) {
        for (Medecin doctor : doctors) {
            String nomBoutton = doctor.getPrenom() + " " + doctor.getNom() + "       spé : " + doctor.getSpecialisation();
            JButton button = new JButton(nomBoutton);
            button.addActionListener(actionListener);
            button.setActionCommand(doctor.getEmail()); // Use doctor's email as the action command for identification
            doctorPanel.add(button);
        }
        validate();
        repaint();
    }
    /**
     * Affiche les créneaux horaires disponibles pour le rendez-vous sélectionné.
     *
     * @param slots La liste des créneaux horaires disponibles.
     * @param actionListener L'action à effectuer lorsqu'un créneau horaire est sélectionné.
     */
    public void displayTimeSlots(List<String> slots, ActionListener actionListener) {
        JPanel timePanel = new JPanel(new GridLayout(0, 1));
        for (String slot : slots) {
            JButton button = new JButton(slot);
            button.addActionListener(actionListener);
            timePanel.add(button);
        }
        setContentPane(new JScrollPane(timePanel)); // Replace current panel with time selection
        validate();
        repaint();
    }

    /**
     * Affiche un message
     *
     * @param message Le message à afficher.
     */
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

