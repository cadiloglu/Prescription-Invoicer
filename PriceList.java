import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class PriceList {
	String[] medicamentName = new String[100]; // The medicament's name on medicaments file.
	String[] socialSecurityInstitute = new String[100]; // The social security type of medicament on medicaments file.
	Date[] validityDate = new Date[100]; // Start date of the current price of the medicament.
	Date[] expiryDate = new Date[100]; // End date of the current price of the medicament.
	Float[] price = new Float[100]; // Price of the medicament on medicaments file.

	public void getPrices(String medicamentsFile) { 

		Read read = new Read();
		String[] prescription = read.readFile(medicamentsFile);

		for (int i = 0; i < prescription.length; i++) { // Reading the information about medicaments line by line
			String[] linePart = prescription[i].split("	");// Splitting the line to get name, SSI type, validity date, expiry date and price.
			medicamentName[i] = linePart[0];
			socialSecurityInstitute[i] = linePart[1];

			DateFormat convert = new SimpleDateFormat("dd.MM.yyyy");

			try {
				validityDate[i] = convert.parse(linePart[2]); // Validity and expiry date's converted from "string" to "date" type.
				expiryDate[i] = convert.parse(linePart[3]);
			} catch (ParseException e) {
				e.fillInStackTrace();
			}

			price[i] = Float.parseFloat(linePart[4]); // The price converted from "string" to "float" type.

		}

	}
}
