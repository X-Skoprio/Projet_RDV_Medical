package view;
import javax.swing.*;
import java.awt.*;

public class ViewEmploye extends JFrame {

    public ViewEmploye(String nom, String email) {
        // Configuration de la fenêtre
        setTitle("Page du Site");
        setSize(600, 400); // Taille de la fenêtre modifiée
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Création du panel principal avec GridLayout
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10)); // 3 lignes, 1 colonne avec espacement de 10 pixels

        // Composante pour le nom
        JPanel nomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelNom = new JLabel("Nom : " + nom);
        labelNom.setFont(new Font("Arial", Font.BOLD, 18));
        nomPanel.add(labelNom);

        // Composante pour l'adresse e-mail
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel labelEmail = new JLabel("Adresse Email : " + email);
        labelEmail.setFont(new Font("Arial", Font.BOLD, 18));
        emailPanel.add(labelEmail);

        // Composante pour les boutons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10)); // 2 lignes, 2 colonnes avec espacement de 10 pixels
        JButton bouton1 = new JButton("Gérer rdv");
        JButton bouton2 = new JButton("Gérer Patients");
        JButton bouton3 = new JButton("Gérer Médecins");
        JButton bouton4 = new JButton("Disconnect");
        buttonPanel.add(bouton1);
        buttonPanel.add(bouton2);
        buttonPanel.add(bouton3);
        buttonPanel.add(bouton4);

        // Ajout des composants au panel principal
        panel.add(nomPanel);
        panel.add(emailPanel);
        panel.add(buttonPanel);

        // Ajout du panel principal à la fenêtre
        add(panel);

        // Affichage de la fenêtre
        setVisible(true);
    }

    public static void main(String[] args) {
        // Vous pouvez remplacer les valeurs ci-dessous par les noms et emails que vous souhaitez afficher
        String nom = "John Doe";
        String email = "john.doe@example.com";

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ViewEmploye(nom, email); // Crée une instance de la fenêtre avec les noms et emails spécifiés
            }
        });
    }
}
