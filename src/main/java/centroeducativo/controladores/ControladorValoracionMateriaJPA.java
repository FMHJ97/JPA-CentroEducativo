package centroeducativo.controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	 * @param nota
	 * @return
	 */
	public boolean findRegistroByNota(Materia m, Profesor p, Estudiante e, Integer nota) {
		EntityManager em = getEntityManager();
		
		Query q = em.createNativeQuery("select * from valoracionmateria "
				+ "where idMateria = ? and idProfesor = ? and idEstudiante = ? and valoracion = ?");
		
		q.setParameter(1, m.getId());
		q.setParameter(2, p.getId());
		q.setParameter(3, e.getId());
		q.setParameter(4, nota);
		
		try {
			q.getSingleResult();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	/**
	 * 
	 * @param m
	 * @param p
	 * @param e
	 * @param nota
	 */
	public void guardar(Materia m, Profesor p, Estudiante e, Integer nota) {
		
		if (findRegistroByNota(m, p, e, nota)) {
			// Si existe un registro en la tabla valoracionmedia
			modificacionNota(m, p, e, nota);
		} else {
			
			
		}
		
	}
	
	/**
	 * 
	 * @param m
	 * @param p
	 * @param e
	 * @param nota
	 */
	private void modificacionNota(Materia m, Profesor p, Estudiante e, Integer nota) {

		EntityManager em = getEntityManager();

		TypedQuery<ValoracionMateria> q = em.createQuery(
				"SELECT v FROM " + nombreTabla + " as v where v.idProfesor = ? "
				+ "and v.idMateria and v.idEstudiante = ?", ValoracionMateria.class);
		
		q.setParameter(1, p.getId());
		q.setParameter(2, m.getId());
		q.setParameter(3, e.getId());
		
		em.getTransaction().begin();
		
		ValoracionMateria vm = q.getSingleResult();
		vm.setValoracion(nota);
		
		em.merge(vm);
		em.getTransaction().commit();
		
		em.close();
	}
	
}
