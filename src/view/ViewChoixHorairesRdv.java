package view;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewChoixHorairesRdv extends JFrame{


    private JComboBox<String> dayDropdown = new JComboBox<>();
    private JComboBox<String> hourDropdown = new JComboBox<>();
    private JButton confirmButton = new JButton("Confirmer le rdv");
    private JButton backButton = new JButton("Retour");

    public ViewChoixHorairesRdv() {
        super("Choisir une horaire pour le rdv");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel dayPanel = new JPanel();
        dayPanel.add(new JLabel("Chosir un jour:"));
        dayPanel.add(dayDropdown);

        JPanel hourPanel = new JPanel();
        hourPanel.add(new JLabel("Choisir une heure:"));
        hourPanel.add(hourDropdown);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(confirmButton);

        add(dayPanel);
        add(hourPanel);
        add(buttonPanel);
    }

    public void setDays(java.util.List<String> days) {
        dayDropdown.removeAllItems();
        for (String day : days) {
            dayDropdown.addItem(day);
        }
    }

    public void setHours(java.util.List<String> hours) {
        hourDropdown.removeAllItems();
        for (String hour : hours) {
            hourDropdown.addItem(hour);
        }
        hourDropdown.setEnabled(true);
    }

    public String getSelectedDay() {
        return (String) dayDropdown.getSelectedItem();
    }

    public String getSelectedHour() {
        return (String) hourDropdown.getSelectedItem();
    }

    public void addDaySelectionListener(ActionListener listener) {
        dayDropdown.addActionListener(listener);
    }

    public void addHourSelectionListener(ActionListener listener) {
        hourDropdown.addActionListener(listener);
    }

    public void addConfirmButtonListener(ActionListener listener) {
        confirmButton.addActionListener(listener);
    }

    public void addBackButtonListener(ActionListener listener) {
        backButton.addActionListener(listener);
    }

    public void display() {

        setVisible(true);
    }
}
