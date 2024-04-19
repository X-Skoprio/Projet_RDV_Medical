package view;

import javax.swing.*;
import java.awt.*;

public class ViewEmployeCreationPatients extends JFrame {
    private JTextField textFieldNom, textFieldPrenom, textFieldAge, textFieldEmail;
    private JPasswordField passwordField;
    private JTextArea textAreaDetails;
    private JButton boutonSoumettre, boutonAnnuler;

    public ViewEmployeCreationPatients() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Création de Patient");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel backgroundPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = new ImageIcon("src/view/fond.png").getImage();
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        this.setContentPane(backgroundPanel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);

        // Form panel
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        textFieldNom = new JTextField();
        textFieldPrenom = new JTextField();
        textFieldAge = new JTextField();
        textFieldEmail = new JTextField();
        passwordField = new JPasswordField();
        textAreaDetails = new JTextArea();

        formPanel.add(new JLabel("Nom :"));
        formPanel.add(textFieldNom);
        formPanel.add(new JLabel("Prénom :"));
        formPanel.add(textFieldPrenom);
        formPanel.add(new JLabel("Âge :"));
        formPanel.add(textFieldAge);
        formPanel.add(new JLabel("Email :"));
        formPanel.add(textFieldEmail);
        formPanel.add(new JLabel("Mot de passe :"));
        formPanel.add(passwordField);
        formPanel.add(new JLabel("Détails :"));
        formPanel.add(textAreaDetails);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        boutonSoumettre = new JButton("Soumettre");
        boutonAnnuler = new JButton("Annuler");
        buttonPanel.add(boutonSoumettre);
        buttonPanel.add(boutonAnnuler);

        backgroundPanel.add(formPanel, gbc);
        gbc.gridy++;
        backgroundPanel.add(buttonPanel, gbc);

        pack();
        setVisible(true);
    }

    public JButton getBoutonSoumettre() {
        return boutonSoumettre;
    }

    public JButton getBoutonAnnuler() {
        return boutonAnnuler;
    }
}
