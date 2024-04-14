package centroeducativo.controladores;

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
	public void insercionNota(Materia m, Profesor p, Estudiante e, int nota) {
		
		EntityManager em = getEntityManager();
		
		ValoracionMateria vm = new ValoracionMateria();
		
		vm.setIdMateria(m.getId());
		vm.setIdProfesor(p.getId());
		vm.setIdEstudiante(e.getId());
		vm.setValoracion(nota);
		
		em.getTransaction().begin();
		em.persist(vm);
		em.getTransaction().commit();
		
		em.close();
	}
	
	/**
	 * 
	 * @param vm
	 * @param nota
	 */
	public void modificacionNota(ValoracionMateria vm, int nota) {

		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		vm.setValoracion(nota);
		em.merge(vm);
		em.getTransaction().commit();
		
		em.close();
	}
	
}
