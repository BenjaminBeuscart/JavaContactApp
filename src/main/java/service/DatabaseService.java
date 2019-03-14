package service;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DatabaseService {

	//Server and port are fixed at localhost and 3306
	private DatabaseService() {
		if (dataSource == null) {
			dataSource = new MysqlDataSource();
			dataSource.setServerName("localhost");
			dataSource.setPort(3306);
			dataSource.setDatabaseName("");
			dataSource.setUser("");
			dataSource.setPassword("");
		}
	}
	
	private static class DatabaseServiceHolder {
		private static final DatabaseService INSTANCE = new DatabaseService();
	}
	
	public static DatabaseService getInstance() {
		return DatabaseServiceHolder.INSTANCE;
	}
	
	private MysqlDataSource dataSource;
	
	public MysqlDataSource getDataSource() {
		return dataSource;
	}
	
	
}
