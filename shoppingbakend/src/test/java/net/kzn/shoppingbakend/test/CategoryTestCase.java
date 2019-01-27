package net.kzn.shoppingbakend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import net.kzn.shoppingbakend.dao.CategoryDAO;
import net.kzn.shoppingbakend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDAO categoryDAO;
	
	private static Category category;
	
	
	@BeforeClass
	public static void init() {
		
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbakend");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
	}
	
/*	@Test
	public void testAddCategory() {
		
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT105.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
	}*/
	
	
	/*@Test
	public void testGetCategory() {
		
		category = categoryDAO.get(3);
		
		assertEquals("Successfully fetching a single category from the table!","Laptop",category.getName());
	}*/
	
/*	@Test
	public void testUpdateCategory() {
		
		category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Successfully updating a single category in the table!",true,categoryDAO.update(category)); 
	}*/
	
	/*@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(2);
		
		assertEquals("Successfully deleting a single category in the table!",true,categoryDAO.delete(category)); 
	}*/
	
	
	/*@Test
	public void testListCategory() {
		
		assertEquals("Successfully fetched the list of categories from the table!",2,categoryDAO.list().size());  
	}*/
	
	@Test
	public void testCRUDCategory(){
		
		//add operation
		category = new Category();
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT1.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		category = new Category();
		category.setName("Laptop");
		category.setDescription("This is some description for laptop!");
		category.setImageURL("CAT2.png");
		
		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
		
		
		//Fetching and updating the single category
		category = categoryDAO.get(2);
		
		category.setName("TV");
		
		assertEquals("Successfully updating a single category in the table!",true,categoryDAO.update(category)); 
		
		//Detete the category
		assertEquals("Successfully deleting a single category in the table!",true,categoryDAO.delete(category));
		
		//Fetching the list of Category based on active
		assertEquals("Successfully fetched the list of categories from the table!",1,categoryDAO.list().size());
		
	}
	
}
