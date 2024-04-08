package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewLoginDetails extends JFrame { // Extend JPanel
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton sendLoginButton;

    public ViewLoginDetails() {
        initializeUI();
    }

    private void initializeUI() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);

        JLabel titleLabel = new JLabel("Entrez vos logins");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(titleLabel, gbc);

        emailField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(new JLabel("Email:"), gbc);
        gbc.gridy = 2;
        this.add(emailField, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 0;
        gbc.gridy = 3;
        this.add(new JLabel("Mot de passe:"), gbc);
        gbc.gridy = 4;
        this.add(passwordField, gbc);

        sendLoginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        this.add(sendLoginButton, gbc);

    }

    // Provide methods to attach action listeners to the buttons

    // Getter methods
    public JTextField getEmailField() {
        return emailField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginButton() {
        return sendLoginButton;
    }

}