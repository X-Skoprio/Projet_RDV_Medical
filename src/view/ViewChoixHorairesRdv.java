package view;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;


import java.sql.Timestamp;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.sql.SQLException;

import java.time.format.DateTimeFormatter;
import java.lang.*;

public class ViewChoixHorairesRdv extends JFrame{


    private JComboBox<String> dayDropdown = new JComboBox<>();
    private JComboBox<String> hourDropdown = new JComboBox<>();
    private JButton confirmButton = new JButton("Confirmer le rdv");
    private JButton backButton = new JButton("Retour");

    public ViewChoixHorairesRdv() {
        super("Choisir une horaire pour le rdv");
        setSize(400, 300);


        JPanel backgroundPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Assume the path to the image is correct and it's loadable
                Image backgroundImage = new ImageIcon("src/view/fond.png").getImage();
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        setContentPane(backgroundPanel);

        JPanel dayPanel = new JPanel();
        dayPanel.add(new JLabel("Chosir un jour:"));
        dayPanel.add(dayDropdown);

        JPanel hourPanel = new JPanel();
        hourPanel.add(new JLabel("Choisir une heure:"));
        hourPanel.add(hourDropdown);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backButton);
        buttonPanel.add(confirmButton);

        backgroundPanel.add(dayPanel);
        backgroundPanel.add(hourPanel);
        backgroundPanel.add(buttonPanel);
        hourDropdown.setRenderer(new BookedTimeRenderer());
        this.setLocationRelativeTo(null); // Center on screen
    }


    // Custom renderer to gray out booked times
    private static class BookedTimeRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value != null && value.toString().contains("(booked)")) {
                setForeground(Color.GRAY);
                setBackground(isSelected ? Color.LIGHT_GRAY : Color.WHITE);
            } else {
                setForeground(Color.BLACK);
                setBackground(isSelected ? Color.BLUE : Color.WHITE);
            }
            return this;
        }
    }

    public void setDays(java.util.List<String> days) {
        dayDropdown.removeAllItems();
        for (String day : days) {
            dayDropdown.addItem(day);
        }
    }

    public void setHours(java.util.List<String> hours, java.util.List<LocalDateTime> bookedTimes) {
        hourDropdown.removeAllItems();
        for (String hour : hours) {
            LocalTime time = LocalTime.parse(hour, DateTimeFormatter.ofPattern("HH:mm"));
            LocalDateTime dateTime = LocalDateTime.of(LocalDate.now(), time); // Combining with today's date just as an example
            boolean isBooked = bookedTimes.stream().anyMatch(bookedTime -> bookedTime.toLocalTime().equals(time));
            if (isBooked) {
                hourDropdown.addItem(hour + " (booked)");
                // If you want to disable selection of booked times, you'll need custom rendering and handling in the JComboBox
            } else {
                hourDropdown.addItem(hour);
            }
        }
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
