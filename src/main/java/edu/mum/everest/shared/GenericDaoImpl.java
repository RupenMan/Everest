/**
 * 
 */
package edu.mum.everest.shared;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

/**
 * @author jeewa
 *
 */
@Repository
public class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected Class<T> daoType;

	public void setDaoType(Class<T> type) {
		daoType = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.mum.everest.shared.GenericDao#save(java.lang.Object)
	 */
	@Override
	public void save(T entity) {
		entityManager.persist(entity);
	}

	public void delete(T entity) {
		entityManager.remove( entity );
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.mum.everest.shared.GenericDao#delete(java.lang.Long)
	 */
	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		T entity = findOne( id );
        delete(entity);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.mum.everest.shared.GenericDao#findOne(java.lang.Long)
	 */
	@Override
	public T findOne(Long id) {
		// TODO Auto-generated method stub
		return (T) entityManager.find( daoType, id );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.mum.everest.shared.GenericDao#update(java.lang.Object)
	 */
	@Override
	public T update(T entity) {
		return entityManager.merge( entity );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.mum.everest.shared.GenericDao#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery( "from " + daoType.getName() )
			       .getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.mum.everest.shared.GenericDao#findAll(java.lang.String,
	 * java.lang.Object)
	 */
	@Override
	public List<T> findAll(String s, Object hint) {
		// TODO Auto-generated method stub
		return null;
	}

}
