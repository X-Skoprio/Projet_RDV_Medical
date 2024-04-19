package view;

import javax.swing.*;
import java.awt.*;

public class ViewEmployeGererPatients extends JFrame {
    private JButton creationNouveauxPatient;
    private JButton ConsulterLesPatients;

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

        creationNouveauxPatient = new JButton("Creation nouveaux patients");
        ConsulterLesPatients = new JButton("Consulter les patients");

        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundPanel.add(creationNouveauxPatient, gbc);
        gbc.gridy = 1;
        backgroundPanel.add(ConsulterLesPatients, gbc);

        this.pack();
        this.setVisible(true);
    }

    public JButton getcreationNouveauxPatientButton() {
        return creationNouveauxPatient;
    }

    public JButton getConsulterLesPatientsButton() {
        return ConsulterLesPatients;
    }


}
