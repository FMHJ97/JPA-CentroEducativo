package centroeducativo.controladores;

import centroeducativo.entities.Profesor;

public class ControladorProfesorJPA extends SuperControladorJPA {
	
	public ControladorProfesorJPA() {
		super("profesor", Profesor.class);
	}

	private static ControladorProfesorJPA instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorProfesorJPA getInstance() {
		if (instance == null) {
			instance = new ControladorProfesorJPA();
		}
		return instance;
	}
	
}
