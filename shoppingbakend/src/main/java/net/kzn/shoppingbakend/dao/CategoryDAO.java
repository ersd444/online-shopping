package net.kzn.shoppingbakend.dao;

import java.util.List;
import net.kzn.shoppingbakend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
}
