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

public class ViewPatientPrendreRdv extends JFrame {
    private JComboBox<Medecin> doctorComboBox;
    private JList<String> dateList;
    private JComboBox<String> timeComboBox;

    private JPanel doctorPanel = new JPanel(new GridLayout(0, 1));
    private JScrollPane scrollPane = new JScrollPane(doctorPanel);

    public ViewPatientPrendreRdv() {
        setTitle("Patient - Prise de rdv");
        setSize(500, 700);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(scrollPane, BorderLayout.CENTER);
        this.setLocationRelativeTo(null); // Center on screen
    }

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

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}

