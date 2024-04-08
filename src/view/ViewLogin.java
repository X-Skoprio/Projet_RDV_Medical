package view;

import javax.swing.*;
import java.awt.*;

public class ViewLogin extends JFrame { // Extend JPanel instead of creating a JFrame internally
    private JButton loginButton;

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

        loginButton = new JButton("Login");
        loginButton.setMargin(new Insets(20, 50, 20, 50));


        this.add(loginButton, gbc);
    }

    // Keep the getter methods to allow the controller to add listeners to the buttons
    public JButton getLoginButton() {
        return loginButton;
    }




}
