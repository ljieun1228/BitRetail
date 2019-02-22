package service;

import java.util.List;

import domain.CategoryDTO;
import proxy.Proxy;

public interface CategoryService {

	public void registCategory(CategoryDTO cate);
	public List<CategoryDTO> bringCategoryList(Proxy pxy);
	public CategoryDTO retrieveCategory(CategoryDTO cate);
	public CategoryDTO retrieveCategoryOne(CategoryDTO cate);
	public int countCategorys(Proxy pxy);
	public boolean existCategory(CategoryDTO cate);
	public void modifyCategory(CategoryDTO cate);
	public void removeCategory(CategoryDTO cate);	
	
}
