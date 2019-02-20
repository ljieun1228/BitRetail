package service;

import java.util.List;

import domain.ImgDTO;
import proxy.Proxy;

public class ImageServiceImpl implements ImageService {

	private static ImageServiceImpl instance = new ImageServiceImpl();
	private ImageServiceImpl() {dao = ImageServiceImpl.getInstance();}
	public static ImageServiceImpl getInstance() {return instance;}
	
	ImageServiceImpl dao;
	@Override
	public void createImage(ImgDTO img) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addImage(ImgDTO img) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ImgDTO> imageList(Proxy proxy) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int countImage(Proxy proxy) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void updateImage(ImgDTO img) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteImage(ImgDTO img) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
