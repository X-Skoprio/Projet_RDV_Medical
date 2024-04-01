package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class ViewLogin {

    public static void main(String[] args) {
        // Création de la fenêtre
        JFrame fenetre = new JFrame("DOCTOUBIB");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(400, 300); // Taille de la fenêtre

        // Création du panneau qui contiendra les boutons et le titre
        JPanel panneau = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Configuration pour centrer les composants
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Place les composants à la fin de la ligne
        gbc.fill = GridBagConstraints.NONE; // Les composants ne s'étendent pas pour remplir l'espace
        gbc.weightx = 1; // Distribue l'espace supplémentaire horizontalement
        gbc.insets = new Insets(10, 10, 10, 10); // Marges externes autour des composants

        // Création et ajout du titre
        JLabel titre = new JLabel("DOCTOUBIB");
        titre.setFont(new Font("Serif", Font.BOLD, 24));
        gbc.weighty = 0.1;
        panneau.add(titre, gbc);

        // Création des boutons avec un padding interne
        JButton bouton1 = new JButton("Patient");
        bouton1.setMargin(new Insets(20, 50, 20, 50)); // Marges internes du bouton
        JButton bouton2 = new JButton("Employé");
        bouton2.setMargin(new Insets(20, 50, 20, 50)); // Marges internes du bouton

        // Réajustement pour les boutons
        gbc.weighty = 1; // Distribue plus d'espace verticalement aux boutons

        // Ajout des boutons au panneau avec les contraintes
        panneau.add(bouton1, gbc);
        panneau.add(bouton2, gbc);

        // Ajout du panneau à la fenêtre
        fenetre.add(panneau);

        // Affichage de la fenêtre
        fenetre.setVisible(true);
    }
}
