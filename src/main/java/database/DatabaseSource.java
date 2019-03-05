package database;

import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DatabaseSource {
	
	private static MysqlDataSource dataSource;
	
	public static DataSource getDataSource() {
		if (dataSource == null) {
			dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");
			dataSource.setPort(3306);
			dataSource.setDatabaseName("contact_app");
			dataSource.setUser("root");
			dataSource.setPassword("");
		}
		return dataSource;
	}
}