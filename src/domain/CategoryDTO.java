package domain;

public class CategoryDTO {
	
	private String categoryId,
				   categoryName,
				   description;

	public String getCategory_id() {
		return categoryId;
	}

	public void setCategory_id(String category_id) {
		this.categoryId = category_id;
	}

	public String getCategory_name() {
		return categoryName;
	}

	public void setCategory_name(String category_name) {
		this.categoryName = category_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CategoriesDTO [categoryId=" + categoryId + ", categoryName=" + categoryName + ", description="
				+ description + "]";
	}
	
	
}
