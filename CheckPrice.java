public class CheckPrice {

	public PriceList price;
	public Patient patient;
	public Read read = new Read();

	public void checkPrices(String prescriptionPath, String medicamentsPath) {

		String[] prescription = read.readFile(prescriptionPath);
		String[] medicaments = read.readFile(medicamentsPath);
		float[] realPrice = new float[prescription.length];
		float total = 0;

		for (int i = 0; i < prescription.length - 1; i++) {
			for (int j = 0; j < medicaments.length; j++) {
				if (patient.wantedMedicamentsName[i].equals(price.medicamentName[j]) // Taking the prices if name, SSI type and date values answers the purpose.
						&& patient.socialSecurityInstitute.equals(price.socialSecurityInstitute[j])
						&& patient.date.after(price.validityDate[j]) && patient.date.before(price.expiryDate[j])) {

					if (realPrice[i] == 0) {
						realPrice[i] = price.price[j];
					} else {
						if (price.price[j] <= realPrice[i]) {
							realPrice[i] = price.price[j];
						}
					}

				}

			}

		}

		for (int i = 0; i < prescription.length - 1; i++) {
			System.out.print(patient.wantedMedicamentsName[i]);
			System.out.printf("	%.2f	", realPrice[i]);
			System.out.print(patient.wantedMedicamentsQuantity[i]);
			System.out.printf("	%.2f%n", patient.wantedMedicamentsQuantity[i] * realPrice[i]);

			total += realPrice[i] * patient.wantedMedicamentsQuantity[i];
		}

		System.out.printf("Total	" + "%.2f", total);

	}

}
