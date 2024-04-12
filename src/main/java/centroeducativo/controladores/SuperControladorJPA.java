package centroeducativo.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import centroeducativo.entities.Entidad;

public class SuperControladorJPA {

	private static EntityManager em = null;
	private String nombreTabla = "";
	private Class tipoEntidad;
	
	/**
	 * Constructor.
	 * @param nombreTabla El nombre de la tabla.
	 * @param tipoEntidad La entidad deseada.
	 */
	public SuperControladorJPA(String nombreTabla, Class tipoEntidad) {
		this.nombreTabla = nombreTabla;
		this.tipoEntidad = tipoEntidad;
	}
	
	/**
	 * Método que obtiene un EntityManager para la unidad
	 * de Persistencia CentroEducativo.
	 * @return
	 */
	protected EntityManager getEntityManager() {
		if (em == null) {
			return Persistence.createEntityManagerFactory("CentroEducativo")
					.createEntityManager();
		}
		return em;
	}
	
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<? extends Entidad> findAll() {
		return (List<Entidad>)
		getEntityManager()
		.createNativeQuery("select * from " + this.nombreTabla, this.tipoEntidad)
		.getResultList();
	}
	
	/**
	 * Método que actualiza los valores de la tabla.
	 * @param e Entidad
	 */
	public void updateTabla(Entidad e) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
}
