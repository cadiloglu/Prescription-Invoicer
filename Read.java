import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Read {  

	Patient person = new Patient();

	public String[] readFile(String path) { //Copied the code from the assigment's pdf to read input file
		try {
			int i = 0;
			int length = Files.readAllLines(Paths.get(path)).size();
			String[] results = new String[length];
			for (String line : Files.readAllLines(Paths.get(path))) {
				results[i++] = line;
			}
			return results;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
