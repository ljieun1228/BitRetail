package enums;

public enum ImageSQL {
	IMG_ADD, SELECT_ONE_IMG, IMG_LAST_SEQ;
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();

		switch (this) {
		case IMG_ADD:
			query.append("INSERT INTO IMAGES(IMG_SEQ, IMG_NAME, IMG_EXTENTION, OWNER) VALUES(IMG_SEQ.NEXTVAL, ?, ?, ?)");
			break;	
			
		case SELECT_ONE_IMG:
			query.append("SELECT * FROM IMAGES WHERE IMG_SEQ LIKE ?");
			break;
			
		case IMG_LAST_SEQ:
			query.append("SELECT IMG_SEQ  FROM IMAGES  WHERE IMG_SEQ LIKE ((SELECT MAX(IMG_SEQ) FROM IMAGES))");
			break;	
			
		default:
			break;
		}
		return query.toString();
	}
}
