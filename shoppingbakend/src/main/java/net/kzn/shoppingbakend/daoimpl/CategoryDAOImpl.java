package net.kzn.shoppingbakend.daoimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import net.kzn.shoppingbakend.dao.CategoryDAO;
import net.kzn.shoppingbakend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();

	static {

		// adding first category
		Category category1 = new Category();
		category1.setId(1);
		category1.setName("Television");
		category1.setDescription("This is some description for television!");
		category1.setImageURL("CAT1.png");
		categories.add(category1);

		// adding second category
		Category category2 = new Category();
		category2.setId(2);
		category2.setName("Mobile");
		category2.setDescription("This is some description for mobile!");
		category2.setImageURL("CAT2.png");
		categories.add(category2);

		// adding third category
		Category category3 = new Category();
		category3.setId(3);
		category3.setName("Laptop");
		category3.setDescription("This is some description for laptop!");
		category3.setImageURL("CAT3.png");
		categories.add(category3);

	}

	@Override
	public List<Category> list() {
		return categories;
	}

}
