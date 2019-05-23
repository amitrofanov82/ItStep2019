package ca.by.project_x.persistence.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.by.project_x.conversion.EntityDtoCoversionUtils;
import ca.by.project_x.persistence.api.ICatalogService;
import ca.by.project_x.persistence.model.catalog.Label;
import ca.by.project_x.persistence.repository.auto.CatalogAutoRepository;
import ca.by.project_x.rest.dto.catalog.Category;

@Service
public class CatalogServiceWithHibernate implements ICatalogService {
	
	@Autowired
	private EntityManagerFactory emf; 
			//Persistence.createEntityManagerFactory("");

	@Override
	public List<Category> findCategoriesByParentId(Long parentId) {
    	List<Label> categoriesDb = null;

    	System.out.println("GET parentId = " + parentId);
        
    	
    	EntityManager em = emf.createEntityManager();
    	Query q = em.createQuery("from Label l where l.parentId = " + parentId);
    	List<Object> l = q.getResultList();
    	
    	System.out.println(l);
    	
    	List<Category> categoriesDto = new ArrayList<>(l.size());
    	l.forEach((entity) 
    			-> categoriesDto
    			.add(EntityDtoCoversionUtils.categoryToDto((Label) entity)));
    	em.close();
        return categoriesDto;
	}
	
}























