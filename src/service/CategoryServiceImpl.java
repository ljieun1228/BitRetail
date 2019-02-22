package service;

import java.util.List;

import dao.CategoryDAOImpl;
import domain.CategoryDTO;
import proxy.Proxy;

public class CategoryServiceImpl implements CategoryService{

	private static CategoryServiceImpl instance = new CategoryServiceImpl();
	private CategoryServiceImpl() {dao = CategoryDAOImpl.getInstance();}
	public static CategoryServiceImpl getInstance() {return instance;}
		
	CategoryDAOImpl dao; 
	
	@Override
	public void registCategory(CategoryDTO cate) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<CategoryDTO> bringCategoryList(Proxy pxy) {
		return dao.selectCategoryList(pxy);
	}
	@Override
	public CategoryDTO retrieveCategory(CategoryDTO cate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CategoryDTO retrieveCategoryOne(CategoryDTO cate) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countCategorys(Proxy pxy) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean existCategory(CategoryDTO cate) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void modifyCategory(CategoryDTO cate) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removeCategory(CategoryDTO cate) {
		// TODO Auto-generated method stub
		
	}



}
