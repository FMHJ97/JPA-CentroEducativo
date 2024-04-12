package centroeducativo.controladores;

import centroeducativo.entities.Materia;

public class ControladorMateriaJPA extends SuperControladorJPA {
	
	public ControladorMateriaJPA() {
		super("materia", Materia.class);
	}

	private static ControladorMateriaJPA instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorMateriaJPA getInstance() {
		if (instance == null) {
			instance = new ControladorMateriaJPA();
		}
		return instance;
	}
	
}
