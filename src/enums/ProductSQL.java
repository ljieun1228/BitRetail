package enums;

public enum ProductSQL {
	 SIGNUP, SIGNIN, LIST, ROW_COUNT, PHONE, DETAIL, UPDATE, UPDATE_PROFILE_IMG, CUST_DELETE;

	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		switch (this) {	
		case SIGNUP:
			query.append("INSERT INTO CUSTOMERS (CUSTOMER_ID,CUSTOMER_NAME,CUST_PW, ADDRESS, CITY, POSTAL_CODE, SSN, GENDER, PHONE, PHOTO) \r\n" + 
					"VALUES(?,?,?, ?, ?, ?, ?, ?, ?,'1020')");
			break;
			
		case SIGNIN:
			query.append("SELECT * FROM CUSTOMERS "
					+ "WHERE CUSTOMER_ID LIKE ? AND CUST_PW LIKE ?");
			break;
			
		case LIST:
			
			  query.append("SELECT T2.*\r\n" + 
					"FROM(SELECT ROWNUM R2,T.*\r\n" + 
					"    FROM (SELECT ROWNUM RNUM ,P.* \r\n" + 
					"          FROM PRODUCTS P  \r\n" + 
					"          ORDER BY RNUM DESC) T) T2  \r\n" + 
					"WHERE R2 BETWEEN ? AND ?");
			
			/*
			query.append("SELECT T.*\r\n" + 
					"FROM (SELECT ROWNUM RNUM, C.*\r\n" + 
					"FROM CUSTOMERS C\r\n" + 
					"ORDER BY RNUM DESC)T\r\n" + 
					"WHERE T.RNUM BETWEEN ? AND ? ");*/
			
			break;
			
		case ROW_COUNT:
			query.append("SELECT COUNT(*) COUNT FROM CUSTOMERS");
			break;
		
		case PHONE:
			query.append("SELECT CUSTOMER_ID, CUSTOMER_NAME, PHONE FROM CUSTOMERS");
			break;
		
		case DETAIL:
			query.append("SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ?");
			break;
			
		case UPDATE:
			query.append("UPDATE CUSTOMERS " + 
					"SET PHONE=?," + 
					"CITY=?," + 
					"ADDRESS=?," + 
					"POSTAL_CODE=?," + 
					"CUST_PW=? "+ 
					"WHERE CUSTOMER_ID=?");
			break;
			
		case UPDATE_PROFILE_IMG:
			query.append("UPDATE CUSTOMERS SET PHOTO = ? WHERE CUSTOMER_ID LIKE ?");
			break;
		
		case CUST_DELETE:
			query.append("DELETE FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ?");
			break;
				
			
		default:
			break;
			
		}
		return query.toString();
	}
}
