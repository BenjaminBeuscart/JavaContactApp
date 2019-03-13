package export;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.collections.ObservableList;
import model.Person;

public class Export {
	
	public static Path createDirectory() {
		Path path = null;
		try {
			String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			path = Paths.get("C:/Users/beusc/Desktop/test/export_" + timeStamp);
			Files.createDirectory(path);
		} catch (IOException e) {
			System.out.println("Wrong path, please change it in creatDirectory() methode from the Export class.");
		}
		return path;
	}
	
	public static void vcardsCreate(ObservableList<Person> persons) throws IOException {
		Path path = createDirectory();
		for (int i = 0; i < persons.size(); i++) {
			Path tmpPath = Paths.get(path.toString() +"/" + persons.get(i).getId() + persons.get(i).getFirstname() + persons.get(i).getLastname() + ".vcf");
			Files.createFile(tmpPath);
			String fileContent = "BEGIN:VCARD\nVERSION:2.1\nN:" + persons.get(i).getLastname() + ";" + persons.get(i).getFirstname() +
					"\nFN:" + persons.get(i).getFirstname() + " " +  persons.get(i).getLastname() + 
					"\nADR;HOME:;;" + persons.get(i).getAddress() +
					"\nTEL;CELL:" + persons.get(i).getPhonenumber() +
					"\nEMAIL:" + persons.get(i).getEmail() +
					"\nEND:VCARD";
			FileWriter fileWriter = new FileWriter(tmpPath.toString());
		    fileWriter.write(fileContent);
		    fileWriter.close();
		}
	}
}
