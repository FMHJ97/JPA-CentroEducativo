package centroeducativo;

import javax.swing.JFrame;

import centroeducativo.utils.Apariencia;



public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Principal instance = null;
	
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}

	/**
	 * Método Principal.
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	

}
