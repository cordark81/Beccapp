package becapp.menus.metodos;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * 
 *  @author Eduardo y Arturo
 *  
 *  Clase para la creación de una tabla
 *
 */

public class renderizarTabla extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object objetoRenderizado, boolean isSelected,
			boolean hasFocus, int row, int column) {

		if (objetoRenderizado instanceof JButton) {
			return (JButton) objetoRenderizado;
		}

		return super.getTableCellRendererComponent(table, objetoRenderizado, isSelected, hasFocus, row, column);
	}

}
