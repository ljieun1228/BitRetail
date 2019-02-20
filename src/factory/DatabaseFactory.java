//데이터베이스를 만드는 구현체
package factory;

import enums.Vendor;
import pool.Constant;

public class DatabaseFactory {
	public static Database createDatabase(Vendor v) {
		Database database = null;
		switch(v) {
		case ORACLE:
			database = new Oracle();
			break;
		}
		return database;
	}
}