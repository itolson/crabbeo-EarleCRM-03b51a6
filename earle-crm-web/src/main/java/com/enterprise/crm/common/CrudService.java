package com.enterprise.crm.common;

import com.enterprise.crm.common.validation.ConstraintViolationInterceptor;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>A service providing generic 'C'reate, 'R'ead, 'U'pdate and 'D'elete functionality for JPA entities. Also provides
 * methods for returning lists and single values from named queries and executing named statements.</p>
 * <p>Should be injected into an EJB using:<br><code>@EJB<br>CrudService crudService;</code></p>
 * <p><b>Must</b> be called from inside a transaction (ie.
 * <code>@TransactionAttribute(TransactionAttributeType.REQUIRED)</code> is on the calling class or method)</p>
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@SuppressWarnings({"UnusedDeclaration"})
@Interceptors({ConstraintViolationInterceptor.class})
public class CrudService {

    @PersistenceContext(unitName = "EarleCRMPU")
    EntityManager em;

    /**
     * Persists a new object to the database
     *
     * @param t new object
     * @return new object with any modifications
     */
    public <T extends Serializable> T create(T t) {
        this.em.persist(t);
        this.em.flush();
        this.em.refresh(t);
        return t;
    }

    /**
     * Retrieves an object from the database
     *
     * @param type {@link Class} of the object
     * @param pk   object's primary key
     * @return object
     */
    public <T extends Serializable> T find(Class<T> type, Serializable pk) {
        return this.em.find(type, pk);
    }

    /**
     * Updates an object on the database
     *
     * @param t object to be updated
     * @return object to be updated with any modifications
     */
    public <T extends Serializable> T update(T t) {
        return this.em.merge(t);
    }

    /**
     * Deletes a previously retrieved object from the database
     *
     * @param obj object to be deleted
     */
    public void delete(Serializable obj) {
        this.em.remove(obj);
        this.em.flush();
    }

    /**
     * Deletes an object from the database by primary key
     *
     * @param type {@link Class} of the object to be deleted
     * @param pk   primary key of the object to be deleted
     */
    public void delete(Class<? extends Serializable> type, Serializable pk) {
        final Object ref = this.em.getReference(type, pk);
        this.em.remove(ref);
        this.em.flush();
    }

    /**
     * Retrieves a list of objects from the database using a named query
     *
     * @param queryName named query
     * @return list of objects
     */
    @SuppressWarnings({"NullableProblems"})
    public <T extends List<? extends Serializable>> T findWithNamedQuery(String queryName) {
        return findWithNamedQuery(queryName, null, 0);
    }

    /**
     * Retrieves a list of objects from the database using a named query
     *
     * @param queryName  named query
     * @param parameters parameters
     * @return list of objects
     */
    public <T extends List<? extends Serializable>> T findWithNamedQuery(String queryName, QueryParameters parameters) {
        return findWithNamedQuery(queryName, parameters, 0);
    }

    /**
     * Retrieves a list of objects from the database using a named query
     *
     * @param queryName   named query
     * @param resultLimit if greater than zero, the returned list is limited to this number of elements
     * @return list of objects
     */
    @SuppressWarnings({"NullableProblems"})
    public <T extends List<? extends Serializable>> T findWithNamedQuery(String queryName, int resultLimit) {
        return findWithNamedQuery(queryName, null, resultLimit);
    }

    /**
     * Retrieves a list of objects from the database using a named query
     *
     * @param queryName   named query
     * @param parameters  parameters
     * @param resultLimit if greater than zero, the returned list is limited to this number of elements
     * @return list of objects
     */
    @SuppressWarnings({"unchecked"})
    public <T extends List<? extends Serializable>> T findWithNamedQuery(String queryName, QueryParameters parameters, int resultLimit) {
        final Query query = this.em.createNamedQuery(queryName);
        applyParameters(query, parameters);
        if (resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }
        return (T) query.getResultList();
    }

    /**
     * Retrieves an object from the database using a named query
     *
     * @param queryName  named query
     * @param parameters parameters
     * @return single object
     * @throws javax.persistence.NonUniqueResultException
     *          if query returns more than one result
     */
    @SuppressWarnings({"unchecked"})
    public <T extends Serializable> T findUniqueWithNamedQuery(String queryName, QueryParameters parameters) {
        final Query query = this.em.createNamedQuery(queryName);
        applyParameters(query, parameters);
        try {
            return (T) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Executes an update or delete statement
     *
     * @param queryName  named query
     * @param parameters parameters
     * @return number of rows deleted or updated
     */
    public int executeNamedStatement(String queryName, QueryParameters parameters) {
        final Query query = this.em.createNamedQuery(queryName);
        applyParameters(query, parameters);
        return query.executeUpdate();
    }

    private void applyParameters(Query query, QueryParameters parameters) {
        if (parameters != null) {
            for (final Map.Entry<String, Object> parameter : parameters.entries()) {
                query.setParameter(parameter.getKey(), parameter.getValue());
            }
        }
    }

    /**
     * Retrieves a list of objects from the database using a raw SQL
     *
     * @param sqlString  SQL string
     * @param parameters a {@link Map} of parameter names to parameter values
     * @return list of objects
     */
    @SuppressWarnings("unchecked")
    public int executeNativeQuery(String sqlString, Map<String, Object> parameters) {
        final Set<Map.Entry<String, Object>> rawParameters = parameters.entrySet();
        final Query query = this.em.createNativeQuery(sqlString);
        for (final Map.Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.executeUpdate();
    }

    // for unit testing
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }
}