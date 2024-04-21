package view;

import javax.swing.*;
import java.awt.*;

/**
 * Classe qui va nous permettre de choisir entre créer un nouveau medecin ou en utiliser un ancien
 * Le choix se fait à l'aide du bouton en tant qu'employe.
 */
public class ViewEmployeGererMedecinsMenu extends JFrame {
    private JButton creationNouveauxMedecinsButton;
    private JButton ConsulterLesMedecinsButton;

    /**
     * Constructeur de la classe
     */
    public ViewEmployeGererMedecinsMenu() {
        initializeUI();
    }

    /**
     * Implementation des compsants graphiques avec le fond etc
     */
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

        creationNouveauxMedecinsButton = new JButton("Creation nouveaux Medecins");
        ConsulterLesMedecinsButton = new JButton("Consulter les Medecins");

        gbc.gridx = 0;
        gbc.gridy = 0;
        backgroundPanel.add(creationNouveauxMedecinsButton, gbc);
        gbc.gridy = 1;
        backgroundPanel.add(ConsulterLesMedecinsButton, gbc);

        this.pack();
        this.setVisible(true);
    }

    /**
     * bouton nouveau Medecin
     * @return retourne si on clique dessus
     */
    public JButton getCreationNouveauxMedecinsButton() {
        return creationNouveauxMedecinsButton;
    }
    /**
     * bouton consulter Medecin
     * @return retourne si on clique dessus
     */
    public JButton getConsulterLesMedecinsButton() {
        return ConsulterLesMedecinsButton;
    }


}
