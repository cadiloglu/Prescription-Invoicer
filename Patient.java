import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Patient {
	String name; // Patient's name.
	String socialSecurityInstitute; // Patient's social security institute.
	Date date; // The prescription date.
	String[] patientInfo = new String[100]; // Used to save patient's information we get from first line of prescription file.
	String[] linePart = new String[100]; // Used to save wanted medicament's name and quantity from the lines starting at the second.
	String[] wantedMedicamentsName = new String[100]; // Saving wanted medicaments' name.
	int[] wantedMedicamentsQuantity = new int[100]; // // Saving wanted medicaments' quantity.

	public void patientInfo(String prescriptionFile) {

		Read read = new Read();
		String[] prescription = read.readFile(prescriptionFile);

		patientInfo = prescription[0].split("	"); // Splitting first line to get patient's information (name, SSI type and prescription date).
		name = patientInfo[0]; // 1st element is name.
		socialSecurityInstitute = patientInfo[1]; // 2nd element is SSI type.

		DateFormat convert = new SimpleDateFormat("dd.MM.yyyy");

		try {
			date = convert.parse(patientInfo[2]); // 3rd element is the prescription date which is converted from "string" to "date" type.
		} catch (ParseException e) {
			e.fillInStackTrace();
		}

		for (int i = 0 ; i < prescription.length-1 ; i++) { // Splitting lines after 1st to get wanted medicament's name and quantity line by line.
			linePart = prescription[i+1].split("	");
			wantedMedicamentsName[i] = linePart[0]; //1st element is name.
			wantedMedicamentsQuantity[i] = Integer.parseInt(linePart[1]); // 2nd element is quantity.
		}
	}

}
