package centroeducativo;

import javax.swing.JFrame;

import centroeducativo.utils.Apariencia;
import centroeducativo.view.JPanelValoracion;


public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private static Principal instance = null;
	
	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}
	
	/**
	 * Default Constructor.
	 */
	public Principal() {
		super("Centro Educativo JPA - Valoración Materia");
		
		this.setBounds(100, 100, 700, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		JPanelValoracion panelValoracion = new JPanelValoracion();
		
		this.getContentPane().add(panelValoracion);
	}
	
	/**
	 * Patrón Singleton.
	 * @return
	 */
	public static Principal getInstance() {
		if (instance == null) {
			instance = new Principal();
		}
		return instance;
	}

	/**
	 * Método Principal.
	 * @param args
	 */
	public static void main(String[] args) {
		getInstance().setVisible(true);
	}
	
}
