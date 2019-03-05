package contactApp;


import java.sql.Connection;
import java.sql.SQLException;
import database.DatabaseManagement;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		Connection connection = DatabaseManagement.start();
		
		DatabaseManagement.add(connection, "Beuscart", "Benjamin", "Ben", "0680053192", "16 clos des aquarelles 59211 Santes", "benjamin.beuscart@isen.yncrea.fr", "1996-09-02");
		//DatabaseManagement.del(connection, "Beuscart", "Benjamin");
		DatabaseManagement.close(connection);
		
		//String listPerson = "SELECT * FROM person";
		//String addPerson = "INSERT INTO person(lastname, firstname, nickname, phone_number, address, email_address, birth_date) VALUES('Beuscart', 'Benjamin', 'Ben', '0680053192', '16 clos des aquarelles 59211 Santes', 'benjamin.beuscart@isen.yncrea.fr', '1996-09-02')";
		//String delPerson = "DELETE FROM person WHERE lastname = 'Beuscart' AND firstname = 'Benjamin'";
		//int nbLines = statement.executeUpdate(addPerson);
	}
}