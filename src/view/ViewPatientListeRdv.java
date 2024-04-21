package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.ControlleurPatientRDV.*;
import controller.Patient.ControlleurPatient;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * La classe  affiche l'interface graphique permettant à un patient de voir ses rendez-vous.
 * Affiche les rendez-vous dans un tableau et peut les modifier ou les supprimer.
 */
public class ViewPatientListeRdv extends JFrame{
    private JFrame frame;
    private JTabbedPane tabbedPane;

    private JPanel bottomPanel;
    private JButton menuButton;
    private static DefaultTableModel model;

    /**
     * Constructeur de la classe
     * Initialise la fenêtre et ses composants graphiques pour afficher la liste des rendez-vous.
     */
    public ViewPatientListeRdv() {
        frame = new JFrame("Rendez-vous Details");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // Use BorderLayout for the frame


        tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);

        // Initialize and add the bottom panel
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // FlowLayout for simplicity
        menuButton = new JButton("Menu");
        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onMenuButtonClicked(); // Method called when button is clicked
            }
        });
        bottomPanel.add(menuButton);
        frame.add(bottomPanel, BorderLayout.SOUTH); // Add panel at the bottom of the frame

        frame.setLocationRelativeTo(null); // Center on screen
    }


    /**
     * Méthode appelée lors du clic sur le bouton "Menu".
     */
    private void onMenuButtonClicked() {

        System.out.println("Menu button clicked");
        this.dispose();
        ControlleurPatient.showPatientWindow();

    }

    /**
     * Ajoute le tableau des rendez-vous à l'interface graphique.
     *
     * @param tabName Le nom du tableau
     * @param data     Les données à afficher dans le tableau.
     * @param columnNames Les noms des colonnes du tableau.
     */
    public void addRdvTable(String tabName, Object[][] data, String[] columnNames) {
        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 5;  // Les boutons sont éditables
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return (columnIndex >= 5) ? JButton.class : String.class;
            }
        };

        JTable table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.setFillsViewportHeight(true);

        // Configuration de la hauteur des lignes pour une meilleure visibilité
        table.setRowHeight(30);


        // Setting up button columns
        setUpButtonColumn(table, 5, "Modifier");
        setUpButtonColumn(table, 6, "Supprimer");

        JScrollPane scrollPane = new JScrollPane(table);
        tabbedPane.addTab(tabName, scrollPane);
    }

    /**
     * Configure une colonne de boutons dans le tableau.
     *
     * @param table Le tableau où ajouter la colonne de boutons.
     * @param column L'indice de la colonne.
     * @param label Le label des boutons.
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
     * Supprime une ligne du tableau.
     *
     * @param model Le modèle du tableau.
     * @param rowIndex L'indice de la ligne à delete.
     */
    public void removeRow(DefaultTableModel model, int rowIndex) {
        model.removeRow(rowIndex);
    }

    /**
     * Renvoie le modèle de données du tableau des rendez-vous.
     *
     * @return Le modèle de données du tableau des rendez-vous.
     */
    public static DefaultTableModel getModelListeRdv() {
        return model;
    }
}

