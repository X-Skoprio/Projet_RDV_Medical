package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.ControlleurPatientRDV.*;

import java.awt.*;
/**
 * Classe qui va nous permettre d'afficher dans un tableau la totalité des patient dans la base de donné.
 * On se concentre ici sur l'affichage graphique.
 */
public class ViewEmployeConsulterPatients extends JFrame {
    private JFrame frame;
    private JTabbedPane tabbedPane;

    private static DefaultTableModel model;
    /**
     * Constructeur qui affiche le tableau en question sur l'écran.
     */
    public ViewEmployeConsulterPatients() {
        frame = new JFrame("Consulter les patients");
        frame.setSize(1000, 600);

        tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);
    }

    /**
     * Va ajouter le patient au tableau affin de l'afficher.
     * Va afficher après de nombreuses vérifications.
     * @param tabName    Tableau que l'on va afficher
     * @param data      données que l'on veut afficher dans le tableau
     * @param columnNames   Nom des colonnes du tableau
     */
    public void addListPatientTable(String tabName, Object[][] data, String[] columnNames) {
         model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 6;  // Les boutons sont éditables
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return (columnIndex >= 6) ? JButton.class : String.class;
            }
        };

        JTable table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.setFillsViewportHeight(true);

        // Configuration de la hauteur des lignes pour une meilleure visibilité
        table.setRowHeight(30);


        // Setting up button columns
        setUpButtonColumn(table, 6, "Voir RDV");
        setUpButtonColumn(table, 7, "Supprimer Patient");

        JScrollPane scrollPane = new JScrollPane(table);
        tabbedPane.addTab(tabName, scrollPane);
    }

    /**
     * Supprime une ligne du tableau.
     *
     * @param model    Le modèle du tableau
     * @param rowIndex L'indice de la ligne à supprimer.
     */
    public void removeRow(DefaultTableModel model, int rowIndex) {
        model.removeRow(rowIndex);
    }

    /**
     * Va gerer le bouton qui permet de rajouter des colonnes au tableau
     * @param table tableauq que l'on va afficher
     * @param column nb de colonne que l'on va rajouter
     * @param label     nom de la colonne.
     */
    private void setUpButtonColumn(JTable table, int column, String label) {
        table.getColumn(table.getColumnName(column)).setCellRenderer(new ButtonRenderer());
        table.getColumn(table.getColumnName(column)).setCellEditor(new ButtonEditor(new JCheckBox(), label));
    }
    /**
     * Affiche la fenêtre.
     */
    public void display() {
        frame.setVisible(true);
    }

    /**
     * Renvoie le modèle de données du tableau.
     *
     * @return Le modèle de données du tableau.
     */
    public static DefaultTableModel getModel() {
        return model;
    }
}

