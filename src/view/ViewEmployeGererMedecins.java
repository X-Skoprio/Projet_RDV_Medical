package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.ControlleurPatientRDV.*;

import java.awt.*;

/**
 * La classe représente l'interface graphique permettant à un employé de gérer les Medecins
 * Affiche un tableau de la liste de Medecin et permet de choisir si l'on veut prendre un RDV
 */
public class ViewEmployeGererMedecins extends JFrame {
    private JFrame frame;
    private JTabbedPane tabbedPane;

    private static DefaultTableModel model;

    /**
     * Constructeur qui initialise les composants graphiques avec le tableau...
     */
    public ViewEmployeGererMedecins() {
        frame = new JFrame("Consulter les patients");
        frame.setSize(1000, 600);

        tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);
    }
    /**
     * Ajoute les médecins au tableau pour les afficher.
     *
     * @param tabName Le nom du tableay
     * @param data     Les données à afficher dans le tableau.
     * @param columnNames Les noms des colonnes du tableau.
     */
    public void addListPatientTable(String tabName, Object[][] data, String[] columnNames) {
        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 4;  // Les boutons sont éditables
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
        setUpButtonColumn(table, 4, "Voir RDV Medecin");
        setUpButtonColumn(table, 5, "Supprimer Medecin");

        JScrollPane scrollPane = new JScrollPane(table);
        tabbedPane.addTab(tabName, scrollPane);
    }

    /**
     * Permet de retirer une colonne du tableau si besoin
     * @param model modele du tableau qu'on récupere avec un sous programme plus bas.
     * @param rowIndex  Indice de la ligne à retirer.
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
     * Renvoie le modèle de données du tableau des Medecins.
     *
     * @return Le modèle de données du tableau.
     */
    public static DefaultTableModel getModelMedecin() {
        return model;
    }
}

