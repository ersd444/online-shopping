package net.kzn.shoppingbakend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import net.kzn.shoppingbakend.dao.CategoryDAO;
import net.kzn.shoppingbakend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * Getting All Category Which are active
	 * */
	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		return query.getResultList();
	}

	
	/*
	 * Getting single category based on id
	 * */
	@Override
	public Category get(int id) {
		
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id)); 
	}

	
	/*
	 * adding a category
	 * */
	@Override
	public boolean add(Category category) {
		
		try {
			//add the category to the database table
			sessionFactory.getCurrentSession().persist(category); 
			return true;
		}catch(Exception ex) {
			
			ex.printStackTrace();
			return false;
		}
	}

	/*
	 * updating a single category
	 * */
	@Override
	public boolean update(Category category) {
		try {
			// updating a single category to the database table
			sessionFactory.getCurrentSession().update(category); 
			return true;
		}catch(Exception ex) {
			
			ex.printStackTrace();
			return false;
		}
	}
	
	/*
	 * delete a single category
	 * */
	@Override
	public boolean delete(Category category) {
		
		category.setActive(false); 
		
		try {
			// deleting a single category to the database table
			sessionFactory.getCurrentSession().update(category); 
			return true;
		}catch(Exception ex) {
			
			ex.printStackTrace();
			return false;
		}
	}

}
