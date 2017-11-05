/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package es.jcyl.educa.javaee.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.transaction.Transactional;

import org.hibernate.criterion.Projections;

import es.jcyl.educa.javaee.model.Centro;

@Stateless
public class CentrosServicio extends BaseServicio {

	@Transactional
	public List<Centro> getCentros() {
		return getSession().createCriteria(Centro.class).list();
	}

	public void crear(Centro centro) {
		getSession().save(centro);
	}

	public Centro buscarPorId(Integer id) {
		return getSession().get(Centro.class, id);
	}

	public void eliminar(Centro centro) {
		getSession().delete(centro);
	}

	public Object actualizar(Centro centro) {
		return getSession().merge(centro);
	}

	public Object total() {
		return getSession().createCriteria(Centro.class)
				.setProjection(Projections.count(
						getSession().getSessionFactory().getClassMetadata(Centro.class).getIdentifierPropertyName()))
				.uniqueResult();
	}

}
