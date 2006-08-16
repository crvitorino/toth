/*
 * ModeloTabela.java
 *
 * Criado em 15 de Agosto de 2006, 20:04
 *
 */

package Componentes;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fernando Dettoni
 */
public class ModeloTabela extends DefaultTableModel{
    
    /** Creates a new instance of ModeloTabela */
    public ModeloTabela(Object[][] data, Object[] col) {
        super(data, col);
    }
    
    public boolean isCellEditable(int row, int column){
      return false;
    }
    
}
