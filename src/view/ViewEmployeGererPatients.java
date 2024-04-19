package view;

import javax.swing.*;
import java.awt.*;

public class ViewEmployeGererPatients extends JFrame {
    private JButton creationNouveauxPatientButton;
    private JButton ConsulterLesPatientsButton;

    public ViewEmployeGererPatients() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Gestion des Patients");
        setSize(new Dimension(600, 400));
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
        gbc.insets = new Insets(10, 50, 10, 50);

        creationNouveauxPatientButton = new JButton("Creation nouveaux patients");
        ConsulterLesPatientsButton = new JButton("Consulter les patients");

        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundPanel.add(creationNouveauxPatientButton, gbc);
        gbc.gridy = 1;
        backgroundPanel.add(ConsulterLesPatientsButton, gbc);

        this.pack();
        this.setVisible(true);
    }

    public JButton getCreationNouveauxPatientButton() {
        return creationNouveauxPatientButton;
    }

    public JButton getConsulterLesPatientsButton() {
        return ConsulterLesPatientsButton;
    }


}
