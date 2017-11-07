/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jcyl.educa.javaee.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.transaction.Transactional;

import es.jcyl.educa.javaee.model.Alumno;

@Stateless
public class AlumnosServicio extends BaseServicio {

	@Transactional
	public List<Alumno> getAlumnos() {
		List<Alumno> resultList = entityManager.createQuery("SELECT a FROM Alumno a").getResultList();

		for (Alumno alumno : resultList) {
			alumno.getEstudios().isEmpty();

			// alumno.getEstudios().forEach(x -> Hibernate.initialize(x.getCentro()));
		}

		return resultList;
	}

	@Transactional
	public List<Alumno> getAlumnosDeUnCentro(Long centroId) {
		List<Alumno> resultList = entityManager.createQuery(
				"SELECT distinct a FROM Alumno a JOIN FETCH a.estudios ae WHERE a.id = ae.alumno AND ae.centro.id = :centroId")
				.setParameter("centroId", centroId).getResultList();

		return resultList;
	}

}