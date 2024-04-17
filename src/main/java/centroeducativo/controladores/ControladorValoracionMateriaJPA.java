package centroeducativo.controladores;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import centroeducativo.entities.Estudiante;
import centroeducativo.entities.Materia;
import centroeducativo.entities.Profesor;
import centroeducativo.entities.ValoracionMateria;

public class ControladorValoracionMateriaJPA extends SuperControladorJPA {
	
	public ControladorValoracionMateriaJPA() {
		super(nombreTabla, ValoracionMateria.class);
	}

	private static ControladorValoracionMateriaJPA instance = null;
	private static String nombreTabla = "valoracionmateria";
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorValoracionMateriaJPA getInstance() {
		if (instance == null) {
			instance = new ControladorValoracionMateriaJPA();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param m
	 * @param p
	 * @param e
	 * @return
	 */
	public ValoracionMateria findRegistroVM(Materia m, Profesor p, Estudiante e) {
		EntityManager em = getEntityManager();
		
		Query q = em.createNativeQuery("select * from valoracionmateria "
				+ "where idMateria = ? and idProfesor = ? and idEstudiante = ?", ValoracionMateria.class);
		
		q.setParameter(1, m.getId());
		q.setParameter(2, p.getId());
		q.setParameter(3, e.getId());
		
		try {
			return (ValoracionMateria) q.getSingleResult();
		} catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param vm
	 * @param nota
	 */
	public void insercionNota(
			Materia m, Profesor p, Estudiante e, int nota, Date fecha) {
		
		EntityManager em = getEntityManager();
		
		ValoracionMateria vm = new ValoracionMateria();
		
		vm.setIdMateria(m.getId());
		vm.setIdProfesor(p.getId());
		vm.setIdEstudiante(e.getId());
		vm.setValoracion(nota);
		vm.setFecha(fecha);
		
		em.getTransaction().begin();
		em.persist(vm);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 * @param vm
	 * @param nota
	 */
	public void modificacionNota(ValoracionMateria vm, int nota, Date fecha) {

		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		vm.setValoracion(nota);
		vm.setFecha(fecha);
		em.merge(vm);
		em.getTransaction().commit();
	}
	
	/**
	 * 
	 * @param vm
	 */
	public void eliminacionNota(ValoracionMateria vm) {

		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		/*
		 *  IllegalArgumentException: Entity must be managed to call remove, 
		 *  indica que la entidad que estamos intentando eliminar 
		 *  (ValoracionMateria) no está gestionada por el EntityManager 
		 *  actual cuando llamamos a em.remove(vm).
		 *  
		 *  En JPA, las entidades pueden encontrarse en tres estados: 
		 *  
		 *  Managed (gestionadas por el EntityManager actual, es decir, 
		 *  enlazadas con la BBDD y con nuestro persistence). 
		 *  
		 *  Detached (previamente gestionadas por el EntityManager 
		 *  pero ya no están asociadas con nuestro persistence). 
		 *  
		 *  Transient (nuevas entidades que no han sido asociadas con 
		 *  nuestro persistence).
		 *  
		 *  Teniendo todo esto en cuenta, debemos asegurarnos de que 
		 *  la entidad que intentamos eliminar está gestionada. 
		 *  Si no está gestionada, debemos realizar un merge 
		 *  con el persistence-unit actual antes de eliminarla.
		 */
		vm = em.merge(vm);
		em.remove(vm);
		em.getTransaction().commit();
	}
	
}
