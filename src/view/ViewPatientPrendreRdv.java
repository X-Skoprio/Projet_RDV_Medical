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
    private JButton returnButton;

    public ViewPatientPrendreRdv() {
        setTitle("Patient - Prise de RDV");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Création d'un JPanel personnalisé pour le fond
        JPanel backgroundPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image backgroundImage = new ImageIcon("src/view/fond.png").getImage();
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        setContentPane(backgroundPanel); // Définition du panel comme contenu principal

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;  // Modification pour remplir horizontalement et verticalement
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;  // Modification pour donner du poids vertical

        JLabel label = new JLabel("Choisir le médecin pour le RDV", JLabel.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 18));
        label.setForeground(Color.BLACK);
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.weighty = 0.1;  // Poids réduit pour le label
        backgroundPanel.add(label, gbc);

        doctorPanel = new JPanel();
        doctorPanel.setLayout(new BoxLayout(doctorPanel, BoxLayout.Y_AXIS));
        scrollPane = new JScrollPane(doctorPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        gbc.weighty = 0.8;  // Poids augmenté pour le JScrollPane
        backgroundPanel.add(scrollPane, gbc);

        returnButton = new JButton("Retour");
        gbc.weighty = 0.1;  // Poids réduit pour le bouton de retour
        backgroundPanel.add(returnButton, gbc);

        setVisible(true);
    }


    public void displayDoctors(List<Medecin> doctors, ActionListener actionListener) {
        doctorPanel.removeAll();  // Enlever les boutons précédents s'il y en a
        for (Medecin doctor : doctors) {
            String buttonLabel = doctor.getPrenom() + " " + doctor.getNom() + " - Spécialisation: " + doctor.getSpecialisation();
            JButton button = new JButton(buttonLabel);
            button.setActionCommand(doctor.getEmail());
            button.addActionListener(actionListener);
            button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getMinimumSize().height));
            doctorPanel.add(button);
        }
        doctorPanel.revalidate();
        doctorPanel.repaint();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public JButton getReturnButton() {
        return returnButton;
    }
}

