package dao;

import java.util.List;

import domain.CategoryDTO;
import proxy.Proxy;

public interface CategoryDAO {

	public void insertCategory(CategoryDTO Cate);
	public List<CategoryDTO> selectCategoryList(Proxy pxy);
	public List<CategoryDTO> selectCategorys(CategoryDTO Cate);
	public CategoryDTO selectCategory(CategoryDTO Cate);
	public CategoryDTO selectCategoryOne(CategoryDTO Cate);
	public int countCategory(Proxy pxy);
	public boolean existsCategoryID(CategoryDTO Cate);
	public void updateCategory(CategoryDTO Cate);
	public void deleteCategory(CategoryDTO Cate);
	
}
