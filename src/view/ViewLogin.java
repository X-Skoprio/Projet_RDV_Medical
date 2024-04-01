package view;

import javax.swing.*;
import java.awt.*;

public class ViewLogin extends JPanel { // Extend JPanel instead of creating a JFrame internally
    private JButton patientButton;
    private JButton employeeButton;

    public ViewLogin() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 1;
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel titre = new JLabel("DOCTOUBIB");
        titre.setFont(new Font("Serif", Font.BOLD, 24));
        gbc.weighty = 0.1;
        this.add(titre, gbc);

        patientButton = new JButton("Patient");
        patientButton.setMargin(new Insets(20, 50, 20, 50));
        employeeButton = new JButton("Employé");
        employeeButton.setMargin(new Insets(20, 50, 20, 50));

        this.add(patientButton, gbc);
        this.add(employeeButton, gbc);
    }

    // Keep the getter methods to allow the controller to add listeners to the buttons
    public JButton getPatientButton() {
        return patientButton;
    }

    public JButton getEmployeeButton() {
        return employeeButton;
    }
}
