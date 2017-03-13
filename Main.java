
public class Main {

	public static void main(String[] args) {

		PriceList price = new PriceList();
		Patient patient = new Patient();

		price.getPrices(args[1]);
		patient.patientInfo(args[0]);

		CheckPrice check = new CheckPrice();

		check.price = price;
		check.patient = patient;

		check.checkPrices(args[0], args[1]);

	}

}
