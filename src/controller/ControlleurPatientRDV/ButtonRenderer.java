package controller.ControlleurPatientRDV;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * La classe ButtonRenderer permet de modifier comme on le souhaite les boutons SWING.
 */
public class ButtonRenderer extends JButton implements TableCellRenderer {

    /**
     * Constructeur de la classe ButtonRenderer.
     */
    public ButtonRenderer() {
        setOpaque(true);
    }

    /**
     * Méthode d'implémentation de l'interface TableCellRenderer.
     * Renvoie le composant à afficher dans la cellule du tableau.
     *
     * @param table         La table à rendre.
     * @param value         La valeur de la cellule.
     * @param isSelected    Indique si la cellule est sélectionnée.
     * @param hasFocus      Indique si la cellule a le focus.
     * @param row           L'indice de la ligne de la cellule.
     * @param column        L'indice de la colonne de la cellule.
     * @return              Le composant à afficher dans la cellule.
     */
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        return this;
    }
}
