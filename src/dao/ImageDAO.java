package dao;

import java.util.List;

import domain.CustomerDTO;
import domain.ImgDTO;
import proxy.Proxy;

public interface ImageDAO {
	
	public void insertImage(ImgDTO img);
	
	public List<ImgDTO> selectimageList(Proxy proxy);
	public List<ImgDTO> selectimages(Proxy proxy);
	public ImgDTO selectImage(ImgDTO img);
	
	public String lastImageSeq(ImgDTO img);

	public int countImage(Proxy proxy);
	
	public void updateImage(ImgDTO img);
	public void deleteImage(ImgDTO img);
	
}
