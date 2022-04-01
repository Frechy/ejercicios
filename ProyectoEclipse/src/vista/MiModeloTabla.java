package vista;

public class MiModeloTabla {

	
	 /**
     * Define la posibilidad de editar de una columna.
     */
    private final boolean [] tableColums = {false, false, false};
     
    public final boolean isCellEditable(int row, int column) {
        return this.tableColums[column];
    }
	
}
