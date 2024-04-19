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

    public ViewPatientPrendreRdv() {
        setTitle("Clinic Appointment Booking");
        setSize(500, 500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void displayDoctors(List<Medecin> doctors, ActionListener selectAction) {
        doctorComboBox = new JComboBox<>(new Vector<>(doctors));
        doctorComboBox.addActionListener(selectAction);
        add(doctorComboBox, BorderLayout.NORTH);
    }

    public void displayDates(List<LocalDateTime> dates, ActionListener dateSelectAction) {
        DefaultListModel<String> model = new DefaultListModel<>();
        dates.forEach(date -> model.addElement(date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))));
        dateList = new JList<>(model);
        dateList.addListSelectionListener(e -> dateSelectAction.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null)));
        JScrollPane scrollPane = new JScrollPane(dateList);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void displayTimes(List<String> times, ActionListener timeSelectAction) {
        timeComboBox = new JComboBox<>(new Vector<>(times));
        timeComboBox.addActionListener(timeSelectAction);
        add(timeComboBox, BorderLayout.SOUTH);
    }

    public Medecin getSelectedDoctor() {
        return (Medecin) doctorComboBox.getSelectedItem();
    }

    public LocalDateTime getSelectedDate() {
        String selected = dateList.getSelectedValue();
        return LocalDateTime.parse(selected, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }

    public String getSelectedTime() {
        return (String) timeComboBox.getSelectedItem();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void refresh() {
        revalidate();
        repaint();
    }
}

